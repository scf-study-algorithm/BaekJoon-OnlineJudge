package BOJ;
//https://www.acmicpc.net/problem/10825
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*국어 점수가 감소하는 순서로
        국어 점수가 같으면 영어 점수가 증가하는 순서로
        국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
        모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)*/

public class BOJ_10825 {
    public static void main(String[] args) throws IOException {
        //scanner로 하면 실행 불가 (초과)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] map = new String[N][4];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split(" ");
        }

        Arrays.sort(map, new Comparator<String[]>() {
            @Override
            public int compare(String[] e1, String[] e2) {
                if(Integer.parseInt(e1[1]) == Integer.parseInt(e2[1])) {
                    if(Integer.parseInt(e1[2]) == Integer.parseInt(e2[2])){
                        if((Integer.parseInt(e1[3]) == Integer.parseInt(e2[3]))){

                            //국영수 점수가 같을 때
                            return e1[0].compareTo(e2[0]);
                        }
                        //국영이 같고 수학점수가 다를 때 수학점수 기준 내림차순
                        return Integer.compare(Integer.parseInt(e2[3]), Integer.parseInt(e1[3]));
                    }

                    //국어가 같을 때 영어 오름차순
                    return Integer.compare(Integer.parseInt(e1[2]), Integer.parseInt(e2[2]));
                }
                //국어점수 내림차순
                return Integer.compare(Integer.parseInt(e2[1]), Integer.parseInt(e1[1]));
            //});
            }
        });

       for(int i=0; i<N; i++){
           System.out.println(map[i][0]);
       }
    }
}
