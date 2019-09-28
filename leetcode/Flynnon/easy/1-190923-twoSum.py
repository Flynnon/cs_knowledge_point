"""
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

链接：https://leetcode-cn.com/problems/two-sum
"""
from typing import List


class Solution:

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
            使用map记录 num -> index 的对应关系，然后遍历得到匹配的index即可
            优化: 无需构建完再遍历，构建与遍历可以一起进行
            时间复杂度: O(N), 空间复杂度: O(N)
        """
        num_index_map = {}
        for index, num in enumerate(nums):
            sub_value = target - num
            matched_index = num_index_map.get(sub_value, None)
            if matched_index is not None:
                return [matched_index, index]
            num_index_map[num] = index
        return []

class Solution2:

    def twoSum(cls, nums: list, target: int) -> list:
        """
            暴力解，两层循环
            时间复杂度: O(N^2), 空间复杂度: O(1)
        """
        length = len(nums)
        for left_index in range(length):
            for right_index in range(left_index + 1, length):
                if nums[left_index] + nums[right_index] == target:
                    return [left_index, right_index]
        return []

