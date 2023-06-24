package ContollerLayer;

import daoInterface.BookDao;
import daoInterface.ConnectionDAO;
import model.Books;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends ConnectionDAO implements BookDao {
    @Override
    public void saveBook(List<Books> booksList) {
        try {
            Connection con = ConnectionDAO.getConn();
            for (Books b : booksList) {
                String sqlQuery = "Insert into books (isbn, bookName) values(?,?)";
                PreparedStatement pst = con.prepareStatement(sqlQuery);
                pst.setInt(1, b.getIsbn());
                pst.setString(2, b.getBookName());
                int affectedRows = pst.executeUpdate();
                System.out.println(affectedRows + " row(s) affected !!");

            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Books> getAllBooks() {
        try {
            Connection conn = ConnectionDAO.getConn();
            String query = "Select * from books";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            List booklist = new ArrayList();
            while (rs.next()) {
                Books b = new Books();
                b.setIsbn(rs.getInt("ISBN"));
                b.setBookName(rs.getString("bookName"));
                booklist.add(b);
            }
            return booklist;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updatebook(Books bookObj, int id) {
        try {
            Connection connection = ConnectionDAO.getConn();
            PreparedStatement pst = connection.prepareStatement("UPDATE books SET isbn = ?, bookName=? where id = ?");
            pst.setInt(1, bookObj.getIsbn());
            pst.setString(2, bookObj.getBookName());
            pst.setInt(3, id);
            int i = pst.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteBook(int id) {
        try{
            Connection connection = ConnectionDAO.getConn();
            PreparedStatement pst = connection.prepareStatement("DELETE from books where id=?");
            pst.setInt(1,id);
            int i = pst.executeUpdate();
            if(i == 1){
                return true;
            }

        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException ex) {
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
        }
        return false;
    }
}
