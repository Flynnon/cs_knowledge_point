import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class r1_190924_e_twoSum {
/*   给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

    示例:

    给定 nums = [2, 7, 11, 15], target = 9

    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
    */
    public static void main(String[] args) {
        r1_190924_e_twoSum r1 = new r1_190924_e_twoSum();
        int [] nums = {2, 8, 4, 5};
        int target = 9;
        System.out.println(Arrays.toString(r1.twoSum(nums,target)));
    }


    //方法一：暴力法,遍历每一个元素，查找一个与该元素的和为target的元素的值。
    /*复杂度分析
        时间复杂度O(n2)：对于每个元素，通过遍历数组其余元素寻找目标元素，耗费O(n)时间
        空间复杂度O(1)
     */
    public  int[] twoSum(int[] nums, int target){
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                if (nums[j]== target - nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        //return null;
        throw new IllegalArgumentException("no such sum");
    }


    //方法二：两遍哈希表，保持数组中元素与索引建立相互对应关系，空间换速度，先将元素值和索引添加map，再查找目标元素。
    /*复杂度分析
        时间复杂度O(n)：我们把包含有n个元素的列表遍历两次。由于哈希表将查找时间缩短到O(1)，所以时间复杂度为O(n)
        空间复杂度O(n)：所需的额外空间取决于哈希表中存储的元素数量，该表中存储了n个元素
     */
    public int[] twoNum1(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            map.put(nums[i],i);
        }
        for (int i=0; i<nums.length; i++){
            int match = target - nums[i];
            if (map.containsKey(match) && map.get(match)!=i){
                return new int[] {i , map.get(match)};
            }
        }
        throw new IllegalArgumentException("no such sum");

    }


    //方法三：一遍哈希表。
    public int[] twoNum2(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int match = target - nums[i];
            if (map.containsKey(match) && map.get(match)!=i){
                return new int[]{map.get(match),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no such sum");
    }
}
