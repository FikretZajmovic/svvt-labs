package week5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private BinarySearch searcher = new BinarySearch();

    @Test
    public void testEmptyArray() {
        int[] elements = {};
        assertEquals(-1, searcher.search(elements, 5));
    }

    @Test
    public void testSingleElementFound() {
        int[] elements = {5};
        assertEquals(0, searcher.search(elements, 5));
    }

    @Test
    public void testSingleElementNotFound() {
        int[] elements = {5};
        assertEquals(-1, searcher.search(elements, 3));
    }

    @Test
    public void testFoundAtStart() {
        int[] elements = {1, 3, 5, 7, 9};
        assertEquals(0, searcher.search(elements, 1));
    }

    @Test
    public void testFoundAtEnd() {
        int[] elements = {1, 3, 5, 7, 9};
        assertEquals(4, searcher.search(elements, 9));
    }

    @Test
    public void testFoundInMiddle() {
        int[] elements = {1, 3, 5, 7, 9};
        assertEquals(2, searcher.search(elements, 5));
    }

    @Test
    public void testNotFoundLessThanMin() {
        int[] elements = {1, 3, 5, 7, 9};
        assertEquals(-1, searcher.search(elements, 0));
    }

    @Test
    public void testNotFoundGreaterThanMax() {
        int[] elements = {1, 3, 5, 7, 9};
        assertEquals(-1, searcher.search(elements, 10));
    }

    @Test
    public void testNotFoundBetweenElements() {
        int[] elements = {1, 3, 5, 7, 9};
        assertEquals(-1, searcher.search(elements, 4));
    }

    @Test
    public void testEvenNumberOfElements() {
        int[] elements = {1, 3, 5, 7, 9, 11};
        assertEquals(3, searcher.search(elements, 7));
    }

    @Test
    public void testDuplicateElements() {
        int[] elements = {1, 3, 3, 3, 5};
        int result = searcher.search(elements, 3);
        assertTrue(result >= 1 && result <= 3);
    }
}