"""
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.

链接：https://leetcode-cn.com/problems/longest-common-prefix
"""
from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        """
            取巧了...
            使用zip内置函数对 strs 进行规整
        """
        common_strs = []

        for elements in zip(*strs):
            # 这里也可以直接使用 set 去重后判断长度，但是感觉空间占用有些大，所以还是直接比
            cur_common_str = elements[0]
            for element in elements[1:]:
                if element != cur_common_str:
                    return ''.join(common_strs)

            common_strs.append(cur_common_str)
        return ''.join(common_strs)


class Solution2:

    def longestCommonPrefix(self, strs: List[str]) -> str:
        """
            一样的思路，纵向比较
        """
        if not strs:
            return ''
        min_length = min(len(ss) for ss in strs)

        first_element = strs[0]
        other_elements = strs[1:]

        common_strs = []
        for index in range(min_length):
            cur_val = first_element[index]
            for element in other_elements:
                if cur_val != element[index]:
                    return ''.join(common_strs)

            common_strs.append(cur_val)
        return ''.join(common_strs)
