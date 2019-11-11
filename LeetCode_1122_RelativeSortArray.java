import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class abcd {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] result = s.relativeSortArray(arr1, arr2);
        System.out.println(result.toString());
    }
}
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //brute force solution: for each element in arr2 find elements in arr1 and swap with out of place elements
        
        //create hash map, add arr1 elements and frequency
        if (arr1.length == arr2.length) {
            return arr2;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr1) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        int pointer = 0, j = 0;
        
        for (int i : arr2) {
            for (j = pointer; j < pointer + map.get(i) && j < arr1.length; j++) {
                arr1[j] = i;
            }
            pointer = j;
            map.put(i , 0);
        }
        
        int unsortedIndex = pointer;
        
        for (int i : map.keySet()) {
            if (map.get(i) != 0) {
                for (j = pointer; j < pointer + map.get(i) && j < arr1.length; j++) {
                    arr1[j] = i;
                }
                pointer = j;
            }
        }
        
        Arrays.sort(arr1, unsortedIndex, arr1.length);
        
        return arr1;
    }
}