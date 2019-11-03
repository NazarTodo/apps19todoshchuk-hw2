package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;


public class Stack {
    private ImmutableLinkedList stack;

    public Stack() {
        this.stack = new ImmutableLinkedList();
    }

    public Object peek() {
        return this.stack.getFirst();
    }

    public Object pop() {
        if (!this.stack.isEmpty()) {
            Object top = this.stack.getLast();
            this.stack = this.stack.removeLast();
            return top;
        } else {
            return -1;
        }
    }

    public void push(Object e) {
        this.stack = this.stack.addLast(e);
    }

    @Override
    public String toString() {
        return this.stack.toString();
    }

}



