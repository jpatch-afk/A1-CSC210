import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DynamicArrayTests {

    private DynamicArray<Character> a1;
    private DynamicArray<Character> a2;
    private DynamicArray<Character> empty;
    private DynamicArray<Character> s;

    /**
     * Initializes DynamicArray<Character> instances to be used for testing.
     * Re-initializes before each test.
     * This ensures that tests do not interfere with one another.
     */
    @Before
    public void setUp() {
        a1 = stringToArray("abcdef");
        a2 = stringToArray("wxyz");
        empty = stringToArray("");
        s = stringToArray("s");
    }

    /**
     * Puts the characters of a string into an array structure
     */
    public DynamicArray<Character> stringToArray(String s) {
        DynamicArray<Character> result = new DynamicArray<Character>(s.length());
        for (int i = 0; i < s.length(); i++) {
            result.add(s.charAt(i), i);
        }
        return result;
    }

    /**
     * Compares the sizes of a DynamicArray<Character> and a string
     */
    public void compareSize(DynamicArray<Character> arr, String s){
        assertEquals("["+s+"] Array lengths are equal", arr.size(), s.length());
    }

    /**
     * Compares each element in a DynamicArray<Character>
     * against those in a string.
     */
    public void compareToString(DynamicArray<Character> arr, String s) {
        for (int i = 0; i < arr.size(); i++) {
            assertEquals("["+s+"] Elements are equal at index " + i, arr.get(i).charValue(), s.charAt(i));
        }
    }

    // ~*~*~*~*~ Append Tests Below ~*~*~*~*~

    /**
     * Tests that appending two non-empty arrays results in
     * a new array containing the elements of both, in order.
     */
    @Test
    public void testAppendStandard() {
        compareToString(a1.append(a2), "abcdefwxyz");
        compareToString(a2.append(a1), "wxyzabcdef");
    }

    /**
     * Tests that appending a non-empty array to itself results in
     * a new array containing the elements repeated twice.
     */
    @Test
    public void testAppendSelf() {
        compareToString(a1.append(a1), "abcdefabcdef");
        compareToString(a2.append(a2), "wxyzwxyz");
    }

    /**
     * Tests that appending a non-empty array and an array of
     * length one results in a new array containing the elements
     * of both, in order.
     */
    @Test
    public void testAppendSingle() {
    compareToString(a1.append(s),"abcdefs");
    compareToString(s.append(a1),"sabcdef");
    compareToString(s.append(s),"ss");
    }

    /**
     * Tests that appending an empty array
     * results in a new array that matches the other array
     */
    @Test
    public void testAppendEmpty() {
        compareToString(a1.append(empty), "abcdef");
        compareToString(empty.append(a1), "abcdef");
        compareToString(empty.append(empty), "");
    }

       // ~*~*~*~*~ Extract Tests Below ~*~*~*~*~


    /**
     * Tests that test the standards of the extract method
     */
    @Test
    public void testExtractStandard() {
        DynamicArray<Character> extracted = a1.extract(0, 5);
        assertEquals(5, extracted.size());
    }

    /**
     * Tests that you can extract the entire array by using the full length of the array 
     */
    @Test
    public void testExtractEntire() {
    DynamicArray<Character> extracted = a1.extract(0, a1.size());

    assertEquals(a1.size(), extracted.size());
  
    for (int i = 0; i < a1.size(); i++) {
        assertEquals(a1.get(i), extracted.get(i));
    }
    }

    /**
    * Tests that you can fill in zero elements 
    */
    @Test
    public void testExtractZero() {
        DynamicArray<Character> extracted = a1.extract(2, 2);
        
        assertEquals(0, extracted.size());
    }

    /**
     * Tests that you can extract from an empty array
     */
   @Test
    public void testExtractEmpty() {
        DynamicArray<Character> extracted = empty.extract(0, 0);

        assertEquals(0, extracted.size());
    }

    /**
     * Tests that extract throws the proper exception
     * when called on invalid indices
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testExtractBounds() {
        DynamicArray<Character> extractLNeg = a1.extract(-1, 5);
        assertEquals(0, extractLNeg.size());

        DynamicArray<Character> extractHigh = a1.extract(-1, s.size() + 1);
        assertEquals(0, extractHigh.size());

        DynamicArray<Character> extractLow = a1.extract(s.size() + 1, s.size() + 2);
        assertEquals(0, extractLow.size());

        DynamicArray<Character> extractHNeg = a1.extract(1, -5);
        assertEquals(0, extractHNeg.size());

        DynamicArray<Character> extractHigher = a1.extract(5, 1);
        assertEquals(0, extractHigher.size());
    }

    // ~*~*~*~*~ Get Tests Below ~*~*~*~*~

    /**
     * Tests that test the standards of the get method
     */
    @Test
    public void testGetStandard() {
        assertEquals((Character) 'f', a1.get(5));
    }

    /**
     * Tests that you can use get for all the methods in the array
     */
    @Test
    public void testGetAll() {
       DynamicArray<Character> getAll = new DynamicArray<Character>(5);

       for (int i = 0; i < getAll.size(); i++) {
            getAll.get(a1.get(i));
       }
       assertEquals(a1.size(), getAll.size());
        
    }

    /**
     * Test getting the same index multiple times returns the same value
     */
    @Test
    public void testGetConsistency() {
        Character first = a1.get(3);
        Character second = a1.get(3);
        Character third = a1.get(3);
        
        assertEquals(first, second);
        assertEquals(second, third);
    }

    /**
     * Test that get throws all the appropriate exceptions 
     */
    @Test(expected = RuntimeException.class)
    public void testGetBounds() {
        a1.get(-1);

        a1.get(a1.size());

        a1.get(a1.size() + 1);
    }


    // ~*~*~*~*~ Add Tests Below ~*~*~*~*~

    /**
     * Tests that test the standards of the add method
     */
    @Test
    public void testAddStandard() {
        empty.add('a', 0);
        assertEquals(1, empty.size());
        assertEquals((Character) 'a', empty.get(0));

        s.add('x', 0);
        
        assertEquals(2, s.size());
        compareToString(s, "xs");
        
    }

    /**
     * Tests that test that you can multiple elements at a time
     */
    @Test
    public void testAddMultiple() {
        s.add('1', 0);  
        s.add('2', 0);  
        s.add('3', 2);  
        
        assertEquals(4, s.size());
        compareToString(s, "213s");
    }

    /**
     * Test that original elements are in the correct spot after the add method is called
     */
    @Test
    public void testOriginalElementsIntact() {

        a1.add('g', 3);
        
        assertEquals((Character) 'a', a1.get(0));
        assertEquals((Character) 'b', a1.get(1));
        assertEquals((Character) 'c', a1.get(2));
        assertEquals((Character) 'g', a1.get(3));
        assertEquals((Character) 'd', a1.get(4));
        assertEquals((Character) 'e', a1.get(5));
        assertEquals((Character) 'f', a1.get(6));
    }


     /**
     * Test that add throws all the appropriate exceptions 
     */
    @Test(expected = RuntimeException.class)
    public void testAddBounds() {
        
        a1.add('x', -1);

        a1.add('x', a1.size() + 1);

        empty.add('X', 1);
    }
}