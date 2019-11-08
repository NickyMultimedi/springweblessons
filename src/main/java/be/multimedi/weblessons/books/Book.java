package be.multimedi.weblessons.books;

import java.io.Serializable;
import java.util.StringJoiner;

public class Book implements Serializable {
    String isbn;
    String titel;
    String auteur;
    double price;

    public Book() {
    }

    public Book(String isbn, String titel, String auteur, double price) {
        this.isbn = isbn;
        this.titel = titel;
        this.auteur = auteur;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String shortRepresentation() {
        return String.format(
                "%s - %s",
                this.getTitel(),
                this.getAuteur()
        );
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("isbn=" + isbn)
                .add("titel='" + titel + "'")
                .add("auteur='" + auteur + "'")
                .add("price=" + price)
                .toString();
    }
}
