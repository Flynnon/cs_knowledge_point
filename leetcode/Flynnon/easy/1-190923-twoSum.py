"""
 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 
 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 
 示例:
 
 给定 nums = [2, 7, 11, 15], target = 9
 
 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 @param {number[]} nums
 @param {number} target
 @return {number[]}
"""
from typing import List


class Solution:

    @classmethod
    def method_one(cls, nums: List[int], number: int) -> List[int]:
        """
            使用map记录 num -> index 的对应关系，然后遍历得到匹配的index即可
            优化: 无需构建完再遍历，构建与遍历可以一起进行
            时间复杂度: O(N), 空间复杂度: O(N)
        """
        num_index_map = {}
        for index, num in enumerate(nums):
            sub_value = number - num
            matched_index = num_index_map.get(sub_value, None)
            if matched_index is not None:
                return [matched_index, index]
            num_index_map[num] = index
        return []

    @classmethod
    def method_two(cls, nums: list, number: int) -> list:
        """
            暴力解，两层循环
            时间复杂度: O(N^2), 空间复杂度: O(1)
        """
        length = len(nums)
        for left_index in range(length):
            for right_index in range(left_index + 1, length):
                if nums[left_index] + nums[right_index] == number:
                    return [left_index, right_index]
        return []


if __name__ == '__main__':
    test_cases = (
        ([3, 2, 4], 6),
    )
    for method in (Solution.method_one, Solution.method_two):
        for nums, number in test_cases:
            index_one, index_two = method(nums, number)
            assert nums[index_one] + nums[index_two] == number
