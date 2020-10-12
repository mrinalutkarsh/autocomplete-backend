package com.mrinal.autocomplete.service;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Mrinal
 * @since 26/09/2020
 */

@Service
public class SuggestionService {

    @Getter
    @Setter
    private List<String> cities;

    public Set<String> findByCityLike(String key) {
        String keyToFilter = key.toUpperCase();
        Set<String> response = new HashSet<>();
        for (String city : cities) {
            if (city.startsWith(keyToFilter)) {
                response.add(city);
            }
        }
        return response;
    }

    /*
     * https://stackoverflow.com/questions/33722217/improving-search-result-using-levenshtein-distance-in-java
     * */
//    public Set<String> findByCityLike(String searchWord) {
//        int maxDistance = searchWord.length();
//        int curDistance;
//        int sumCurMax;
//        String checkWord;
//
//        // preventing double words on returning list
//        Set<String> response = new HashSet<>();
//
//        for (String city : cities) {
//            checkWord = city;
//            curDistance = calculateDistance(searchWord, checkWord);
//            sumCurMax = maxDistance + curDistance;
//            if (sumCurMax == checkWord.length()) {
//                response.add(checkWord);
//            }
//        }
//        return response;
//    }

//    public int calculateDistance(String inputWord, String checkWord) {
//        int[][] wordMartix = new int[inputWord.length() + 1][checkWord.length() + 1];
//
//        for (int i = 0; i <= inputWord.length(); i++) {
//            wordMartix[i][0] = i;
//        }
//
//        for (int j = 0; j <= checkWord.length(); j++) {
//            wordMartix[0][j] = j;
//        }
//
//        for (int i = 1; i < wordMartix.length; i++) {
//            for (int j = 1; j < wordMartix[i].length; j++) {
//                if (inputWord.charAt(i - 1) == checkWord.charAt(j - 1)) {
//                    wordMartix[i][j] = wordMartix[i - 1][j - 1];
//                } else {
//                    int minimum = Integer.MAX_VALUE;
//                    if ((wordMartix[i - 1][j]) + 1 < minimum) {
//                        minimum = (wordMartix[i - 1][j]) + 1;
//                    }
//
//                    if ((wordMartix[i][j - 1]) + 1 < minimum) {
//                        minimum = (wordMartix[i][j - 1]) + 1;
//                    }
//
//                    if ((wordMartix[i - 1][j - 1]) + 1 < minimum) {
//                        minimum = (wordMartix[i - 1][j - 1]) + 1;
//                    }
//
//                    wordMartix[i][j] = minimum;
//                }
//            }
//        }
//        return wordMartix[inputWord.length()][checkWord.length()];
//    }
}
