package br.com.bicmsystems.library.model;

import java.time.LocalDate;

public class Book {

    private final String name;
    private final String writer;
    private final LocalDate releaseDate;

    private boolean reserved;

    public Book(String name, String writer, LocalDate releaseDate) {
        this.name = name;
        this.writer = writer;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getWriter() {
        return writer;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public void reserve() {
        this.reserved = true;
    }

}
