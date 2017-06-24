package ch.spring.loriapp.web.modelobject;

import ch.spring.loriapp.business.riot.entity.League;

public class ObjectMapperHelper {

	public static LeagueObject mapLeagueObject(League league){
		
		LeagueObject leagueObject = new LeagueObject();
		leagueObject.setFreshBlood(league.isFreshBlood());
		leagueObject.setHotStreak(league.isHotStreak());
		leagueObject.setInactive(league.isInactive());
		leagueObject.setLeagueName(league.getLeagueName());
		leagueObject.setLeaguePoints(league.getLeaguePoints());
		leagueObject.setLosses(league.getLosses());
		leagueObject.setPlayerOrTeamId(league.getPlayerOrTeamId());
		leagueObject.setPlayerOrTeamName(league.getPlayerOrTeamName());
		leagueObject.setQueueType(league.getQueueType());
		leagueObject.setRank(league.getRank());
		leagueObject.setTier(league.getTier());
		leagueObject.setVeteran(league.isVeteran());
		leagueObject.setWins(league.getWins());
		
		StringBuilder sb = new StringBuilder();
		sb.append(leagueObject.getTier().toLowerCase());
		sb.append("_");
		sb.append(leagueObject.getRank().toLowerCase());
		sb.append(".png");
		
		leagueObject.setTierUrl(sb.toString());
		
		return leagueObject;
	}
}
