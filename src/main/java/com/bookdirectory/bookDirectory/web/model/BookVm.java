package com.bookdirectory.bookDirectory.web.model;

public class BookVm {

    private String title;
    private String author;
    private String synopsis;
    private String releaseDate;

    //empty constructor
    public BookVm() {

    }

    public BookVm(String title, String author, String synopsis, String releaseDate) {
        this.title = title;
        this.author = author;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
