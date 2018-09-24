package test;
import sample.model.Criptography;
public class TestCripto {
    public static void main(String args[]) {
        String senha = "arkanjo45";
        String senhaEnc = Criptography.enc(senha);

        System.out.println("Senha Normal: "+senha);
        System.out.println("Senha Enc: "+senhaEnc);
        System.out.println("Senha Dec: "+Criptography.dec(senhaEnc));
    }
}
