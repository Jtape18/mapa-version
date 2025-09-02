package com.mapaversion.mapa_version;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mapaversion.mapa_version")
public class MapaVersionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapaVersionApplication.class, args);
	}

}
