public class Decrypter {
    public static String decrypt(String num) {
        int encryptedNum = Integer.parseInt(num);

        int[] digits = Encrypter.numToArray(encryptedNum);

        Encrypter.digitSwap(digits);

        for(int i = 0; i < 4; i++) {
            digits[i] = (digits[i] + 3) % 10;
        }

        return Encrypter.convertString(digits);
    }


    public static void main(String[] args) {
        String check = decrypt("2591");
        System.out.println(check);
    }
}
