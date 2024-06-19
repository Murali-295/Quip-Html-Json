package com.mk.service;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class HtmlService {

    public Map<String,Object> generateHtmlToJson(Document document) throws IOException {

        Elements headers = document.select("h1,h2,h3,h4,h5,h6");

        List<Map<String,String>> headerData=new ArrayList<>();

        for(Element header:headers){
            Map<String,String> headings=new LinkedHashMap<>();
            headings.put("tag",header.tagName());
            headings.put("content",header.text());

            for (Attribute attribute : header.attributes()) {
                headings.put(attribute.getKey(), attribute.getValue());
            }
            headerData.add(headings);
        }

        Map<String,Object> totalData = new LinkedHashMap<>();
        totalData.put("headings", headerData);

        return totalData;
    }

}
