package ru.skillbox;

public class Book {
    private final String name;
    private final String author;
    private final int pages;
    private final int numberISBN;

    public Book(String name, String author, int pages, int numberISBN)
    {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.numberISBN = numberISBN;
    }

    public String getName()
    {
        return name;
    }

    public String getAuthor()
    {
        return author;
    }

    public int getPages()
    {
        return pages;
    }

    public int getNumberISBN()
    {
        return numberISBN;
    }
}

