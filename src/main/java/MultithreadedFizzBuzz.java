import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultithreadedFizzBuzz {
    
    public static Lock lock = new ReentrantLock();
    
    public static Condition fizzbuzzCond = lock.newCondition();
    public static Condition fizzCond = lock.newCondition();
    public static Condition buzzCond = lock.newCondition();
    public static Condition numberCond = lock.newCondition();
    public static int[] number = new int[1];
    
    public static class FizzBuzz implements Runnable{
        private int maxValue;
        
        public FizzBuzz(int maxValue) {
            super();
            this.maxValue = maxValue;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    lock.lock();
                    while((number[0] % 5 != 0) || (number[0] % 3 != 0)) {
                            fizzbuzzCond.await();
                    }
                    if(number[0] >= maxValue) break;
                    System.out.println(number[0] + " fizzbuzz");
                    number[0] = number[0] + 1;
                    fizzCond.signal();
                    buzzCond.signal();
                    numberCond.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
        
    }
    
    public static class Fizz implements Runnable{
        private int maxValue;
        
        public Fizz(int maxValue) {
            super();
            this.maxValue = maxValue;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    lock.lock();
                    while((number[0] % 3 != 0) || (number[0] % 3 == 0 && number[0] % 5 == 0)) {
                            fizzCond.await();
                    }
                    if(number[0] >= maxValue) break;
                    System.out.println(number[0] + " fizz");
                    number[0] = number[0] + 1;
                    fizzbuzzCond.signal();
                    buzzCond.signal();
                    numberCond.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
        
    }
    
    public static class Buzz implements Runnable{
        private int maxValue;
        
        public Buzz(int maxValue) {
            super();
            this.maxValue = maxValue;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    lock.lock();
                    while((number[0] % 5 != 0) || (number[0] % 3 == 0 && number[0] % 5 == 0)) {
                            buzzCond.await();
                    }
                    if(number[0] >= maxValue) break;
                    System.out.println(number[0] + " buzz");
                    number[0] = number[0] + 1;
                    fizzbuzzCond.signal();
                    fizzCond.signal();
                    numberCond.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
        
    }
    
    public static class Number implements Runnable{
        private int maxValue;
        
        public Number(int maxValue) {
            super();
            this.maxValue = maxValue;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    lock.lock();
                    while((number[0] % 5 == 0) || (number[0] % 3 == 0)) {
                            numberCond.await();
                    }
                    if(number[0] >= maxValue) break;
                    System.out.println(number[0] + " sieukaka");
                    number[0] = number[0] + 1;
                    fizzbuzzCond.signal();
                    fizzCond.signal();
                    buzzCond.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
        
    }

    public static void main(String[] args) {
        number[0] = 0;
        ExecutorService es = Executors.newFixedThreadPool(10);
        List<Runnable> tasks = Arrays.asList(new FizzBuzz(16), new Fizz(16), new Buzz(16), new Number(16));
        for (Runnable task : tasks) {
            es.submit(task);
        }
    }

}
