import java.util.*;
import java.math.*;
class Solution {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int min=Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {   
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        //양방향 간선만들기
        for(int i=0; i<wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            list[a].add(b);
            list[b].add(a);
        }
        
        //모든 간선을 한번씩 끊어본다
        for(int i=0; i<wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            visited = new boolean[n+1];
            list[a].remove((Integer) b);
            list[b].remove((Integer) a);
            
            int cnt = dfs(1);
            int abs = Math.abs(cnt - (n-cnt));
            min = Math.min(min, abs);
            list[a].add(b);
            list[b].add(a);
        }
        return min;
    }
    
    static int dfs(int v) {
        visited[v] = true;
        int cnt = 1;
        for(int i: list[v]) {
            if(!visited[i]) {
                cnt += dfs(i);
            }
        }
        return cnt;
    }
}