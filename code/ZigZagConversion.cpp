//problem describe
/*
6. ZigZag Conversion  QuestionEditorial Solution  My Submissions
Total Accepted: 110371
Total Submissions: 436190
Difficulty: Easy
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
class Solution {
public:
    string convert(string s, int numRows) {
    if(numRows==1)return s;
    string result="";
    long len=s.length();
    //i表示行， j表示列
    for(int i=0;i<numRows;i++)
    {
        int j=i;
        if(i==0||i==numRows-1)
        {
            while(j<len)
            {
                result+=s[j];
                j+=2*numRows-2;
            }
        }
        else
        {
            while(j<len)
            {
                result+=s[j];
                int diff=(numRows-i-1)*2;
                if(j+diff<len)
                    result+=s[j+diff];
                j+=2*numRows-2;
            }
        }
    }
    return result;
    }
};
