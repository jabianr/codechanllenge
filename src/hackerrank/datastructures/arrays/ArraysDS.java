/*
* Given an array A  of N integers, print each element in reverse order as a single line of space-separated integers.
* */
package hackerrank.datastructures.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArraysDS {

    public int[] reverseArray(int[] a) {
        int n = a.length;
        int[] result = new int[n];
        for(int i = 0, j = n - 1; i < n; i++, j--){
            result[j] = a[i];
        }
        return  result;
    }

    @Test
    public void test1ReverseArray(){
        //GIVEN
        int[] a = new int[] {1, 4, 3, 2};
        int[] expected = new int[] {2, 3, 4, 1};
        //WHEN
        int[] response = reverseArray(a);
        //THEN
        assertArrayEquals(expected, response);
    }
}
