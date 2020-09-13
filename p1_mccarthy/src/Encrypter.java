public class Encrypter {
    String encrypt(String num) {
        int unencryptedNum = Integer.parseInt(num); //Convert the inserted string into a number in order to manipulate the numbers

        int[] digits = numToArray(unencryptedNum); //Calls the convertNum function and stores each number in an array

        //Encryption arithmetic
        for(int i = 0; i < 4; i++) {
            digits[i] = (digits[i] + 7) % 10;
        }

        digitSwap(digits);//Calls digitSwap function and assigns new numbers back to the array.

        return convertString(digits);
    }

    //convertNum converts every number in the int into a single digit and stores in an array for future manipulation.
    static int[] numToArray(int num) {
        int[] numArray = new int[4];

        for(int i = 0; i < 4; i++) {
            numArray[4 - i - 1] = num % 10;

            num = num / 10;
        }
        //Numbers stored read left to right in the array, so 1234 inputted will read [1, 2 ,3, 4]

        return numArray;
    }

    //convertString converts the array back into a String to send the result back to the user
    static String convertString(int[] digits) {
        String result = "";
        for(int i = 0; i < 4; i++) {
            result = result.concat(Integer.toString(digits[i]));
       }
        return result;
    }

    //digitSwap takes the digits after arithmetic and swaps them
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
