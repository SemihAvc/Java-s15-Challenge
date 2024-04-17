package com.workintech.library.Persons;

import com.workintech.library.Enums.Kategory;
import com.workintech.library.Interfaces.CommonAuthority;
import com.workintech.library.Interfaces.LibrarianAuthority;
import com.workintech.library.Enums.KitapDurumu;
import com.workintech.library.Enums.PersonalRoles;
import com.workintech.library.Library;
import com.workintech.library.Book;

import java.util.Iterator;
import java.util.TreeMap;

public class Librarian extends Person implements LibrarianAuthority, CommonAuthority {
    private Library library;

    public Librarian(String name, String surname, long TCKN, PersonalRoles personalRoles) {
        super(name, surname, TCKN, personalRoles);

    }

    public Librarian(String name, Library library) {
        super(name);
        this.library = library;
    }


    @Override
    public void addBook(Book book) {
        if (book.getStock() == 0 && book.getKitapDurumu() == KitapDurumu.HASARLI) {
            book.setKitapDurumu(KitapDurumu.HASARLIDEGIL);
        }
        if (library.getBooks().containsKey(book.getID())) {
            updateBook(book, book.getID(), book.getAuthor(), book.getName(), book.getPrice(),
                    book.getKitapDurumu(), book.getStock(), book.getKategory());
        } else {
            book.setStock(book.getStock() + 1);
            TreeMap<Long, Book> sortedBooks = new TreeMap<>(library.getBooks());
            sortedBooks.put(book.getID(), book);
            library.setBooks(sortedBooks);
            System.out.println("Kitap başarıyla eklenmiştir" + book.getName());
        }

    }


    @Override
    public void addBook(java.awt.print.Book book) {

    }

    @Override
    public void deleteBook(Long ID) {
        Iterator<Book> iterator = library.getBooks().values().iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getID() == ID) {
                iterator.remove();
                System.out.println("Bu kitap sistemden silinmiştir." + book.getName() + "+" + book.getID());
                return;
            }
        }
        System.out.println("Sistmde  böyle bir kitap bulunmamaktadır.");
    }

    @Override
    public void updateBook(java.awt.print.Book book, Long ID, String author, String name, double price, KitapDurumu kitapDurumu, int stock, Kategory kategory) {

    }

    @Override
    public void updateBook(Book book, Long ID, String author, String name, double price, KitapDurumu kitapDurumu, int stock, Kategory kategory) {
        Long oldID = null;
        if (searchBook(book.getName())) {
            oldID = book.getID();

            book.setStock(stock);
            book.setKitapDurumu(kitapDurumu);
            book.setKategory(kategory);
            book.setName(name);
            book.setID(ID);
            book.setAuthor(author);
            book.setPrice(price);
        }
        // Mevcut kitabın ID'sini değiştir
        library.getBooks().remove(oldID);
        library.getBooks().put(book.getID(), book);
    }

    @Override
    public boolean searchBook(String bookName) {
        for (Book book : library.getBooks().values()) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                System.out.println("Aradığınız kitap sistemde bulunmuştur." + ("Kitap adı:" + book.getName()) + "Kitap ID:" + book.getID() + "Kitap Yazarı:" + book.getAuthor() + "Kitap Stok:" + book.getStock());
                return true;
            }
        }
        System.out.println("Aradığınız kitap sistemde bulunmamaktadır.");
        return false;
    }


    @Override
    public boolean searchBook(long ID) {

        for (Book book : library.getBooks().values()) {

            if (book.getID() == ID) {

                System.out.println("Aradığınız kitap sistemde bulunmuştur.");
                System.out.println("Kitap adı: " + book.getName());
                System.out.println("Kitap ID: " + book.getID());
                System.out.println("Kitap Yazarı: " + book.getAuthor());
                System.out.println("Kitap Stok: " + book.getStock());

                return true;
            }
        }

        System.out.println("Aradığınız kitap sistemde bulunmamaktadır.");
        return false;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "library=" + library +
                '}';
    }
}


