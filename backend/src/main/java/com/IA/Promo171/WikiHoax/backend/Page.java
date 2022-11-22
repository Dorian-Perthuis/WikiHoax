package com.IA.Promo171.WikiHoax.backend;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="page", cascade = CascadeType.ALL)
    private List<Image> img = new ArrayList();

    public Page(long id) {
        this.id = id;
    }


    public Page(Long id, String titre, String description) {
        this.id = id;
        this.titre = titre;
        this.description = description;
    }


    public List<Image> getImages() {
        return img;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImg() {
        return this.img;
    }

    public void setImg(List<Image> img) {
        this.img = img;
    }

    public void addImage(Image image){
        this.img.add(image);
    }


}
