"""
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
"""


class Solution:
    def lengthOfLongestSubstringOne(self, s: str) -> int:
        """
            使用map记录之前出现的元素及下标
            再使用两个指针进行遍历，一个指向当前子串的最左边界，一个指向当前遍历的字符
            每次遍历到一个字符时，对map及左边界指针进行更新，长度 = 当前元素下标 - 当前元素上一次出现的下标
            时间复杂度: O(N) 空间复杂度: O(N)
        """
        char_index_map = {}
        longest = left_index = cur_count = 0
        for index, char in enumerate(s):
            pre_index = char_index_map.get(char)
            if pre_index is None:
                # 若当前元素没有出现过，直接加到字典里
                cur_count += 1
            else:
                # 移除map中的key,直到没有当前字符为止，并更新左边界下标
                for i in range(left_index, pre_index + 1):
                    char_index_map.pop(s[i], None)
                cur_count = index - pre_index
                left_index = pre_index + 1
            char_index_map[char] = index
            longest = max(longest, cur_count)
        return longest

    def lengthOfLongestSubstringTwo(self, s: str) -> int:
        """
            思路不变，但是无需频繁更新字典数据
            最长不重复子串长度 = 当前元素下标 - 当前元素上一次出现的下标 + 1
            时间复杂度: O(N) 空间复杂度: O(N)
        """
        char_index_map = {}
        longest = left_index =  0
        for index, char in enumerate(s):
            pre_index = char_index_map.get(char)
            if pre_index is not None:
                # 若当前元素出现过，则 左边界至少需要裁减到 pre_index + 1 的位置
                left_index = max(left_index, pre_index + 1)
            # 当前子串长度 = 当前元素下标 - 左边界下标 + 1
            longest = max(longest, index - left_index + 1)
            char_index_map[char] = index
        return longest

