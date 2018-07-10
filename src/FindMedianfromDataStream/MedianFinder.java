package FindMedianfromDataStream;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by liutaotao on 2018/7/10.
 */
public class MedianFinder {
    ArrayList<Integer> array;

    public MedianFinder() {
        array = new ArrayList<>();
    }

    public void addNum(int num) {
        
    }

    public double findMedian() {
        array.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        if (array.size() % 2 == 1) {
            return array.get(array.size() / 2);
        } else {
            int l = array.size() / 2, r = l - 1;
            return (array.get(l) + array.get(r)) / 2.0;
        }
    }

    public static void main(String[] args) {

    }
}
