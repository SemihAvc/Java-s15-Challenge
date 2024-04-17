package com.workintech.library.Interfaces;

import com.workintech.library.Enums.Kategory;
import com.workintech.library.Enums.KitapDurumu;

import java.awt.print.Book;

public interface LibrarianAuthority {
void addBook(Book book);



    void  deleteBook(Long ID);

void updateBook(Book book, Long ID,String author, String name, double price, KitapDurumu kitapDurumu, int stock , Kategory kategory);

}
