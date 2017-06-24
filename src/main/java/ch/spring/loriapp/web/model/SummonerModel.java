package ch.spring.loriapp.web.model;

import java.util.List;

import ch.spring.loriapp.web.modelobject.LeagueObject;

public class SummonerModel {
	private List<LeagueObject> leagues;

	public List<LeagueObject> getLeagues() {
		return leagues;
	}

	public void setLeagues(List<LeagueObject> leagues) {
		this.leagues = leagues;
	}
}
