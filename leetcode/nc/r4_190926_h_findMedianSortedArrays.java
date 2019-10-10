import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class r4_190926_h_findMedianSortedArrays {
    /*
    给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

    请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

    你可以假设 nums1 和 nums2 不会同时为空。

    示例 1:

    nums1 = [1, 3]
    nums2 = [2]

    则中位数是 2.0
    示例 2:

    nums1 = [1, 2]
    nums2 = [3, 4]

    则中位数是 (2 + 3)/2 = 2.5

     */



    public static void main(String[] args) {
        r4_190926_h_findMedianSortedArrays r4 = new r4_190926_h_findMedianSortedArrays();
        int[] numsl = {1,2};
        int[] nums2 = {3,4};
        System.out.println(r4.findMedianSortedArrays(numsl,nums2));
    }




    //方法一：不懂时间复杂度——！
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        List<Integer> list = new ArrayList<Integer>();
        double median = 0;
        for(int numOf1 : nums1){
            list.add(numOf1);
        }
        for(int numOf2 : nums2){
            list.add(numOf2);
        }
        Collections.sort(list);
        int l = list.size();
        if (l%2 == 0){
            median = (list.get(l/2) + list.get(l/2-1))/2.0;
        }else{
            median = list.get((l-1)/2);
        }
        return median;
    }

    //方法二：二分递归法
    /*任一位置i将A划分成两个部分, m+1种划分的方法;任一位置j将B划分成两个部分同理；
      为了将{A、B}中元素划分成长度相等，一部分中元素总是大于另一部分中的元素，需保证i+j=m−i+n−j（或：m-i+n-j+1）
      如果n≥m，只需要使i=0~m,j=(m+n+1)/2-i;B[j-1]<=A[i]以及A[i-1]<=B[j]

      复杂度分析：
        时间复杂度：O(log(min(m,n)))，查找的区间是[0,m]，该区间的长度在每次循环之后都会减少为原来的一半，只需要执行log(m)次循环，由于每次循环中进行常量次数的操作，所以时间复杂度为O(log(m))，由于m<=n,时间复杂度是O(log(min(m,n)))
        空间复杂度：O(1)，只需要恒定的内存来存储9个局部变量
     */
    public double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public double findMedianSortedArrays11(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }




    //方法三
    /*复杂度分析：
        时间复杂度：遍历 len/2+1 次，len=m+n，所以时间复杂度依旧是 O(m+n)
        空间复杂度：申请了常数个变量，空间复杂度O(1)
     */
    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

}
