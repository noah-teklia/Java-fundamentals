package _00_fundamentals.Array_List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(8);
        numbers.add(10);
        numbers.add(3);
        numbers.add(6);
        numbers.add(2);
        System.out.println("Before:" + numbers);
      /*  for(int i:numbers){
            if(i%2!=0){
                numbers.remove(i);

            }
        }

       */
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 1) {
                iterator.remove();

            }
        }
        System.out.println("After: " + numbers);
    }
}
