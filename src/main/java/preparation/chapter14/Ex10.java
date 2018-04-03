package preparation.chapter14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex10 {
    public static void main(String[] args) {
        List<Integer> lastSalaries = Arrays.asList(80, 30, 80, 40, 20);

        System.out.println(findCap(lastSalaries, 210));
    }

    public static double findCap(List<Integer> lastSalaries, int targetPayroll){
        lastSalaries = new ArrayList<>(lastSalaries);
        if(lastSalaries.isEmpty()) return -1f;
        int realSize = lastSalaries.size();
        lastSalaries.add(Integer.MAX_VALUE);
        Collections.sort(lastSalaries);
        if(targetPayroll < lastSalaries.get(0)) return targetPayroll/(double)(lastSalaries.size());
        int sumSofar = 0;
        double result = 0f;
        int currSize = realSize;
        for(int i = -1; i < realSize ; i++){
            double cap = currSize == 0 ? lastSalaries.get(i) : (targetPayroll - sumSofar) / (double)(currSize);
//            System.out.println(String.format("%d %f", i, cap));
            if(cap > lastSalaries.get(i + 1)){
                sumSofar += lastSalaries.get(i + 1);
                currSize --;
            } else {
                result = cap;
                break;
            }
        }
        return result;
    }
}
