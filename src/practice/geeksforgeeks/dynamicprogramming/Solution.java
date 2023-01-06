package practice.geeksforgeeks.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1};
        int k = 2;
        System.out.println(canPartitionKSubsets(nums, k));
    }
    public static class Node {
        public List<List<Integer>> list = new ArrayList<>();
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //if (sum%k != 0) return false;
        sum = sum/k;

        Node[][] dp = new Node[nums.length+1][sum+1];
        for (int i = 0; i < nums.length+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                dp[i][j] = new Node();
            }
        }

        for (int i = 1; i < nums.length+1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i-1] <= j) {
                    List<List<Integer>> list = dp[i-1][j-nums[i-1]].list;
                    List<List<Integer>> newList = dp[i][j].list;
                    if (list.size() != 0) {
                        for (List<Integer> items: list) {
                            List<Integer> item = new ArrayList<>(items);
                            item.add(nums[j]);
                            newList.add(item);
                        }
                    } else {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[j]);
                        newList.add(item);
                    }
                    dp[i][j].list.addAll(dp[i-1][j].list);
                }
                //dp[i][j].list.addAll(dp[i-1][j].list);
            }
        }

        if (dp[nums.length][sum].list.size() == k) {
            return true;
        } else {
            return false;
        }
    }
}