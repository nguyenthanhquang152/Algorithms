package amazon;
import java.util.*;

public class Excercise1 {
    public List<String> prioritizedOrders(int numOrders, List<String> orderList)
    {
        // WRITE YOUR CODE HERE
        LinkedList<String> result = new LinkedList<>();
        List<Prime> primes = new ArrayList<>();
        List<String> nonPrimes = new ArrayList();
        // 1. Separate orderList into primes and nonPrimes
        for(int i = 0; i < orderList.size(); i++){
            if(this.isPrime(orderList.get(i))) {
                primes.add(new Prime(i, orderList.get(i)));
            } else {
                nonPrimes.add(orderList.get(i));
            }
        }
        // 2. Sort primes
        Collections.sort(primes, new Comparator<Prime>() {
            @Override
            public int compare(Prime o1, Prime o2) {
                String firstContent = o1.metadata.substring(o1.metadata.indexOf(" ") + 1);
                String secondContent = o2.metadata.substring(o2.metadata.indexOf(" ") + 1);
                int metadataCompared = firstContent.compareTo(secondContent);
                if(metadataCompared == 0) {
                    return o1.index.compareTo(o2.index);
                } else {
                    return metadataCompared;
                }
            }
        });

        // 3. Add primes to result
        for(Prime prime : primes) {
            result.addLast(prime.metadata);
        }
        // 4. Add nonPrimes to result
        for(String nonPrime: nonPrimes) {
            result.addLast(nonPrime);
        }
        return result;
    }

    public static class Prime {
        public Prime(Integer index, String metadata) {
            this.index = index;
            this.metadata = metadata;
        }
        Integer index;
        String metadata;
    }

    public boolean isPrime(String order) {
        String[] splitted = order.split(" ");
        try {
            Integer.parseUnsignedInt(splitted[1]);
            return false;
        } catch (NumberFormatException ne) {
            return true;
        }
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList(
            "a1 alps cow bar", "mi2 jog jog mid pet",
                "wz3 34 54 398", "x4 45 21 7"
        );

        Excercise1 ex = new Excercise1();
        List<String> result = ex.prioritizedOrders(4, input);
        System.out.println(result);
    }

}
