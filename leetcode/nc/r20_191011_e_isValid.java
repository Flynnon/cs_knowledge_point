import java.util.HashMap;
import java.util.Stack;

public class r20_191011_e_isValid {
    /*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。
    示例 1:
    输入: "()"
    输出: true
    示例 2:
    输入: "()[]{}"
    输出: true
    示例 3:
    输入: "(]"
    输出: false
    示例 4:
    输入: "([)]"
    输出: false
    示例 5:
    输入: "{[]}"
    输出: true
     */


    //思路，遍历字符串，当遇见连续两个字符加起来等于()[]{}三者中之一时，将其从字符串删除，当字符串等于“”时返回true
    //如果连续两次字符串长度不变且字符串不为“”则返回false
    //未实现
    public static void main(String[] args) {
        //boolean b = r20_191011_e_isValid.isValid(new String("()[]{}"));
        //System.out.println(b);


    }

   /* public static boolean isValid(String s){
        StringBuilder sb = new StringBuilder(s);
        for (int i=0; i<s.length(); i++){
            if (s.substring(i,i+1)=="()"||s.substring(i,i+1)=="{}"||s.substring(i,i+1)=="[]"){
                sb.delete(i,i+1);
                s=sb.toString();
            }
        }



        *//*int lenOfS = s.length();
        for (int i=0; i<lenOfS; i++){
            for (int j=0; j<s.length(); j++){
                i = 0;
                do {
                    s.replace()
                }
                if (s.substring(i,i+1)=="()"||s.substring(i,i+1)=="{}"||s.substring(i,i+1)=="[]"){

                }
            }
        }*//*

    }*/


    //官方题解，栈的方法，左括号入栈，遇见与最新的左括号对应的有括号就减掉一对，依次进行操作，碰到不能解决的右括号
    //则返回false，遍历结束，栈为空返回true；
    //复杂度分析：时间复杂度：O(n)，因为我们一次只遍历给定的字符串中的一个字符并在栈上进行 O(1) 的推入和弹出操作。
    //空间复杂度：O(n)，当我们将所有的开括号都推到栈上时以及在最糟糕的情况下，我们最终要把所有括号推到栈上。

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public r20_191011_e_isValid() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }



    public boolean isValid(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}

