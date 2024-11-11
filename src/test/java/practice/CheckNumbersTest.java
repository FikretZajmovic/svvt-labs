package practice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CheckNumbersTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 5, 17, 19, 211})
    void testIsPrime(int number) {
        CheckNumbers cn = new CheckNumbers();
        assertTrue(cn.isPrime(number));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/fibonacci.csv", numLinesToSkip = 1)
    void testFibonacci(int number, int expected){
        CheckNumbers cn = new CheckNumbers();
        assertEquals(expected, cn.fibonacci(number));
    }
}