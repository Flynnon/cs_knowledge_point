"""
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 
Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.

链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
"""


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        """
            没什么好说的，直接指针操作就行。需要注意边界条件
        """
        dummy_node = ListNode(0)
        dummy_node.next = head

        dummy = dummy_node
        while True:
            first = dummy_node.next
            if not first:
                break

            second = first.next
            if not second:
                break

            first.next = second.next
            second.next = first
            dummy_node.next = second
            dummy_node = first
        return dummy.next


class Solution2:
    def swapPairs(self, head: ListNode) -> ListNode:
        """
            递归
        """
        # 若当前节点为空或下一个节点为空，结束递归
        if not head or not head.next:
            return head

        # 得到后面部分反转之后的头节点
        tmp = self.swapPairs(head.next.next)
        new_head = head.next
        new_head.next = head
        head.next = tmp
        return new_head
