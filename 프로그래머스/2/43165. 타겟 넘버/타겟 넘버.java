class Solution {
    public int dfs(int[] numbers, int target, int idx, int sum){
        if(idx >= numbers.length){
            if(sum == target){
                return 1;
            }
            else {
                return 0;
            }
        }
        
        int result = 0;
        
        result += dfs(numbers, target, idx + 1, sum + numbers[idx]);
        result += dfs(numbers, target, idx + 1, sum - numbers[idx]);
        
        return result;
    }
    
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }
}