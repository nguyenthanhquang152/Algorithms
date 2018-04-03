
public class Spreadsheet {

    public static void main(String[] args) {
        System.out.println(decodeColumn("ZAA"));
        System.out.println(encodeColumn(17603));
    }
    
    public static String encodeColumn(int column) {
        int numberOfAlphabet = 'Z' - 'A' + 1;
        StringBuilder builder = new StringBuilder();
        while(column > 0) {
            column = (column - 1);
            int modulo = column % numberOfAlphabet;
            char c = (char)(modulo + 'A');
            builder.append(c);
            column = column/numberOfAlphabet;
        }
        return builder.reverse().toString();
    }
    
    public static int decodeColumn(String column) {
        int result = 0;
        int numberOfAlphabet = 'Z' - 'A' + 1;
        for(int i=0; i<column.length(); i++) {
            result = result * numberOfAlphabet + column.charAt(i) - 'A' + 1;
        }
        return result;
    }

}
