package com.domain;

import javax.persistence.*;


@Entity
@Table(name = "book")
public class Book {
    /*• id – идентификатор книги в БД;
• title – название книги. Можно использовать тип VARCHAR(100);
• description – краткое описание о чем книга. Можно использовать тип
    VARCHAR(255);
• author – фамилия и имя автора. Можно использовать тип VARCHAR(100);
• isbn – ISBN книги. Можно использовать тип VARCHAR(20);
• printYear – в каком году напечатана книга (INT);
• readAlready – читал ли кто-то эту книгу. Это булево поле.*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 100)
    private String title;

    @Column(unique = true)
    private String description;

    @Column(length = 100, updatable = false)
    private String author;

    @Column(length = 20)
    private String isbn;

    @Column(name = "print_year")
    private int printYear;

    @Column(name = "is_read")
    private boolean readAlready;

    public Book(String title, String description, String author, String isbn, int printYear, boolean readAlready) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.isbn = isbn;
        this.printYear = printYear;

        this.readAlready = readAlready;
    }

    public Book() {
    }

    public String getDescription() {
        return description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", printYear=" + printYear +
                ", readAlready=" + readAlready +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrintYear() {
        return printYear;
    }

    public void setPrintYear(int printYear) {
        this.printYear = printYear;
    }

    public void setReadAlready(boolean readAlready) {
        this.readAlready = readAlready;

    }

    public boolean isReadAlready() {

        return readAlready;
    }
}
