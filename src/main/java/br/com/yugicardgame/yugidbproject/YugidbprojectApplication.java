package br.com.yugicardgame.yugidbproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.yugicardgame.yugidbproject.main.MainMenu;

@SpringBootApplication
public class YugidbprojectApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(YugidbprojectApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		new MainMenu().showMenu();

	}
}
