package PeekingIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liutaotao on 2018/1/29.
 */
public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer i, j;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        j = iterator.next();
    }

    public Integer peek() {
        return j;
    }

    @Override
    public boolean hasNext() {
        return j != null;
    }

    @Override
    public Integer next() {
        i = j;
        if (iterator.hasNext())
            j = iterator.next();
        else j = null;
        return i;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        PeekingIterator pi = new PeekingIterator(list.iterator());
        while (pi.hasNext()) {
            System.out.println(pi.peek() + " " + pi.next());
        }
    }
}
