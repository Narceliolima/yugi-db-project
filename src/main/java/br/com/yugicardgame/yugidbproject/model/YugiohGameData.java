package br.com.yugicardgame.yugidbproject.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record YugiohGameData(@JsonAlias("data") List<YugiohGameCard> card) {
	
}
