package preparation.chapter7;

public class Ex4 {
    public static void main(String[] args) {
        char[] s = new char[]{
                'a','c','d','b','b','c','a'
        };
        int size = s.length;
        // remove 'b' characters and count 'a'
        int aCount = 0;
        int lastWrite = 0;
        for(int i=0; i<size; i++){
            if(s[i] == 'a'){
                aCount++;
            }
            if(s[i] != 'b'){
                s[lastWrite] = s[i];
                lastWrite++;
            }
        }
        lastWrite--;
        int startInReverse = lastWrite + aCount;
        System.out.println(startInReverse);
        while(lastWrite >= 0){
            if(s[lastWrite] == 'a'){
                s[startInReverse--] = 'd';
                s[startInReverse--] = 'd';
            } else {
                s[startInReverse--] = s[lastWrite];
            }
            lastWrite--;
        }
        StringBuilder builder = new StringBuilder();
        for(char c : s) builder.append(c);
        System.out.println(builder.toString());

    }
}
