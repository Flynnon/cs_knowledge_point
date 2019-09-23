"""
 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 
 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 
 示例：
 
 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 
 @param l1
 @param l2
 @return {ListNode}
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    @classmethod
    def method_one(cls, l1: ListNode, l2: ListNode) -> ListNode:
        """
            直接加, 得到和，然后根据和反推结果
            时间复杂度: O(M+N), 空间复杂度: O(1) ?
            风险点: 求出的 sum 可能很大(当然，对于Python来说不是问题...)
        """
        sum_value = 0

        for node in (l1, l2):
            suffix = 1
            while node:
                sum_value += node.val * suffix
                suffix *= 10
                node = node.next

        root = node = None

        while True:
            t_node = ListNode(sum_value % 10)
            sum_value //= 10
            if root is None:
                root = node = t_node
            else:
                node.next = t_node
                node = node.next
            if sum_value == 0:
                break

        return root

    @classmethod
    def method_two(cls, l1: ListNode, l2: ListNode) -> ListNode:
        """
            模拟进位
            时间复杂度: O(Max(M+N)), 空间复杂度: O(1)
        """
        carry = 0
        root = node = None
        while True:
            if l1:
                v1 = l1.val
                l1 = l1.next
            else:
                v1 = None

            if l2:
                v2 = l2.val
                l2 = l2.next
            else:
                v2 = None

            if v1 is None and v2 is None and carry == 0:
                break

            cur_value = carry + (v1 or 0) + (v2 or 0)
            carry = cur_value // 10

            if root is None:
                root = node = ListNode(cur_value % 10)
            else:
                node.next = ListNode(cur_value % 10)
                node = node.next

        return root

    @classmethod
    def better_method_two(cls, l1: ListNode, l2: ListNode) -> ListNode:
        """
            对方法2的优化
            在判断 root 及 node 的时候可以使用 DummyNode 简化书写
        """
        carry = 0
        dummy_node = ListNode(0)
        node = dummy_node
        while True:
            if l1:
                v1 = l1.val
                l1 = l1.next
            else:
                v1 = None

            if l2:
                v2 = l2.val
                l2 = l2.next
            else:
                v2 = None

            if v1 is None and v2 is None and carry == 0:
                break

            cur_value = carry + (v1 or 0) + (v2 or 0)
            carry = cur_value // 10

            t_node = ListNode(cur_value % 10)
            node.next = t_node
            node = node.next

        return dummy_node.next
