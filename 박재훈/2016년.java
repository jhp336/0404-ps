class Solution {
    public String solution(int a, int b) {
      //누적 일수 구하기
        int day = 0;
        for(int i = 1; i < a; i++){
            day += convertMonth(i);
        }
        day += b;
        
        String answer = "";
        switch(day % 7){
            case 1:
                answer = "FRI";
                break;
            case 2:
                answer = "SAT";
                break;
            case 3:
                answer = "SUN";
                break;
            case 4:
                answer = "MON";
                break;
            case 5:
                answer = "TUE";
                break;
            case 6:
                answer = "WED";
                break;
            case 0:
                answer = "THU";
                break;
        }
        return answer;
    }
    static int convertMonth(int month){
        if(month <= 7){
            if(month % 2 == 0){
                if(month == 2){
                    return 29;
                }
                return 30;
            }
            return 31;
        }
        
        if(month % 2 == 0){
            return 31;
        }
        return 30;
    }
}
