package codejam;

import java.util.Scanner;

public class GoYourOwnWay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long nTestcases = Long.parseLong(sc.nextLine());
        for(long i = 0; i < nTestcases; i++) {
            int dimension = Integer.parseInt(sc.nextLine());
            String rivalPath = sc.nextLine();
            String yourPath = findYourPath(rivalPath);
            printResult(yourPath, i+1);
        }
    }

    public static String findYourPath(String rivalPath) {
        String result = "";
        for (int i = 0; i < rivalPath.length(); i++){
            char nextRivalAction = rivalPath.charAt(i);
            if(nextRivalAction == 'S') {
                result += 'E';
            } else {
                result += 'S';
            }
        }
        return result;
    }

    public static void printResult(String yourPath, long index) {
        System.out.printf("Case #%d: %s\n", index, yourPath);
    }
}
