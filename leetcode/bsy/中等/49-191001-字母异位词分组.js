// 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

// 示例:

// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
// 输出:
// [
//   ["ate","eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// 说明：

// 所有输入均为小写字母。
// 不考虑答案输出的顺序。

/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    let str = []
    for(let i = 0; i<strs.length; i++){
      let num = []
      let a = strs[i]
      strs.splice(i,1)
      i--
      num.push(a)
      for(let j = 0; j<strs.length; j++){
        if(isAnagram(a,strs[j])){
          num.push(strs[j])
          strs.splice(j,1)
          j--
        }
      }
      str.push(num)
    }
  return str
};
var isAnagram = function(s, t) {
    var len=s.length
    for(var i=0;i<len;i++){
        if(s==t || s=='' || t=='' || s.length != t.length) break;
        t=t.replace(new RegExp(s[0],'g'),"");        
        s=s.replace(new RegExp(s[0],'g'),"");
    }
    return s==t? true:false;
}
