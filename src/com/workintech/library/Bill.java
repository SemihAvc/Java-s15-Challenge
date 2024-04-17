package com.workintech.library;

import com.workintech.library.Enums.KitapDurumu;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Locale;

public class Bill implements Comparable<Bill> {
    private LocalDate date;
    private Long ID;
    private String bookname;
    private KitapDurumu kitapDurumu;
    private double price;

    public Bill(LocalDate date, Long ID, String bookname, KitapDurumu kitapDurumu, double price) {
        this.date = date;
        this.ID = ID;
        this.bookname = bookname;
        this.kitapDurumu = kitapDurumu;
        this.price = price;
    }

    public void billPrinter() {
        System.out.println("Fatura Bilgileri");
        System.out.println("Date: " + date);
        System.out.println("ID: " + ID);
        System.out.println("com.workintech.library.Book Name: " + bookname);
        System.out.println("Kitap Durumu: " + kitapDurumu);
        System.out.println("Amount To Be Paid: " + price);
    }

    @Override
    public String toString() {
        return "com.workintech.library.Bill{" +
                "date=" + date +
                ", ID=" + ID +
                ", bookname='" + bookname + '\'' +
                ", kitapDurumu=" + kitapDurumu +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Bill bill) {
        Collator collator = Collator.getInstance(new Locale("tr", "TR"));
        int nameComparison = collator.compare(this.bookname, bill.bookname); // iki faturanın kitap isimlerini karşılaştırıyoruz
        if (bill.date.isEqual(this.date)) {
            return nameComparison;
        }
        return bill.date.compareTo(this.date);
    }
}
