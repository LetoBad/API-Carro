package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CarroRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Carro("Porsche", "GT3RS", "Branco e Verde", 2020)));
            log.info("Preloading " + repository.save(new Carro("Mclaren", "P1", "Laranja", 2019)));
            log.info("Preloading " + repository.save(new Carro("Mclaren", "Senna", "Azul", 2019)));
            log.info("Preloading " + repository.save(new Carro("Ferrari", "588 GT3", "Vermelho", 2021)));
        };
    }
}