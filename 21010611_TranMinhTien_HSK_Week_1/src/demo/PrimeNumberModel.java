package demo;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberModel {
	    public List<Integer> getPrimeNumbers(int n) {
	        List<Integer> primeNumbers = new ArrayList<>();
	        int num = 2;
	        while (primeNumbers.size() < n) {
	            if (isPrime(num)) {
	                primeNumbers.add(num);
	            }
	            num++;
	        }
	        return primeNumbers;
	    }
	    
	    private boolean isPrime(int n) {
	        if (n <= 1) {
	            return false;
	        }
	        for (int i = 2; i <= Math.sqrt(n); i++) {
	            if (n % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	
}
