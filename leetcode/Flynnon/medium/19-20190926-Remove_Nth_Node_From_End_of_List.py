"""
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?

链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
"""

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution1:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        """
            两遍扫描，先扫描一遍获取链表长度，然后可以求出需要前进的位数
            然后前进删除节点即可
        :param head:
        :param n:
        :return:
        """
        length = 0
        node = head
        while node:
            node = node.next
            length += 1
        dummy_node = ListNode(0)
        dummy_node.next = head
        pre = dummy_node
        node = head
        for _ in range(length - n):
            pre = pre.next
            node = node.next

        pre.next = node.next
        node.next = None
        return dummy_node.next

class Solution2:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        """
            进阶版，快慢指针往后扫，快指针到头的时候，慢指针指向的就是需要删除的节点
            当然，最好使用dummy_node，这样慢指针指向的是需要删除节点的前一个节点，删除更方便
        :param head:
        :param n:
        :return:
        """
        dummy_node = ListNode(0)
        dummy_node.next = head

        fast_node = head
        slow_node = dummy_node

        for _ in range(n):
            fast_node = fast_node.next

        while fast_node:
            fast_node = fast_node.next
            slow_node = slow_node.next

        slow_node.next = slow_node.next.next
        return dummy_node.next