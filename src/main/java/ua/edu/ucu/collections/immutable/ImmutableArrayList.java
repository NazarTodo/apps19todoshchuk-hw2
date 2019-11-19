package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] lst;

    public ImmutableArrayList() {
        this.lst = new Object[0];
    }

    public ImmutableArrayList(Object[] lst) {
        this.lst = Arrays.copyOf(lst, lst.length);
    }

    private void checkIndex(int index) {
        if (index < 0 || index > this.lst.length) {

            throw new IndexOutOfBoundsException();

        }
    }

    @Override
    public ImmutableArrayList add(Object e) {
        int n = this.lst.length;
        Object[] newLst = Arrays.copyOf(this.lst, n + 1);
        newLst[n] = e;
        return new ImmutableArrayList(newLst);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        checkIndex(index);
        Object[] newLst = Arrays.copyOf(this.lst, this.lst.length + 1);
        int i;
        newLst[index] = e;
        for (i = index + 1; i < newLst.length; i++) {
            newLst[i] = this.lst[i - 1];
        }
        return new ImmutableArrayList(newLst);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        Object[] newLst = Arrays.copyOf(this.lst, this.lst.length + c.length);
        for (int i = 0; i < c.length; i++) {
            newLst[this.lst.length + i] = c[i];
        }
        return new ImmutableArrayList(newLst);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        checkIndex(index);
        Object[] newLst = Arrays.copyOf(this.lst, this.lst.length + c.length);
        for (int i = 0; i < c.length; i++) {
            newLst[index + i] = c[i];
        }
        for (int i = index + c.length; i < newLst.length; i++) {
            newLst[i] = this.lst[i - c.length];
        }
        return new ImmutableArrayList(newLst);
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return this.lst[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        checkIndex(index);
        Object[] newLst = Arrays.copyOf(this.lst, this.lst.length);
        for (int i = index; i < newLst.length - 1; i++) {
            newLst[i] = newLst[i + 1];
        }
        newLst = Arrays.copyOf(newLst, newLst.length - 1);
        return new ImmutableArrayList(newLst);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        checkIndex(index);
        Object[] newLst = Arrays.copyOf(this.lst, this.lst.length);
        newLst[index] = e;
        return new ImmutableArrayList(newLst);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.lst.length; i++) {
            if (this.lst[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.lst.length;
    }

    @Override
    public ImmutableArrayList clear() {
        Object[] newLst = {};
        return new ImmutableArrayList(newLst);
    }

    @Override
    public boolean isEmpty() {
        return this.lst.length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newLst = Arrays.copyOf(this.lst, this.lst.length);
        return newLst;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < this.lst.length; i++) {
            if (i < this.lst.length - 1) {
                buf.append(this.lst[i]);
                buf.append(", ");
            } else {
                buf.append(this.lst[i]);
            }
        }

        return buf.toString();
    }

}
