/**
 * Market
 * Criptography Class
 * @author hover
 */
package sample.model;
//imports
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class Criptography {
    //Variables
    static String IV = "AAAABBBBBBBBBBBB";
    static String encKey = "01at456789abcdef";
    
    public static String enc(String pureText) {
        Cipher encript = null;
        try {
            encript = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        }
        SecretKeySpec key = null;
        try {
            key = new SecretKeySpec(encKey.getBytes("UTF-8"), "AES");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            encript.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        }
        BASE64Encoder b64 = new BASE64Encoder();
        byte[] textenc = null;
        try {
            textenc = encript.doFinal(pureText.getBytes("UTF-8"));
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        }
        String text = b64.encode(textenc);
        return text;   
    }

    public static String dec(String textoencriptado) {
        Cipher decript = null;
        try {
            decript = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        }
        SecretKeySpec key = null;
        try {
            key = new SecretKeySpec(encKey.getBytes("UTF-8"), "AES");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            decript.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        }
        BASE64Decoder b64d = new BASE64Decoder();
        byte[] decText = null;
        try {
            decText = b64d.decodeBuffer(textoencriptado);
        } catch (IOException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        }
        String textoDec = null;
        try {
            textoDec = new String(decript.doFinal(decText),"UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, ex);
        }
        return textoDec;
    }
}
