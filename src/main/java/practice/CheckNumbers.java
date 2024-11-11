package practice;

import static java.lang.Math.sqrt;

public class CheckNumbers {
    public boolean isPrime(int number) {
        if (number == 0) {
            return false;
        }
        if (number == 1){
            return true;
        }
        for(int i = 2; i < sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    public int fibonacci(int number){
        if(number <= 1){
            return number;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
