package com.IA.Promo171.WikiHoax.backend;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="page", cascade = CascadeType.ALL)
    private List<Image> img = new ArrayList();

    public Page(long id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return img;
    }

}
