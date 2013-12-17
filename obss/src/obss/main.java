import java.io.BufferedInputStream;
import java.util.Scanner;

public class main {

    static char maze[][];
    static int max, result, N;

    public static boolean placeable(int i, int j) {
        if (maze[i][j] == 'X')
            return false;
        int k=j;
        while (k >= 0 && maze[i][k] != 'X') {
            if (maze[i][k--] == '*')
                return false;
        }
        k=i;
        while (k >= 0 && maze[k][j] != 'X') {
            if (maze[k--][j] == '*')
                return false;
        }
        return true;
    }

    public static void DFS(int i, int j, int max) {
        if ((i==N-1&&j==N)||(i==N&&j==N-1)) {
            result = max > result ? max : result;
            return;
        } else if (i < N && j < N && placeable(i, j)) {
            maze[i][j] = '*';
            if (j == N - 1) {
                DFS(i + 1, 0, max + 1);
            } else {
                DFS(i, j + 1, max + 1);
            }
            maze[i][j] = '.';
        }
        if (j == N - 1) {
            DFS(i + 1, 0, max);
        } else {
            DFS(i, j + 1, max);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(new BufferedInputStream(System.in));

        while (cin.hasNext()) {
            N = cin.nextInt();
            if (N == 0)  return;
            max = 0;
            result = 0;
            maze = new char[N][N];
            String str;
            for (int i = 0; i < N; i++) {
                str = cin.next();
                for (int j = 0; j < N; j++) {
                    maze[i][j] = str.charAt(j);
                }
            }

            DFS(0, 0, 0);
            System.out.println(result);

        }

    }
}