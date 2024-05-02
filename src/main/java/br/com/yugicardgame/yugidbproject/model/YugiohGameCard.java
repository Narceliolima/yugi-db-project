package br.com.yugicardgame.yugidbproject.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record YugiohGameCard(@JsonAlias("name") String name,
							@JsonAlias("type") String type,
							@JsonAlias("level") int level,
							@JsonAlias("atk") int atk,
							@JsonAlias("def") int def,
							@JsonAlias("race") String race,
							@JsonAlias("card_sets") List<CardSets> cardSets,
							@JsonAlias("misc_info") List<MiscInfo> miscInfo,
							@JsonAlias("card_prices") List<CardPrices> cardPrices) {
	
	@Override
	public String toString() {
		return "YugiohGameCard [name=" + name + ", type=" + type + ", level=" + level + ", atk=" + atk + ", def=" + def
				+ ", race=" + race + "]";
	}
}
