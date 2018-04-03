package preparation.chapter16;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Ex1 {

    public static void main(String[] args) {
        towerHanoi(10);
    }

    public static void towerHanoi(int dishes){
        computeTowerHanoi(dishes, 0, 1, 2);

    }

    public static void computeTowerHanoi(int dishes, int fromPeg, int toPeg, int usePeg){
        if(dishes > 0) {
            // Move (dishes - 1) from fromPeg to usePeg
            computeTowerHanoi(dishes - 1, fromPeg, usePeg, toPeg);
            // Move largest dishes from fromPeg to toPeg
            System.out.println((fromPeg + 1) + " -> " + (toPeg + 1));
            computeTowerHanoi(dishes - 1, usePeg, toPeg, fromPeg);
        }
    }
}
