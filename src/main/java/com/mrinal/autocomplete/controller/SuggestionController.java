package com.mrinal.autocomplete.controller;


import com.mrinal.autocomplete.service.SuggestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author Mrinal
 * @since 26/09/2020
 */

@Slf4j
@RestController
@RequestMapping(value = "/search")
public class SuggestionController {

    @Autowired
    SuggestionService suggestionService;

//    @GetMapping(value = "/{key}")
//    public ResponseEntity<Set<String>> compute(@PathVariable("key") String key) {
//        log.info("Computing suggestions for input:{}", key);
//        Set<String> response = suggestionService.findByCityLike(key);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    @CrossOrigin
    @Cacheable(value = "autoCompleteCache", key="#key", unless="#result == null")
    @GetMapping(value = "/{key}")
    public ResponseEntity<Set<String>> compute(@PathVariable("key") String key) {
        log.info("Computing suggestions for input:{}", key);
        Set<String> response = suggestionService.findByCityLike(key);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
