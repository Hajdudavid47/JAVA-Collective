package pgdp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UpaTest {
    // DO NOT MODIFY THIS FIELD
    protected Utils utils;
    protected Bag bag;

    @BeforeEach
    protected void setUp() {
        // DO NOT INITIALIZE YOUR OWN OBJECTS FOR TESTING; ONLY USE THIS!
        // DO NOT MODIFY THIS METHOD.
        // You can create more methods with the @BeforeEach annotation,
        // if you need to set up anything for your test cases.
        this.utils = new Utils();
        this.bag = new Bag();
    }

    // ================ GCD TESTS ==================
    @Test
    public void testGcdBasic() {
        assertEquals(4, utils.gcd(8, 12));
        assertEquals(2, utils.gcd(18, 26));
    }
    @Test
    public void testGcdWithZero() {
        assertEquals(5, utils.gcd(5, 0));
        assertEquals(7, utils.gcd(0, 7));
    }

   @Test
   public void testGcdWithoutCommonDivisor() {
       assertEquals(1, utils.gcd(13, 17)); // Prime numbers should have GCD of 1
       assertEquals(1, utils.gcd(19, 23));
   }

   @Test
   public void testGcdWithMultiples() {
       assertEquals(15, utils.gcd(15, 45)); // One number is a multiple of the other
   }

   @Test
   public void testGcdWithSwappedParameterOrder() {
       assertEquals(6, utils.gcd(54, 24));
       assertEquals(6, utils.gcd(24, 54)); // Swapped order
   }

    // ================ SORT TESTS ==================
    @Test
    public void testSortEmptyArray() {
        int[] arr = {};
        int[] sorted = utils.sort(arr);
        assertArrayEquals(new int[]{}, sorted);
    }

    @Test
    public void testSort() {
        int[] arr = {5, 3, 8, 1, 2};
        int[] sorted = utils.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, sorted);
    }

    @Test
    public void testSortWithNegativeNumbers() {
        int[] arr = {0, -1, 5, -3, 2};
        int[] sorted = utils.sort(arr);
        assertArrayEquals(new int[]{-3, -1, 0, 2, 5}, sorted);
    }

    @Test
    public void testSortWithRepeatedNumbers() {
        int[] arr = {4, 2, 4, 3, 2};
        int[] sorted = utils.sort(arr);
        assertArrayEquals(new int[]{2, 2, 3, 4, 4}, sorted);
    }

    @Test
    public void testOriginalUnmodified() {
        int[] arr = {5,4,3,2,1};
        assertTrue(true);
        int[] sorted = utils.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sorted);
        assertArrayEquals(new int[]{5,4,3,2,1}, arr); // Original array should remain unchanged
    }

    // ================ DATE VALIDATION TESTS ==================
    @Test
    public void testOutOfRangeMonth() {
        assertTrue(utils.isValidDate(10, 4, 2020));
        assertFalse(utils.isValidDate(10, 13, 2020));
    }

    @Test
    public void testFebruaryLeapYear() {
        assertTrue(utils.isValidDate(29, 2, 2020));
        assertFalse(utils.isValidDate(29, 2, 2019));
    }

    @Test
    public void testAdvancedLeapYear() {
        assertTrue(utils.isValidDate(29, 2, 2000)); // Divisible by 400
        assertFalse(utils.isValidDate(29, 2, 1900)); // Divisible by 100 but not by 400
    }

    @Test
    public void testNegatives() {
        assertFalse(utils.isValidDate(10, 10, -1));
        assertFalse(utils.isValidDate(-5, 10, 2020));
        assertFalse(utils.isValidDate(10, -3, 2020));
    }

    @Test
    public void testZeroValues() {
        assertFalse(utils.isValidDate(0, 10, 2020));
        assertFalse(utils.isValidDate(10, 0, 2020));
    }

    @Test
    public void test31Days() {
        assertTrue(utils.isValidDate(31, 1, 2001));
        assertFalse(utils.isValidDate(31, 4, 2001));
    }

    // ================ BAG TESTS ==================
    @Test
    public void testBagAddUntilCapacity() {
        // Capacity is 3
        assertTrue(bag.add(1));
        assertTrue(bag.add(2));
        assertTrue(bag.add(3));
        assertFalse(bag.add(4)); // Should fail, capacity reached
    }

    @Test
    public void testBagContains() {
        bag.add(10);
        bag.add(20);
        assertTrue(bag.contains(10));
        assertTrue(bag.contains(20));
        assertFalse(bag.contains(30));
    }

    @Test
    public void testBagRemove() {
        bag.add(15);
        assertTrue(bag.remove(15));
        assertFalse(bag.contains(15));
        bag.add(25);
        assertTrue(bag.contains(25));
    }

    @Test
    public void testBagRemoveNonExistent() {
        bag.add(5);
        assertFalse(bag.remove(10)); // 10 was never added
    }

    @Test
    public void testBagRemoveOne() {
        bag.add(7);
        bag.add(7);
        assertTrue(bag.remove(7));
        assertTrue(bag.contains(7)); // One instance should still be present
        assertTrue(bag.remove(7));
    }

    @Test
    public void testBagRemoveDecreaseCapacity() {
        bag.add(5);
        bag.add(10);
        bag.add(15);
        assertTrue(bag.remove(10));
        assertTrue(bag.add(20)); // Should succeed now
    }

    @Test
    public void testBagRemoveFromEarlierIndex() {
        bag.add(1);
        bag.add(2);
        bag.add(3);
        assertTrue(bag.remove(1));
        assertFalse(bag.contains(1));
        assertTrue(bag.contains(2));
        assertTrue(bag.contains(3));
    }
}
