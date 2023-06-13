
package Dao;

import DATA.Database;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import model.User_id;
import java.sql.ResultSet;
import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class UserIdDao implements DaoInterFace<User_id>{
    public static UserIdDao getInstance(){
        return new UserIdDao();
    }
    @Override
    public int insert(User_id t) {
        int ketqua = 0;
        try {
            //taoh lien ket
            Connection conn =Database.getConnection();
            ////tao doi tuong Statement
            Statement stmt =conn.createStatement();
            //thuc thi cau lenh sql
            String sql = "INSERT INTO user_id(name,age,user_name,password)"+
                         "VALUES ('"+t.getName()+"',"+t.getAge()+",'"+t.getUser_name()+"','"+t.getPassword()+"')";
            ketqua =stmt.executeUpdate(sql); 
            //tao statement tao các phương thức thực thi cơ sở dữ liệu trong sql
            //kiem tra 
            System.out.println("Thêm thành công "+sql);
            System.out.println("co "+ketqua+" da duoc them");
            //dong ket noi
            Database.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(User_id t) {
        int ketqua = 0;
        try {
            Connection conn = Database.getConnection();
            //taoj doi tuong Statement
            Statement stmt = conn.createStatement();
            //cau lenh sql
            String sql = "UPDATE user_id"+
                         "SET"+
                        " name='"+t.getName()+"'"+
                        ",age="+t.getAge()+
                        ",use_name="+t.getUser_name()+
                        ",password="+t.getPassword()+"'"+
                        " WHERE use_name="+t.getUser_name()+"";
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
           String sql = "DELETE FROM user_id ";
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

    
    
    /*
    public User_id CheckLogin(String user_name, String password,User_id t){
        try {
            //tao lien ket
            Connection conn = Database.getConnection();
            // khai bao Statement
            Statement stmt = conn.createStatement();
            //thuc thi cau lenh
            String sql = "SELECT * FROM login where "
                    + "name ="+t.getName()+""
                    + "password="+t.getPassword()+"";
            
        } catch (Exception e) {
        }
        return null;
    }
   */

    @Override
    public ArrayList<User_id> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User_id> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User_id selectById(User_id t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
