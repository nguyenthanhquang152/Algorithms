package codejam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Foregone {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long nTestcases = sc.nextLong();
        for(long i = 0; i < nTestcases; i++) {
            long money = sc.nextLong();
            List<Long> splitted = splitMoney(money);
            printResult(splitted, i+1);
        }
    }

    public static List<Long> splitMoney(long money) {
        long first = 0;
        long second = 0;
        long exp = 1;
        while(money > 0) {
            long dividedByTen = money / 10;
            long remainder = money % 10;
            if(remainder == 4) {
                first = first + exp * 2;
                second = second + exp * 2;
            } else {
                first = first + exp * remainder;
            }
            exp = 10 * exp;
            money = dividedByTen;
        }
        return Arrays.asList(first,second);

    }

    public static void printResult(List<Long> result, long index) {
        System.out.printf("Case #%d: %d %d\n", index, result.get(0), result.get(1));
    }
}
