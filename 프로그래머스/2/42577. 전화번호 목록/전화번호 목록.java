import java.io.*;
import java.util.*;
class Solution {
    //나 자신이 다른 문자에 대해 접두사로 쓰였으면 false를 저장 아니면 true
    
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> phoneMap = new HashMap<>();
        for(int i=0; i<phone_book.length; i++) {
            phoneMap.put(phone_book[i], i);
        }
        for(int i=0; i<phone_book.length; i++) {
            for(int j=0; j<phone_book[i].length(); j++) {
                if(phoneMap.containsKey(phone_book[i].substring(0,j))) {
                    return false;
                }
            }
        }
        return true;
    }
    
}