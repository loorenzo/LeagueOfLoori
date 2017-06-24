package ch.spring.loriapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ch.spring.loriapp.business.riot.common.Region;
import ch.spring.loriapp.business.riot.entity.Leagues;
import ch.spring.loriapp.business.riot.entity.Summoner;
import ch.spring.loriapp.business.riot.service.SummonerService;
import ch.spring.loriapp.exception.RiotApiException;

@Controller
public class SummonerController {

	@Autowired
	SummonerService summonerService;

	@GetMapping("/summoner/{region}/{summoner}")
	public String openSummoner(@PathVariable Region region, @PathVariable String summoner) {

		Summoner sum = null;
		try {
			sum = summonerService.getSummonerByName(summoner, region);
		} catch (RiotApiException e) {
			System.out.println("fail");
			// TODO: Ex handling
		}

		try {
			List<Leagues> a = summonerService.getLeaguesById((int) sum.getId(), region);
			System.out.println(a);
		} catch (RiotApiException e) {
			System.out.println("fail");
			// TODO: Ex handling
		}

		return "summoner";
	}
}
