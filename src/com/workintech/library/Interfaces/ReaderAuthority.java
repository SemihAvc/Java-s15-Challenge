package com.workintech.library.Interfaces;

public interface ReaderAuthority {

    void borrow(String book);
    void  returnBook(String returnBook, boolean isHasarlı);
    boolean  login(String inputName, String inputSurname,String inputEmail,long inputTCKN , String inputPassword);
}
