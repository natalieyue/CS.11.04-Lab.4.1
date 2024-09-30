import java.util.Scanner;

public class Main {


    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str) {
        int number = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                number++;
            } else if (str.charAt(i) == ')') {
                number--;
            }
        }
        return number == 0;
    }


    // 2. reverseInteger
    public static String reverseInteger(int num) {

        boolean isNegative = num < 0;
        if (isNegative) {
            num = -num;
        }

        String aAsString = String.valueOf(num);
        StringBuilder finalNum = new StringBuilder();


        for (int i = 0; i < aAsString.length(); i++) {
            finalNum.append(aAsString.charAt(aAsString.length() - i - 1));
        }


        String reversedString = finalNum.toString();

        if (isNegative) {
            reversedString = "-" + reversedString;
        }

        return reversedString;
    }


    // 3. encryptThis
    public static String encryptThis(String message) {
        Scanner sc = new Scanner(message);
        StringBuilder newMessage = new StringBuilder();
        String currentWord;
        while (sc.hasNext()) {
            currentWord = sc.next();
            int firstLetter = (int) currentWord.charAt(0);
            if (currentWord.length() > 2) {
                currentWord = firstLetter + String.valueOf(currentWord.charAt(currentWord.length() - 1)) + currentWord.substring(2, currentWord.length() - 1) + String.valueOf(currentWord.charAt(1));
            } else if (currentWord.length() == 2) {
                currentWord = firstLetter + String.valueOf(currentWord.charAt(1));
            } else {
                currentWord = String.valueOf(firstLetter);
            }
            newMessage.append(currentWord);
            if (sc.hasNext()) {
                newMessage.append(" ");
            }

        }
        return (newMessage.toString());
    }

    // 4. decipherThis

    public static String decipherThis(String message){
        String[] words = message.split(" ");
        StringBuilder finalMessage = new StringBuilder();
        String currentWord = " ";
        for (int i = 0; i<words.length; i++){
            currentWord = words[i];

            StringBuilder numberList = new StringBuilder();
            StringBuilder wordList = new StringBuilder();

            for(char c: currentWord.toCharArray()){
                if(Character.isDigit(c)){
                    numberList.append(c);
                } else{
                    wordList.append(c);
                }
            }

            char numberCode = (char) Integer.parseInt(numberList.toString());
            String wordLetters = wordList.toString();
            currentWord = numberCode + wordLetters;

            char secondLetter = currentWord.charAt(currentWord.length()-1);
            String lastLetter = "";
            String middle = "";
            if(currentWord.length()>2){
                middle = currentWord.substring(2, currentWord.length() - 1);
                lastLetter = String.valueOf(currentWord.charAt(1));
            }
            currentWord = String.valueOf(numberCode) + secondLetter + middle + lastLetter;
            finalMessage.append(currentWord);

            if(i != words.length-1){
                finalMessage.append(" ");
            }
        }

        return finalMessage.toString();
    }


}

