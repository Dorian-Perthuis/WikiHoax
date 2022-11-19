package com.IA.Promo171.WikiHoax.backend;

public class Achievement {
    private int UserId;
    private int score;
    private boolean novice=true;
    private boolean intermediaire=false;
    private boolean expert=false;

    public Achievement(int userId, int score) {
        UserId = userId;
        this.score = score;
    }
}
