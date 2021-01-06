package com.leet.code;

/**
 * @Description:
 * @Author: Miracle Pu
 * @Date: 2021/1/6
 * @Version: V1.0
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            int l1i = 0;
//            int l2i = 0;
//            Map<Integer, Integer> map = new HashMap();
//            Map<Integer, ListNode> nodeMap = new HashMap();
//            for (ListNode i1 = l1; i1 != null; i1 = i1.next) {
//                nodeMap.put(l1i, new ListNode(i1.val));
//                l1i++;
//            }
//            for (ListNode i2 = l2; i2 != null; i2 = i2.next) {
//                ListNode l1Node = nodeMap.get(l2i);
//                if (null == l1Node) {
//                    nodeMap.put(l2i, new ListNode(i2.val));
//                } else {
//                    int sum = l1Node.val + i2.val;
//                    nodeMap.put(l2i, new ListNode(sum));
//                }
//                l2i++;
//            }
//            int index = Math.max(l1i, l2i);
//            boolean carry = false;
//            for (int i = 0; i < index; i++) {
//                ListNode node = nodeMap.get(i);
//                if (node.val > 9) {
//                    carry = true;
//                    node.val = Integer.parseInt(String.valueOf(nodeMap.get(i).val).substring(1, 2));
//                }
//                if (carry) {
//                    if (null == nodeMap.get(i + 1)) {
//                        node.next = new ListNode(1);
//                    } else {
//                        nodeMap.get(i + 1).val = nodeMap.get(i + 1).val + 1;
//                        node.next = nodeMap.get(i + 1);
//                    }
//                    carry = false;
//                } else {
//                    node.next = nodeMap.get(i + 1);
//                }
//            }
//            return nodeMap.get(0);
            ListNode head = null, tail = null;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int n1 = l1 != null ? l1.val : 0;
                int n2 = l2 != null ? l2.val : 0;
                int sum = n1 + n2 + carry;
                if (head == null) {
                    head = tail = new ListNode(sum % 10);
                } else {
                    tail.next = new ListNode(sum % 10);
                    tail = tail.next;
                }
                carry = sum / 10;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
            return head;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        ListNode listNode = solution.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3)))
//                , new ListNode(5, new ListNode(6, new ListNode(4))));
//        ListNode listNode = solution.addTwoNumbers(new ListNode(0)
//                , new ListNode(0));
//        ListNode listNode = solution.addTwoNumbers(new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))))
//                , new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        ListNode listNode = solution.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(9)))
                , new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9)))));
        for (ListNode i = listNode; i != null; i = i.next) {
            System.out.println(i.val);
        }
    }
}
