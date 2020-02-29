/*
* - Create a list, seqList , of N empty sequences, where each sequence is indexed from 0 to N-1.
* The elements within each of the N sequences also use 0-indexing.
* - Create an integer, lastAnswer, and initialize it to 0.
* - The 2 types of queries that can be performed on your list of sequences (seqList) are described below:
* 1.- Query: 1 x y
*   a.- Find the sequence, seq , at index ((x^lastAnswer)%N) in seqList.
*   b.- Append integer y to sequence seq.
* 2.- Query: 2 x y
*   a.- Find the sequence, seq, at index ((x^lastAnswer)%N) in seqList.
*   b.- Find the value of element y%size in seq (where size is the size of seq) and assign it to lastAnswer.
*   c.- Print the new value of lastAnswer on a new line
*
* Task
* Given N, Q , and q queries, execute each query.
* */
package hackerrank.datastructures.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DynamicArray {

    public List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        List<Integer>[] seqList = new ArrayList[n];
        // initializing seqList with empty sequences
        for(int i = 0; i < n; i++){
            seqList[i] = new ArrayList<>();
        }
        int lastAnswer = 0;

        for (List<Integer> l : queries) {
            int q = l.get(0);
            int x = l.get(1);
            int y = l.get(2);

            int index = (x ^ lastAnswer) % n;

            if(q == 1){
                seqList[index].add(y);
            }else if(q == 2){
                lastAnswer = seqList[index].get(y % seqList[index].size());
                result.add(lastAnswer);
            }

        }

        return result;
    }


    @Test
    public void test1DynamicArray(){
        //GIVEN
        int n = 2;
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1, 0, 5));
        queries.add(Arrays.asList(1, 1, 7));
        queries.add(Arrays.asList(1, 0, 3));
        queries.add(Arrays.asList(2, 1, 0));
        queries.add(Arrays.asList(2, 1, 1));
        List<Integer> expected = Arrays.asList(7, 3);
         //WHEN
        List<Integer> result = dynamicArray(n, queries);
        //THEN
        result.forEach(System.out::println);
        assertEquals(expected, result);
    }

}
