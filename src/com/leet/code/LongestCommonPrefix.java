package com.leet.code;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Description:
 * @Author: Miracle Pu
 * @Date: 2021/3/4
 * @Version: V1.0
 */
public class LongestCommonPrefix {
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder prefix = new StringBuilder("");
            int shortest = Arrays.stream(strs)
                    .map(String::length)
                    .min(Integer::compareTo)
                    .orElse(0);
            for (int i = 0; i < shortest; i++) {
                String temp = "";
                boolean isOver = false;
                for (String str : strs) {
                    if (temp.isEmpty()) {
                        temp = String.valueOf(str.charAt(i));
                    } else {
                        if (!temp.equals(String.valueOf(str.charAt(i)))) {
                            temp = "";
                            isOver = true;
                            break;
                        }
                    }
                }
                if (isOver) {
                    return prefix.toString();
                }
                if (!temp.isEmpty()) {
                    prefix.append(temp);
                }
            }
            return prefix.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"cir", "car"}));
    }
}
