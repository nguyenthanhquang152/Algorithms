package preparation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class DefineContainer {
    public static void main(String[] args){
        Integer[] lines = new Integer[] {
//                1, 8, 6, 2, 5, 4, 8, 3, 7
                3, 5, 7, 5, 6, 5, 8, 3
        };

        System.out.println(Arrays.toString(defineContainer(lines)));
        System.out.println(Arrays.toString(optimizedDefinContainer(lines)));
    }

    private static Integer[] optimizedDefinContainer(Integer[] lines){
        int left = 0;
        int right = lines.length - 1;
        Integer[] container = new Integer[]{0, lines.length - 1};
        int maxArea = Integer.MIN_VALUE;
        while(left < right){
            int maxAreaSofar = (right - left) * Math.min(lines[left], lines[right]);
            if(maxAreaSofar > maxArea){
                maxArea = maxAreaSofar;
                container[0] = left;
                container[1] = right;
            }
            if(lines[left] < lines[right]) left++;
            else right--;
        }
        return container;
    }

    private static Integer[] defineContainer(Integer[] lines){
        Integer[] container = new Integer[]{
                0,0
        };
        int maxArea = Integer.MIN_VALUE;
        for(int left = 0; left< lines.length; left++){
            for(int right = left + 1; right < lines.length; right++){
                int maxAreaSofar = (right - left) * Math.min(lines[left], lines[right]);
                if(maxAreaSofar > maxArea){
                    maxArea = maxAreaSofar;
                    container[0] = left;
                    container[1] = right;
                }
            }
        }
        return container;
    }
}
