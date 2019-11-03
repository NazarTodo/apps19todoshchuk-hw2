package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    private Queue q;

    @Before
    public void setUp() throws Exception {
        q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
    }

    @Test
    public void peek() {
        Object real1 = q.peek();
        Object exp1 = 1;
        assertEquals(real1, exp1);
//        testing peek in empty queue
        Queue newQ = new Queue();
        Object real2 = newQ.peek();
        Object exp2 = -1;
        assertEquals(real2, exp2);
    }

    @Test
    public void dequeue() {
//        testing dequeue in empty queue
        Queue newQ = new Queue();
        Object empty = -1;
        Object real = newQ.dequeue();
        assertEquals(empty, real);

//        adding elements to queue
        newQ.enqueue(11);
        newQ.enqueue(21);
        newQ.enqueue(38);

        Object del = newQ.dequeue();
        Object exp = 11;
        assertEquals(del, exp);

        String exp1 = "21, 38";
        String real2 = newQ.toString();
        assertEquals(exp1, real2);
    }

    @Test
    public void enqueue() {
        Queue newQ = new Queue();

        for(int i = 0; i < 9; i++){
            newQ.enqueue(i);
        }

        String exp = "0, 1, 2, 3, 4, 5, 6, 7, 8";
        String real = newQ.toString();
        assertEquals(exp, real);
    }

    @Test
    public void testToString() {
        String real = q.toString();
        String exp = "1, 2, 3";
        assertEquals(real, exp);
    }
}
