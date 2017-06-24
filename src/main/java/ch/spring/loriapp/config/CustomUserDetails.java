package ch.spring.loriapp.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import ch.spring.loriapp.business.riot.common.Region;

@SuppressWarnings("serial")
public class CustomUserDetails extends User {

	private String summonerName;
	private Region region;

	public CustomUserDetails(String username, String summonerName, String password, Region region, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.summonerName = summonerName;
		this.region = region;
	}

	public String getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}
