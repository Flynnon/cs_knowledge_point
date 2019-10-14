"""
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 2^31 − 1 when the division result overflows.

链接：https://leetcode-cn.com/problems/divide-two-integers
"""


class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        """
            x // y == 2^x + 2^y + ... + 0
            归根到底还是减法，只是每次尽可能多的减去值(考虑到不能用乘除法，直接用位移)，可以认为是贪心
        """

        assert divisor != 0

        symbol = 1
        if dividend < 0:
            dividend = -dividend
            symbol = -1

        if divisor < 0:
            divisor = -divisor
            symbol = 1 if symbol == -1 else -1

        multiple = 0
        # 当被除数大于除数的时候才需要继续
        while dividend >= divisor > 0:

            # 本次的最大倍数(2^t_multiple <= dividend && 2^(t_multiple + 1) > dividend)
            t_multiple = 1
            tmp_divisor = divisor

            # 求当前的最大2倍数
            while True:
                if tmp_divisor > dividend:
                    break

                # 简单的移位
                tmp_divisor <<= 1
                t_multiple <<= 1

            # 上面会多移位一次，此处移回来
            t_multiple >>= 1
            dividend -= (tmp_divisor >> 1)

            # 将目前的倍数增加至最大倍数中
            multiple += t_multiple

        # 这个不好说算不算乘法，但不这么写就写不了了....
        if symbol == -1:
            multiple = -multiple

        max_value = 0x7fffffff
        # 这里对结果进行裁剪，在python中无数字大小的限制，因此....
        if multiple > max_value or multiple < -(max_value + 1):
            return max_value
        return multiple
