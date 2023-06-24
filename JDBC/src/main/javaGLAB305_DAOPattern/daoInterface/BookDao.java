package daoInterface;

import model.Books;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {

    //CRUD operations that will be exposed to our business layer.
    /**
     * This is the method to be used to list down all the records from the books table.
     */
    List<Books> getAllBooks() throws ClassNotFoundException, SQLException;

    boolean updatebook(Books bookObj, int id);

    /**
     * This method to be used to create a record in the books table.
     */
    void saveBook(List<Books> booksList);

    /**
     * This is the method to be used to update a record into the books table.
     */
    boolean deleteBook(int id);
}
