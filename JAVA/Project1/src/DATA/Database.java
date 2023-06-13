/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;
import com.mysql.cj.conf.PropertyKey;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;


/**
 *
 * @author ADMIN
 */
public class Database {
    //ket noi co so du lieu
    public static Connection getConnection() {
        Connection conn = null;
        //tao ket noi voi database
        try{
            //dang ky mysql Driver voi DriverManager
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //khai bao cow so
            String DB_URL   ="jdbc:mysql://localhost:3306/quản_ly_sách";
            String USER     = "root";
            String PASSWORD = "";
            //tao doi tuong Statement
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            Statement stmt = conn.createStatement();
                System.out.println("ket noi thanh cong");
                System.err.println(conn.getCatalog());
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //ngat ket noi csdl
    public static void closeConnection(Connection conn) {
        try {
            if (conn!= null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
}
