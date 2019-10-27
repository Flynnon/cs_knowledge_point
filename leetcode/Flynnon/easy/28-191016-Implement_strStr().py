"""
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

链接：https://leetcode-cn.com/problems/implement-strstr
"""

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        """
            维护一个与 needle 等长的 滑动窗口，然后比较就可以
        """
        if needle == '':
            return 0
        length_haystack = len(haystack)
        length_needle = len(needle)
        if length_haystack < length_needle:
            return -1
        elif length_haystack == length_needle:
            if haystack == needle:
                return 0
            else:
                return -1
        for left_index in range(length_haystack - length_needle + 1):
            if length_haystack[left_index: left_index + length_needle] == needle:
                return left_index
        return -1
