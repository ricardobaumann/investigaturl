package com.github.ricardobaumann.investigaturl.services;

import com.github.ricardobaumann.investigaturl.models.UrlData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by ricardobaumann on 22/11/16.
 */
@Service
public class UrlDataService {

    public UrlData extractFrom(String url) throws IOException {

        Document doc = Jsoup.connect(url).get();
        Elements titleElements = doc.getElementsByTag("title");
        String title = null;
        if (titleElements!=null && titleElements.hasText()) {
            title = titleElements.get(0).text();
        }

        UrlData urlData = new UrlData();
        urlData.setPageTitle(title);

        return urlData;
    }

}
