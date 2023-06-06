import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution5 {
    private static int convertToArabic(String romanNumber) {
        char pred = '0';
        int sum = 0;
        int repeat = 0;
        int countV = 0;
        int countL = 0;
        int countD = 0;

        for (int i = 0; i < romanNumber.length(); i++) {
            switch (romanNumber.charAt(i)) {
                case 'M':
                    if (pred == '0' || pred == 'M') sum += 1000;
                    else if (pred == 'C' && repeat == 1) sum += 800;
                    else return -1;
                    break;
                case 'D':
                    countD++;
                    if (pred == '0' || pred == 'M') {
                        sum += 500;
                        countD++;
                    } else if (pred == 'C' && repeat == 1) sum += 300;
                    else return -1;
                    break;
                case 'C':
                    if (pred == '0' || pred == 'M' || pred == 'D' || pred == 'C') sum += 100;
                    else if (pred == 'X' && repeat == 1) sum += 80;
                    else return -1;
                    break;
                case 'L':
                    countL++;
                    if (pred == '0' || pred == 'C' || pred == 'M' || pred == 'D' || pred == 'L') sum += 50;
                    else if (pred == 'X' && repeat == 1) sum += 30;
                    else return -1;
                    break;
                case 'X':
                    if (pred == 'I' && repeat == 1) sum += 8;
                    else if (pred == 'V') return -1;
                    else sum += 10;
                    break;
                case 'V':
                    countV++;
                    if (pred != 'I' && repeat == 1) sum += 5;
                    else sum += 3;
                    break;
                case 'I':
                    sum += 1;
            }
            if (romanNumber.charAt(i) == pred && pred != 'M') repeat++;
            else repeat = 1;
            if (repeat > 3 || countV > 1 || countL > 1 || countD > 1) return -1;
            pred = romanNumber.charAt(i);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String romanNumber = reader.readLine().strip();
            System.out.println(convertToArabic(romanNumber));
        }
    }
}