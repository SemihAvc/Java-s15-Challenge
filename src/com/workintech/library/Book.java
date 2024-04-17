package com.workintech.library;

import com.workintech.library.Enums.Kategory;
import com.workintech.library.Enums.KitapDurumu;

public class Book implements Comparable<Book>, Cloneable { // clonable nesleelri klonlamamızz ayarlar
public  Long ID;
private  String author;
private String name;
private  double price;
private KitapDurumu kitapDurumu;
private  int stock;
private Kategory kategory;

    public Book(Long ID, String author, String name, double price, KitapDurumu kitapDurumu, int stock, Kategory kategory) {
        this.ID = ID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.kitapDurumu = kitapDurumu;
        this.stock = stock;
        this.kategory = kategory;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public KitapDurumu getKitapDurumu() {
        return kitapDurumu;
    }

    public void setKitapDurumu(KitapDurumu kitapDurumu) {
        this.kitapDurumu = kitapDurumu;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Kategory getKategory() {
        return kategory;
    }

    public void setKategory(Kategory kategory) {
        this.kategory = kategory;
    }

    @Override
    public String toString() {
        return "com.workintech.library.Book{" +
                "ID=" + ID +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", kitapDurumu=" + kitapDurumu +
                ", stock=" + stock +
                ", kategory=" + kategory +
                '}';
    }
    @Override
    public int  compareTo(Book book){
        return Long.compare(this.ID, book.getID());
    }

}
