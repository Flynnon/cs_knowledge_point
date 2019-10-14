import java.util.HashMap;
import java.util.Map;

public class r13_191010_e_romanToInt {
    /*
    罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
    字符          数值
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
    通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
    I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
    X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
    C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
    给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
    示例 1:
    输入: "III"
    输出: 3
    示例 2:
    输入: "IV"
    输出: 4
    示例 3:
    输入: "IX"
    输出: 9
    示例 4:
    输入: "LVIII"
    输出: 58
    解释: L = 50, V= 5, III = 3.
    示例 5:
    输入: "MCMXCIV"
    输出: 1994
    解释: M = 1000, CM = 900, XC = 90, IV = 4.
     */

    //iv=4 ix=9 xl=40 xc=90 cd=400 cm=900

    //想法：将字符串反转，分别判断每一位的下一位，根据情况选择target加多少；放弃原因：需要太多判断，并且每次判断需要同时判断是否在字符串的边界
/*    public int romanToInt(String s) {
        String reverseS = new StringBuilder(s).reverse().toString();
        char[] sArr = reverseS.toCharArray();
        int target = 0;
        for (int i=0; i<sArr.length; i++){
            if (sArr[i]=='I'){
                target = target+1;
            }else if (sArr[i]=='V'){
                if (sArr[i+1]!='I'){
                    target = target+5;
                }else {
                    target = target +4;
                }
            }else if (sArr[i]=='X'){
                if (sArr[i+1]!='I'){
                    target = target +10;
                }else {
                    target = target +9;
                }
            }else if (sArr[i]=='L'){
                if (sArr[i+1]!='X'){
                    target = target +50;
                }else {
                    target = target +40;
                }
            }else if (sArr[i]=='C'){
                if (sArr[i+1]!='L'){
                    target = target +100;
                }else {
                    target = target +90;
                }
            }else if (sArr[i]==''){
                if (sArr[i+1]!='L'){
                    target = target +100;
                }else {
                    target = target +90;
                }
        }
    }*/


    //我的想法的实现 ，优化了条件结构
    public int romanToInt1(String s){
        char[] ch = s.toCharArray();
        int num = 0;
        for (int i = 0; i < ch.length - 1; i++) {
            if(ch[i] == 'I' && (ch[i + 1] == 'V' || ch[i + 1] == 'X'))
                num -= 2;
            if(ch[i] == 'X' && (ch[i + 1] == 'L' || ch[i + 1] == 'C'))
                num -= 20;
            if(ch[i] == 'C' && (ch[i + 1] == 'D' || ch[i + 1] == 'M'))
                num -= 200;
        }
        for (int i = 0; i < ch.length; i++) {
            switch (ch[i]) {
                case 'M':
                {num += 1000;continue;}
                case 'D':
                {num += 500;continue;}
                case 'C':
                {num += 100;continue;}
                case 'L':
                {num += 50;continue;}
                case 'X':
                {num += 10;continue;}
                case 'V':
                {num += 5;continue;}
                default:
                {num += 1;continue;}
            }
        }
        return num;
    }

    //解法一：首先将所有的组合可能性列出并添加到哈希表中
    //然后对字符串进行遍历，由于组合只有两种，一种是 1 个字符，一种是 2 个字符，其中 2 个字符优先于 1 个字符
    //先判断两个字符的组合在哈希表中是否存在，存在则将值取出加到结果 targrt 中，并向后移2个字符。不存在则将判断当前 1 个字符是否存在，存在则将值取出加到结果 target 中，并向后移 1 个字符
    //遍历结束返回结果 target

    public int romanToInt(String s){
        Map<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);

        int target = 0;
        //循环遍历字符串中判断连着的两个字符串是否有特殊罗马数字
        for (int i=0; i<s.length();){
            if (i+1<s.length() && map.containsKey(s.substring(i,i+2))){
                //i+1<s.length是判断不会索引越界的条件
                target += map.get(s.substring(i,i+2));
                //如果有特殊罗马数字，则从这个特殊的罗马数字的第二个字符的下一位开始判断
                i += 2;
            } else {
                target += map.get(s.substring(i,i+1));
                i++;
            }
        }
        return target;
    }



    /*
    把所有可能的组合都放进HashMap，然后遍历字符串的时候，优先查找两位数的组合是否存在，再判断一位的。但是这样既增加了多余的内存来存储组合，并且逻辑方面也不简单。
    把基础的罗马数字添加到HashMap中，遍历字符串，同时分别取出后面两位的对应整数，判断如果后面位数的值比前面的值小，那么就在总数上加上前面的数值，否则就减去前面的数值
     */
    public int romanToInt2(String s){
        // 算法一：判断后面数值是否大于前面
        Map<Character, Integer> romaNumber = new HashMap<>();
        romaNumber.put('I', 1);
        romaNumber.put('V', 5);
        romaNumber.put('X', 10);
        romaNumber.put('L', 50);
        romaNumber.put('C', 100);
        romaNumber.put('D', 500);
        romaNumber.put('M', 1000);

        int firstValue = 0;
        int nextValue = 0;
        int sum = 0;

        for (int i = 0; i < s.length(); i++){
            firstValue = romaNumber.get(s.charAt(i));
            if (i == s.length()-1){
                sum += firstValue;
            }else {
                nextValue = romaNumber.get(s.charAt(i+1));
                if (firstValue >= nextValue){
                    sum += firstValue;
                }else{
                    sum -= firstValue;
                }
            }
        }
        return sum;
    }


    public int romanToInt3(String s) {
        String[] roman = {"IV", "IX", "XL", "XC", "CD", "CM", "I", "V", "X", "L", "C", "D", "M"};
        int[] nums = {4, 9, 40, 90, 400, 900, 1, 5, 10, 50, 100, 500, 1000};
        int num = 0;
        while (s.length() > 0) {
            for (int i = 0; i < roman.length; i++) {
                if (s.startsWith(roman[i])) {
                    num += nums[i];
                    s = s.substring(roman[i].length());
                    break;
                }
            }
        }
        return num;
    }
}
