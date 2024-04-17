package com.workintech.library.Interfaces;

import com.workintech.library.Book;
import com.workintech.library.Enums.Kategory;
import com.workintech.library.Enums.KitapDurumu;

public interface CommonAuthority {
    void addBook(Book book);

    void updateBook(Book book, Long ID, String author, String name, double price, KitapDurumu kitapDurumu, int stock, Kategory kategory);

    boolean searchBook(String bookName);
    boolean searchBook(long ID);
}
