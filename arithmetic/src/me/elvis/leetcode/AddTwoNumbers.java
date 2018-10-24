package me.elvis.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * *********************************************************
 * * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)                 **
 * * Output: 7 -> 0 -> 8                                  **
 * * Explanation: 342 + 465 = 807.                        **
 * *********************************************************
 */
public class AddTwoNumbers {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode head = new ListNode(0);

            // Result list node start with index 1.
            ListNode result = head;

            // when x + y > 10, carry = 1, And it will be added to next value
            int carry = 0;
            while(l1 != null || l2 != null)
            {
                int digitX = l1 == null ? 0 : l1.val;
                int digitY = l2 == null ? 0 : l2.val;
                int singleDigitSumResult = digitX + digitY + carry;
                carry = singleDigitSumResult / 10;
                result.next = new ListNode(singleDigitSumResult % 10);

                // Move pointer
                result = result.next;
                if(l1 != null)
                {
                    l1 = l1.next;
                }

                if(l2 != null)
                {
                    l2 = l2.next;
                }
            }
            if(carry > 0)
            {
                result.next = new ListNode(carry);
            }
            return head.next;
        }
    }
}
