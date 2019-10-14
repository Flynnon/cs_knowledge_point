public class r75_191012_n_sortColors {
    /*
    给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
    注意:
    不能使用代码库中的排序函数来解决这道题。
    示例:
    输入: [2,0,2,1,1,0]
    输出: [0,0,1,1,2,2]
     */

    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]==0) count0++;
            if (nums[i]==1) count1++;
            if (nums[i]==2) count2++;
            }
        for (int i=0; i< nums.length; i++){
            if (i<count0) nums[i]=0;
            if (i>=count0 && i<count0+count1) nums[i]=1;
            if (i>=count0+count1) nums[i]=2;
        }
    }


    //三指针法：如果遇到 0，则放到数组的前端。如果遇到 2，则放到数组的后端，如果遇到 1，则不处理。
    public void sortColors1(int[] nums) {
        // 三指针
        int i=0, l=0, r=nums.length-1;
        while(i<=r){
            if(i<l || nums[i]==1)
                i++;
            else if(nums[i]==0)
                swap(nums,i,l++);
            else if(nums[i]==2)
                swap(nums,i,r--);
        }
    }

    private void swap(int[] nums, int i, int j){
        if(i==j)
            return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    //冒泡
    public void sortColors2(int[] nums) {
        // 外层for循环控制循环次数
        for (int i = 0; i < nums.length; i++) {
            int tem = 0;
            // 内层for循环控制相邻的两个元素进行比较
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    tem = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tem;
                }
            }
        }
    }
}
