package ch.spring.loriapp.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import ch.spring.loriapp.business.riot.common.Region;
import ch.spring.loriapp.business.riot.entity.League;
import ch.spring.loriapp.business.riot.entity.Summoner;
import ch.spring.loriapp.business.riot.service.SummonerService;
import ch.spring.loriapp.exception.RiotApiException;
import ch.spring.loriapp.web.model.SummonerModel;
import ch.spring.loriapp.web.modelobject.ObjectMapperHelper;

@Controller
public class SummonerController {

	@Autowired
	SummonerService summonerService;

	@GetMapping("/summoner/{region}/{summoner}")
	public String openSummoner(@PathVariable Region region, @PathVariable String summoner, @ModelAttribute("model") SummonerModel model) {

		Summoner sum = null;
		try {
			sum = summonerService.getSummonerByName(summoner, region);
		} catch (RiotApiException e) {
			System.out.println("fail");
			// TODO: Ex handling
		}

		if (sum != null) {
			try {
				List<League> leagues = summonerService.getLeaguesById((int) sum.getId(), region);
				model.setLeagues(leagues.stream().map(ObjectMapperHelper::mapLeagueObject).collect(Collectors.toList()));

			} catch (RiotApiException e) {
				System.out.println("fail");
				// TODO: Ex handling
			}
		}

		return "summoner";
	}
}
