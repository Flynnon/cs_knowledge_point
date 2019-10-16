"""
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?

链接：https://leetcode-cn.com/problems/palindrome-number
"""

class Solution:
    def isPalindrome(self, x: int) -> bool:
        """ 转成字符串然后双指针往中间扫 """
        # 优化，直接判定负数，减少运算
        if x < 0:
            return False
        x = str(x)
        left_index = 0
        right_index = len(x) - 1
        while left_index <= right_index:
            if x[left_index] != x[right_index]:
                return False
            left_index += 1
            right_index -= 1
        return True


class Solution1:
    def isPalindrome(self, x: int) -> bool:
        """ 构造一个反过来的int，判断回文 """
        if x < 0:
            return False

        other = 0
        # 已经过了中间，则跳过
        while other < x:
            x, mod =  divmod(x, 10)

            # 最低位是0，则非回文
            if other == 0 and mod == 0:
                return False

            if other >= x:
                break

            other = other * 10 + mod

        return x == other


class Solution2:
    def isPalindrome(self, x: int) -> bool:
        """ 上一种的优化，把判断移出去 """
        if x < 0:
            return False

        if x % 10 == 0 and x != 0:
            return False

        other = 0
        # 已经过了中间，则跳过
        while other < x:
            x, mod =  divmod(x, 10)

            if other >= x:
                break

            other = other * 10 + mod

        return x == other
