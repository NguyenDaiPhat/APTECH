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
import model.Orders;
/**
 *
 * @author ADMIN
 */
public class OrderDao implements DaoInterFace<Orders>{
     public static OrderDao getInstance(){
        return new OrderDao();
    }
    @Override
    public int insert(Orders t) {
       int ketqua = 0;
        try {
           //tao lien ket
           Connection conn =Database.getConnection();
          //tao doi tuong Statement
           Statement stmt = conn.createStatement();
          //thuc thi cau lenh sql
           String sql = "INSERT INTO orders(id, name, price, number, total,inventory)"+
           "VALUES ('"+t.getId()+"','"+t.getName()+"',"+t.getPrice()+","+t.getNumber()+",'"+t.getTotal()+"',"+t.getInventory()+")";   //,"+t.getImg()+"
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
    public int update(Orders t) {
       int ketqua = 0;
        try {
           //tao lien ket
           Connection conn =Database.getConnection();
          //tao doi tuong Statement
           Statement stmt = conn.createStatement();
          //thuc thi cau lenh sql
           String sql = "UPDATE orders "+
                        "SET"+
                        " id='"+t.getId()+"'"+
                        ", name='"+t.getName()+"'"+
                        ",price="+t.getPrice()+
                        ",number="+t.getNumber()+
                        ",inventory="+t.getInventory()+
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

    @Override
    public int delete() {
        int ketqua = 0;
        try {
           //tao lien ket
           Connection conn =Database.getConnection();
          //tao doi tuong Statement
           Statement stmt = conn.createStatement();
          //thuc thi cau lenh sql
           String sql = "DELETE FROM orders ";
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

    @Override
    public ArrayList<Orders> selectAll() {
        ArrayList<Orders> ketqua = new ArrayList<Orders>();
        try {
           //tao lien ket
           Connection conn =Database.getConnection();
          //tao doi tuong Statement
           Statement stmt = conn.createStatement();
          //thuc thi cau lenh sql de lay du lieu ra
           String sql = "SELECT * FROM orders";
           ResultSet rs = stmt.executeQuery(sql);//lay tung dong ra.
           System.out.println(sql);
           while(rs.next()){
               String id = rs.getString("id");
               String name = rs.getString("name");
               float price = rs.getFloat("price");
               int number = rs.getInt("number");
               String total = rs.getString("total");
               int inventory = rs.getInt("inventory");
               Orders orders = new Orders(id, name, price, number, total,inventory);
               ketqua.add(orders);
           }
          //System.out.println("co"+ketqua+"da duoc them");
        //đóng kết nối
           Database.closeConnection(conn);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public Orders selectById(Orders c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Orders> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
