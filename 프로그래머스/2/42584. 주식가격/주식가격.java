class Solution {
    public int[] solution(int[] prices) {
        //prices.length=5
        int index = 0;
        int[] arr = new int[prices.length];
        while(true) {
            int searchIndex = index+1;
            while(true) {
                if(prices[index] > prices[searchIndex]) break;
                if(searchIndex == prices.length-1) break;
                searchIndex++;
            }
            arr[index] = searchIndex-index;
            index++;
            if(index == prices.length-1) break;
        }
        return arr;
    }
}