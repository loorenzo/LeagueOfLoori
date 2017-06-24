package ch.spring.loriapp.business.riot.common;

import org.springframework.beans.factory.annotation.Value;

public abstract class BaseRiotProperties {

	@Value("${riot.development.key}")
	private String riotApiKey;

	@Value("${riot.euw.url}")
    private String riotEuwUrl;
	
	@Value("${riot.euw.avatar.url}")
	private String riotEuwAvatarUrl;

	protected String getRiotEuwAvatarUrl() {
		return riotEuwAvatarUrl;
	}

	protected void setRiotEuwAvatarUrl(String riotEuwAvatarUrl) {
		this.riotEuwAvatarUrl = riotEuwAvatarUrl;
	}

	protected String getRiotApiKey() {
		return riotApiKey;
	}

	protected void setRiotApiKey(String riotApiKey) {
		this.riotApiKey = riotApiKey;
	}

	protected String getRiotEuwUrl() {
		return riotEuwUrl;
	}

	protected void setRiotEuwUrl(String riotEuwUrl) {
		this.riotEuwUrl = riotEuwUrl;
	}

	protected String getApiUrl(Region region){
		
		switch(region){
		case EUW: 
			return getRiotEuwUrl();
		case NA:
			break;
		case KR:
			break;
		default: 
			return getRiotEuwUrl();
		}
		return null;
	}
	
	protected String getApiAvatarUrl(Region region){
		
		switch(region){
		case EUW: 
			return getRiotEuwAvatarUrl();
		case NA:
			break;
		case KR:
			break;
		default: 
			return getRiotEuwAvatarUrl();
		}
		return null;
	}
}
