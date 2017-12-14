package it.iol.oauthaaa.security;

import it.iol.oauthaaa.bean.AAAProfile;
import it.iol.oauthaaa.bean.UserProfile;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class AAAProxy {

	private Proxy proxy;
	private RestTemplate template;
	public final static String PAAA_AUTHE = "PAAA_AUTHE=";

	public AAAProxy() {
		proxy = new Proxy(Type.HTTP, new InetSocketAddress(
				"proxy.tcl.virgilio.net", 3003));

		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

		requestFactory.setProxy(proxy);

		template = new RestTemplate(requestFactory);
	}

	public String getAuthCookie(String user, String password) {

		System.setProperty("javax.net.debug", "all");
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("a3l", user);
		map.add("a3p", password);
		map.add("a3aid", "hpcommunity");
		map.add("a3st", "hpcommunity");
		map.add("a3se", "");
		map.add("a3ep", "http://community.virgilio.it/");
		map.add("a3afep", "");
		map.add("totop", "true");

		HttpEntity<String> response = template.postForEntity(
				"https://aaacsc.virgilio.it/piattaformaAAA/aapm/amI", map,
				String.class);

		HttpHeaders headers = response.getHeaders();

		List<String> cookies = headers.get("Set-Cookie");
		
		for (String cookie : cookies) {
			if (cookie.indexOf(PAAA_AUTHE)!=-1)
				return cookie.substring(cookie.indexOf(PAAA_AUTHE)+PAAA_AUTHE.length(), cookie.indexOf(";",cookie.indexOf(PAAA_AUTHE)));
		}

		return "";
	}
	
	public AAAProfile getUserProfile(String paaaCookie) throws JsonParseException, JsonMappingException, IOException {

		System.setProperty("javax.net.debug", "all");
				
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Cookie", PAAA_AUTHE + paaaCookie);
		HttpEntity<byte[]> requestEntity = new HttpEntity<byte[]>(null, requestHeaders);
		ResponseEntity<String> rssResponse = template.exchange(
		    "http://api.community.virgilio.it/dashboard-api-web/authen/gethomepagedashboard/HP.js?rnd=886382034",
		    HttpMethod.GET,
		    requestEntity,
		    String.class);
	
		String rss = (String)rssResponse.getBody();
		
		rss = rss.replace("jsonp(", "");
		rss = rss.replace("})", "}");

		
		ObjectMapper mapper = new ObjectMapper();
		UserProfile userProfile = mapper.readValue(rss, UserProfile.class);


		return new AAAProfile(userProfile.getHomePageDashboard().getCurrentNick(),userProfile.getHomePageDashboard().getRegistrEmail()); 
	}

}
