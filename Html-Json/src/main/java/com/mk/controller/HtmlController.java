package com.mk.controller;

import com.mk.service.HtmlService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

import java.util.*;

@RestController
public class HtmlController {

    @Autowired
    private HtmlService htmlService;


    @GetMapping("/convertHTMLToJson")
    public  Map<String,Object> convertHTMLToJson() throws IOException {

        // to get data from a local html file
        String url = "https://moz.com/learn/seo/h1-tags#:~:text=For%20the%20purposes%20of%20clarity,page%20or%20other%20online%20location.";
        Document document = Jsoup.connect(url).get();

        return htmlService.generateHtmlToJson(document);
    }
}