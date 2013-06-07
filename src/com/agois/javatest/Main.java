/**
 * 
 */
package com.agois.javatest;

import java.util.Arrays;

/**
 * @author agois
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 22, 44, -1, -3, -5, 0, 9, 8, 7, 50, 100, -1, 0, 0};
        
        findMaxContiguousRangeWithMaxProduct(arr);
        
        findThreeNumbersSumZero(arr);
    }

    private static void findThreeNumbersSumZero(int[] arr) {
        Arrays.sort(arr);
        int j = 1;
        int k = arr.length - 1;
        outer:
        for (int i = 0; i < arr.length - 2; i++) {
            loop2:
            for (j = i+1; j < k; j++) {
                for (k =arr.length-1; k > j; --k) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum == 0) {
                        System.out.println("found indexes "+i+" "+j+" "+k);
                        System.out.println("found values "+arr[i]+" "+arr[j]+" "+arr[k]);
                        break outer;
                    } else if (sum < 0) {
                        break loop2;
                    }
                }
            }
        }
    }

    private static void findMaxContiguousRangeWithMaxProduct(int[] arr) {
        int windowSize = arr.length;
        int product = 1;
        int initialPos = 0;
        while ((initialPos + windowSize) <= arr.length) {
            product = 1;
            for (int i = initialPos; i < (initialPos + windowSize); i++) {
                product *= arr[i];
                if (product == 0) {
                    break;
                }
            }
            if (product <= 0) {
                if ((initialPos + windowSize) < arr.length) {
                    initialPos++;
                } else {
                    initialPos = 0;
                    windowSize--;
                }
            } else {
                break;
            }
        }
        System.out.println("max product = "+product);
        System.out.println("max range = ["+initialPos+","+(initialPos+windowSize)+"]");
    }

}
