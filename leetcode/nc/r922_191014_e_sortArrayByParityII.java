import java.util.ArrayList;
import java.util.List;

public class r922_191014_e_sortArrayByParityII {
    /*
    给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
    对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
    你可以返回任何满足上述条件的数组作为答案。
    示例：
    输入：[4,2,5,7]
    输出：[4,5,2,7]
    解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
     */

    public int[] sortArrayByParityII(int[] A) {
        int [] B = new int[A.length];
        int odd = 1;
        int even = 0;
        for (int i=0; i<A.length; i++){
            if (A[i]%2==0){
                B[even] = A[i];
                even += 2;
            }else {
                B[odd] = A[i];
                odd += 2;
            }
        }
        return B;
    }


    //题解：双指针，无需开辟额外数组空间，让偶数部分下标 i 之前的所有数都是偶数。为了实现这个目标，把奇数部分作为暂存区，不断增加指向奇数部分的指针，直到找到一个偶数，然后交换指针 i，j 所指的数
    /*复杂度分析：
        时间复杂度，O(N)，其中 N是 A 的长度。
        空间复杂度，O(1)
     */
    public int[] sortArrayByParityII1(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2)
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1)
                    j += 2;

                // Swap A[i] and A[j]
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        return A;
    }
}
