import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0, passBySkill = 0;
        int size = enemy.length;
      //스킬 사용 가능 횟수가 라운드 개수보다 많으면 무조건 다깸
        if(size <= k){
            answer = size;
        }else{
          //k번 만큼 pq에 저장
          //sum : 전체 적 수, passBySkill : 스킬 써서 막을 수 있는 적 수(적 제일 많은 3개의 라운드의 합)
            for(int i = 0;i < k;i++){
                sum += enemy[i];
                passBySkill += enemy[i];
                pq.add(enemy[i]);
                answer++;
            }
            for(int i = k; i < size; i++){
              //다음 라운드 적 수가 pq내 가장 적은 수보다 크면 다음 라운드에 스킬 쓰는 게 이득
                int min = pq.peek();
                if(min < enemy[i]){
                    pq.poll();
                    pq.add(enemy[i]);
                    passBySkill -= min;
                    passBySkill += enemy[i];
                }
                sum += enemy[i];
              //스킬을 다 써도 적을 다 못 막으면 반복문 종료
                if(sum - passBySkill > n){
                    break;
                }
                answer++;
            }
        }
        
        return answer;
    }
}
