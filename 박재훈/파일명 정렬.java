import java.util.*;
import java.math.BigInteger;
class Solution {
    static class File implements Comparable<File>{
        String head, number, tail;
        BigInteger numberBI;
        public File(String head, String number, String tail){
            this.head = head;
            this.number = number;
            BigInteger temp = new BigInteger(number);
            this.numberBI = temp;
            this.tail = tail;
        }
        
        public int compareTo(File o) {
            if(this.head.equalsIgnoreCase(o.head)){
                return this.numberBI.compareTo(o.numberBI);
            }
            return this.head.compareToIgnoreCase(o.head);
        }
    }
    public String[] solution(String[] files) {
        int size = files.length;
        String[] answer = new String[size];
        File[] sortFiles = new File[size];
        for(int i = 0; i < size; i++){
            String head="", number="", tail="";
            StringBuilder sb = new StringBuilder();
            String str = files[i];
            int len = str.length();
            boolean headCheck = false, numCheck = false;
            for(int j = 0; j < len; j++){
                char c =str.charAt(j);
              //이번에 탐색하는 문자가 숫자인데 아직 head 입력 안되었으면 지금까지 저장한걸 head에 넣기
                if(c>='0' && c<='9'){
                    if(!headCheck){
                        head = sb.toString();
                        headCheck = true;
                        sb.setLength(0);
                    }
                    sb.append(c);
                //이번에 탐색하는 문자가 숫자아님 아직 number 입력 안되었으면 지금까지 저장한걸 number에 넣기
                }else{
                    if(headCheck && !numCheck){
                        number = sb.toString();
                        numCheck = true;
                        sb.setLength(0);
                    }
                    sb.append(c);
                }
            }
          //아직 number가 입력 안됨 -> head + 숫자 로만 이루어져서 위 조건문에 안걸림 -> 한번더 처리
            if(!numCheck){
                number = sb.toString();
            }else{
              //남는건 tail에 저장
                tail = sb.toString();
            }
            sortFiles[i] = new File(head, number, tail);
        }
        Arrays.sort(sortFiles);
        for(int i = 0; i < size; i++){
            StringBuilder sb = new StringBuilder();
            File f = sortFiles[i];
            sb.append(f.head).append(f.number).append(f.tail);
            answer[i] = sb.toString();
        }
        return answer;
    }
}
