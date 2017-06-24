package ch.spring.loriapp.business.riot.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.spring.loriapp.business.riot.common.BaseRiotProperties;
import ch.spring.loriapp.business.riot.common.Region;
import ch.spring.loriapp.business.riot.entity.League;
import ch.spring.loriapp.business.riot.entity.Summoner;
import ch.spring.loriapp.exception.RiotApiException;

@Service
public class SummonerService extends BaseRiotProperties {

	@Autowired
	ObjectMapper objectMapper;

	public Summoner getSummonerByName(String name, Region region) throws RiotApiException {

		try {
			StringBuilder sb = new StringBuilder();
			sb.append(getApiUrl(region));
			sb.append("/lol/summoner/v3/summoners/by-name/");
			sb.append(name);
			sb.append("?api_key=");
			sb.append(getRiotApiKey());
			URL url = new URL(sb.toString());
			Summoner summoner = objectMapper.readValue(url, Summoner.class);
			return summoner;
		} catch (IOException e) {
			throw new RiotApiException(e.getMessage());
		}
	}

	public byte[] getSummonerAvatarByName(String name, Region region) throws RiotApiException {

		try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
			StringBuilder sb = new StringBuilder();
			sb.append(getApiAvatarUrl(region));
			sb.append(name);
			sb.append(".png");
			URL url = new URL(sb.toString());
			BufferedImage image = ImageIO.read(url);
			ImageIO.write(image, "png", output);
			output.flush();
			return output.toByteArray();

		} catch (IOException e) {
			throw new RiotApiException(e.getMessage());
		}
	}

	public List<League> getLeaguesById(int summonerId, Region region) throws RiotApiException {

		try {
			StringBuilder sb = new StringBuilder();
			sb.append(getApiUrl(region));
			sb.append("/lol/league/v3/positions/by-summoner/");
			sb.append(summonerId);
			sb.append("?api_key=");
			sb.append(getRiotApiKey());
			URL url = new URL(sb.toString());
			return objectMapper.readValue(url, new TypeReference<List<League>>() {
			});
		} catch (IOException e) {
			throw new RiotApiException(e.getMessage());
		}
	}

}
