package com.IA.Promo171.WikiHoax.backend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

            File links =new File("backend//src//main//resources//links.txt");
            Scanner scanner =new Scanner(links);

            String url;

            ArrayList<Page> pages=new ArrayList<>();
            ArrayList<Image> images=new ArrayList<>();

            long page_id=1;
            long image_id=1;

            while (scanner.hasNextLine()) {
                url = scanner.nextLine();

                System.out.println(url);

                final HtmlPage page = client.getPage(url);

                String title = ((HtmlAnchor) page.getFirstByXPath("//h1//a")).getTextContent();

                System.out.println(title);

                String desc = page.getElementById("mf-section-0").getTextContent().replaceAll("\n","");
                System.out.println(desc);

                Page wikiPage=new Page(page_id,title,desc);

                ArrayList<String> imgUrls = new ArrayList<>();

                List<HtmlImage> imgs = page.getByXPath(
                        "//div//div[@class='section_text']//ol[@class='steps_list_2']//li//div[@class='mwimg  largeimage  floatcenter ']//a[@class='image']//div[@class='content-spacer']//img");

                for (HtmlImage img : imgs) {
                    String imgUrl = img.getAttribute("data-src");

                    Image image= new Image(image_id,imgUrl,wikiPage);

                    images.add(image);

                    image_id++;
                }
                pages.add(wikiPage);

                page_id++;
            }
            scanner.close();

            SQLFile(pages,images);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void SQLFile(ArrayList<Page> pages, ArrayList<Image> images){
        File data=new File("backend//src//main//resources//data.sql");
        try {
            data.createNewFile();
            FileOutputStream fstream=new FileOutputStream(data);
            OutputStreamWriter osw=new OutputStreamWriter(fstream,StandardCharsets.UTF_8);
            BufferedWriter writer=new BufferedWriter(osw);

            writer.write("INSERT INTO page(id,description,titre) VALUES\n");

            for(int i=0;i<pages.size();i++){
                Page page = pages.get(i);
                System.out.println(page.getTitre());
                System.out.println(page.getDescription());
                writer.write("("+page.getId().toString()+",\""+page.getDescription()+"\",\""+page.getTitre()+"\")");

                if(i<pages.size()-1){
                    writer.write(",\n");
                }
            }
            writer.write(";\n\n");

            writer.write("INSERT INTO image(id,url,page_fk) VALUES\n");

            for (int i=0;i<images.size();i++){
                Image image=images.get(i);
                writer.write("("+image.getId().toString()+",\""+image.getUrl()+"\","+image.getPage().getId().toString()+")");

                if(i<images.size()-1){
                    writer.write(",\n");
                }
            }
            writer.write(";\n\n");

            writer.close();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }

}
