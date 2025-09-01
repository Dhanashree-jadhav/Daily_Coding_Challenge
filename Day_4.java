Day 4 of 30 🗓

Problem : Merge Two Sorted Arrays
You are given two sorted arrays arr1 of size m and arr2 of size n. Your task is to merge these two arrays into a single sorted array without using any extra space (i.e., in-place merging). The elements in arr1 should be merged first, followed by the elements of arr2, resulting in both arrays being sorted after the merge.

Input :
Two sorted integer arrays arr1 of size m and arr2 of size n.
Example : 
arr1 = [1, 3, 5, 7]
arr2 = [2, 4, 6, 8]

Output :
Both arr1 and arr2 should be sorted after the merge. Since you cannot use extra space, the final result will be reflected in arr1 and arr2.
Example:
arr1 = [1, 2, 3, 4]
arr2 = [5, 6, 7, 8]


Code : 
import java.util.*;

public class MergeSortedArrays {

    // Function to calculate next gap
    private static int nextGap(int gap) {
        if (gap <= 1) return 0;        // gap can't go below 1
        return (gap / 2) + (gap % 2);  // divide by 2 and round up
    }

    public static void merge(int[] arr1, int[] arr2, int m, int n) {
        int gap = nextGap(m + n);   // initial gap
        
        while (gap > 0) {
            int i = 0, j = gap;     // two pointers gap apart
            
            while (j < (m + n)) {
                
                // Case 1: both pointers in arr1
                if (i < m && j < m) {
                    if (arr1[i] > arr1[j]) {
                        int temp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = temp;
                    }
                }
                
                // Case 2: i in arr1, j in arr2
                else if (i < m && j >= m) {
                    if (arr1[i] > arr2[j - m]) {
                        int temp = arr1[i];
                        arr1[i] = arr2[j - m];
                        arr2[j - m] = temp;
                    }
                }
                
                // Case 3: both pointers in arr2
                else {
                    if (arr2[i - m] > arr2[j - m]) {
                        int temp = arr2[i - m];
                        arr2[i - m] = arr2[j - m];
                        arr2[j - m] = temp;
                    }
                }
                
                i++;
                j++;
            }
            
            gap = nextGap(gap); // reduce gap
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int m = arr1.length;
        int n = arr2.length;

        merge(arr1, arr2, m, n);

        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));
    }
}
