/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN;

import DATA.Database;
import Dao.BookDao;
import Dao.OrderDao;
import Login.Screen;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Book;
import java.sql.ResultSet;
import model.Orders;
//chon JbuttonBuy thi update jlable10
/**
 *
 * @author ADMIN
 */
public class BuyMain extends javax.swing.JFrame {

    private MainScreen mainScreen;
    private Screen screen;
    private SellingMain sellingMain;
    private ArrayList<Book> list = new ArrayList<Book>();
    private ArrayList<Orders> listOrders = new ArrayList<Orders>();
    DefaultTableModel model;
    DefaultTableModel model1;
    int current = 0;
    private String inventory;
    public BuyMain() {
        initComponents();
        this.setupActions();
        this.setVisible(true);
        setLocationRelativeTo(null);
        model = (DefaultTableModel) jTable1.getModel();
        model1 = (DefaultTableModel) jTable2.getModel();
        showTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jToolBar1 = new javax.swing.JToolBar();
        ButtonMain = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        ButtonTest = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtinputFind = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txt = new javax.swing.JPanel();
        jButtonBuy = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        txtPrice = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtinventory = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtaftersale = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtTotalAll = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        ExitItem = new javax.swing.JMenuItem();
        ManageMenu = new javax.swing.JMenu();
        InventoryItem = new javax.swing.JMenuItem();
        SellingItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        ButtonMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ImgHome-icon.png"))); // NOI18N
        ButtonMain.setText("TRANG CHỦ");
        ButtonMain.setFocusable(false);
        ButtonMain.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonMain.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(ButtonMain);
        jToolBar1.add(jSeparator3);

        ButtonTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/imgFix.png"))); // NOI18N
        ButtonTest.setText("KIỂM TRA");
        ButtonTest.setFocusable(false);
        ButtonTest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonTest.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(ButtonTest);
        jToolBar1.add(jSeparator4);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("CHỌN SẢN PHẨM KHÁCH MUA");

        txtinputFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtinputFindKeyReleased(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ SÁCH", "TÊN SÁCH", "GIÁ", "SỐ LƯỢNG"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonBuy.setText("CHỌN");
        jButtonBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuyActionPerformed(evt);
            }
        });

        jLabel3.setText("MÃ SẢN PHẬM:");

        jLabel4.setText("TÊN SÁCH:");

        jLabel5.setText("GIÁ:");

        jLabel6.setText("SỐ LƯỢNG MUA:");

        jLabel7.setText("TỔNG SỐ TIỀN:");

        jLabel11.setText("SỐ LƯỢNG CÒN:");

        jLabel8.setText("SỐ LƯỢNG SAU BÁN:");

        javax.swing.GroupLayout txtLayout = new javax.swing.GroupLayout(txt);
        txt.setLayout(txtLayout);
        txtLayout.setHorizontalGroup(
            txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(44, 44, 44)
                        .addGroup(txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtLayout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(txtLayout.createSequentialGroup()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(txtLayout.createSequentialGroup()
                        .addGroup(txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtLayout.createSequentialGroup()
                                .addGroup(txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, txtLayout.createSequentialGroup()
                                        .addGroup(txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(38, 38, 38)
                                        .addGroup(txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtAmount, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, txtLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGroup(txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(txtLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButtonBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(txtLayout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(txtinventory, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtaftersale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        txtLayout.setVerticalGroup(
            txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtId))
                .addGap(18, 18, 18)
                .addGroup(txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtName))
                .addGap(18, 18, 18)
                .addGroup(txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrice))
                .addGap(18, 18, 18)
                .addGroup(txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTotal))
                .addGap(18, 18, 18)
                .addGroup(txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtinventory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtaftersale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonBuy))
        );

        jLabel2.setText("ĐƠN HÀNG:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ SÁCH", "TÊN SÁCH", "GIÁ", "SỐ LƯỢNG MUA", "TỔNG TIỀN", "SỐ LƯỢNG CÒN"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jButton1.setText("MUA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("TỔNG SỐ TIỀN:");

        jMenuBar1.setPreferredSize(new java.awt.Dimension(190, 26));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ImgSystem.png"))); // NOI18N
        jMenu1.setText("HỆ THỐNG ");

        ExitItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/imgExit.png"))); // NOI18N
        ExitItem.setText("ĐĂNG XUẤT");
        jMenu1.add(ExitItem);

        jMenuBar1.add(jMenu1);

        ManageMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ImgManage.png"))); // NOI18N
        ManageMenu.setText("QUẢN LÝ");

        InventoryItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ImgInventory.png"))); // NOI18N
        InventoryItem.setText("HÀNG TỒN");
        ManageMenu.add(InventoryItem);

        SellingItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ImgInventory.png"))); // NOI18N
        SellingItem.setText("HÀNG BÁN CHẠY");
        ManageMenu.add(SellingItem);

        jMenuBar1.add(ManageMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(jLabel1))
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtinputFind, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotalAll, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtinputFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTotalAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void txtinputFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtinputFindKeyReleased
        //tao lien ket
        list.clear();
        try{
           //Book order = new Book();
           Connection conn =Database.getConnection();
          //tao doi tuong Statement
           Statement stmt = conn.createStatement();
          //thuc thi cau lenh sql de lay du lieu ra
           String sql = "SELECT * FROM book where id ='"+txtinputFind.getText()+"' or name ='"+txtinputFind.getText()+"'";
                ResultSet rs = stmt.executeQuery(sql);//lay tung dong ra.
                System.out.println(sql);
                while(rs.next()){
                  String id = rs.getString("id");
                  String name = rs.getString("name");
                  float price = rs.getFloat("price");
                  int number = rs.getInt("number");
                  Book book = new Book(id, name, price, number);
                  list.add(book);
                }
          //System.out.println("co"+ketqua+"da duoc them");
          loadDataArray();
        //đóng kết nối
           Database.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("LỖI");
        }
       
       
    }//GEN-LAST:event_txtinputFindKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //Nhấn chuột phải 2 lần sẽ đưa dữ liệu lên thanh
        current= jTable1.getSelectedRow();
        Display(current);// ham hien thi duw lieu
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BookDao.getInstance().updateOrder();
        //OrderDao.getInstance().delete();
        JOptionPane.showMessageDialog(rootPane, "Mua hàng thành công");
        showTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuyActionPerformed
        Orders order = new Orders();
        order.setId(txtId.getText());
        order.setName(txtName.getText());
        order.setPrice(Float.parseFloat(txtPrice.getText()));
        order.setNumber(Integer.parseInt(txtAmount.getText()));
        int setNumber = Integer.parseInt(txtAmount.getText());
        
        if(setNumber > 0){
            if (Integer.parseInt(txtAmount.getText()) <= Integer.parseInt(txtinventory.getText())) {
            double result = Double.parseDouble(txtAmount.getText()) * Double.parseDouble(txtPrice.getText());
            txtTotal.setText(String.valueOf(result));
            order.setTotal(txtTotal.getText());
            int  inventory= Integer.parseInt(txtinventory.getText()) - Integer.parseInt(txtAmount.getText());
            txtaftersale.setText(String.valueOf(inventory));
            order.setInventory(Integer.parseInt(txtaftersale.getText()));
            //list.add(inventory);
                if (order != null){
                    OrderDao.getInstance().insert(order);
                    JOptionPane.showMessageDialog(rootPane, "THÊM VÀO GIỎ HÀNG!");
                    txtId.setText("");
                    txtName.setText("");
                    txtPrice.setText("");
                    txtAmount.setText("");
                    txtTotal.setText("");
                    txtinventory.setText("");
                    txtaftersale.setText("");
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Student's ID cannot be duplicated!");
                }
            }else{
            JOptionPane.showMessageDialog(rootPane, "SỐ LƯỢNG HÀNG KHÔNG ĐỦ ");
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "SỐ LƯỢNG ÂM");
        }
        

        showTable();
    }//GEN-LAST:event_jButtonBuyActionPerformed
    private void showTable(){
        model1.setColumnIdentifiers(new Object[]{
             "MÃ SÁCH", "TÊN SÁCH", "GIÁ", "SỐ LƯỢNG", "SỐ TIỀN", "SỐ LƯỢNG CÒN"
        }); 
        model1.getDataVector().removeAllElements();
        model1.fireTableDataChanged();
        
        float total = 0.0f;
        for (Orders eachOrder : listOrders = OrderDao.getInstance().selectAll()) {
           total += Float.valueOf(eachOrder.getTotal());
           //int inventory = Integer.parseInt(txtinventory.getText()) - Integer.parseInt(txtAmount.getText());
           model1.addRow(new Object[]{
                eachOrder.getId(),
                eachOrder.getName(),
                eachOrder.getPrice(),
                eachOrder.getNumber(),
                eachOrder.getTotal(),
                eachOrder.getInventory(),
            });
        }
        txtTotalAll.setText(String.format("%.0f VND", total));
                   
    }
    private  void loadDataArray(){//Doj du lieu ra bang
        model.setColumnIdentifiers(new Object[]{
             "MÃ SÁCH", "TÊN SÁCH", "GIÁ", "SỐ LƯỢNG"
        }); 
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        for (Book t : list) {
            model.addRow(new Object[]{
                t.getId(),t.getName(),t.getPrice(),t.getNumber()
            });
            
        }
    }
    
                
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonMain;
    private javax.swing.JButton ButtonTest;
    private javax.swing.JMenuItem ExitItem;
    private javax.swing.JMenuItem InventoryItem;
    private javax.swing.JMenu ManageMenu;
    private javax.swing.JMenuItem SellingItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBuy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel txt;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JLabel txtId;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtPrice;
    private javax.swing.JLabel txtTotal;
    private javax.swing.JLabel txtTotalAll;
    private javax.swing.JLabel txtaftersale;
    private javax.swing.JTextField txtinputFind;
    private javax.swing.JLabel txtinventory;
    // End of variables declaration//GEN-END:variables

    private void setupActions(){
        ButtonMain.addActionListener((ActionEvent actionEvent) ->{
            this.mainScreen = mainScreen == null ? new MainScreen() : mainScreen;
            this.setVisible(false);
        });
        ExitItem.addActionListener((ActionEvent actionEvent)->{
            this.screen = screen == null ? new Screen() : screen;
            this.setVisible(false);    
        } );
        SellingItem.addActionListener((ActionEvent actionEvent) ->{
            this.sellingMain = sellingMain == null ? new SellingMain() : sellingMain;
            this.setVisible(false);
        });
    }
    public void Display(int i){
        Book t = list.get(i);
        txtId.setText(t.getId());
        txtName.setText(t.getName());
        txtPrice.setText(String.valueOf(t.getPrice()));
        txtinventory.setText(String.valueOf(t.getNumber()));
        
    }
}
