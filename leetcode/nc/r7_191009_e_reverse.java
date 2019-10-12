import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class r7_191009_e_reverse {
    /*
    给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

    示例 1:
    输入: 123
    输出: 321
    示例 2:
    输入: -123
    输出: -321
    示例 3:
    输入: 120
    输出: 21
    注意:

    假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

     */

    //解题思路：数字、字符串、字符数组的转换及判断
    //复杂度分析：
    public int reverse(int x) {
        //数字转字符数组
        char[] strArray = (x + "").toCharArray();
        //定义数组存放由非零非符号组成的字节，利用list自带的reserve方法
        ArrayList<String> list = new ArrayList<String>();
        for (int i=0; i<strArray.length; i++){
            if (strArray[i] != 0 && strArray[i] != '-'){
                list.add(String.valueOf(strArray[i]));
            }
        }
        Collections.reverse(list);
        //字符拼接成字符串
        String str0 = "";
        for (String str1 : list){
            str0 += str1;
        }
        //int边界判断及原数字符号判断
        try {
            int target = Integer.parseInt(str0);
            if (x < 0) {
                return 0 - target;
            }
            return target;
        }catch (Exception e){
            return 0;
        }
    }



    //题解
    /*
    方法：弹出和推入数字 & 溢出前进行检查
        思路
        我们可以一次构建反转整数的一位数字。在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出。
        算法
        反转整数的方法可以与反转字符串进行类比。
        我们想重复“弹出”x的最后一位数字，并将它“推入”到rev的后面。最后rev将与x相反。
        要在没有辅助堆栈/数组的帮助下 “弹出” 和 “推入” 数字，我们可以使用数学方法。

        //pop operation:
        pop = x % 10;
        x /= 10;

        //push operation:
        temp = rev * 10 + pop;
        rev = temp;
        但是，这种方法很危险，因为当temp=rev⋅10+pop 时会导致溢出。
        幸运的是，事先检查这个语句是否会导致溢出很容易。
        为了便于解释，我们假设 rev是正数。
        如果temp=rev⋅10+pop导致溢出，那么一定有rev≥INTMAX/10
        如果rev>INTMAX/10,那么temp=rev⋅10+pop一定会溢出。
        如果rev==INTMAX/10,那么只要pop>7,temp=rev⋅10+pop就会溢出。
        当rev 为负时可以应用类似的逻辑。

     复杂度分析：
        时间复杂度：O(log(x))，x中大约有log 10(x)位数字。
        空间复杂度：O(1)。

     */
    public int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
