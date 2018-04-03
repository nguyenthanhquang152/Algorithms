package preparation.chapter7;

public class Ex3 {
    public static void main(String[] args) {
        System.out.println(stringToInt("A") + " is " + intToString(1));
        System.out.println(stringToInt("B") + " is " + intToString(2));
        System.out.println(stringToInt("Y") + " is " + intToString(25));
        System.out.println(stringToInt("Z") + " is " + intToString(26));
        System.out.println(stringToInt("AA") + " is " + intToString(27));
        System.out.println(stringToInt("AB") + " is " + intToString(28));
        System.out.println(stringToInt("ZY") + " is " + intToString(701));
        System.out.println(stringToInt("ZZ") + " is " + intToString(702));
    }

    public static int stringToInt(String col){
        int result = 0;
        for(int i = 0; i < col.length(); i++){
            char c = col.charAt(i);
            result = result * 26 + c - 'A' + 1;
        }
        return result;
    }

    public static String intToString(int colId){
        StringBuilder result = new StringBuilder();
        int id = colId;
        while(id != 0){
            id = (id - 1);
            result.append((char)((id % 26) + 'A'));
            id /= 26;
        }
        result.reverse();
        return result.toString();
    }
}
