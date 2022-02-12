package com.company;

import java.time.LocalDate;
import java.util.Date;

public class Book {
    private String name;
    private String author;
    private int pageSize;
    private LocalDate releaseDate;

    public Book(String name, String author, int pageSize, LocalDate releaseDate) {
        this.name = name;
        this.author = author;
        this.pageSize = pageSize;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
