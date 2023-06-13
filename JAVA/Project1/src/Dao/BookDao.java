/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DATA.Database;
import java.sql.Statement;
//import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JTextField;
import model.Book;

/**
 *
 * @author ADMIN
 */
public class BookDao implements DaoInterFace<Book>{

    public static BookDao getInstance(){
        return new BookDao();
    }
    @Override
    public int insert(Book t) {
        int ketqua = 0;
        try {
           //tao lien ket
           Connection conn =Database.getConnection();
          //tao doi tuong Statement
           Statement stmt = conn.createStatement();
          //thuc thi cau lenh sql
           String sql = "INSERT INTO book(id, name, publish, price, number, category,img)"+
           "VALUES ('"+t.getId()+"','"+t.getName()+"',"+t.getPublish()+","+t.getPrice()+","+t.getNumber()+",'"+t.getCategory()+"','"+t.getImg()+"')";   //,"+t.getImg()+"
           ketqua =stmt.executeUpdate(sql); 
          //tao statement tao các phương thức thực thi cơ sở dữ liệu trong sql
          //kiem tra 
          System.out.println("Thêm thành công "+sql);
          System.out.println("co "+ketqua+" da duoc them");
        //đóng kết nối
          Database.closeConnection(conn);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(Book t) {
        int ketqua = 0;
        try {
           //tao lien ket
           Connection conn =Database.getConnection();
          //tao doi tuong Statement
           Statement stmt = conn.createStatement();
          //thuc thi cau lenh sql
           String sql = "UPDATE book "+
                        "SET"+
                        " id='"+t.getId()+"'"+
                        ", name='"+t.getName()+"'"+
                        ",publish="+t.getPublish()+
                        ",price="+t.getPrice()+
                        ",number="+t.getNumber()+
                        ",category='"+t.getCategory()+"'"+
                        ",img='"+t.getImg()+"'"+
                        " WHERE id='"+t.getId()+"'";  
        //kiem tra 
          ketqua =stmt.executeUpdate(sql);
          System.out.println("Thêm thành công "+sql);
          //System.out.println("co"+ketqua+"da duoc them");
        //đóng kết nối
          Database.closeConnection(conn);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return ketqua;
    }
    public int updateOrder(){
        int ketqua = 0;
        try {
           //tao lien ket
           Connection conn =Database.getConnection();
          //tao doi tuong Statement
           Statement stmt = conn.createStatement();
          //thuc thi cau lenh sql
           String sql = "UPDATE book t1, orders t2 "
                   + "SET t1.number = t2.inventory "
                   + "WHERE t1.id = t2.id";
        //kiem tra 
          ketqua =stmt.executeUpdate(sql);
          System.out.println("Thêm thành công "+sql);
          //System.out.println("co"+ketqua+"da duoc them");
        //đóng kết nối
          Database.closeConnection(conn);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return ketqua;
    }
    @Override
    public int delete() {
        int ketqua = 0;
        try {
           //tao lien ket
           Connection conn =Database.getConnection();
          //tao doi tuong Statement
           Statement stmt = conn.createStatement();
          //thuc thi cau lenh sql
           String sql = "DELETE FROM book ";
        //kiem tra 
          ketqua =stmt.executeUpdate(sql);
          System.out.println("Xóa thành công "+sql);
          //System.out.println("co"+ketqua+"da duoc them");
        //đóng kết nối
          Database.closeConnection(conn);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return ketqua;
    }
    //lay tat ca du lieu trong database
    @Override
    public ArrayList<Book> selectAll() {
        ArrayList<Book> ketqua = new ArrayList<Book>();
        try {
           //tao lien ket
           Connection conn =Database.getConnection();
          //tao doi tuong Statement
           Statement stmt = conn.createStatement();
          //thuc thi cau lenh sql de lay du lieu ra
           String sql = "SELECT * FROM book";
           ResultSet rs = stmt.executeQuery(sql);//lay tung dong ra.
           System.out.println(sql);
           while(rs.next()){
               String id = rs.getString("id");
               String name = rs.getString("name");
               int publish = rs.getInt("publish");
               float price = rs.getFloat("price");
               int number = rs.getInt("number");
               String category = rs.getString("category");
               String img = rs.getString("img");
               
               Book book = new Book(id, name, publish, price, number, category,img);
               ketqua.add(book);
           }
          //System.out.println("co"+ketqua+"da duoc them");
        //đóng kết nối
           Database.closeConnection(conn);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return ketqua;
    }

    //dua sach ra man hinh theo id

    /**
     *
     * @param t
     * @return
     */
    @Override
    public Book selectById(Book t) {
        Book ketqua = null;
        try {
           //tao lien ket
           Connection conn =Database.getConnection();
          //tao doi tuong Statement
           Statement stmt = conn.createStatement();
          //thuc thi cau lenh sql de lay du lieu ra
           String sql = "SELECT * FROM book where id ='"+t.getId()+"'";
           ResultSet rs = stmt.executeQuery(sql);//lay tung dong ra.
           System.out.println(sql);
           while(rs.next()){
               String id = rs.getString("id");
               String name = rs.getString("name");
               int publish = rs.getInt("publish");
               float price = rs.getFloat("price");
               int number = rs.getInt("number");
               String category = rs.getString("category");
               String img = rs.getString("img");
               
              Book book = new Book(id, name, publish, price, number, category,img);
      
           }
          //System.out.println("co"+ketqua+"da duoc them");
        //đóng kết nối
           Database.closeConnection(conn);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return ketqua;
    }
    //lay theo dieu kien
    @Override
    public ArrayList<Book> selectByCondition(String condition) {
        ArrayList<Book> ketqua = new ArrayList<Book>();
        try {
           //tao lien ket
           Connection conn =Database.getConnection();
          //tao doi tuong Statement
           Statement stmt = conn.createStatement();
          //thuc thi cau lenh sql de lay du lieu ra
           String sql = "SELECT * FROM book where"+ condition;
           ResultSet rs = stmt.executeQuery(sql);//lay tung dong ra.
           System.out.println(sql);
           while(rs.next()){
               String id = rs.getString("id");
               String name = rs.getString("name");
               int publish = rs.getInt("publish");
               float price = rs.getFloat("price");
               int number = rs.getInt("number");
               String category = rs.getString("category");
               String img = rs.getString("img");
               
               Book book = new Book(id, name, publish, price, number, category,img);
               ketqua.add(book);
           }
          //System.out.println("co"+ketqua+"da duoc them");
        //đóng kết nối
           Database.closeConnection(conn);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return ketqua;
    }
    
}
