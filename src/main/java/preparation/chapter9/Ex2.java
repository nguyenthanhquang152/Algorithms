package preparation.chapter9;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;

public class Ex2 {
    public static void main(String[] args) {
        String expression = "3,4,+,2,*,1,+";
        String[] elements = expression.split(",");
        Deque<Integer> accumulator = new LinkedList<>();

        Map<String, Function<Deque<Integer>, Integer>> ops = new HashMap<>();
        ops.put("+", (acc) ->  acc.pop() + acc.pop());
        ops.put("-", (acc) ->  acc.pop() - acc.pop());
        ops.put("*", (acc) ->  acc.pop() * acc.pop());
        ops.put("/", (acc) ->  acc.pop() / acc.pop());

        for(String element: elements){
            if(ops.get(element) == null){
                accumulator.push(Integer.parseInt(element));
            } else {
                Integer result = ops.get(element).apply(accumulator);
                accumulator.push(result);
            }
        }
        System.out.println(accumulator.pop());
    }
}
