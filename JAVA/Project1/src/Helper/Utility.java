/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;
import java.nio.charset.Charset;
import java.util.Random;
/**
 *
 * @author ADMIN
 */
public class Utility {
   public static String SERVER_IMAGE_PATH = "./images/";
   public static String generateRandomString(int numberOfCharacters) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
         + "0123456789"
         + "abcdefghijklmnopqrstuvxyz";
 
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(numberOfCharacters);

        for (int i = 0; i < numberOfCharacters; i++) {

         // generate a random number between
         // 0 to AlphaNumericString variable length
         int index
          = (int)(AlphaNumericString.length()
            * Math.random());

         // add Character one by one in end of sb
         sb.append(AlphaNumericString
            .charAt(index));
        }

        return sb.toString();
    }
}
