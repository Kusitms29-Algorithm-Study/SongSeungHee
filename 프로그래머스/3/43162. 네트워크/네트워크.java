import java.io.*;
import java.util.*;
class Solution {
    static int[] visited;
    static int cnt=0;

    static int row;
    static int col;
    public int solution(int n, int[][] computers) {
        visited = new int[n];
        for(int i = 0; i<n; i++) {
            if(visited[i] == 0) {
                bfs(i,n,computers);
                cnt++;
            }
            
        }
            return cnt;
    }
    static void bfs(int a, int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
            q.offer(a);
            visited[a] = 1;
            while(!q.isEmpty()) {
                int value = q.poll();
                for(int i =0; i<n; i++) {
                    if(computers[value][i] == 1 && visited[i] ==0) {
                            q.offer(i);
                            visited[i] = 1;
                        }
                }
            }
        
    }
}