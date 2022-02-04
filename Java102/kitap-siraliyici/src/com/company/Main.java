package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;


class Book implements Comparable<Book>{
    private String bookName;
    private int pageNo;
    private String author;
    private Date date;

    public Book(String bookName, int pageNo, String author, Date date) {
        this.bookName = bookName;
        this.pageNo = pageNo;
        this.author = author;
        this.date = date;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(Book o) {
        if(pageNo == o.pageNo)
        {
            if(bookName.compareTo(o.bookName) == 0)
            {
                if(pageNo == o.pageNo)
                    return 0;
                else if (pageNo > o.pageNo)
                    return 1;
                else
                    return -1;
            }
            else
                return bookName.compareTo(o.bookName);
        }
        else if(pageNo > o.pageNo)
            return -1;
        else
            return 1;
    }
}


public class Main {

    public static void main(String[] args) {
        PriorityQueue<Book> bookList = new PriorityQueue<>();
        bookList.add(new Book("A Kitabı",100,"A Author",new Date()));
        bookList.add(new Book("C Kitabı",101,"A Author",new Date()));
        bookList.add(new Book("B Kitabı",120,"B Author",new Date()));
        bookList.add(new Book("E Kitabı",90,"C Author",new Date()));
        bookList.add(new Book("D Kitabı",20,"E Author",new Date()));

        //bookList.comparator();

        for (Book book:bookList) {
            System.out.println(book.getBookName());
        }
        for (Book book:bookList) {
            System.out.println(book.getPageNo());
        }
    }
}
