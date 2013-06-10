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
        
        int[] arr2 = {55, 22, 44, 1, 45, 5, 76, 87, 33, 55, 99};
        findBestBuySellDays(arr2);
        
        findClosesPerfectSquare(170);
    }

    private static void findClosesPerfectSquare(int i) {
        int prev = (int) Math.floor(Math.sqrt(i));
        int next = prev + 1;
        int sqrPrev = prev*prev;
        int sqrNext = next*next;
        if (i - sqrPrev > sqrNext - i) {
            System.out.println("square = "+sqrNext);
        } else {
            System.out.println("square = "+sqrPrev);
        }
    }

    private static void findBestBuySellDays(int[] arr) {
        int min = arr[0];
        int idxMin = 0;
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                idxMin = i;
            }
        }
        int max = arr[0];
        int idxMax = 0;
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                idxMax = i;
            }
        }
        System.out.println("Best buying date is "+idxMin);
        System.out.println("Best selling date is "+idxMax);
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
