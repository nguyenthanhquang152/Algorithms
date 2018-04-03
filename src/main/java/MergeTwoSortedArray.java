import java.util.Arrays;

public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int[] a = new int[] {
                1,3,5,7,9
        };
        int[] b = new int[] {
                -2,0,2,4,6,8,10
        };
        perform(a,b);
        System.out.println(Arrays.toString(a) + Arrays.toString(b));
    }
    
    public static void perform(int[] a, int[] b) {
        for(int bIndex = b.length - 1; bIndex >= 0; bIndex--) {
            if(a[a.length - 1] > b[bIndex]) {
                int lastBValue = b[bIndex];
                b[bIndex] = a[a.length - 1];
                int placeholder = a.length - 2;
                while(placeholder >= 0 && a[placeholder] > lastBValue) {
                    a[placeholder + 1] = a[placeholder];
                    placeholder--;
                }
                a[placeholder+1] = lastBValue;
            }
        }
    }

}
