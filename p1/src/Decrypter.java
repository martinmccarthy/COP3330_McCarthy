public class Decrypter {
    String decrypt(String num) {
        int encryptedNum = Integer.parseInt(num);

        int[] digits = numToArray(encryptedNum);

        digitSwap(digits);

        for(int i = 0; i < 4; i++) {
            digits[i] = (digits[i] + 3) % 10;
        }

        return convertString(digits);
    }

    static int[] numToArray(int num) {
        int[] numArray = new int[4];

        for(int i = 0; i < 4; i++) {
            numArray[4 - i - 1] = num % 10;

            num = num / 10;
        }
        //Numbers stored read left to right in the array, so 1234 inputted will read [1, 2 ,3, 4]

        return numArray;
    }

    static String convertString(int[] digits) {
        String result = "";
        for(int i = 0; i < 4; i++) {
            result = result.concat(Integer.toString(digits[i]));
        }
        return result;
    }

    static void digitSwap(int[] digits) {
        int temp;

        //Swap digit 1 and digit 3
        temp = digits[0];
        digits[0] = digits[2];
        digits[2] = temp;

        //Swap digit 2 and digit 4
        temp = digits[1];
        digits[1] = digits[3];
        digits[3] = temp;
    }
}
