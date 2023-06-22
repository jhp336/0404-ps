class Solution {
    public int[] solution(String[] wallpaper) {
        int h = wallpaper.length;
        int w = wallpaper[0].length();
        char[][] map = new char[h][w];
        int sr=Integer.MAX_VALUE,sc=Integer.MAX_VALUE,er=0,ec=0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                map[i][j] = wallpaper[i].charAt(j);
                if(map[i][j] == '#'){        
                    sr = Math.min(sr,i);
                    sc = Math.min(sc,j);
                    er = Math.max(er,i);
                    ec = Math.max(ec,j);
                }
            }
        }
      
        int[] answer = {sr,sc,er+1,ec+1};
        return answer;
    }
}
