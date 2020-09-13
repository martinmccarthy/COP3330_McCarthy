import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Encrypter myEncrypter = new Encrypter();
        Decrypter myDecrypter = new Decrypter();

        System.out.print("Enter a number for encryption: ");
        String input = sc.next();

        String encryptedValue = myEncrypter.encrypt(input);

        System.out.println("Encrypted value: " + encryptedValue);

        String decryptedValue = myDecrypter.decrypt(encryptedValue);

        System.out.println("Decrypted value: " + decryptedValue);

    }
}
