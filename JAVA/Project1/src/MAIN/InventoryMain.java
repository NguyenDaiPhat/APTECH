/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN;

import Dao.BookDao;
import Login.Screen;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Book;

/**
 *
 * @author ADMIN
 */
public class InventoryMain extends javax.swing.JFrame {

    private MainScreen mainScreen;
    private Screen screen;
    private TestMain testMain;
    private SellingMain sellingMain;
    private ArrayList<Book> list = BookDao.getInstance().selectAll();
    DefaultTableModel model;
    public InventoryMain() {
        initComponents();
        setLocationRelativeTo(null);
        this.setupActions();
        this.setVisible(true);
        //list = BookDao.getInstance().selectByCondition("number>100");
        model = (DefaultTableModel) jTable1.getModel();
        showTable();
    }
    public void showTable(){
         for (Book t : list) {
             if (t.getNumber()>80) {
                 model.addRow(new Object[]{
                t.getId(),t.getName(),t.getPublish(),t.getPrice(),t.getNumber(),t.getCategory()
            });
             }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jToolBar1 = new javax.swing.JToolBar();
        ButtonMain = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        ButtonTest = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        SystemMenu = new javax.swing.JMenu();
        ExitItem = new javax.swing.JMenuItem();
        ManageMenu = new javax.swing.JMenu();
        SellingItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(732, 769));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);

        ButtonMain.setBackground(new java.awt.Color(255, 255, 255));
        ButtonMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ImgHome-icon.png"))); // NOI18N
        ButtonMain.setText("TRANG CHỦ");
        ButtonMain.setFocusable(false);
        ButtonMain.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonMain.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(ButtonMain);
        jToolBar1.add(jSeparator3);

        ButtonTest.setBackground(new java.awt.Color(255, 255, 255));
        ButtonTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/imgFix.png"))); // NOI18N
        ButtonTest.setText("KIỂM TRA");
        ButtonTest.setFocusable(false);
        ButtonTest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonTest.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(ButtonTest);
        jToolBar1.add(jSeparator5);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("HÀNG TỒN");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TÊN SÁCH", "XUẤT BẢN", "GIÁ", "SỐ LƯỢNG", "THỂ LOẠI"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        SystemMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ImgSystem.png"))); // NOI18N
        SystemMenu.setText("HỆ THỐNG");

        ExitItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/imgExit.png"))); // NOI18N
        ExitItem.setText("ĐĂNG XUẤT");
        SystemMenu.add(ExitItem);

        jMenuBar1.add(SystemMenu);

        ManageMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ImgManage.png"))); // NOI18N
        ManageMenu.setText("QUẢN LÝ");

        SellingItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ImgInventory.png"))); // NOI18N
        SellingItem.setText("HÀNG BÁN CHẠY");
        ManageMenu.add(SellingItem);

        jMenuBar1.add(ManageMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                            .addComponent(jSeparator6))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonMain;
    private javax.swing.JButton ButtonTest;
    private javax.swing.JMenuItem ExitItem;
    private javax.swing.JMenu ManageMenu;
    private javax.swing.JMenuItem SellingItem;
    private javax.swing.JMenu SystemMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
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
        ButtonTest.addActionListener((ActionEvent actionEvent) ->{
            this.testMain = testMain == null ? new TestMain() : testMain;
            this.setVisible(false);
        });
        SellingItem.addActionListener((ActionEvent actionEvent) ->{
            this.sellingMain = sellingMain == null ? new SellingMain() : sellingMain;
            this.setVisible(false);
        });
    }
}
