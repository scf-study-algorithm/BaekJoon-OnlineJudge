package BOJ;
//https://www.acmicpc.net/problem/15649
import java.util.*;

public class BOJ_15649 {
    public static int[] arr;
    public static boolean[] visit;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        arr = new int[M];
        visit = new boolean[N];

        dfs(N,M,0);


    }

    public static void dfs(int N, int M, int depth){
        // 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
        if (depth == M) {
            for(int num : arr) System.out.print(num + " ");
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {

            // 만약 해당 노드(값)을 방문하지 않았다면?
            if (visit[i] == false) {

                visit[i] = true;		// 해당 노드를 방문상태로 변경
                arr[depth] = i + 1;		// 해당 깊이를 index로 하여 i + 1 값 저장
                dfs(N, M, depth + 1);	// 다음 자식 노드 방문을 위해 depth 1 증가시키면서 재귀호출

                // 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
                visit[i] = false;
            }
        }
        return;


    }
}
