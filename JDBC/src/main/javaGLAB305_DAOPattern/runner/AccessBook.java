package runner;

import ContollerLayer.BookDaoImpl;
import daoInterface.BookDao;
import model.Books;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccessBook {
    public static void main(String[] args) {
        // creating object for BookDao interface and books class
        BookDao bookDao = new BookDaoImpl();//upcasting
        System.out.println("--------- inserting book records ----------");
        ArrayList<Books> BookList = new ArrayList<>();

        //Adding books to lsit
        Books b = new Books();
        b.setIsbn(120);
        b.setBookName("Java Book");
        BookList.add(b);

        Books b2 = new Books();
        b2.setIsbn(300);
        b2.setBookName("Python Book");
        BookList.add(b2);

        Books b3 = new Books();
        b3.setIsbn(365);
        b3.setBookName("JavaScript Book");
        BookList.add(b3);

        Books b4 = new Books();
        b4.setIsbn(256);
        b4.setBookName("SQL Book");
        BookList.add(b4);

        bookDao.saveBook(BookList);

        // Retrieve Books
        System.out.println( " ====== Display list of all books ====");
        try{
            for(Books b1: bookDao.getAllBooks()){
                int isbn = b1.getIsbn();
                String bookname = b1.getBookName();
                System.out.println("======================");
                System.out.println("ISBN Number :" + isbn + "and Book name: " + bookname);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Update booklist
        System.out.println("----Book information is updating -----");
        b.setIsbn(3);
        b.setBookName("Algorithm Book");
        boolean result = bookDao.updatebook(b,3);
        System.out.println(result);

        //Delete booklist
        System.out.println("----Book Entry is deleted -----");
        boolean a = bookDao.deleteBook(4);
        if(a == true){
            System.out.println("Record is deleted");
        }else {
            System.out.println("Record is not deleted");
        }
    }
}
