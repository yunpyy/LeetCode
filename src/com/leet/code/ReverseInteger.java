package com.leet.code;

/**
 * @Description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: Miracle Pu
 * @Date: 2021/1/7
 * @Version: V1.0
 */
public class ReverseInteger {
    static class Solution {
        public int reverse(int x) {
            String s = Integer.toString(x);
            StringBuilder builder = new StringBuilder(s);
            StringBuilder reverse = builder.reverse();
            try {
                return Integer.parseInt(reverse.toString());
            } catch (NumberFormatException e) {
                if (!reverse.toString().contains("-")) {
                    return 0;
                }
                String substring = reverse.substring(0, reverse.length() - 1);
                try {
                    Integer.parseInt(substring);
                } catch (NumberFormatException numberFormatException) {
                    return 0;
                }
                String s1 = "-" + substring;
                return Integer.parseInt(s1);
            }
//            long n = 0;
//            while (x != 0) {
//                n = n * 10 + x % 10;
//                x = x / 10;
//            }
//            return (int) n == n ? (int) n : 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.reverse(123));
//        System.out.println(solution.reverse(-123));
//        System.out.println(solution.reverse(120));
//        System.out.println(solution.reverse(1534236469));
        System.out.println(solution.reverse(-2147483648));
    }
}
