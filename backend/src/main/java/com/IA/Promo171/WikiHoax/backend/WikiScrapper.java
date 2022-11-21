package com.IA.Promo171.WikiHoax.backend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class WikiScrapper {

    private static PageDao pageDao;

    public static void main(String[] args){
        try {
            final WebClient client = new WebClient();
            client.getOptions().setCssEnabled(false);
            client.getOptions().setJavaScriptEnabled(false);

            String url="https://fr.wikihow.com/arrêter-de-baver-pendant-son-sommeil";

            final HtmlPage page = client.getPage(url);

            String title= ((HtmlAnchor) page.getFirstByXPath("//h1[@class='title_md']//a")).getTextContent();

            System.out.println(title);

            String desc=page.getElementById("mf-section-0").asNormalizedText();
            System.out.println(desc);
    
    

            Page wikiPage=pageDao.newPage(new Page(title,desc));

            Long id=wikiPage.getId();

            ArrayList<String> imgUrls=new ArrayList<>();

            List<HtmlImage> imgs=page.getByXPath("//div//div[@class='section_text']//ol[@class='steps_list_2']//li//div[@class='mwimg  largeimage  floatcenter ']//a[@class='image']//div[@class='content-spacer']//img");


            for(HtmlImage img : imgs){
                String imgUrl=img.getAttribute("data-src");

                imgUrls.add(imgUrl);

                Image im= new Image(imgUrl,wikiPage);

                wikiPage.addImage(im);
            }


          }
          catch (Exception e) {
            e.printStackTrace();
          }
    }
    
}
