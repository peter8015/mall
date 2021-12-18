package com.macro.mall;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    @Test
    public void t1() {
        int[] nums = new int[]{1,2,3,5,7};
        int target = 6;

        int[] r = find(nums, target);
        System.out.println("i, k:" + r[0] + "," + r[1]);
    }

    /**
     * O(n^2)
     * @param nums
     * @param target
     * @return
     */
    private int[] find(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int k = 0; k < nums.length; k++) {
                if(nums[i] + nums[k] == target) {
                    return new int[]{i,k};
                }
            }
        }
        return null;
    }


    private int[] findA(int[] nums, int target) {
        Map<Integer, Integer> data = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            data.put(nums[i], i);  //1,0   2,1   3,2  5,3    7,4
        }

        for(int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            if(data.containsKey(k)) {
                return new int[]{i, data.get(k)};
            }
        }
        return null;
    }

    @Test
    public void t3() {
        int[] prices = {7,1,5,3,6,4};

        int k = maxProfit(prices);

        System.out.println(k);
    }

    public int maxProfit(int[] prices) {
        int fit = 0;

        int n = prices.length;

        for(int i = 1; i < n; ++i) {
            fit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return 0;
    }
}
