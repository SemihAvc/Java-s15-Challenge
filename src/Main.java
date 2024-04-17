import com.workintech.library.Book;
import com.workintech.library.Enums.Kategory;
import com.workintech.library.Enums.KitapDurumu;
import com.workintech.library.Library;
import com.workintech.library.Persons.Librarian;
import com.workintech.library.Persons.Reader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Kütüphanemize Hoş Geldiniz");

        Book book1 = new Book(1L, "Mehmet Rauf", "Eylül", 35, KitapDurumu.HASARLIDEGIL, 2, Kategory.NOVEL);
        Book book2 = new Book(2L, "Kemal Tahir", "Devlet Ana", 30, KitapDurumu.HASARLIDEGIL, 6, Kategory.HISTORY);
        Book book3 = new Book(3L, "Oğuz Atay", "Bir Bilim Adamının Kitabı", 40, KitapDurumu.HASARLIDEGIL, 14, Kategory.HISTORY);
        Book book4 = new Book(4L, "Ahmet Mehmet", "Şafağın Çocuğu", 20, KitapDurumu.HASARLIDEGIL, 0, Kategory.HISTORY);
        Book book5 = new Book(5L, "Ayşe Özkan", "Problemlerle Matematik", 85, KitapDurumu.HASARLIDEGIL, 0, Kategory.STUDYBOOKS);
        Book book6 = new Book(6L, "Buse Deniz", "Aslanın Doğuşu", 60, KitapDurumu.HASARLI, 20, Kategory.FANTASY);
        Book book7 = new Book(7L, "Cengiz Elbaş", "Eski Çocuklar", 15, KitapDurumu.HASARLIDEGIL, 6, Kategory.NOVEL);
        Book book8 = new Book(8L, "Ceren Gören", "Türklük Terimleri", 12, KitapDurumu.HASARLI, 0, Kategory.HISTORY);
        Book book9 = new Book(9L, "Elif Işık", "Ezel", 20, KitapDurumu.HASARLIDEGIL, 12, Kategory.MAGAZINES);
        Book book10 = new Book(10L, "Osman Sınav", "Kurtlar Vadisi", 100, KitapDurumu.HASARLIDEGIL, 12, Kategory.STUDYBOOKS);

        Library library = new Library();

        library.getBooks().put(book3.getID(), book3);
        library.getBooks().put(book1.getID(), book1);
        library.getBooks().put(book2.getID(), book2);
        library.getBooks().put(book10.getID(), book10);
        library.getBooks().put(book8.getID(), book8);
        library.getBooks().put(book7.getID(), book7);
        System.out.println("Kütüphanede bulunan kitaplar:" + library.getBooks());

        //Ekleme işlemleri
        Librarian librarian = new Librarian("Leyla", library);
        librarian.addBook(book1);
        librarian.addBook(book1);
        librarian.addBook(book2);
        librarian.addBook(book3);
        librarian.addBook(book4);
        librarian.addBook(book5);
        librarian.addBook(book6);
        librarian.addBook(book7);
        librarian.addBook(book8);
        librarian.addBook(book7);
        librarian.addBook(book8);
        librarian.addBook(book9);
        librarian.addBook(book10);


        // Kitap listesini yazdırma
        for (Book book : library.getBooks().values()) {
            System.out.println(book);
        }
        librarian.searchBook("Kurtlar Vadisi");
        librarian.searchBook("Aslanın Doğuşu");
        librarian.searchBook("Devlet Ana");
        librarian.searchBook("DEVLET ANA");
        librarian.searchBook("Güneş Doğarken");



        librarian.searchBook("Kurtlar Vadisi");



        //delete book

        librarian.deleteBook(1L);
        librarian.deleteBook(2L);


        for (Book book : library.getBooks().values()) {
            System.out.println(book);
        }

        // GÜNCELLEME
        librarian.updateBook(book4,11L,"Ahmet Mehmet","Şafağın Çocuğu",50,KitapDurumu.HASARLIDEGIL,5,Kategory.HISTORY);
        for (Book book : library.getBooks().values()) {
            System.out.println(book);
        }
//READER iŞLEMLERİ
        Reader reader1 = new Reader("Semih","Avcı","semavci95@gmail.com",123456,"15L","Avc123",250,library);
        Reader reader2 = new Reader("Süleyman","Çakır","sem95@gmail.com",134562,"15L","Avc123",250,library);
        Reader reader3 = new Reader("İskender","Büyük","semavci5@gmail.com",23456,"55L","Av23",250,library);
        Reader reader4 = new Reader("Ziya","Laz","smavci95@gmail.com",123457,"15L","Avc123",250,library);


        //GİRİŞ YAP

        reader1.login("Semih","Avcı","semavci95@gmail.com",123456,"Avc123");
        reader3.login("İskender","Büyük","semavci5@gmail.com",23456,"Av23");
        reader3.login("İskener","Büük","semvci5@gmail.com",2356,"A23");// Hatalı giriş.



        //Kitap Arama
        //İsme Göre
        reader1.searchBook("Şahane Hayat");
        reader2.searchBook("Merhaba Hayat");
        reader3.searchBook("Kurtlar Vadisi");
        //ID'ye göre
        reader1.searchBook(5L);
        reader1.searchBook(14L);






        //Kitap Ödünç Alma-Fatura basılıyor
        //En fazla 5 kitap alınıyor.-Alınan kitaptan 2.si alınamıyor. -Kitap alındığında stock azalıyor.
        reader1.borrow("Şahane Hayat");
        reader1.borrow("Devlet Ana");
        reader1.borrow("Türklük Terimleri");
        reader1.borrow("Aslanın Doğuşu");
        reader1.borrow("Bir Bilim Adamının Kitabı");
        reader1.borrow("Devlet Ana");

        reader1.displayBorrowedBooks();
        //Kalan Parayı gösterme
        System.out.println("Bakiye: " +reader1.getMoney());

        // for (Book book : library.getBooks().values()) {
        //  System.out.println(book);
        // }
        //Stockta bulunmama durumu
        reader2.borrow("Türklük Terimleri");
        reader2.borrow("Devlet Ana");
        reader2.borrow("Devlet Ana");
        reader2.displayBorrowedBooks();
        System.out.println("Bakiye: " +reader2.getMoney());
        for (Book book : library.getBooks().values()) {
            System.out.println(book);
        }


        //Geri verme
        //Kitap hasarlı ise ücret iadesi yok.Hasarlı değilse fiyat/1.50 iade edilir

        reader1.returnBook("Şahane Hayat",true);
        reader1.returnBook("Aslanın Doğuşu",false);

        reader1.displayBorrowedBooks();
        //Kalan Parayı gösterme
        System.out.println("Bakiye: " +reader1.getMoney());

        for (Book book : library.getBooks().values()) {
            System.out.println(book);
        }









    }}