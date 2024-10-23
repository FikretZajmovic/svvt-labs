package week4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

class NumberCheckerTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 18, 28, 1142})
    public void testIsEven(int n){
        NumberChecker nc = new NumberChecker();
        assertTrue(nc.isEven(n));
    }

    @ParameterizedTest
    @NullSource
    void testNull(String n){
        assertNull(n);
    }

    @ParameterizedTest
    @EmptySource
    void testEmpty(String[] n){
        assertArrayEquals(new String[0], n);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 5, 17, 19, 211})
    public void testIsPrime(int n){
        NumberChecker nc = new NumberChecker();
        assertTrue(nc.isPrime(n));
    }

    @ParameterizedTest
    @CsvSource({"2, 4", "3, 9", "5, 25", "11, 121"})
    void testSquare(int n, int expected){
        NumberChecker nc = new NumberChecker();
        assertEquals(expected, nc.square(n));
    }

    @ParameterizedTest
    @CsvSource(value = {"2;4", "3;9", "5;25", "11;121"}, delimiter = ';')
    void testSquare1(int n, int expected){
        NumberChecker nc = new NumberChecker();
        assertEquals(expected, nc.square(n));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void testSquare2(int number, int expected) {
        NumberChecker numberChecker = new NumberChecker();
        assertEquals(expected, numberChecker.square(number));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/fibonacci.csv", numLinesToSkip = 1)
    void testFibonacci(int number, int expected) {
        NumberChecker numberChecker = new NumberChecker();
        assertEquals(expected, numberChecker.fibonacci(number));
    }
}