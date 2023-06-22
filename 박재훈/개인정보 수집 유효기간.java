import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int tSize = terms.length;
        HashMap<String, Integer> map = new HashMap<>();
      //약관 종류를 키로, 유효기간을 값으로 하는 hashmap
        for(int i = 0; i < tSize; i++){
            String[] input = terms[i].split(" ");
            map.put(input[0], Integer.parseInt(input[1]));
        }
        
        List<Integer> list = new ArrayList<>();
        int pSize = privacies.length;
        for(int i = 0; i < pSize; i++){
            String[] input = privacies[i].split(" ");
            String[] date = input[0].split("\\.");

          //수집일자에서 연도, 월 가져오기
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);

          //약관 종류에 따라 유효기간 가져오기
            int term = map.get(input[1]);
            month += term;
          //기존 월에 기간 더해서 12보다 크면 year와 month 추가 처리 
            if(month > 12){
                year += month/12;
                month = month%12;
                if(month == 0){
                    month = 12;
                    year--;
                }
            }
            String sMonth;
            if(month < 10){
                sMonth = '0'+Integer.toString(month);
            }else{
                sMonth = Integer.toString(month);
            }
            String lastDate = Integer.toString(year)+'.'+ sMonth+'.'+date[2];
            if(lastDate.compareTo(today) <= 0){
                list.add(i+1);
            }
        }
        int size = list.size();
        int[] answer = new int[size];
        for(int i = 0; i < size; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
