import java.util.*;

public class r15_191018_n_threeSum {

    /*
    给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
    注意：答案中不可以包含重复的三元组。
    例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    满足要求的三元组集合为：
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
     */
    public static void main(String[] args) {
        r15_191018_n_threeSum r = new r15_191018_n_threeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> lists = r.threeSum(nums);
        System.out.println(lists.size());
        System.out.println("===============");
        for (int i=0; i<lists.get(1).size(); i++){
            System.out.println(lists.get(1).get(i));
        }
    }





    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length<3) return list;
        HashSet<List<Integer>> set = new HashSet();
        for (int i=0; i<nums.length-2; i++){
            for (int j=i+1; j<nums.length-1; j++){
                for (int k=j+1; k<nums.length; k++){
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }
            }
        }
        for (List<Integer> li : set){
            if (li.get(0)+li.get(1)+li.get(2) == 0){
                list.add(li);
            }
        }
        return list;
    }







    /*
    双for循环，第二遍双指针遍历头尾

    首先对数组进行排序，排序后固定一个数nums[i]，再使用左右指针指向nums[i]后面的两端，
    数字分别为nums[L]和nums[R]，计算三个数的和sum判断是否满足为 0，满足则添加进结果集
    如果nums[i]大于0，则三数之和必然无法等于0，结束循环
    如果nums[i] ==nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
    当sum ==0 时，nums[L]nums[L] == nums[L+1]则会导致结果重复，应该跳过，L++
    当sum ==0 时，nums[R]nums[R] == nums[R-1]则会导致结果重复，应该跳过，R--

    时间复杂度：O(n^2) ，n为数组长度
     */


    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }


}








    /*
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> numInt = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            numInt.add(nums[i]);
        }
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                if (numInt.contains(0-nums[i]-nums[j])){
                    numInt
                    //&& numInt.indexOf(0-nums[i]-nums[j])>j
                    list.add(Arrays.asList(nums[i],nums[j],0-nums[i]-nums[j]));
                }
            }
        }
//        for (int i=0; i<list.size(); i++){
//            Collections.sort(list.get(i));
//        }

        HashSet set = new HashSet(list);
        list.clear();
        list.addAll(set);
        return list;
    }
    */
