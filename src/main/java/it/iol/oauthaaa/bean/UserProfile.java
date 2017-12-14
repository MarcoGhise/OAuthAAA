package it.iol.oauthaaa.bean;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"homePageDashboard"
})
public class UserProfile {

@JsonProperty("homePageDashboard")
private HomePageDashboard homePageDashboard;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The homePageDashboard
*/
@JsonProperty("homePageDashboard")
public HomePageDashboard getHomePageDashboard() {
return homePageDashboard;
 }

/**
* 
* @param homePageDashboard
* The homePageDashboard
*/
@JsonProperty("homePageDashboard")
public void setHomePageDashboard(HomePageDashboard homePageDashboard) {
this.homePageDashboard = homePageDashboard;
 }

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
 }

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
 }

}
