/*
* Given a 6 x 6 2D Array, arr:
*   1 1 1 0 0 0
    0 1 0 0 0 0
    1 1 1 0 0 0
    0 0 0 0 0 0
    0 0 0 0 0 0
    0 0 0 0 0 0
*We define an hourglass in A to be a subset of values with indices falling in this pattern
* in arr's graphical representation:
*   a b c
      d
    e f g
*
* There are 16 hourglasses in arr, and an hourglass sum is the sum of an hourglass' values.
* Calculate the hourglass sum for every hourglass in arr, then print the maximum hourglass sum.
* For example, given the 2D array:
*   -9 -9 -9  1 1 1
     0 -9  0  4 3 2
    -9 -9 -9  1 2 3
     0  0  8  6 6 0
     0  0  0 -2 0 0
     0  0  1  2 4 0
*We calculate the following 16 hourglass values:
*   -63, -34, -9, 12,
    -10, 0, 28, 23,
    -27, -11, -2, 10,
    9, 17, 25, 18
*Our highest hourglass value is 28 from the hourglass:
*   0 4 3
      1
    8 6 6
*
* */
package hackerrank.datastructures.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Array2DDS {

    /* Starting form position [0][0] */
    public int hourglassSum(int[][] arr) {
        int result = Integer.MIN_VALUE;
        int sum;
        for(int i = 0; i < arr.length - 2; i++){
            for(int j = 0; j < arr[i].length - 2; j++){
                sum = 0;
                /*          a            b               c*/
                sum += arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                /*              d               */
                sum += arr[i + 1][j + 1];
                /*      e                f                   g*/
                sum += arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                if(sum > result){
                    result = sum;
                }
            }
        }
        return result;
    }

    /* Different order. Starting form [2][2] */
    public int hourglassSum2(int[][] arr) {
        int result = Integer.MIN_VALUE;
        int sum;
        for(int i = 2; i < arr.length; i++){
            for(int j = 2; j < arr[i].length; j++){
                sum = 0;
                /*          a            b               c*/
                sum =  arr[i - 2 ][j - 2] + arr[i - 2][j - 1] + arr[i - 2][j] +
                /*                       d                   */
                                arr[i - 1][j - 1] +
                /*      e                f                   g*/
                        arr[i][j - 2] + arr[i][j - 1] + arr[i][j];

                if(sum > result){
                    result = sum;
                }
            }
        }
        return result;
    }


    @Test
    public void test1HourGlassSum(){
        //GIVEN
        int[][] arr = new int[][] { {1, 1, 1, 0, 0, 0},
                                    {0, 1, 0, 0, 0, 0},
                                    {1, 1, 1, 0, 0, 0},
                                    {0, 0, 2, 4, 4, 0},
                                    {0, 0, 0, 2, 0, 0},
                                    {0, 0, 1, 2, 4, 0} };
        int expected = 19;
        //WHEN
        int result = hourglassSum(arr);
        //THEN
        assertEquals(expected, result);
    }

    @Test
    public void test2HourGlassSum(){
        //GIVEN
        int[][] arr = new int[][] { {-9, -9, -9,  1, 1, 1},
                                    { 0,  -9, 0,  4, 3, 2},
                                    {-9, -9, -9,  1, 2, 3},
                                    { 0,  0,  8,  6, 6, 0},
                                    { 0,  0,  0, -2, 0, 0},
                                    { 0,  0,  1,  2, 4, 0} };
        int expected = 28;
        //WHEN
        int result = hourglassSum(arr);
        //THEN
        assertEquals(expected, result);
    }

    @Test
    public void test1HourGlassSum2(){
        //GIVEN
        int[][] arr = new int[][] { {1, 1, 1, 0, 0, 0},
                                    {0, 1, 0, 0, 0, 0},
                                    {1, 1, 1, 0, 0, 0},
                                    {0, 0, 2, 4, 4, 0},
                                    {0, 0, 0, 2, 0, 0},
                                    {0, 0, 1, 2, 4, 0} };
        int expected = 19;
        //WHEN
        int result = hourglassSum2(arr);
        //THEN
        assertEquals(expected, result);
    }

    @Test
    public void test2HourGlassSum2(){
        //GIVEN
        int[][] arr = new int[][] { {-9, -9, -9,  1, 1, 1},
                                    { 0,  -9, 0,  4, 3, 2},
                                    {-9, -9, -9,  1, 2, 3},
                                    { 0,  0,  8,  6, 6, 0},
                                    { 0,  0,  0, -2, 0, 0},
                                    { 0,  0,  1,  2, 4, 0} };
        int expected = 28;
        //WHEN
        int result = hourglassSum2(arr);
        //THEN
        assertEquals(expected, result);
    }
}
