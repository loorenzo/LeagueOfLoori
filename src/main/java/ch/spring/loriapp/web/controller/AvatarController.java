package ch.spring.loriapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.spring.loriapp.business.riot.common.Region;
import ch.spring.loriapp.business.riot.service.SummonerService;
import ch.spring.loriapp.exception.RiotApiException;

@Controller
public class AvatarController {

	@Autowired
	SummonerService summonerService;
	
	@ResponseBody
	@GetMapping("/avatar/{summoner}")
	public byte[] getAvatar(@PathVariable String summoner) {
		
		try {
			return summonerService.getSummonerAvatarByName(summoner, Region.EUW);
		} catch (RiotApiException e) {
			return null;
		}
	}
}
