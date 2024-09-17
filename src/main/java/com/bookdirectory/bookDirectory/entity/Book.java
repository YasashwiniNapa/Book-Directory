package com.bookdirectory.bookDirectory.entity;

import com.fasterxml.jackson.annotation.JsonProperty;



 public class Book {
    @JsonProperty("author")
    private String author;

    @JsonProperty("title")
    private String title;

    @JsonProperty("synopsis")
    private String synopsis;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("id")
    private long id;


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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

     @Override
     public String toString() {
         return "Book{" +
                 "author='" + author + '\'' +
                 ", title='" + title + '\'' +
                 ", synopsis='" + synopsis + '\'' +
                 ", releaseDate='" + releaseDate + '\'' +
                 ", id=" + id +
                 '}';
     }
 }
