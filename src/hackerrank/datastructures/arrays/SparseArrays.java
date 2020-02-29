/*
* There is a collection of input strings and a collection of query strings.
* For each query string, determine how many times it occurs in the list of input strings.
* For example, given input strings =  ['ab', 'ab', 'abc'] and queries = ['ab', 'abc', 'bc']
* We find 2 instances of 'ab', 1 of 'abc' and 0 of 'bc'.
* For each query, we add an element to our return array, result = [2, 1, 0].
 * */
package hackerrank.datastructures.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SparseArrays {

    public int[] matchingStrings(String[] strings, String[] queries) {
        int[] result = new int[queries.length];
        int count;
        for(int i=0; i < queries.length; i++){
            count = 0;
            for(int j=0; j < strings.length; j++){
                if(queries[i].equals(strings[j])){
                    count++;
                }
                result[i] = count;
            }
        }
        return result;
    }

    @Test
    public void test1MatchingStrings(){
        //GIVEN
        String[] strings = new String[] {"aba", "baba", "aba", "xzxb"};
        String[] queries = new String[] {"aba", "xzxb", "ab"};
        int[] expected = new int[] {2, 1, 0};
        //WHEN
        int[] result = matchingStrings(strings, queries);
        //THEN
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2MatchingStrings(){
        //GIVEN
        String[] strings = new String[] {"def", "de", "fgh"};
        String[] queries = new String[] {"de", "lmn", "fgh"};
        int[] expected = new int[] {1, 0, 1};
        //WHEN
        int[] result = matchingStrings(strings, queries);
        //THEN
        assertArrayEquals(expected, result);
    }

    @Test
    public void test3MatchingStrings(){
        //GIVEN
        String[] strings = new String[] {"abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf", "na",
                "asdjf", "na", "basdn", "sdaklfj", "asdjf"};
        String[] queries = new String[] {"abcde", "sdaklfj", "asdjf", "na", "basdn"};
        int[] expected = new int[] {1, 3, 4, 3, 2};
        //WHEN
        int[] result = matchingStrings(strings, queries);
        //THEN
        assertArrayEquals(expected, result);
    }
}
