/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs331.assignment.pkg2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author George
 */
public class Algorithm1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] test = generateArr(1000000);
        long startTime = System.currentTimeMillis();
        System.out.println(select(50, test));
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time taken: " + totalTime + " milliseconds");
        Arrays.sort(test);
        System.out.println(test[50]);
    }

    private static int select(int k, int[] set) {
        int start = 0;
        int end = set.length - 1;
        while (start < end) {
            int pivot = partition(set, start, end);
            if (pivot < k) {
                start = pivot + 1;
            } else if (pivot > k) {
                end = pivot - 1;
            } else {
                return set[pivot];
            }
        }
        return set[start];
    }

    private static int partition(int[] set, int start, int end) {
        int pivot = start, temp;
        while (start <= end) {
            //loops until you find an element larger than pivot
            while (start <= end && set[start] <= set[pivot]) {
                start++;
            }
            //loops until you find an element smalle than pivot
            while (start <= end && set[end] > set[pivot]) {
                end--;
            }
            //stop looping when you;ve checked every element
            if (start > end) {
                break;
            }
            // swap the two elements
            temp = set[start];
            set[start] = set[end];
            set[end] = temp;
        }
        //swap pivot
        temp = set[end];
        set[end] = set[pivot];
        set[pivot] = temp;
        return end;
    }

    private static int[] generateArr(int len) {
        Set<Integer> random = new HashSet<Integer>();
        for (int i = 0; i < len; i++) {
            int number = (int) (Math.random() * (len * 5));
            if (!random.contains(number)) {
                random.add(number);
            } else {
                i--;
            }
        }
        int[] res = new int[random.size()];
        int counter = 0;
        for (Integer i : random) {
            res[counter] = i;
            counter++;
        }
        return res;
    }
}
