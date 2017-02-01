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
public class Algorithm2 {
    public static void main (String[] arg) {
        
    }
    
    private static int select(int k, int[] set) {
        if(set.length < 50) {
            Arrays.sort(set);
            return set[k];
        }
        return 0;
    }
    
    //Generates the array used for testing
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
