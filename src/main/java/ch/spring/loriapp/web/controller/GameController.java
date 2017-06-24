package ch.spring.loriapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GameController {

	@GetMapping("/game/{region}/{summoner}")
	public String openGame(@PathVariable String region, @PathVariable String summoner) {
		return "currentgame";
	}
}
