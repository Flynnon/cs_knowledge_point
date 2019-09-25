import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class r3_190924_n_lengthOfLongestSubstring {
    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    /*
    示例 1:
    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */

    //思路，将字符串拆分为字符存入set集合，计算set长度，将字符串按第一个字符切割，再将切割完的所有字符串按第二个字符切割，切割次数为set长度，取最后结果长度最大的字符串


    public int lengthOfLongestSubstring(String s ){
        Set<Character> set = new HashSet<>();
        String[] allStr = new String[]{};
        char[] chars = s.toCharArray();
        for (char everyChar : chars){
            set.add(everyChar);
        }
        for (char everyChar : set){

        }
        return 0;
    }
}
