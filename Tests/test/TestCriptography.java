package test;

import sample.criptography.Criptography;

public class TestCriptography {

    public static void main(String args[]){
        String senha = Criptography.enc("1234");

        System.out.println(Criptography.dec(senha));
        System.out.println(senha);
    }
}
