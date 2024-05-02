package br.com.yugicardgame.yugidbproject.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CardPrices(@JsonAlias("amazon_price") double price) {

}
