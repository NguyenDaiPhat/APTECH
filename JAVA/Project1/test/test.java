
import DATA.Database;
import model.Book;
import Dao.BookDao;
import MAIN.TestMain;
import java.sql.Connection;
import java.util.ArrayList;
import model.User_id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Book book1 = new Book(1,"thep",2020,20000,30,"kinh di");
        //Book book2 = new Book(2,"lửa và máu",2020,20000,30,"chiến tranh");
       
        //Book book2 = new Book("sdhfks","lửa và máu",2020,20000,30,"chiến tranh");
        //BookDao.getInstance().insert(book2);
        //BookDao.getInstance().insert(book2);
        
        
        //Book book1 = new Book(1,"THÉP CỦA TÔI",2020,20000,30,"Tiệu thuyết");
        //BookDao.getInstance().update(book1);
        
        //Book book2 = new Book(2,"lua",2020,20000,30,"hai");
        //BookDao.getInstance().delete(book2);
        
        
        //ArrayList<Book> list = BookDao.getInstance().selectAll();
        //for (Book book :list) {
        //    System.out.println(book.toString());
        //}
        new TestMain();
        
    }
    
}
