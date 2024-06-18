import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        LinkedList<int[]> list = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            list.offer(new int[] {i, priorities[i]});
        }
        int cnt =0;
        while(!list.isEmpty()) {
            int max = 0;
            int maxidx = 0;
            for(int i=0; i<list.size(); i++) {
                if(max < list.get(i)[1]) {
                    max = list.get(i)[1];
                    maxidx = i;
                }
            }
            for(int i=0; i<maxidx; i++) {
                list.offer(list.poll());
            }
            int idx = list.poll()[0];
            cnt++;
            if(idx == location) {
                break;
            }
        }
        return cnt;
    }
}