package com.ban.ms.eureka.client.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
@RequestMapping(path="/api")
public class WordController {

    private final static String DEMO_SUBJECT   = "demo-subject";
    private final static String DEMO_VERB      = "demo-verb";
    private final static String DEMO_ARTICLE   = "demo-article";
    private final static String DEMO_ADJECTIVE = "demo-adjective";
    private final static String DEMO_NOUN      = "demo-noun";
    private final static String WORD_URL       = "/api/word/say";
    private final static String HTTP           = "http://";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${words:#{null}}")
    private String wordsString;



    @RequestMapping(path="/word/say")
    private String sayWord() {

        if(StringUtils.isEmpty(wordsString)) {
            return "";
        }

        String[] words = wordsString.split("\\,");
        int size = words.length;
        Random r = new Random();
        int rand = r.nextInt(size);
        return words[rand];
    }

    @RequestMapping(path="/sentence/say")
    private String saySentence() {

        String subj = restTemplate.getForObject(HTTP + DEMO_SUBJECT + WORD_URL, String.class);
        String verb = restTemplate.getForObject(HTTP + DEMO_VERB + WORD_URL, String.class);
        String article = restTemplate.getForObject(HTTP + DEMO_ARTICLE + WORD_URL, String.class);
        String adjective = restTemplate.getForObject(HTTP + DEMO_ADJECTIVE + WORD_URL, String.class);
        String noun = restTemplate.getForObject(HTTP + DEMO_NOUN + WORD_URL, String.class);

        return subj + " "
                + verb + " "
                + article + " "
                + adjective + " "
                + noun + " ";
    }
}
