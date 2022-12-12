package com.example.mobileprogrammingproject.model;

public class GameModel {
    public GameModel(Integer id, String name, String photoUrl, int metaCritic, String genre, String description, String redditUrl, String websiteUrl) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
        this.metaCritic = metaCritic;
        this.genre = genre;
        this.description = description;
        this.redditUrl = redditUrl;
        this.websiteUrl = websiteUrl;
    }

    private Integer id;

    private String name;

    private String photoUrl;

    private int metaCritic;

    private String genre;

    private String description;

    private String redditUrl;

    private String websiteUrl;

    private boolean isFavorited;

    private boolean isClicked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getMetaCritic() {
        return metaCritic;
    }

    public void setMetaCritic(int metaCritic) {
        this.metaCritic = metaCritic;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRedditUrl() {
        return redditUrl;
    }

    public void setRedditUrl(String redditUrl) {
        this.redditUrl = redditUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public boolean isFavorited() {
        return isFavorited;
    }

    public void setFavorited(boolean favorited) {
        isFavorited = favorited;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }
}
