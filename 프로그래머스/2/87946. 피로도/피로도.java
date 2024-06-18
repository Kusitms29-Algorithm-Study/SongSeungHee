import java.util.*;

class Solution {
    static int count;
    static int max =0;
    static boolean visited[];
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(dungeons,  k,0);
        return max;
    }
    static void dfs(int[][] dungeons, int k, int count) {
            for(int i=0; i<dungeons.length; i++) {
                if(k >= dungeons[i][0] && !visited[i]) {
                    visited[i] = true;
                    dfs(dungeons, k-dungeons[i][1], count+1);
                    //백트랙킹을 하기위함
                    visited[i] = false;
                } 
            }     
         if (max < count) {
            max = count;
        }
    }
}