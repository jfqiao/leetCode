/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters.

*/

class Solution {
public:
    int firstUniqChar(string s) {
     if(s.length()==1)return 0;
     int array[26];
     int pos[26];
     for(int i=0;i<26;i++){
         array[i]=0;
         pos[i]=-1;
     }
     for(int i=0;i<s.length();i++){
         pos[s[i]-97]=i;
         (array[s[i]-97])++;
     }
     int min=-1,position=0,result=-1;
     while(position<26){
        if(array[position]==1){
            if(min==-1){
                min=pos[position];
                result=position;
            }
            if(min>pos[position]){
                min=pos[position];
                result=position;
            }
        }
        position++;
     }
     result+=97;
     for(int i=0;i<s.length();i++){
         if(s[i]==result)return i;
     }
     return -1;
    }
};
