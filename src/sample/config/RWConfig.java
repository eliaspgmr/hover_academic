/**
 * Lê e escreve no arquivo config
 * @author hover
 */
package sample.config;

import sample.criptography.Criptography;
import sample.model.bean.Config;
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

    private static final File arquivo = new File("config.ini");
    private static final String[] data = new String[4];
    private static boolean createValue;
    private static boolean readValue;
    private static boolean writeValue;
    private static Config config;


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
    
    public static Config read(){
        try {
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            try {
                while(br.ready()){
                    data[i] = Criptography.dec(br.readLine());
                    i++;
                }
                config = new Config(data[0], data[1], data[2], data[3]);
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
        return config;
    }
    
    public static void write(Config inf){
        try {
            FileWriter fw = new FileWriter(arquivo);
            BufferedWriter bw = new BufferedWriter(fw);
            

            bw.write(Criptography.enc(inf.getUser()));
            bw.newLine();
            bw.write(Criptography.enc(inf.getPassword()));
            bw.newLine();
            bw.write(Criptography.enc(inf.getServer()));
            bw.newLine();
            bw.write(Criptography.enc(inf.getPort()));
            bw.newLine();

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
    

    
}
