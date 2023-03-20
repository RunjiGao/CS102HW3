package Cs102hw3;
import java.util.Scanner; 
public class Sieve {
    void primesTo(int n) {
        ArrayQueue numbers = new ArrayQueue(n);
        ArrayQueue primes = new ArrayQueue(n);

        // Enqueue all numbers from 2 to n into numbers
        for (int i = 2; i <= n; i++) {
            numbers.enqueue(i);
        }

        // Find the next prime number and eliminate its multiples from numbers
        while (!numbers.isEmpty() && numbers.first() <= Math.sqrt(n)) {
            int p = numbers.dequeue();
            primes.enqueue(p);

            // Eliminate all multiples of p from numbers
            ArrayQueue temp = new ArrayQueue(n);
            while (!numbers.isEmpty()) {
                int num = numbers.dequeue();
                if (num % p != 0) {
                    temp.enqueue(num);
                }
            }
            numbers = temp;
        }

        // All remaining numbers in numbers are prime, so add them to primes
        while (!numbers.isEmpty()) {
            primes.enqueue(numbers.dequeue());
        }

        // Print all prime numbers in primes
        while (!primes.isEmpty()) {
            System.out.print(primes.dequeue()+",");
        }
    }

    public static void main(String[] args) {
    	Scanner myObj = new Scanner(System.in);
		System.out.println("Please enter a number that is higher than or equal to 2: ");
		int inputint = myObj.nextInt();
		if(inputint<2) {
			System.out.println("Please enter a number that is higher or equal to 2");
		}
		else {
        Sieve sieve = new Sieve();
        sieve.primesTo(inputint);
    }
    }
}
