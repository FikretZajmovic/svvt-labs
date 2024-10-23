package week2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println("Before all tests");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before each test");
    }

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(10, 5);
        assertEquals(5, result, "10 - 5 should equal 5");
    }

    @Test
    public void testAdditionNegative() {
        Calculator calculator = new Calculator();
        assertNotEquals(6, calculator.add(2, 3), "2 + 3 should not equal 6");
    }

    @Test
    public void testFactorial() {
        Calculator calculator = new Calculator();
        assertEquals(120, calculator.factorial(5), "5! should equal 120");
    }

    @Test
    public void testFactorialNegative() {
        Calculator calculator = new Calculator();
        assertNotEquals(120, calculator.factorial(4), "4! should not equal 120");
    }

    @Test
    public void testArrayEquals() {
        String[] actual = {"Hello", "JUnit", "Framework"};
        String[] expected = {"Hello", "JUnit", "Framework"};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void assertBooleans() {
        assertFalse(1 > 2);
        assertTrue(2 > 1);
    }

    @Test
    public void assertNullsAndNotNulls() {
        String s = null;
        assertNull(s);
        s = "Hello";
        assertNotNull(s);
    }

    @Test
    public void stringToArrayIsNull(){
        Calculator calculator = new Calculator();
        assertNull(calculator.stringToArray(null));
    }

    @Test
    public void stringToArrayIsNotNull(){
        Calculator calculator = new Calculator();
        assertNotNull(calculator.stringToArray("Hello JUnit"));
    }

    @Test
    public void testSort() {
        Calculator calculator = new Calculator();
        int[] actual = {5, 3, 7};
        int[] expected = {3, 5, 7};
        assertArrayEquals(expected, calculator.sort(actual));
    }

    @Test
    public void testIfArrayEmpty(){
        Calculator calculator = new Calculator();
        int[] actual = {};
        int[] expected = {};
        assertArrayEquals(expected, calculator.sort(actual));
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After each test");
    }

    @AfterAll
    public static void tearDownAfterClass() {
        System.out.println("After all tests");
    }
}