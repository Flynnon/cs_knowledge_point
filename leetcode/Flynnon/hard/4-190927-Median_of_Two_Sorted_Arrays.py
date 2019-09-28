"""
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
"""
from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int],
                               nums2: List[int]) -> float:
        """
            合并 --> 排序 --> 求中位
            时间复杂度 O(log(M+N))，空间复杂度 O(M+N)
        """
        nums = nums1 + nums2
        nums.sort()
        length = len(nums)
        return (nums[(length - 1) // 2] + nums[length // 2]) / 2


class Solution2:
    def findMedianSortedArrays(self, nums1: List[int],
                               nums2: List[int]) -> float:
        """
            合并 --> 排序 --> 求中位
            优化: 排序这里可以使用归并排序，时间复杂度为 O(M+N)，空间复杂度 O(M+N)
        """
        nums = []
        left_index = right_index = 0
        length_1, length_2 = len(nums1), len(nums2)

        remain_index, remain_list = None, None

        while True:
            if left_index == length_1:
                remain_index = right_index
                remain_list = nums2
            elif right_index == length_2:
                remain_index = left_index
                remain_list = nums1

            if remain_index is not None:
                length = len(remain_list)
                for i in range(remain_index, length):
                    nums.append(remain_list[i])
                break

            if nums1[left_index] < nums2[right_index]:
                cur_value = nums1[left_index]
                left_index += 1
            else:
                cur_value = nums2[right_index]
                right_index += 1
            nums.append(cur_value)

        length_sum = length_1 + length_2
        return (nums[(length_sum - 1) // 2] + nums[length_sum // 2]) / 2


class Solution3:
    def findMedianSortedArrays(self, nums1: List[int],
                               nums2: List[int]) -> float:
        """
            使用两个指针左右边界扫，得到中值
            前提: 两个列表均是排序的
            时间复杂度: O(M+N), 空间复杂度: O(1)
        """

        not_empty = None

        if not nums1:
            not_empty = nums2
        if not nums2:
            not_empty = nums1

        if not_empty is not None:
            length = len(not_empty)
            return (not_empty[(length - 1) // 2] + not_empty[length // 2]) / 2

        length_one, length_two = len(nums1), len(nums2)

        left_index_one = left_index_two = 0
        right_index_one, right_index_two = length_one - 1, length_two - 1
        count = (length_one + length_two) // 2
        left_value = right_value = 0

        for _ in range(count - 1):
            one_left_max, two_left_max = nums1[left_index_one], nums2[
                left_index_two]

            if max(one_left_max,
                   two_left_max) == two_left_max:
                left_value = two_left_max

                if left_index_one < length_one - 1:
                    left_index_one += 1
                else:
                    left_index_two += 1
            else:
                if left_index_two < length_two - 1:
                    left_index_two += 1
                else:
                    left_index_one += 1
                left_value = one_left_max

            one_right_min, two_right_min = nums1[right_index_one], nums2[
                right_index_two]
            if min(one_right_min,
                   two_right_min) == two_right_min:
                if right_index_one > 0:
                    right_index_one -= 1
                else:
                    right_index_two -= 1

                right_value = two_right_min
            else:
                if right_index_two > 0:
                    right_index_two -= 1
                else:
                    right_index_one -= 1
                right_value = one_right_min

            print('left_value', left_value, 'left_index_one', left_index_one, 'left_index_two', left_index_two)
            print('right_value', right_value, 'right_index_one', right_index_one, 'right_index_two', right_index_two)
        return (left_value + right_value) / 2

if __name__ == '__main__':
    nums1 = [2,3,4]
    nums2 = [1]
    print(Solution3().findMedianSortedArrays(nums1, nums2))