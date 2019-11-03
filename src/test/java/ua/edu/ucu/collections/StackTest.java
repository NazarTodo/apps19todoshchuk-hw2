package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    private Stack s;
    @Before
    public void setUp(){
        s = new Stack();
        s.push(11);
        s.push(22);
        s.push(33);
    }

    @Test
    public void peek() {
        Object real1 = s.peek();
        Object exp1 = 11;
        assertEquals(real1, exp1);

//        trying to peek from empty stack
//        expecting -1
        Stack newS = new Stack();
        Object exp2 = -1;
        Object real2 = newS.peek();
        assertEquals(exp2, real2);

    }

    @Test
    public void pop() {
        Stack newS = new Stack();
//        trying to pop from empty stack
//        expecting -1
        Object empty = -1;
        Object real1 = newS.pop();
        assertEquals(empty, real1);

        newS.push(21);
        newS.push(81);
        newS.push(88);

        Object del1 = newS.pop();
        Object exp1 = 88;
        assertEquals(del1, exp1);

        Object del2 = newS.pop();
        Object exp2 = 81;
        assertEquals(del2, exp2);

        Object del3 = newS.pop();
        Object exp3 = 21;
        assertEquals(del3, exp3);
    }

    @Test
    public void push() {
        Stack newS = new Stack();
        for(int i = 12; i < 18; i++){
            newS.push(i);
        }

        String exp = "12, 13, 14, 15, 16, 17";
        String real = newS.toString();
        assertEquals(exp, real);
    }

    @Test
    public void testToString() {
        String real = s.toString();
        String exp = "11, 22, 33";
        assertEquals(real, exp);
    }


}
