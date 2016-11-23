package com.github.ricardobaumann.investigaturl.services;

import com.github.ricardobaumann.investigaturl.models.UrlData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Business service class
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
        Optional<Node> docTypeElement = doc.childNodes().stream().filter((node) -> node instanceof DocumentType).findFirst();

        docTypeElement.ifPresent((value)-> urlData.setHtmlVersion(value.attributes().asList().toString()));

        Elements links = doc.select("a[href]");
        int totalLinks = links.size();

        urlData.setExternalLinks((int)
                links
                        .stream()
                        .filter((link)-> link.attr("href").startsWith("http"))
                        .count());

        urlData.setInternalLinks(totalLinks - urlData.getExternalLinks());

        Map<Integer, Integer> headingLevels = new HashMap<>();

        for (int x=1;x<=6;x++) {
            Elements headings = doc.select(String.format("h%s",x));
            headingLevels.put(x, headings.size());
        }

        urlData.setHeadingLevels(headingLevels);

        urlData.setContainLoginForm(doc.select("form input[id*=email],input[id*=user],input[id*=password]").size()>0);

        return urlData;
    }

}
