package preparation.chapter7;

public class Ex11 {
    public static void main(String[] args) {
        String input = "Hello World!";
        StringBuilder[] threeLines = new StringBuilder[]{
                new StringBuilder(),new StringBuilder(),new StringBuilder()
        };
        for(int i=0; i<input.length(); i++){
            int line = (int)Math.sin(i * Math.PI/2) + 1;
            threeLines[line].append(input.charAt(i));
        }
        System.out.println(threeLines[2].toString() + threeLines[1].toString() + threeLines[0].toString());
        snakePrint(input);
    }

    public static void snakePrint(String input){
        // Top line
        // init: 1, step: 4
        StringBuilder builder = new StringBuilder();
        for(int i=1; i<input.length(); i=i+4){
            builder.append(input.charAt(i));
        }
        // Center line
        // init: 0, step: 2
        for(int i=0; i<input.length(); i=i+2){
            builder.append(input.charAt(i));
        }
        // Bottom line
        // init: 3, step: 4
        for(int i=3; i<input.length(); i=i+4){
            builder.append(input.charAt(i));
        }
        System.out.println(builder.toString());
    }
}
