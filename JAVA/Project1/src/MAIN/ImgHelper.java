/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author ADMIN
 */
public class ImgHelper {
        // xet do lown cua hinh anh
        public static Image resize(Image originalImage, int targetWidth, int targetHeight)//Dinh nghi chieu dai chieu rong hinh anh(toByteArry
        {
            Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
            return resultingImage;
        }
        // chuyen hinh anh vao mangr Byte
        public static byte[] toByteArry(Image img, String type)throws IOException{
            BufferedImage resizedImage = new BufferedImage(128, 128, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(img, 0, 0,null);
            g.dispose();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(resizedImage, type, baos);
            byte[] imageInByte = baos.toByteArray();
            return imageInByte; 
        }
        // chuyeenj veef img vaf hie thi
        public static Image creImageFromByteArray(byte [] data,String type) throws IOException{
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            BufferedImage bImage2 = ImageIO.read(bis);
            
            Image image = bImage2.getScaledInstance(bImage2.getWidth(), bImage2.getHeight(), Image.SCALE_SMOOTH);
            return  image;
        }
}
