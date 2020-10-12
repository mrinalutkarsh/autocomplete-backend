package com.mrinal.autocomplete;

import com.mrinal.autocomplete.helper.DataLoader;
import com.mrinal.autocomplete.service.SuggestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Slf4j
@SpringBootApplication
public class AutocompleteApplication {

    @Autowired
    DataLoader dataLoader;

    @Autowired
    SuggestionService suggestionService;

    public static void main(String[] args) {
        SpringApplication.run(AutocompleteApplication.class, args);
    }

    @Bean
    public CommandLineRunner setUp() {
        return (args) -> {
            List<String> cities = dataLoader.loadData();
            suggestionService.setCities(cities);
        };
    }
}
