import java.util.*;
import java.io.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> participantMap = new HashMap<>();
        for(int i=0; i<participant.length; i++) {
            participantMap.put(participant[i], participantMap.getOrDefault(participant[i], 0) +1);
        }
        for(int i=0; i<completion.length; i++) {
            participantMap.put(completion[i], participantMap.get(completion[i])-1);
        }
        String a = "";
        //map을 검사하여 value 값이 0이 아닌 key값 반환
        for(String key: participantMap.keySet()) {
            if(participantMap.get(key) != 0) {
                a = key;
            }
        }
        return a;
    }
}