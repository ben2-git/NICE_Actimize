import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class task_1 {
    public static int randomInRange(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1); // got from the company;
    }
    /**
     *  My first solution is my best solution, yet i gave 3 different ways to solve this problem
     *  Best   time complexity O(max - min)
     *  Best   space complexity O(max - min)
     */
    public static void first_solution(int min, int max){
        if(min > max) throw new IllegalArgumentException ("Illegal argument");

        int [] array = new int [max - min + 1];
        int index = 0, tmp = 0;
        for(int i = 0; i < array.length; i++)
            array[i] = min + i;

        // adding all the natural numbers [min, max] sorted in the array
        //O(max - min)

        for(int i = 0; i < array.length; i++){
            index = randomInRange(i, array.length -1); // 4 > 5 > 6 > 7
            System.out.println(array[index]);
            tmp = array[i];
            array[i] = array[index];
            array[index] = tmp;
        }
        // O(max - min)
        // generate random index in decreased size of indexes that are not yet generated
        // then replace element in index that was generated with element that was not.
    }
    /**
     *  time complexity O(max - min)
     *  space complexity O(max - min)
     */

    public static void second_sol(int min, int max){
        if(min > max) throw new IllegalArgumentException ("Illegal argument");

        List<Integer> arrayList = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < (max - min + 1); i++)
            arrayList.add(min + i);
        // O(n)

        while (!arrayList.isEmpty()){
            index = randomInRange(0, arrayList.size() - 1);
            System.out.println(arrayList.get(index));
            arrayList.remove(index); // O(n)
        } // O(n^2)
        // remove the element that provide from the list
    }
    /**
     *  time complexity O((max - min)^2)
     *  space complexity O(max - min) predicted
     */


    public static void third_sol(int min, int max){
        if(min > max) throw new IllegalArgumentException ("Illegal argument");

        List<Integer> arrayList = new ArrayList<>();
        for (int i = min; i <= max; i++)
            arrayList.add(i); // O(n)

        Collections.shuffle(arrayList); // O(n)

        for (int i = 0; i < arrayList.size(); i++)
            System.out.println(arrayList.get(i)); // O(n)

        // shuffle all the element and print them
    }

    /**
     * time complexity O(max - min)
     * space complexity O(max - min)
     * This function was used without the provided function (didn't understand completely the second assignment
     * about solving with another option so I gave solution with and without the provided function
     */
}
