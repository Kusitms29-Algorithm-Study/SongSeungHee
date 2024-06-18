import java.io.*;
import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cnt = s.length();
        char[] arr = new char[s.length()];
        arr = s.toCharArray();
        Stack<Character> k = new Stack<>();
        int i=0;
        while(cnt-->0) {
            if(arr[i] == '(') {
               k.push('(');
           } else {
                if(k.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    k.pop();
                }
            }
            i++;
        }
        if(k.isEmpty() && answer == true) {
            return true;
        } else {
            return false;
        }
    }
}