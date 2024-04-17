package com.workintech.library.Persons;

import com.workintech.library.Bill;
import com.workintech.library.Book;
import com.workintech.library.Enums.Kategory;
import com.workintech.library.Enums.KitapDurumu;
import com.workintech.library.Interfaces.CommonAuthority;
import com.workintech.library.Interfaces.ReaderAuthority;
import com.workintech.library.Library;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Formattable;
import java.util.List;

public class Reader extends Person implements ReaderAuthority, CommonAuthority {
private String id;
private  String password;
    private  List<Book> borrowedBooks;
    private double money;
private List<Bill> bills;


private Library library;

    public Reader(String name, String surname, String email, long TCKN, String id, String password,  double money,Library library) {
        super(name, surname, email, TCKN);
        this.id = id;
        this.password = password;
        this.bills = bills;
        this.money = money;
        this.borrowedBooks = borrowedBooks;
        this.library = library;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public void updateBook(Book book, Long ID, String author, String name, double price, KitapDurumu kitapDurumu, int stock, Kategory kategory) {

    }

    @Override
    public boolean searchBook(String bookName) {
       if (library==null){
           System.out.println("Hata: Kütüphane bulunamadı.");
           return false;
       }
   for (Book book: library.getBooks().values()){
       if (book.getName().equalsIgnoreCase(bookName)){
           System.out.println("Aradığınız kitap:"+book.getID()+book.getName()+book.getAuthor()+book.getStock()+book.getKategory());
           return true;
       }
   }
        System.out.println("Aradığınız kitabı sistemde bulamadık.");
   return false;

    }

    @Override
    public boolean searchBook(long ID) {
       for (Book book:library.getBooks().values()){
           if (book.getID()== ID){
               System.out.println("Aradığınız kitap:"+book.getID()+book.getName()+book.getAuthor()+book.getKategory()+book.getStock());
               return true;

           }
       }
        System.out.println("Aradığınız kitap bulunamadı.");
       return false;
    }

    @Override
    public void borrow(String requiredBook) {
        if (borrowedBooks.size() >= 5) {
    System.out.println("En fazla 5 kitap alabilirsiniz.");
    return;
}
for (Book borrowedBook : borrowedBooks){
    if (requiredBook.equalsIgnoreCase(borrowedBook.getName())){
        System.out.println(requiredBook+"Bu kitabı daha önce  zaten ödünç aldınız.");
        return;
    }
}
for (Book book : library.getBooks().values()){
    if (requiredBook.equalsIgnoreCase(book.getName()) && book.getStock()>0){
        if (book.getKitapDurumu()== KitapDurumu.HASARLI){
            System.out.println(requiredBook+"Kitap şuanda ödünç alınamaz.");
            return;
        }
double bookPrice = book.getPrice();
        if (this.getMoney() >= bookPrice){
            borrowedBooks.add(book);
            book.setStock(book.getStock()-1);
            this.setMoney(this.getMoney() -bookPrice);
            Bill bill = new Bill(LocalDate.now(),book.getID(),book.getName(),book.getKitapDurumu(),book.getPrice());bills.add(bill);



            if (book.getKitapDurumu()== KitapDurumu.HASARLI){
                System.out.println("Son"+requiredBook+"kitabı almıştır"+bookPrice+"bakiyenizden düşülmüştür.");
                bill.billPrinter();
            }else {
                System.out.println("Yetersiz bakiye lütfen bakiyenizi yükseltin.");
                return;
            }
        }
    }
}
        System.out.println(requiredBook+"Kitabı stokta bulunmamaktadır.");
    }
    @Override
    public void returnBook(String returnBook, boolean isHasarlı) {
        for (Book book: borrowedBooks){
            if (book.getName().equalsIgnoreCase(returnBook)){
                 borrowedBooks.remove(book);
            }
            book.setStock(book.getStock()+1);//iade işlemi
            if (isHasarlı){
                System.out.println(returnBook+"katabınız hasarlı iade edildi.Ücret iadesi yapılmayacak.");
                return;
            }else {
                double refundeAmound =book.getPrice()/1.50;
                this.setMoney(this.getMoney()+refundeAmound);
                System.out.println(refundeAmound+"kitabınız başarıyla iade edldi.Ücret iadesi yapıldı:"+refundeAmound+"TL");
            }
        }
        System.out.println("Bu kitap ödünç alınmamış  yada hatalı bir kitap ismi girdiniz.");
    }

    @Override
    public boolean login(String inputName, String inputSurname, String inputEmail, long inputTCKN, String inputPassword) {
if (password.equalsIgnoreCase(inputPassword)&& getEmail() == inputEmail && inputTCKN==getTCKN()){

    System.out.println("Sisteme Hoşgeldiniz."+inputName+inputSurname);
    return true;
}
        System.out.println("Lüten tekrar deneyiniz.");
return false;
    }
    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("Ödünç alınan kitap bulunmamaktadır.");
            return;
        }

        System.out.println("Ödünç alınan kitaplar:");
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getName());
        }
    }

}
