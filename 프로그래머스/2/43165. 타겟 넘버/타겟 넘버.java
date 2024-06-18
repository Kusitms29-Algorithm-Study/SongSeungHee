import java.io.*;
import java.util.*;

class Solution {
    static int result;
    public int solution(int[] numbers, int target) {
        result =0;
        dfs(numbers, 0, target, 1);
        return result;
    }
    static void dfs(int[] numbers, int sum, int target, int depth) {
        if(depth==numbers.length+1) {
            if(sum == target) {
                result++;
            }
            return;
        }
        dfs(numbers, sum + numbers[depth-1], target, depth+1);
        dfs(numbers, sum - numbers[depth-1], target, depth+1);
    }
}