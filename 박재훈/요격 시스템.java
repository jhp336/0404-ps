import java.util.*;
class Solution {
    public int solution(int[][] targets) {
      //(s,e)에서 s기준으로 오름차순 정렬
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        
        int answer = 0;
        int size = targets.length;
        int left = targets[0][0], right = targets[0][1];
        for(int i = 1; i < size; i++){
          //i번째 미사일의 범위가 기존 미사일로 요격 가능한 경우(left ~ right 범위와 겹치는 경우) 
            if(right > targets[i][0]){
                left = targets[i][0];
                right = Math.min(right, targets[i][1]);
            }else{// 새로운 미사일 필요
                answer++;
                left = targets[i][0];
                right = targets[i][1];
            }
        }
        return ++answer;
    }
}
