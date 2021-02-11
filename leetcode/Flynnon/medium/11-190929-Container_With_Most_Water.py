"""
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

链接：https://leetcode-cn.com/problems/container-with-most-water

"""
from typing import List


class Solution:
    def maxArea(self, heights: List[int]) -> int:
        """
            暴力双层循环
            时间复杂度: O(N^2) 空间复杂度: O(1)
            无法实际应用，时间复杂度太高: 提交时，有一个很长的输入，导致超时了
        """
        length = len(heights)
        max_area = 0
        for index_left, height_left in enumerate(heights):
            for index_right in range(index_left + 1, length):
                cur_min_height = min(height_left, heights[index_right])
                cur_area = (index_right - index_left) * cur_min_height
                max_area = max(cur_area, max_area)
        return max_area


class Solution2:
    def maxArea(self, heights: List[int]) -> int:
        """
            双指针往中间扫
            由于宽始终是变小的，因此只需要保证高不比上一次小即不会遗漏case
            时间复杂度: O(N) 空间复杂度: O(1)
        """
        right_index = len(heights) - 1
        left_index = max_area = 0

        # 由题意，此处无需判空
        left_height = heights[left_index]
        right_height = heights[right_index]

        pre_height = 0
        for _ in range(right_index):
            cur_height = min(left_height, right_height)

            # 若此时，高与宽均比上一次小，则无需更新面积
            if cur_height > pre_height:
                max_area = max(max_area, cur_height * (right_index - left_index))
            pre_height = cur_height

            # 调整下标
            if cur_height == left_height:
                left_index += 1
                left_height = heights[left_index]
            else:
                right_index -= 1
                right_height = heights[right_index]

        return max_area