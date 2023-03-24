import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
public class AES{
    public static void main(String[] args) throws Exception {
        String  message="iameswar";
        byte[] myMessage =message.getBytes(); 
        KeyGenerator Mygenerator = KeyGenerator.getInstance("AES");
        SecretKey myDesKey = Mygenerator.generateKey();
        Cipher myCipher = Cipher.getInstance("AES");
        myCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
        byte[] myEncryptedBytes=myCipher.doFinal(myMessage);
        myCipher.init(Cipher.DECRYPT_MODE, myDesKey);
        byte[] myDecryptedBytes=myCipher.doFinal(myEncryptedBytes);
        String encrypteddata=new String(myEncryptedBytes);
        String decrypteddata=new String(myDecryptedBytes);
        System.out.println("Message : "+ message);
        System.out.println("Encrypted - "+ encrypteddata);
        System.out.println("Decrypted Message - "+ decrypteddata);
    }
}