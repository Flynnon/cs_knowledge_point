import java.util.*;

public class r3_190925_n_lengthOfLongestSubstring {
    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    /*
    示例 1:
    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */

    /*
    不可取，实现需要太多嵌套循环、每次切割还要新建数组封装、还涉及到太多字符字符串的转化

    思路，将字符串拆分为字符存入set集合，计算set长度，将字符串按第一个字符切割，再将切割完的所有字符串按第二个字符切割，切割次数为set长度，取最后结果长度最大的字符串


    public int lengthOfLongestSubstring(String s ){
        Set<Character> set = new HashSet<>();
        String[] allStr = new String[]{};
        char[] chars = s.toCharArray();
        for (char charOfChars : chars){
            set.add(charOfChars);
        }
        for (char charOfSet : set){

        }
        return 0;
    }
    */


    //方法一：暴力法，拆分字符串为无重复字符的子字符串，循环遍历出长度最长的子字符串
    /*复杂度分析
        时间复杂度：O(n3),要验证索引范围在[i,j)内的字符是否都是唯一的，我们需要检查该范围中的所有字符,因此，它将花费O(j−i)的时间
        空间复杂度：O(min(n,m))，我们需要O(k)的空间来检查子字符串中是否有重复字符，其中k表示Set的大小，而Set的大小取决于字符串n的大小以及字符集/字母m的大小
     */
    public int lengthOfLongestSubstring(String s){
        int lenOfS = s.length();
        int lenOfSS = 0;
        for (int i=0; i<lenOfS; i++){
            for (int j=i+1; j<=lenOfS; j++){
                if (allSS(s,i,j)){
                    lenOfSS = Math.max(lenOfSS, j-i);
                }
            }
        }
        return lenOfSS;
    }

    public boolean allSS(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for (int i=start; i<end; i++){
            Character character = s.charAt(i);
            if (set.contains(character))return false;
            set.add(character);
        }
        return true;
    }


    //方法二：滑动窗口
    /*
    通过使用HashSet作为滑动窗口，我们可以用O(1)的时间来完成对字符是否在当前的子字符串中的检查。

    滑动窗口是数组/字符串问题中常用的抽象概念，窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即[i,j)（左闭，右开）。
    而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i,j)向右滑动 1个元素，则它将变为[i+1,j+1)（左闭，右开）。
    回到我们的问题，我们使用 HashSet 将字符存储在当前窗口[i,j)（最初j=i）中。然后我们向右侧滑动索引j，如果它不在HashSet中，我们会继续滑动j。
    直到s[j]已经存在于HashSet中。此时，我们找到的没有重复字符的最长子字符串将会以索引i开头。如果我们对所有的i这样做，就可以得到答案。

     复杂度分析
        时间复杂度：O(2n)=O(n)，在最糟糕的情况下，每个字符将被i和j访问两次
        空间复杂度：O(min(m,n))，与之前的方法相同。滑动窗口法需要O(k)的空间，其中k表示Set的大小。而Set的大小取决于字符串n的大小以及字符集/字母m的大小
     */
    public int lengthOfLongestSubstring1(String s){
        int lenOfS = s.length();
        Set<Character> set = new HashSet<>();
        int lenOfSS=0, i=0, j=0;
        while(i<lenOfS && j<lenOfS){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                lenOfSS = Math.max(lenOfSS, j-i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return lenOfSS;
    }

    //方法三：map
    //滑动窗口优化，上面方法需要2n个步骤，可以定义字符到索引的映射map，字符重复跳过窗口，步骤为n
    //如果s[j]在[i,j)范围内有与 j'重复的字符，我们不需要逐渐增加i,我们可以直接跳过 [i，j']范围内的所有元素，并将i变为 j'+1
    public int lengthOfLongestSubstring2(String s){
        int lenOfS = s.length(), lenOfSS = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0, j=0; j<lenOfS; j++){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            lenOfSS = Math.max(lenOfSS, j-i+1);
            map.put(s.charAt(j), j+1);
        }
        return lenOfSS;
    }


    //方法三：假设字符集，用数组代替map
    //int[26]用于字母a-z,A-Z; int[128]用于ASII码; int[256]用于拓展ASII码
    /*复杂度分析（优化的滑动窗口和方法三）：
        时间复杂度：O(n),索引j将迭代n次
        空间复杂度(HashMap):O(min(m,n))
        空间复杂度(Table):O(m),m是字符集大小
     */
    public int lengthOfLongestSubstring3(String s){
        int lenOfS = s.length(), lenOfSS = 0;
        int[] index = new int[128];
        for (int i=0, j=0; j<lenOfS; j++){
            i = Math.max(index[s.charAt(j)],i);
            lenOfSS = Math.max(lenOfS, j-i+1);
            index[s.charAt(j)] = j+1;
        }
        return lenOfS;
    }


    //评论中方法四：
    public int lengthOfLongestSubstring4(String s) {
        int i = 0;
        int flag = 0;
        int length = 0;
        int result = 0;
        while (i < s.length()) {
            int pos = s.indexOf(s.charAt(i),flag);
            if (pos < i) {
                if (length > result) {
                    result = length;
                }
                if (result >= s.length() - pos - 1) {
                    return result;
                }
                length = i - pos - 1;
                flag = pos + 1;
            }
            length++;
            i++;
        }
        return length;
    }



    //评论中方法五
    /*
    思路如下，滑动窗口+数组
    记录当前最长字符串，同时窗口向右移动，无论何时都使得当前窗口含有当前最长不重复子串，知道窗口移到底部。返回最大长度。
    注：有个地方取了巧，在遍历字符串的时候将遍历过的字符记录在自定义长度为95的数组里(与ASCII码表相对应)。
     */
    public int lengthOfLongestSubstring5(String s)
    {
        char[] strs = s.toCharArray();
        int[] isValid = new int[95];
        int result = 0;
        int max = 0;
        for (int i = 0; i < strs.length; i++)
        {
            if (isValid[strs[i] - ' '] != 0)
            {
                result = max > result ? max : result;
                for (int j = i - max; j < isValid[strs[i] - ' ']; j++)
                {
                    max--;
                    isValid[strs[j] - ' '] = 0;
                }
            }
            max++;
            isValid[strs[i] - ' '] = i + 1;
        }
        return max > result ? max : result;
    }



    //评论中方法六
    /*
    假设c[i]是以第i个字符为结尾时的最长无重复字符串长度，用一个数组或者字典保存字符出现的最近位置,这里用p[c]代表字符c出现的最近位置。
    显然c[0]=1,当下标为i时，有两种情况：若字符s[i]没出现或者字符s[i]出现但 i - p[s[i]] > c[i - 1] + 1，则 c[i] = c[i - 1] + 1;否则 c[i] = i - p[s[i]]。
    遍历一遍数组c就得到答案。
    这个是拿Kadane算法改的
     */

    public int lengthOfLongestSubstring6(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] appear = new int[95];
        int cur = 0, global = 0;

        for (int i = 0; i < 95; i++)
            appear[i] = -1;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - ' ';
            cur = appear[c] == -1 ? cur + 1 : Math.min(cur + 1, i - appear[c]);
            appear[c] = i;
            global = Math.max(global, cur);
        }

        return global;
    }

}
