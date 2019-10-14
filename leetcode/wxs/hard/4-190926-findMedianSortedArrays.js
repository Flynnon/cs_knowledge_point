/**
 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 
 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 
 你可以假设 nums1 和 nums2 不会同时为空。
 
 示例 1:
 
 nums1 = [1, 3]
 nums2 = [2]
 
 则中位数是 2.0
 示例 2:
 
 nums1 = [1, 2]
 nums2 = [3, 4]
 
 则中位数是 (2 + 3)/2 = 2.5
 */
//非排序
var findMedianSortedArrays = function (nums1, nums2){
    let len1 = nums1.length;
    let len2 = nums2.length;
    let sum = len1 + len2;
    let arr = [];
    let i, j;
    for (i = 0, j = 0; i < len1 && j < len2;){
        if (nums1[i] < nums2[j]){
            arr.push(nums1[i]);
            i++;
        } else{
            arr.push(nums2[j]);
            j++;
        }
    }
    // let start = i, end = len1 - 1;
    while (j < len2){
        arr.push(nums2[j++]);
    }
    while (i < len1){
        arr.push(nums1[i++]);
    }
    // if (j < len2){
    //     start = j, end = len2 - 1;
    //     while (start <= end){
    //         arr.push(nums2[start++]);
    //     }
    // } else{
    //     while (start <= end){
    //         arr.push(nums1[start++]);
    //     }
    // }
    let mid = Math.floor(sum / 2);
    return sum % 2 === 0 ? arr[mid] / 2 + arr[mid - 1] / 2 : arr[mid];
};
//排序
var findMedianSortedArrays = function (nums1, nums2){
    let nums = nums1.concat(nums2).sort((a, b) => {return a - b;});
    nums1 = null;
    nums2 = null;
    let len = nums.length, mid = Math.floor(len / 2);
    return len % 2 === 0 ? (nums[mid] + nums[mid - 1]) / 2 : nums[mid];
};