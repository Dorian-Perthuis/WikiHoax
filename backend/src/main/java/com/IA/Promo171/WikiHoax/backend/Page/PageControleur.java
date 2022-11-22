package com.IA.Promo171.WikiHoax.backend.Page;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.IA.Promo171.WikiHoax.backend.Image.Image;

@RestController
public class PageControleur {

    @Autowired
    private PageDao pageDao;

    @RequestMapping(value = "/page/{id}/new/", method = RequestMethod.GET)
    public Page newPage(@PathVariable int id) {
        Page newPage = new Page(id);
        

        Image img1 =new Image("url1");
        img1 = pageDao.newImage(img1);
        Image img2 = new Image("url2");
        img2 = pageDao.newImage(img2);

        img1.setPage(newPage);
        img2.setPage(newPage);

        newPage.getImages().add(img1);
        newPage.getImages().add(img2);

        newPage = pageDao.newPage(newPage);

        return newPage;
    }

    @RequestMapping(value = "/page/{id}/images/", method = RequestMethod.GET)
    public String listeImagesForPage(@PathVariable int id) {

        Page aPage = pageDao.getPage(Long.valueOf(id));
        List<Image> lesImages = aPage.getImages();
        return lesImages.stream().map(img -> {return img.toJson();}).collect(Collectors.joining(",", "[", "]")); 

    }
}