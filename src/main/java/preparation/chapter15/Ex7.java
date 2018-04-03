package preparation.chapter15;

import java.util.*;

public class Ex7 {
    // IntAndPi has a formula: c = a + b * Pi
    public static class IntAndPi implements Comparable<IntAndPi>{
        public int a;
        public int b;
        public double val;

        public IntAndPi(int a, int b) {
            this.a = a;
            this.b = b;
            this.val = a + b * Math.PI;
        }

        @Override
        public int compareTo(IntAndPi o) {
            return Double.compare(val, o.val);
        }

        @Override
        public String toString() {
            return "" + val;
        }

        public static IntAndPi addToOne(IntAndPi some){
            return new IntAndPi(some.a + 1, some.b);
        }

        public static IntAndPi addToPi(IntAndPi some){
            return new IntAndPi(some.a, some.b + 1);
        }
    }

    public static void main(String[] args) {
        List<IntAndPi> gen10Nums = genKIntAndPiNumbers(10);
        System.out.println(gen10Nums);
        System.out.println(happyBirthDay(2018));
        TreeSet<Integer> test = new TreeSet<>(Arrays.asList(1,4,3,2,6,9,5,7,8,0));
        System.out.println(test);
    }

    public static List<IntAndPi> genKIntAndPiNumbers(int k){
        if(k < 1) return Collections.emptyList();
        IntAndPi first = new IntAndPi(0,0);
        int i = 0, j = 0;
        List<IntAndPi> result = new ArrayList<>(k);
        result.add(first);
        for(int n = 1; n < k; n++){
            IntAndPi addToOne = IntAndPi.addToOne(result.get(i));
            IntAndPi addToPi = IntAndPi.addToPi(result.get(j));
            IntAndPi added = addToOne.compareTo(addToPi) < 0 ? addToOne : addToPi;
            result.add(added);
            if(added.compareTo(addToOne) == 0) i++;
            if(added.compareTo(addToPi) == 0) j++;
        }
        return result;
    }

    public static String happyBirthDay(int year){
        if(year <= 1995) return "All my best to your little miracle.";
        return happyBirthDay(year - 1);
    }
}
