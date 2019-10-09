"""
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

链接：https://leetcode-cn.com/problems/partition-list
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        """
            把原来的一个链表拆分成两个链表再合并就行
            时间复杂度: O(N), 空间复杂度: O(1)
        """
        left_dummy = left_tail = ListNode(0)
        right_dummy = right_tail = ListNode(0)
        while head is not None:
            if head.val < x:
                left_tail.next = head
                head = head.next
                left_tail = left_tail.next
            else:
                right_tail.next = head
                head = head.next
                right_tail = right_tail.next
        # 注意, 此处需要将链表尾部置空, 否则会变成环
        right_tail.next = None
        left_tail.next = right_dummy.next
        return left_dummy.next

