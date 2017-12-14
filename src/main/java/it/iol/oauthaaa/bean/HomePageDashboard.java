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
"currentNick",
"error",
"logged",
"registrEmail",
"unreadMsg"
})
public class HomePageDashboard {

@JsonProperty("currentNick")
private String currentNick;
@JsonProperty("error")
private String error;
@JsonProperty("logged")
private Boolean logged;
@JsonProperty("registrEmail")
private String registrEmail;
@JsonProperty("unreadMsg")
private Integer unreadMsg;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The currentNick
*/
@JsonProperty("currentNick")
public String getCurrentNick() {
return currentNick;
 }

/**
* 
* @param currentNick
* The currentNick
*/
@JsonProperty("currentNick")
public void setCurrentNick(String currentNick) {
this.currentNick = currentNick;
 }

/**
* 
* @return
* The error
*/
@JsonProperty("error")
public String getError() {
return error;
 }

/**
* 
* @param error
* The error
*/
@JsonProperty("error")
public void setError(String error) {
this.error = error;
 }

/**
* 
* @return
* The logged
*/
@JsonProperty("logged")
public Boolean getLogged() {
return logged;
 }

/**
* 
* @param logged
* The logged
*/
@JsonProperty("logged")
public void setLogged(Boolean logged) {
this.logged = logged;
 }

/**
* 
* @return
* The registrEmail
*/
@JsonProperty("registrEmail")
public String getRegistrEmail() {
return registrEmail;
 }

/**
* 
* @param registrEmail
* The registrEmail
*/
@JsonProperty("registrEmail")
public void setRegistrEmail(String registrEmail) {
this.registrEmail = registrEmail;
 }

/**
* 
* @return
* The unreadMsg
*/
@JsonProperty("unreadMsg")
public Integer getUnreadMsg() {
return unreadMsg;
 }

/**
* 
* @param unreadMsg
* The unreadMsg
*/
@JsonProperty("unreadMsg")
public void setUnreadMsg(Integer unreadMsg) {
this.unreadMsg = unreadMsg;
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
