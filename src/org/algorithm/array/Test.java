package org.algorithm.array;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        removeElement();
    }

    public static void binarySearch() {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 2;
        System.out.println(binarySearch.search(nums, target));
    }

    public static void removeElement() {
        RemoveObject removeObject = new RemoveObject();
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(Arrays.toString(nums));
        System.out.println(removeObject.removeElement(nums, val));
    }
}
