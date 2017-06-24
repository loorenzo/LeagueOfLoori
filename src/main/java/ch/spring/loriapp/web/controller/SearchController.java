package ch.spring.loriapp.web.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

	@PostMapping(value = "/search", params = { "summoner", "!game" })
	public String redirectSearchSummoner(@RequestParam(required = false) String summoner, @RequestParam String region, @RequestParam String search) {

		if (StringUtils.isNotBlank(search)) {
			return "redirect:/summoner/" + region + "/" + search;
		} else {
			return "home";
		}

	}

	@PostMapping(value = "/search", params = { "game", "!summoner" })
	public String redirectSearchGame(@RequestParam String game, @RequestParam String region, @RequestParam String search) {
		return "redirect:/game/" + region + "/" + search;
	}

}
