package code;
public class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    if (i < s.length() - 1) {
                        char tmp = s.charAt(i + 1);
                        if (tmp == 'V') {
                            result += 4;
                            i++;
                        }
                        else if (tmp == 'X') {
                            result += 9;
                            i++;
                        }
                        else
                            result += 1;
                    }
                    else
                        result += 1;
                    break;
                case 'V':
                        result += 5;
                    break;
                case 'X':
                    if (i < s.length() - 1) {
                        char tmp = s.charAt(i + 1);
                        if (tmp == 'L') {
                            result += 40;
                            i++;
                        }
                        else if (tmp == 'C') {
                            result += 90;
                            i++;
                        }
                        else
                            result += 10;
                    }
                    else
                        result += 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if (i < s.length() - 1) {
                        char tmp = s.charAt(i + 1);
                        if (tmp == 'D') {
                            result += 400;
                            i++;
                        }
                        else if (tmp == 'M') {
                            result += 900;
                            i++;
                        }
                        else
                            result += 100;

                    }
                    else
                        result += 100;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}
