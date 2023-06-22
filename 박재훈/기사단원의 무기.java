class Solution {
    public int solution(int number, int limit, int power) {
        int[] dp = new int[number+1];
      //1부터 자신의 배수들의 숫자를 1씩 늘려줌
        for(int i = 1; i <= number; i++){
          //number보다 작은 배수 찾는 과정
            for(int j = 1; i*j <= number; j++){
                dp[i*j]++;
            }
        }
        int answer = 0;
        for(int i = 1; i <= number; i++){
            if(dp[i] > limit){
                answer += power;
            }else{
                answer += dp[i];
            }
        }
        return answer;
    }
}
