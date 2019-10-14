import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class r349_191011_e_intersection {
    /*
    给定两个数组，编写一个函数来计算它们的交集。
    示例 1:
    输入: nums1 = [1,2,2,1], nums2 = [2,2]
    输出: [2]
    示例 2:
    输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    输出: [9,4]
    说明:
    输出结果中的每个元素一定是唯一的。
    我们可以不考虑输出结果的顺序。
     */

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List <Integer> list = new ArrayList<>();
        for (int i=0; i<nums1.length; i++){
            set1.add(nums1[i]);
        }
        for (int i=0; i<nums2.length; i++){
            set2.add(nums2[i]);
        }
        for (Integer in : set1){
            if (set2.contains(in)){
                list.add(in);
            }
        }
        int[] nums = new int[list.size()];
        for (int i=0; i<list.size(); i++){
            nums[i] = list.get(i);
        }
        return nums;
    }


    //优化版
    //时间空间复杂度均为O（m+n）
    public int[] intersection1(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<Integer>();
            for (Integer n : nums1) set1.add(n);
            HashSet<Integer> set2 = new HashSet<Integer>();
            for (Integer n : nums2) set2.add(n);

            set1.retainAll(set2);

            int [] nums = new int[set1.size()];
            int idx = 0;
            for (int s : set1) nums[idx++] = s;
            return nums;
        }


}
