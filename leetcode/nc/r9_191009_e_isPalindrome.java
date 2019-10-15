import java.lang.reflect.Array;

public class r9_191009_e_isPalindrome {
    /*
    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

    示例 1:
    输入: 121
    输出: true
    示例 2:
    输入: -121
    输出: false
    解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
    示例 3:
    输入: 10
    输出: false
    解释: 从右向左读, 为 01 。因此它不是一个回文数。
    进阶:
    你能不将整数转为字符串来解决这个问题吗？
     */

    //解题思路：转字节数组对称位及正负的判断
    //复杂度分析：
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        char[] intArr = (x + "").toCharArray();
        for (int i=0; i<intArr.length; i++){
            if (intArr[i] != intArr[intArr.length-i-1]){
                return false;
            }
        }
        return true;
    }


    //题解一
    /*
        方法：反转一半数字
        思路
        映入脑海的第一个想法是将数字转换为字符串，并检查字符串是否为回文。但是，这需要额外的非常量空间来创建问题描述中所不允许的字符串。
        第二个想法是将数字本身反转，然后将反转后的数字与原始数字进行比较，如果它们是相同的，那么这个数字就是回文。
        但是，如果反转后的数字大于 \text{int.MAX}int.MAX，我们将遇到整数溢出问题。
        按照第二个想法，为了避免数字反转可能导致的溢出问题，为什么不考虑只反转 \text{int}int 数字的一半？毕竟，如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。
        例如，输入 1221，我们可以将数字 “1221” 的后半部分从 “21” 反转为 “12”，并将其与前半部分 “12” 进行比较，因为二者相同，我们得知数字 1221 是回文。
        让我们看看如何将这个想法转化为一个算法。

        1.负数直接返回false
        2.%10得到最后一位
          /10得到移除最后一位的数
          反复
        3.判断已经反转一半的方法
          原始数字/10，反转数字*10，当反转数字大于原始数字时，已经反转一半

        复杂度分析：
            时间复杂度：O(log 10(n))，对于每次迭代，我们会将输入除以10，因此时间复杂度为O(log 10(n))
            空间复杂度：O(1)。
     */
    public boolean isPalindrome1(int x) {
        if (x<0) return false;
        int num = x;
        int reverseNum = 0;
        while (num > reverseNum){
            reverseNum = reverseNum*10+num%10;
            num = num/10;
        }
        //偶数个数字用||前匹配，奇数个数字用||后匹配，0 || 1 = 1
        return num == reverseNum || num == reverseNum/10;
    }
}
