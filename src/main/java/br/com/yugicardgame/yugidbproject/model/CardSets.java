package br.com.yugicardgame.yugidbproject.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CardSets(@JsonAlias("set_name") String setName,
						@JsonAlias("set_code") String setCode,
						@JsonAlias("set_rarity") String setRarity,
						@JsonAlias("set_price") double setPrice) {

}
