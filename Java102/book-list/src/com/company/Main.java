package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Book book1 = new Book("Kitap1","Yazar1",100,LocalDate.of(1999,12,1));
        Book book2 = new Book("Kitap2","Yazar2",250,LocalDate.of(2001,1,4));
        Book book3 = new Book("Kitap3","Yazar3",350,LocalDate.of(1999,12,1));
        Book book4 = new Book("Kitap4","Yazar2",499,LocalDate.of(1993,9,1));
        Book book5 = new Book("Kitap5","Yazar4",50,LocalDate.of(1995,12,1));
        Book book6 = new Book("Kitap6","Yazar5",15,LocalDate.of(1999,7,1));
        Book book7 = new Book("Kitap7","Yazar2",45,LocalDate.of(2005,12,1));
        Book book8 = new Book("Kitap8","Yazar3",120,LocalDate.of(1890,6,1));
        Book book9 = new Book("Kitap9","Yazar6",243,LocalDate.of(1999,5,1));
        Book book10 = new Book("Kitap10","Yazar6",432,LocalDate.of(1990,12,1));

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);

        Map<String,String> bookAuthor = new HashMap<>();
        books.stream().forEach((Book book) -> {
           bookAuthor.put(book.getName(),book.getAuthor());
        });

        bookAuthor.forEach((String key,String value)-> System.out.println(key + " -> " + value));

        ArrayList<Book> newList = new ArrayList<>();
        books.stream().filter((Book book)-> book.getPageSize()>100).forEach(book -> newList.add(book));
        newList.forEach(x->System.out.println(x.getPageSize()));

    }
}
