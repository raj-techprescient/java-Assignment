import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Scanner;
import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;


public class EncryptDecrypt {
    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
        keygenerator.init(128);
        return keygenerator.generateKey();
    }
    public static IvParameterSpec generateIv() {
        byte[] initializationVector = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(initializationVector);
        return new IvParameterSpec(initializationVector);
    }
    public static byte[] encrypt(String input, SecretKey key, IvParameterSpec iv)
            throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        return cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
    }
    public static String decrypt(byte[] cipherText, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] plainText = cipher.doFinal(cipherText);
        return new String(plainText);
    }

    public static void main(String[] args) throws Exception{
        SecretKey symmetricKey = generateKey();
        IvParameterSpec iv = generateIv();

        // Takes input from the keyboard
        Scanner message = new Scanner(System.in);
        System.out.println("Enter the text message to encrypt");
        String plainText = message.nextLine();
        message.close();

        // Encrypt the message using the symmetric key
        byte[] cipherText = encrypt(plainText, symmetricKey, iv);

        System.out.println("The encrypted message is: " + cipherText);

        // Decrypt the encrypted message
        String decryptedText = decrypt(cipherText, symmetricKey, iv);

        System.out.println( "Your original message is: " + decryptedText);
    }
}
