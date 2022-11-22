package com.IA.Promo171.WikiHoax.backend.Image;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.IA.Promo171.WikiHoax.backend.Page.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "page_fk")
    @JsonIgnore
    private Page page;
    
    public Image() {
    }

    public Image(String url) {
        this.url = url;
    }

    public String toJson() { 
        return ImageHelper.toJsonConverter(this);
    }

    public void setPage(Page newPage) {
        this.page=newPage;
    }
    

}
