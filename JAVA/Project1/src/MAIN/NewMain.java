/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN;

import Dao.BookDao;
import Helper.Utility;
import Login.Screen;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Book;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author ADMIN
 */
public class NewMain extends javax.swing.JFrame {
    private ArrayList<Book> list;
    private MainScreen mainScreen;
    private Screen screen;
    private TestMain testMain;
    private InventoryMain inventoryMain;
    private SellingMain sellingMain;
    private String absoluteImageFilePath;
    private File file;
    int current = 0;
    private String imageFileName = "";
    private Image Image1;
    
    DefaultTableModel model;
    public NewMain() {
        initComponents();
        this.setupActions();
        this.setVisible(true);
        setLocationRelativeTo(null);
        //hienj thij cac cot
        list = BookDao.getInstance().selectAll();
        model = (DefaultTableModel) jTable3.getModel();
        //model.setColumnIdentifiers(new Object[]{
        //     "ID", "TÊN SÁCH", "XUẤT BẢN", "GIÁ", "SỐ LƯỢNG", "THỂ LOẠI"
        //});
        showTable();
      
    }
    public void showTable(){
         model.setColumnIdentifiers(new Object[]{
             "MÃ SÁCH", "TÊN SÁCH", "XUẤT BẢN", "GIÁ", "SỐ LƯỢNG", "THỂ LOẠI","HÌNH ẢNH"
        });        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        for (Book t : list =BookDao.getInstance().selectAll()) {
            model.addRow(new Object[]{
                t.getId(),t.getName(),t.getPublish(),t.getPrice(),t.getNumber(),t.getCategory(),t.getImg()
            });
        }
    }
    
    
    //Chọn ảnh
    public BufferedImage rescale(BufferedImage originalImage)//Dinh nghi chieu dai chieu rong hinh anh(toByteArry
    {
        BufferedImage resizedImage = new BufferedImage(175, 285, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, 175, 285, null);
        g.dispose();
        return resizedImage;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jProgressBar1 = new javax.swing.JProgressBar();
        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        ButtonMain = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        ButtonTest = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabelName = new javax.swing.JLabel();
        jLabelPublish = new javax.swing.JLabel();
        jLabelFloat = new javax.swing.JLabel();
        jLabelAmount = new javax.swing.JLabel();
        jLabelCategory = new javax.swing.JLabel();
        txtPublish = new javax.swing.JTextField();
        txtFloat = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtCategory = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        ButtoniMG = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtAmount = new javax.swing.JTextField();
        jButtonNew = new javax.swing.JButton();
        jButtonFix = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        SystemMenu = new javax.swing.JMenu();
        ExitItem = new javax.swing.JMenuItem();
        ManageMenu = new javax.swing.JMenu();
        InventoryItem = new javax.swing.JMenuItem();
        SellingItem = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem7.setText("jMenuItem7");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jToolBar1.setRollover(true);

        ButtonMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ImgHome-icon.png"))); // NOI18N
        ButtonMain.setText("TRANG CHỦ");
        ButtonMain.setFocusable(false);
        ButtonMain.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonMain.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(ButtonMain);
        jToolBar1.add(jSeparator5);

        ButtonTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/imgFix.png"))); // NOI18N
        ButtonTest.setText("KIỂM TRA");
        ButtonTest.setFocusable(false);
        ButtonTest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonTest.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(ButtonTest);
        jToolBar1.add(jSeparator9);
        jToolBar1.add(jSeparator6);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTitle.setText("NHẬP HÀNG");

        jLabelName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName.setText("TÊN SÁCH:");

        jLabelPublish.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPublish.setText("XUẤT BẢN:");

        jLabelFloat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelFloat.setText("GIÁ:");

        jLabelAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAmount.setText("SỐ LƯỢNG:");

        jLabelCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCategory.setText("THỂ LOẠI:");

        txtFloat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFloatActionPerformed(evt);
            }
        });

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "THỆ LOẠI", "KINH DỊ", "CỔ TÍCH", "HÀI", "TRINH THÁM", "VĂN HỌC", "NGÔN TÌNH", " " }));

        labelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Book-icon.png"))); // NOI18N
        labelImage.setMaximumSize(new java.awt.Dimension(175, 285));
        labelImage.setMinimumSize(new java.awt.Dimension(175, 285));
        labelImage.setPreferredSize(new java.awt.Dimension(175, 285));

        ButtoniMG.setText("CHỌN ẢNH");
        ButtoniMG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtoniMGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(ButtoniMG)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtoniMG)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jButtonSave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonSave.setText("LƯU");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("MÃ SÁCH");

        jButtonNew.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonNew.setText("TẠO MỚI ");
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });

        jButtonFix.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonFix.setText("SỬA");
        jButtonFix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFixActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator10, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                        .addGap(125, 125, 125))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelCategory)
                                .addGap(26, 26, 26)
                                .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAmount)
                                    .addComponent(jLabelFloat))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFloat, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPublish)
                                    .addComponent(jLabelName)
                                    .addComponent(jLabel1))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtPublish, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonNew, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButtonFix, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelName))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPublish, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPublish))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFloat)
                            .addComponent(txtFloat, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))
                            .addComponent(jLabelAmount))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCategory))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSave)
                            .addComponent(jButtonFix)
                            .addComponent(jButtonNew)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ SÁCH", "TÊN SÁCH", "XUẤT BẢN", "GIÁ", "SỐ LƯỢNG", "THỂ LOẠI", "HÌNH ẢNH"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        SystemMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ImgSystem.png"))); // NOI18N
        SystemMenu.setText("HỆ THỐNG");

        ExitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        ExitItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/imgExit.png"))); // NOI18N
        ExitItem.setText("ĐĂNG XUẤT");
        SystemMenu.add(ExitItem);

        jMenuBar1.add(SystemMenu);

        ManageMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ImgManage.png"))); // NOI18N
        ManageMenu.setText("QUẢN LÝ");

        InventoryItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ImgInventory.png"))); // NOI18N
        InventoryItem.setText("HÀNG TỒN");
        ManageMenu.add(InventoryItem);

        SellingItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ImgInventory.png"))); // NOI18N
        SellingItem.setText("HÀNG BÁN CHẠY");
        SellingItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SellingItemActionPerformed(evt);
            }
        });
        ManageMenu.add(SellingItem);

        jMenuBar1.add(ManageMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SellingItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SellingItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SellingItemActionPerformed

  
    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        Book t = new Book(); 
        t.setId(txtid.getText());
        t.setName(txtName.getText());
        t.setPublish(Integer.parseInt(txtPublish.getText()));
        t.setPrice(Float.parseFloat(txtFloat.getText()));
        t.setNumber(Integer.parseInt(txtAmount.getText()));
        t.setCategory(txtCategory.getSelectedItem().toString());
        t.setImg(this.imageFileName);
        
        if (t != null){
            BookDao.getInstance().insert(t);
            JOptionPane.showMessageDialog(rootPane, "Add Success!");
            txtid.setText("");
            txtName.setText("");
            txtPublish.setText("");
            txtFloat.setText("");
            txtAmount.setText("");
            txtCategory.setSelectedItem("THỆ LOẠI");
            labelImage.setIcon(new ImageIcon(getClass().getResource("/IMG/Book-icon.png")));
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Student's ID cannot be duplicated!");
        }
        showTable();
    }//GEN-LAST:event_jButtonSaveActionPerformed
    // hien thi anh len giao dien createImageFrom
    private void ButtoniMGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtoniMGActionPerformed
        try {
             JFileChooser fc = new JFileChooser("C:\\Users\\ADMIN\\Desktop\\Sach\\Sach");
            int res = fc.showOpenDialog(null);
            this.file = fc.getSelectedFile();
            absoluteImageFilePath = file.getAbsolutePath();   
            String fileExtension = absoluteImageFilePath
                               .substring(absoluteImageFilePath.lastIndexOf("."),
                               absoluteImageFilePath.length());
            imageFileName =String.format("%s%s", Helper.Utility.generateRandomString(15),fileExtension);
            
            FileUtils.copyFile(this.file, new File(Helper.Utility.SERVER_IMAGE_PATH+imageFileName));                       
            if (absoluteImageFilePath != null) {
                labelImage.setIcon(resizeIcon(String.valueOf(absoluteImageFilePath)));
                System.out.println(absoluteImageFilePath);
                 
            } // Oops!
            else {
                JOptionPane.showMessageDialog(null,
                        "You must select one image to be the reference.", "Aborting...",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception exception) {
            if(exception instanceof NullPointerException) {
                System.err.println("Bạn chưa chọn ảnh");
                return;
            }
            System.out.println("Lỗi khi chọn ảnh hoặc lưu file lên server");
            exception.printStackTrace();
            //System.out.println(absoluteImageFilePath);
        }                                         

    }//GEN-LAST:event_ButtoniMGActionPerformed

    private void jButtonFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFixActionPerformed
        Book t = new Book(); 
        t.setId(txtid.getText());
        t.setName(txtName.getText());
        t.setPublish(Integer.parseInt(txtPublish.getText()));
        t.setPrice(Float.parseFloat(txtFloat.getText()));
        t.setNumber(Integer.parseInt(txtAmount.getText()));
        t.setCategory(txtCategory.getSelectedItem().toString());
        t.setImg(this.imageFileName);
        if (t != null){
            JOptionPane.showMessageDialog(rootPane, "SỬA THÀNH CÔNG");
            BookDao.getInstance().update(t);
            txtid.setText("");
            txtName.setText("");
            txtPublish.setText("");
            txtFloat.setText("");
            txtAmount.setText("");
            txtCategory.setSelectedItem("THỆ LOẠI");
            labelImage.setIcon(new ImageIcon(getClass().getResource("/IMG/Book-icon.png")));
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Student's ID cannot be duplicated!");
        }
        showTable();
    }//GEN-LAST:event_jButtonFixActionPerformed

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        //làm trắng danh sách
        txtid.setText("");
        txtName.setText("");
        txtPublish.setText("");
        txtFloat.setText("");
        txtAmount.setText("");
        txtCategory.setSelectedItem("THỆ LOẠI");
        labelImage.setIcon(new ImageIcon(getClass().getResource("/IMG/Book-icon.png")));
    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        //Nhấn chuột phải 2 lần sẽ đưa dữ liệu lên thanh
          current= jTable3.getSelectedRow();
          display(current);// ham hien thi duw lieu
    }//GEN-LAST:event_jTable3MouseClicked

    private void txtFloatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFloatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFloatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonMain;
    private javax.swing.JButton ButtonTest;
    private javax.swing.JButton ButtoniMG;
    private javax.swing.JMenuItem ExitItem;
    private javax.swing.JMenuItem InventoryItem;
    private javax.swing.JMenu ManageMenu;
    private javax.swing.JMenuItem SellingItem;
    private javax.swing.JMenu SystemMenu;
    private javax.swing.JButton jButtonFix;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAmount;
    private javax.swing.JLabel jLabelCategory;
    private javax.swing.JLabel jLabelFloat;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPublish;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelImage;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JComboBox<String> txtCategory;
    private javax.swing.JTextField txtFloat;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPublish;
    private javax.swing.JTextField txtid;
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
        InventoryItem.addActionListener((ActionEvent actionEvent) ->{
            this.inventoryMain = inventoryMain == null ? new InventoryMain() : inventoryMain;
            this.setVisible(false);
        });
        SellingItem.addActionListener((ActionEvent actionEvent) ->{
            this.sellingMain = sellingMain == null ? new SellingMain() : sellingMain;
            this.setVisible(false);
        });
    }

    private ImageIcon resizeIcon(String ImagePath) {
        ImageIcon imgIcon = new ImageIcon(ImagePath);
        Image img = ImgHelper.resize(imgIcon.getImage(), 175, 285);
        ImageIcon resizeIcon = new ImageIcon(img);
        return resizeIcon;
    }
    public void display(int i){
        Book book = list.get(i);
        txtid.setText(book.getId());
        txtName.setText(book.getName());
        txtPublish.setText(String.valueOf(book.getPublish()));
        txtFloat.setText(String.valueOf(book.getPrice()));
        txtAmount.setText(String.valueOf(book.getNumber()));
        txtCategory.setSelectedItem(book.getCategory());
        try {
            String absolutePath = Utility.SERVER_IMAGE_PATH+book.getImg();
            //labelImage.setIcon(resizeIcon(absolutePath)); 
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Image1 = toolkit.getImage(absolutePath);        
            labelImage.setIcon(resizeIcon(absolutePath));
        }catch(Exception e) {
            System.err.println("cannot get image from server");
            e.printStackTrace();
        }
            
        
    }
}

