package br.com.yugicardgame.yugidbproject.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.yugicardgame.yugidbproject.model.Card;
import br.com.yugicardgame.yugidbproject.model.YugiohGameCard;
import br.com.yugicardgame.yugidbproject.model.YugiohGameData;
import br.com.yugicardgame.yugidbproject.services.APIConsumer;
import br.com.yugicardgame.yugidbproject.services.JsonDataConverter;

public class MainMenu {

	private final String BASE_NAME_FOR_SEARCH = "Card Set";
	private final String URL = "https://db.ygoprodeck.com/api/v7/cardinfo.php?misc=yes&cardset="+BASE_NAME_FOR_SEARCH;
	private APIConsumer consumer = new APIConsumer(URL, BASE_NAME_FOR_SEARCH);
	private JsonDataConverter converter = new JsonDataConverter();
	
	public void showMenu() {
		
		System.out.println("Digite o nome do Card Pack");
		String dataToSearch = "2-Player Starter Set";
		String data = consumer.getData(dataToSearch);
				
		YugiohGameData cardList = converter.getJsonData(data, YugiohGameData.class);
		
		//Busca uma carta na posição zero, depois filtra atravéz do cardset desta carta um em especifico, retorna uma lista e depois intera ela mandando imprimir
		cardList.card().get(0).cardSets().stream().filter(cardSet -> cardSet.setName().equals(dataToSearch)).toList().forEach(System.out::println);
		
		cardList.card().forEach(System.out::println);
		
		System.out.println("\nTop 5 Cartas com maior quantidade de estrelas");
		cardList.card().stream().sorted(Comparator.comparing(YugiohGameCard::level).reversed()).limit(5).forEach(System.out::println);
		
		List<Card> listaCarta = cardList.card().stream().map(cardGame -> new Card(cardGame)).collect(Collectors.toList());
		
		System.out.println("\n\nCartas Objeto");
		listaCarta.forEach(System.out::println);
		
		System.out.println("\n\nPrimeiros Lancamentos");
		listaCarta.stream().peek(card -> System.out.println("Filtrando: "+card))
							.filter(card -> card.getReleaseDate().isBefore(LocalDate.of(2002, 06, 15)))
							.peek(card -> System.out.println("Ordenando: "+card))
							.sorted(Comparator.comparing(Card::getReleaseDate).reversed())
							.forEach(card -> System.out.printf("Nome: %s|Level: %d|Atk: %d|Def: %d|Raca: %s|Data de Lancamento: %s\n",card.getName(),card.getLevel(),card.getAtk(),card.getDef(),card.getRace(),card.getReleaseDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
	}
}
