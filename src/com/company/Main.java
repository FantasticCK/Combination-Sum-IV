package com.company;

public class Main {

    public static void main(String[] args) {
        new Solution().combinationSum4(new int[]{3, 1, 2}, 4);
    }
}

class Solution2 {
    public int combinationSum4(int[] nums, int target) {
        int l = nums.length;
        int[][] dp = new int[l + 1][target + 1];

        dp[0][0] = 1;

        for (int i = 1; i < l + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                int num = nums[i - 1];
                if (num > j) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }

                if (num == j) {
                    dp[i][j] = dp[i - 1][j] + 1;
                    continue;
                }

                for (int k = 1; k <= i; k++) {
                    if (j - nums[k - 1] < 0)
                        continue;
                    dp[i][j] += dp[i][j - nums[k - 1]];
                }
            }
        }
        return dp[l][target];
    }
}

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }
}