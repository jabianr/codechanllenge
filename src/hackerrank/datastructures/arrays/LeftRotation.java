/*
* A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left.
* For example, if 2 left rotations are performed on array [1, 2, 3, 4, 5], then the array would become [3, 4, 5, 1, 2].
* Given an array of n integers and a number, d, perform d left rotations on the array.
* Then print the updated array as a single line of space-separated integers.
* */
package hackerrank.datastructures.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class LeftRotation {

    public int[] leftRotation(int d, int[] a){
        int[] result = new int[a.length];
        int index = d % a.length;
        int i = 0;
        int j = index;

        if (index == 0) return a;

        while(true){
            result[i++] = a[j++];
            if(j == a.length){
                j = 0;
            }else if(j == index){
                break;
            }
        }
        return result;
    }
    public void printLeftRotation(int d, int[] a) {
        int index = d % a.length;
        int i = index;

        while (true) {
            System.out.print(a[i++] + " ");
            if (i == a.length) {
                i = 0;
            } else if (i == index) {
                break;
            }
        }
    }

    @Test
    public void test1LeftRotation(){
        //GIVEN
        int d = 4;
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] expected = new int[] {5, 1, 2, 3, 4};
        //WHEN
        int[] result = leftRotation(d, a);
        //THEN
        assertArrayEquals(expected, result);
    }

    @Test
    public void test1PrintLeftRotation(){
        //GIVEN
        int d = 2;
        int[] a = new int[]{1, 2, 3, 4, 5};
        //WHEN
        printLeftRotation(d, a);
        //THEN
        //Print out 3 4 5 1 2
    }
}
