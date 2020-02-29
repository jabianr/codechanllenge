/*
* Starting with a 1-indexed array of zeros and a list of operations,
* for each operation add a value to each of the array element between two given indices, inclusive.
* Once all operations have been performed, return the maximum value in your array.
* For example, the length of your array of zeros n = 10  Your list of queries is as follows:
*   a b k
    1 5 3
    4 8 7
    6 9 1
* Add the values of k between the indices a and b inclusive:
* index->	 1 2 3  4  5 6 7 8 9 10
	[0,0,0, 0, 0,0,0,0,0, 0]
	[3,3,3, 3, 3,0,0,0,0, 0]
	[3,3,3,10,10,7,7,7,0, 0]
	[3,3,3,10,10,8,8,8,1, 0]
*
* The largest value is 10 after all operations are performed.
* */
package hackerrank.datastructures.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayManipulation {


    /*
    * Brute force. No compliance with it the time limit
    *
    * */
    public long bruteArrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];
        int start, end;
        long value;
        long max = 0;
        for(int i = 0; i < queries.length; i++){
            start = queries[i][0] - 1;
            end =  queries[i][1] - 1;
            value = queries[i][2];
            while(start <= end){
                arr[start] += value;
                if(arr[start] > max){
                    max = arr[start];
                }
                start++;
            }
        }
        return max;

    }

    /*
    * Efficient
    *
    * */
    long efficientArrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n + 2];
        int start, end;
        long value;
        long max = 0L;
        for(int i = 0; i < queries.length; i++){
            start = queries[i][0];
            end =  queries[i][1] + 1;
            value = queries[i][2];
            arr[start] += value;
            arr[end] -= value;

        }
        for(int i = 1; i <= n; i++){
            arr[i] += arr[i - 1];
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    @Test
    public void test1BruteArrayManipulation(){
        //GIVEN
        int n = 5;
        int[][] queries = new int[][] {{1, 2, 100},{2, 5, 100},{3, 4, 100}};
        long expected = 200;
        //WHEN
        long result = bruteArrayManipulation(n, queries);
        //THEN
        assertEquals(expected, result);
    }
    @Test
    public void test2BruteArrayManipulation(){
        //GIVEN
        int n = 10;
        int[][] queries = new int[][] {{1, 5, 3},{4, 8, 7},{6, 9, 1}};
        long expected = 10;
        //WHEN
        long result = bruteArrayManipulation(n, queries);
        //THEN
        assertEquals(expected, result);
    }

    @Test
    public void test1EfficientArrayManipulation(){
        //GIVEN
        int n = 5;
        int[][] queries = new int[][] {{1, 2, 100},{2, 5, 100},{3, 4, 100}};
        long expected = 200;
        //WHEN
        long result = efficientArrayManipulation(n, queries);
        //THEN
        assertEquals(expected, result);
    }
    @Test
    public void test2EfficientArrayManipulation(){
        //GIVEN
        int n = 10;
        int[][] queries = new int[][] {{1, 5, 3},{4, 8, 7},{6, 9, 1}};
        long expected = 10;
        //WHEN
        long result = efficientArrayManipulation(n, queries);
        //THEN
        assertEquals(expected, result);
    }
}
