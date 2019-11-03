package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    private ImmutableList immutableArrayList;
    private ImmutableList emptyArrayList;


    @Before
    public void setUp() throws Exception {
        Object[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        immutableArrayList = new ImmutableArrayList(arr);
        emptyArrayList = new ImmutableArrayList();
    }

    @Test
    public void add() {
        ImmutableList lst = immutableArrayList.add(11);
        Object[] exp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertArrayEquals(lst.toArray(), exp);
    }

    @Test
    public void testEmptyInitialization() {
        Object[] emptyArray = {};
        Object[] real = emptyArrayList.toArray();
        boolean exp = emptyArrayList.isEmpty();
        assertTrue(exp);
        assertArrayEquals(emptyArray, real);
    }

    @Test
    public void testImmutability() {
        Object[] toAdd = {81, 32, 21};
        Object[] oldArray = immutableArrayList.toArray();
        ImmutableList lst = immutableArrayList.addAll(toAdd);
        Object[] newArray = immutableArrayList.toArray();
        assertArrayEquals(oldArray, newArray);
    }


    @Test
    public void testAdd() {
        Object x = 50;
        ImmutableList lst = immutableArrayList.add(2, x);
        Object[] exp = {1, 2, 50, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(lst.toArray(), exp);
    }

    @Test
    public void addAll() {
        Object[] newArr = {81, 32, 21};
        ImmutableList lst = immutableArrayList.addAll(newArr);
        Object[] exp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 81, 32, 21};
        assertArrayEquals(exp, lst.toArray());
    }

    @Test
    public void testAddAll() {
        Object[] newArr = {81, 32, 21};
        ImmutableList lst = immutableArrayList.addAll(2, newArr);
        Object[] exp = {1, 2, 81, 32, 21, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(exp, lst.toArray());
    }

    @Test
    public void get() {
        Object real = immutableArrayList.get(2);
        Object exp = 3;
        assertEquals(real, exp);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testWrongIndex() {
        Object el = immutableArrayList.get(21);

    }

    @Test
    public void remove() {
        ImmutableList lst = immutableArrayList.remove(8);
        Object[] exp = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        assertArrayEquals(lst.toArray(), exp);
    }

    @Test
    public void set() {
        ImmutableList lst = immutableArrayList.set(0, 101);
        Object[] exp = {101, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(lst.toArray(), exp);
    }

    @Test
    public void indexOf() {
        int search1 = immutableArrayList.indexOf(10);
        int search2 = immutableArrayList.indexOf(101);
        int exp1 = 9;
        int exp2 = -1;
        assertEquals(search1, exp1);
        assertEquals(search2, exp2);
    }

    @Test
    public void size() {
        int real = immutableArrayList.size();
        int exp = 10;
        assertEquals(real, exp);
    }

    @Test
    public void clear() {
        ImmutableList lst = immutableArrayList.clear();
        Object[] exp = {};
        Object[] works = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(lst.toArray(), exp);
        assertArrayEquals(immutableArrayList.toArray(), works);
    }

    @Test
    public void isEmpty() {
        boolean real = immutableArrayList.isEmpty();
        boolean exp = false;
        assertEquals(real, exp);
    }

    @Test
    public void toArray() {
        ImmutableList lst = immutableArrayList.add("hello");
        Object[] exp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, "hello"};
        Object[] real = lst.toArray();
        assertArrayEquals(exp, real);
    }


    @Test
    public void testToString() {
        ImmutableList lst = immutableArrayList.add("hello");
        String exp = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, hello";
        String real = lst.toString();
        assertEquals(exp, real);
    }
}
