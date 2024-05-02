package br.com.yugicardgame.yugidbproject.model;

import java.time.LocalDate;
import java.util.List;

public class Card {

	private String name;
	private String type;
	private Integer level;
	private Integer atk;
	private Integer def;
	private String race;
	private List<CardSets> cardSets;
	private Double price;
	private LocalDate releaseDate;
	
	public Card(YugiohGameCard gameCard) {
		this.name = gameCard.name();
		this.type = gameCard.type();
		this.level = gameCard.level();
		this.atk = gameCard.atk();
		this.def = gameCard.def();
		this.race = gameCard.race();
		this.cardSets = gameCard.cardSets();
		this.price = gameCard.cardPrices().get(0).price();
		this.releaseDate = LocalDate.parse(gameCard.miscInfo().get(0).releaseDate());
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getLevel() {
		return level;
	}

	public int getAtk() {
		return atk;
	}

	public int getDef() {
		return def;
	}

	public String getRace() {
		return race;
	}

	public List<CardSets> getCardSets() {
		return cardSets;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public void setCardSets(List<CardSets> cardSets) {
		this.cardSets = cardSets;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Card [name=" + name + ", type=" + type + ", level=" + level + ", atk=" + atk + ", def=" + def
				+ ", race=" + race + ", price=" + price + ", releaseDate=" + releaseDate + "]";
	}
}
