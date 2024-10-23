package week4;

public class NumberChecker {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public boolean isPrime(int number){
        if(number < 2){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    public int square(int n){
        return n * n;
    }

    public int fibonacci(int n){
        if(n <= 1){
            return n;
        } else{
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
