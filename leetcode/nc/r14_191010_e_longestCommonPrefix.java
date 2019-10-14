public class r14_191010_e_longestCommonPrefix {
    /*
    编写一个函数来查找字符串数组中的最长公共前缀。
    如果不存在公共前缀，返回空字符串 ""。
    示例 1:
    输入: ["flower","flow","flight"]
    输出: "fl"
    示例 2:
    输入: ["dog","racecar","car"]
    输出: ""
    解释: 输入不存在公共前缀。
    说明:
    所有输入只包含小写字母 a-z 。
     */
    public static void main(String[] args) {
        r14_191010_e_longestCommonPrefix r = new r14_191010_e_longestCommonPrefix();
        String[] str = {"caa","","a","acb"};
        System.out.println(r.longestCommonPrefix(str));
    }




    public String longestCommonPrefix(String[] strs){
        int minLen=0;
        String targetChar="";
        String target="";
        if (strs.length==1) return strs[0];
        for (int i=0; i<strs.length-1; i++){
            minLen = Math.min(strs[i].length(),strs[i+1].length());
            System.out.println(minLen);
            if (strs[i]=="") return target;
        }
        //if (minLen == 0) return target;
        for (int j=0; j<minLen; j++){
            for (int k=0; k<strs.length-1; k++){
                //if (strs[k]=="") return target;
                if (strs[k].charAt(j)==strs[k+1].charAt(j)){
                    targetChar = strs[k].charAt(j)+"";
                }else {
                    return target;
                }
            }
            target += targetChar;
            //System.out.println(target1);
        }
        return target;
    }



    //题解
    /*
    方法一：水平扫描法，LCP(S1…Sn)=LCP(LCP(LCP(S1,S2),S3),…Sn)
    复杂度分析：时间复杂度：O(S)，S是所有字符串中字符数量的总和。最坏的情况下，n个字符串都是相同的。算法会将S1与其他字符串[S2…Sn]都做一次比较。这样就会进行S次字符比较，其中S是输入数据中所有字符数量。
              空间复杂度：O(1)我们只需要使用常数级别的额外空间。
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
    /*方法二，水平扫描法，扫描每个字符串的同一列，想象数组的末尾有一个非常短的字符串，使用上述方法依旧会进行S次比较。优化这类情况的一种方法就是水平扫描。我们从前往后枚举字符串的每一列，先比较每个字符串相同列上的字符（即不同字符串相同下标的字符）然后再进行对下一列的比较。
      复杂度分析：同方法一
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
     }



     /*
     思路
        标签：链表
        当字符串数组长度为 0 时则公共前缀为空，直接返回
        令最长公共前缀 ans 的值为第一个字符串，进行初始化
        遍历后面的字符串，依次将其与 ans 进行比较，两两找出公共前缀，最终结果即为最长公共前缀
        如果查找过程中出现了 ans 为空的情况，则公共前缀不存在直接返回
        时间复杂度：O(s)，s 为所有字符串的长度之和
      */
    public String longestCommonPrefix3(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }


}
