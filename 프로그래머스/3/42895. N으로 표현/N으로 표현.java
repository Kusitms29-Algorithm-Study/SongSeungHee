class Solution {
    static int result = Integer.MAX_VALUE;
    public int solution(int N, int number) {
        dfs(0,0,N,number);
        if(result == Integer.MAX_VALUE) {
            result = -1;
        }
        return result;
    }
    static void dfs(int depth, int sum ,int N, int number) {
        if(depth<9) {
            if(sum == number) {
                result = Math.min(result, depth);
            }
        } if(depth > 8) {
            return;
        }
        int temp = 0;
        for(int i=1; i<9; i++) {
            temp = temp * 10 + N;
            dfs(depth+i, sum + temp, N, number);
            dfs(depth+i, sum - temp, N, number);
            dfs(depth+i, sum * temp, N, number);
            dfs(depth+i, sum / temp, N, number);
        }
    }
}