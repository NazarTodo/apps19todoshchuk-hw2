package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableList immutableList;
    private ImmutableList defLst, testLst;
    private ImmutableLinkedList onlyLinked;
    private Object[] arr;
    private Object x, y, z;


    @Before
    public void setUp() throws Exception {
        Object[] testArr = new Object[]{7, 8, 11, 13, 43, 2, 51, 97, 5};
        arr = new Object[]{50, 21, 10};
        x = 8;
        y = 11;
        z = 14;
        immutableList = new ImmutableLinkedList();
        defLst = immutableList.addAll(arr);
        ImmutableLinkedList lst1 = new ImmutableLinkedList();
        ImmutableLinkedList lst2 = lst1.addFirst(x);
        ImmutableLinkedList lst3 = lst2.addFirst(z);
        onlyLinked = lst3.addLast(y);
        //        only linked looks like {14, 8, 11}
        testLst = immutableList.addAll(testArr);

    }

    @Test
    public void add() {
        ImmutableList lst = immutableList.add(x);
        Object[] exp = {8};
        assertArrayEquals(exp, lst.toArray());
    }

    @Test
    public void testAdd() {
        ImmutableList lst = immutableList.add(x);
        ImmutableList lst2 = lst.add(y);
        ImmutableList lst3 = lst2.add(1, z);
        Object[] exp = {8, 14, 11};
        assertArrayEquals(exp, lst3.toArray());
    }

    @Test
    public void testImmutability() {
        ImmutableList lst1 = immutableList.add(x);
        ImmutableList lst2 = lst1.add(y);
        ImmutableList lst3 = lst2.add(1, z);
        Object[] exp1 = {};
        Object[] exp2 = {8};
        Object[] exp3 = {8, 11};
        assertArrayEquals(exp1, immutableList.toArray());
        assertArrayEquals(exp2, lst1.toArray());
        assertArrayEquals(exp3, lst2.toArray());
    }

    @Test
    public void testOnlyLinkedImmutability() {
        ImmutableLinkedList lst1 = onlyLinked.addFirst(77);
        Object[] lst1Exp = {77, 14, 8, 11};
        Object[] linkedExp = {14, 8, 11};
        assertArrayEquals(lst1Exp, lst1.toArray());
        assertArrayEquals(linkedExp, onlyLinked.toArray());
        ImmutableLinkedList lst2 = lst1.addLast(97);
        Object[] lst2Exp = {77, 14, 8, 11, 97};
        Object[] lst1Old = {77, 14, 8, 11};
        assertArrayEquals(lst1Old, lst1.toArray());
        assertArrayEquals(lst2Exp, lst2.toArray());
    }

    @Test
    public void addAll() {
        ImmutableList lst = immutableList.add(x);
        ImmutableList lst2 = lst.addAll(arr);
        Object[] exp = {8, 50, 21, 10};
        assertArrayEquals(exp, lst2.toArray());
    }

    @Test
    public void testAddAll() {
        Object[] toAdd = {1, 2, 3};
        ImmutableList lst = defLst.addAll(0, toAdd);
        Object[] exp = {1, 2, 3, 50, 21, 10};
        assertArrayEquals(exp, lst.toArray());
        ImmutableList lst2 = defLst.addAll(1, toAdd);
        Object[] exp2 = {50, 1, 2, 3, 21, 10};
        assertArrayEquals(lst2.toArray(), exp2);
    }

    @Test
    public void get() {

        Object real = defLst.get(2);
        Object exp = 10;
        assertEquals(real, exp);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOutsideIndex() {
//        No such index
        int index = 23;
        Object real = defLst.get(index);
    }

    @Test
    public void remove() {
        ImmutableList lst = defLst.remove(0);
        Object[] exp = {21, 10};
        assertArrayEquals(exp, lst.toArray());

    }

    @Test
    public void set() {
        ImmutableList lst = defLst.set(0, 101);
        Object[] exp = {101, 21, 10};
        assertArrayEquals(exp, lst.toArray());
    }

    @Test
    public void indexOf() {
        int real = defLst.indexOf(50);
        int exp1 = 0;
        assertEquals(real, exp1);
        int fake = defLst.indexOf(666);
        int exp2 = -1;
        assertEquals(fake, exp2);
    }

    @Test
    public void size() {
        int length = defLst.size();
        int exp1 = 3;
        assertEquals(length, exp1);
        Object[] newArr = {101, 21, 5};
        ImmutableList lst = defLst.addAll(1, newArr);
        int length2 = lst.size();
        int exp2 = 6;
        assertEquals(length2, exp2);
    }

    @Test
    public void clear() {
        Object[] immLst = defLst.toArray();
        ImmutableList lst = defLst.clear();
        Object[] exp = {};
        assertArrayEquals(exp, lst.toArray());
        assertArrayEquals(defLst.toArray(), immLst);
    }

    @Test
    public void isEmpty() {
        ImmutableList lst = defLst.clear();
        assertTrue(lst.isEmpty());
        assertFalse(defLst.isEmpty());
    }

    @Test
    public void toArray() {
        Object[] immLst = defLst.toArray();
        Object[] exp = {50, 21, 10};
        assertArrayEquals(immLst, exp);
    }

    @Test
    public void addFirst() {
        ImmutableLinkedList lst = onlyLinked.addFirst(101);
        Object[] exp = {101, 14, 8, 11};
        Object[] real = lst.toArray();
        assertArrayEquals(exp, real);
    }

    @Test
    public void addLast() {
        ImmutableLinkedList lst8 = new ImmutableLinkedList();

        ImmutableLinkedList lst = onlyLinked.addLast(101);
        Object[] exp = {14, 8, 11, 101};
        Object[] real = lst.toArray();
        assertArrayEquals(exp, real);
        ImmutableLinkedList lst1 = new ImmutableLinkedList();
        ImmutableLinkedList lst2 = lst1.addLast(500);
        Object[] exp2 = {500};
        assertArrayEquals(exp2, lst2.toArray());
    }

    @Test
    public void getFirst() {
        Object real = onlyLinked.getFirst();
        Object exp = 14;
        assertEquals(real, exp);
    }

    @Test
    public void getLast() {
        Object real = onlyLinked.getLast();
        Object exp = 11;
        assertEquals(real, exp);


    }

    @Test
    public void getLastAndFirstEmpty() {
        ImmutableLinkedList lst = new ImmutableLinkedList();
        Object exp = -1;
        Object real1 = lst.getLast();
        Object real2 = lst.getFirst();
        assertEquals(exp, real1);
        assertEquals(exp, real2);

    }

    @Test
    public void removeFirst() {
        ImmutableLinkedList lst = onlyLinked.removeFirst();
        Object[] exp = {8, 11};
        Object[] real = lst.toArray();
        assertArrayEquals(exp, real);
    }

    @Test
    public void removeLast() {
        ImmutableLinkedList lst = onlyLinked.removeLast();
        Object[] exp = {14, 8};
        Object[] real = lst.toArray();
        assertArrayEquals(exp, real);
    }

    @Test
    public void copyLinkedList() {
        ImmutableLinkedList lst = new ImmutableLinkedList();
        ImmutableLinkedList lst1 = lst.copyLinkedList();
        assertArrayEquals(lst1.toArray(), lst.toArray());
    }

    @Test
    public void testToString() {
        ImmutableList lst = immutableList.add(x);
        ImmutableList lst2 = lst.addAll(arr);
        String exp = "8, 50, 21, 10";
        assertEquals(exp, lst2.toString());
    }

    @Test
    public void testHugeLst() {
        ImmutableList lst1 = testLst.add(30);
        Object[] exp = {7, 8, 11, 13, 43, 2, 51, 97, 5, 30};
        assertArrayEquals(exp, lst1.toArray());
        ImmutableList lst2 = testLst.add(7, 30);
        Object[] exp2 = {7, 8, 11, 13, 43, 2, 51, 30, 97, 5};
        assertArrayEquals(exp2, lst2.toArray());
        Object[] toAdd = {1, 2, 3};
        ImmutableList lst3 = testLst.addAll(toAdd);
        Object[] exp3 = {7, 8, 11, 13, 43, 2, 51, 97, 5, 1, 2, 3};
        assertArrayEquals(lst3.toArray(), exp3);
        ImmutableList lst4 = testLst.addAll(5, toAdd);
        Object[] exp4 = {7, 8, 11, 13, 43, 1, 2, 3, 2, 51, 97, 5};
        assertArrayEquals(exp4, lst4.toArray());
    }

    @Test
    public void testHugeLstSetAndRemove() {
        ImmutableList lst = testLst.remove(7);
        Object[] immutable = {7, 8, 11, 13, 43, 2, 51, 97, 5};
        Object[] exp = {7, 8, 11, 13, 43, 2, 51, 5};
        assertArrayEquals(testLst.toArray(), immutable);
        assertArrayEquals(exp, lst.toArray());
        ImmutableList lst2 = testLst.set(7, "Arman");
        Object[] exp2 = {7, 8, 11, 13, 43, 2, 51, "Arman", 5};
        assertArrayEquals(lst2.toArray(), exp2);
    }
}
