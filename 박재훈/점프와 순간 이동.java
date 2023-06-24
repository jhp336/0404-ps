public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n > 0){
          //순간이동에는 건전지 안달음 -> 최대한 사용
            if(n % 2 == 0){
                n /= 2;
            }else{
                n--;
                ans++;
            }
            
        }
        return ans;
    }
}
