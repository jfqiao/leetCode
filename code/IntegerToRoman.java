package code;
/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

Subscribe to see which companies asked this question
*/

public class IntegerToRoman {
    //罗马数字基本字符有七�?: I V X L C D M 分别�?: 1 5 10 50 100 500 1000
    public String intToRoman(int num) {
        String result = "";
        while (num >= 1000) {
            result += "M";
            num -= 1000;
        }
        if (num >= 900) {
            result += "CM";
            num -= 900;
        }
        else if (num >= 500) {
            result += "D";
            num -= 500;
        }
        else if (num >= 400) {
            result += "CD";
            num -= 400;
        }
        while (num >= 100) {
            result += "C";
            num -= 100;
        }
        if (num >= 90) {
            result += "XC";
            num -= 90;
        }
        else if (num >= 50) {
            result += "L";
            num -= 50;
        }
        else if (num >= 40) {
            result += "XL";
            num -= 40;
        }
        while (num >= 10) {
            result += "X";
            num -= 10;
        }
        if (num >= 9) {
            result += "IX";
            num -= 9;
        }
        else if (num >= 5) {
            result += "V";
            num -= 5;
        }
        else if (num >= 4) {
            result += "IV";
            num -= 4;
        }
        while (num >= 1) {
            result += "I";
            num -= 1;
        }
        return result;
    }
}
