package com.mrinal.autocomplete.helper;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mrinal
 * @since 26/09/2020
 */

@Slf4j
@Component
public class DataLoader {

    //File with static city data
    @Value("classpath:cities.tsv")
    private Resource resource;

    public List<String> loadData() {
        log.info("Loading data...");
        List<String> cities = Collections.emptyList();
        try {
            InputStream inputStream = resource.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            cities = bufferedReader.lines().collect(Collectors.toList());
            cities.replaceAll(String::toUpperCase);
            bufferedReader.close();
            inputStream.close();
            log.info("Data loading complete");
        } catch (Exception e) {
            log.error("Error occurred loading data from, exception:", e);
        }
        return cities;
    }
}
