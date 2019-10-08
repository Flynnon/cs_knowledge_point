"""
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL

链接：https://leetcode-cn.com/problems/rotate-list
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        """
            双指针往后扫，将链表变成一个环，然后从中间处截断环即可
            此处即  使用快慢指针找链表的倒数第k个节点
        """
        # 对于长度很小的链表，直接返回原链表
        if not head or not head.next:
            return head

        # 使用 dummy 节点来减少运算逻辑
        dummy = ListNode(0)
        dummy.next = head
        slow = fast = dummy

        # 将快指针向后移动 k 位，与慢指针结合来找链表的倒数第k个节点
        # 此处使用 length 来记录链表长度，当 k 很大时，可以跳过部分遍历，否则某些输入会超时
        length = 0
        while k:
            fast = fast.next
            length += 1
            # 遍历到尾部时，跳过不必要的遍历 并 重新开始
            if fast.next is None:
                fast = dummy
                k %= length
            k -= 1

        # fast -> 链表的尾节点
        # slow 新链表的头节点的前一个节点
        while fast and fast.next:
            slow = slow.next
            fast = fast.next

        # 截断链表 + 拿到新的 head
        fast.next = head
        head = slow.next
        slow.next = None
        return head

