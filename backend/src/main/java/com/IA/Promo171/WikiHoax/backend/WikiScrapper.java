package com.IA.Promo171.WikiHoax.backend;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WikiScrapper {
    public static void main(String[] args) {
        try {
            final WebClient client = new WebClient();
            client.getOptions().setCssEnabled(false);
            client.getOptions().setJavaScriptEnabled(false);

            //String url="https://fr.wikihow.com/arrêter-de-baver-pendant-son-sommeil";
            String url="https://fr.wikihow.com/persuader-les-gens-de-voter-pour-moi";

            final HtmlPage page = client.getPage(url);

            String title= ((HtmlAnchor) page.getFirstByXPath("//h1[@class='title_md']//a")).getTextContent();

            System.out.println(title);

            String desc=page.getElementById("mf-section-0").asNormalizedText();
            System.out.println(desc);

            ArrayList<String> imgUrls=new ArrayList<>();

            List<HtmlImage> imgs=page.getByXPath("//div//div[@class='section_text']//ol[@class='steps_list_2']//li//div[@class='mwimg  largeimage  floatcenter ']//a[@class='image']//div[@class='content-spacer']//img");

            Files.createDirectory(Paths.get("D:/WikiHoaxImages/"+title));

            for(HtmlImage img : imgs){
                String imgUrl=img.getAttribute("data-src");

                imgUrls.add(imgUrl);
            }

          }
          catch (Exception e) {
            e.printStackTrace();
          }
    }
}
