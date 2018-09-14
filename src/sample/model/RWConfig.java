/**
 * Lê e escreve no arquivo config
 * @author hover
 */
package sample.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RWConfig {
    public static void createFile(){
        if(!arquivo.exists()){
            try {
                arquivo.createNewFile();
                FileWriter fw = new FileWriter(arquivo);
                BufferedWriter bw = new BufferedWriter(fw);
            
                bw.write(Criptography.enc("User"));
                bw.newLine();
                bw.write(Criptography.enc("senha1234"));
                bw.newLine();
                bw.write(Criptography.enc("localhost"));
                bw.newLine();
                bw.write(Criptography.enc("3306"));
                
                bw.close();
                fw.close();
                createValue = true;
            } catch (IOException ex) {
                Logger.getLogger(RWConfig.class.getName()).log(Level.SEVERE, null, ex);
                createValue = false;
            }
        }else{
            createValue = true;
        }
    }
    
    public static String[] read(){
        try {
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            try {
                while(br.ready()){
                    data[i] = Criptography.dec(br.readLine());
                    i++;
                }
            } catch (IOException ex) {
                Logger.getLogger(RWConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(RWConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(RWConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
            readValue = true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RWConfig.class.getName()).log(Level.SEVERE, null, ex);
            readValue = false;
        }
        return data;
    }
    
    public static void write(String[] inf){
        try {
            FileWriter fw = new FileWriter(arquivo);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int j=0;j<4;j++){
                bw.write(Criptography.enc(inf[j]));
                bw.newLine();
            }
            bw.close();
            fw.close();
            writeValue = true;
        } catch (IOException ex) {
            Logger.getLogger(RWConfig.class.getName()).log(Level.SEVERE, null, ex);
            writeValue = false;
        }
    }
    
    public static boolean getCreateValue(){
        return createValue;
    }
    
    public static boolean getReadValue(){
        return readValue;
    }
    
    public static boolean getWriteValue(){
        return writeValue;
    }
    
    private static final File arquivo = new File("config.ini");
    private static final String[] data = new String[4];
    private static boolean createValue;
    private static boolean readValue;
    private static boolean writeValue;
    
}
