package com.IA.Promo171.WikiHoax.backend;

public class Word {
    private String word;
    private Boolean hidden=true;

    public Word(String word, Boolean hidden) {
        this.word = word;
        this.hidden = hidden;
    }

    public Word() {
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Boolean isHidden() {
        return this.hidden;
    }

    public Boolean getHidden() {
        return this.hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }
    
}
