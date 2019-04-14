package codejam;

import java.util.*;

public class Ciphertext {
    // function check
// whether a number
// is prime or not
    static boolean isPrime(int n)
    {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so
        // that we can skip
        // middle five numbers
        // in below loop
        if (n % 2 == 0 ||
                n % 3 == 0)
            return false;

        for (int i = 5;
             i * i <= n; i = i + 6)
            if (n % i == 0 ||
                    n % (i + 2) == 0)
                return false;

        return true;
    }

    // Function to print primes
    static Set<Integer> primesLessThan(int n)
    {
        Set<Integer> primes = new HashSet<>();
        for (int i = 2; i <= n; i++)
        {
            if (isPrime(i))
                primes.add(i);
        }
        return primes;
    }

    public static long gcd(long num1, long num2) {
        while (num1 != num2) {
            if(num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }
        return num2;
    }

    public static List<Long> factor(long number) {
        List<Long> factorList = new ArrayList<>();
        Set<Long> factorSet = new HashSet<>();
        for(long i = 2; i< number; i++) {
            while(number%i == 0) {
                if(factorSet.add(i)) {
                    factorList.add(i);
                }
                number = number/i;
            }
        }
        if(number >2) {
            if(factorSet.add(number)) {
                factorList.add(number);
            }
        }
        if(factorList.size() == 1) {
            factorList.add(factorList.get(0));
        }
        return factorList;
    }


    /**
     * 1
     * 103 33
     * 49 49 217 1891 4819 2291 2987 3811 1739 2491 4717 445 65 1079 8383 5353 901 187 649 1003 697 3239 7663 291 123 779 1007 3551 1943 2117 1679 989 3053
     * CCCJQUIZKNOWBEVYOFDPFLUXALGORITHMS
     *
     * 1
     * 103 34
     * 49 217 217 217 1891 4819 2291 2987 3811 1739 2491 4717 445 65 1079 8383 5353 901 187 649 1003 697 3239 7663 291 123 779 1007 3551 1943 2117 1679 989 3053
     * CCJCJQUIZKNOWBEVYOFDPFLUXALGORITHM
     * @param args
     */
    // Driver Code
    public static void main (String[] args)
    {

        Scanner sc = new Scanner(System.in);
        long nTestcases = Long.parseLong(sc.nextLine());
        for(long i = 0; i < nTestcases; i++) {
            String firstLine = sc.nextLine();
            String[] nl = firstLine.split(" ");
            int n = Integer.parseInt(nl[0]);
            int l = Integer.parseInt(nl[1]);
//            Set<Integer> primeLessThanN = primesLessThan(n);
            String secondLine = sc.nextLine();
            String[] productStrings = secondLine.split(" ");
            List<Long> products = new ArrayList<>();
            for(int iProduct=0; iProduct<productStrings.length; iProduct++) {
                products.add(Long.parseLong(productStrings[iProduct]));
            }
            Set<Long> guessedPrimes = new HashSet<>();
            LinkedList<Long> orderedPrimes = new LinkedList<>();
            if(products.get(0) == products.get(1)) {
                long gcd = gcd(products.get(0), products.get(1));
                if(gcd != products.get(0)) {
                    orderedPrimes.add(products.get(0) / gcd);
                    guessedPrimes.add(products.get(0) / gcd);
                    orderedPrimes.add(gcd);
                    guessedPrimes.add(gcd);
                } else {
                    List<Long> factors = factor(products.get(0));
                    if(products.get(1) % factors.get(0) == 0) {
                        orderedPrimes.add(factors.get(1));
                        orderedPrimes.add(factors.get(0));
                    } else {
                        orderedPrimes.addAll(factors);
                    }
                    guessedPrimes.addAll(factors);
                }
            } else {
                List<Long> factors = factor(products.get(0));
                if(products.get(1) % factors.get(0) == 0) {
                    orderedPrimes.add(factors.get(1));
                    orderedPrimes.add(factors.get(0));
                } else {
                    orderedPrimes.addAll(factors);
                }
                guessedPrimes.addAll(factors);
            }
            for(int iProduct = 1; iProduct < products.size(); iProduct ++){
                long guessedPrime = products.get(iProduct) / orderedPrimes.get(orderedPrimes.size() - 1);
                guessedPrimes.add(guessedPrime);
                orderedPrimes.addLast(guessedPrime);
            }
            List<Long> tempPrimes = new ArrayList<>(guessedPrimes);
            Collections.sort(tempPrimes);
            Map<Long, Character> dict = new HashMap<>();
            for(char j = 0; j < tempPrimes.size(); j++) {
                char val = (char)('A' + j);
                dict.put(tempPrimes.get(j), val);
            }
            String result = "";
            for(int iProduct=0; iProduct < products.size(); iProduct++) {
                result += dict.get(products.get(iProduct) / orderedPrimes.get(iProduct));
            }
            result = dict.get(products.get(0) / orderedPrimes.get(1)) + result;
            System.out.printf("Case #%d: %s\n", i + 1, result);
        }
    }
}
