package java_5_15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/cf24906056f4488c9ddb132f317e03bc?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：
     *
     *
     * int maze[5][5] = {
     * 0, 1, 0, 0, 0,
     * 0, 1, 0, 1, 0,
     * 0, 0, 0, 0, 0,
     * 0, 1, 1, 1, 0,
     * 0, 0, 0, 1, 0,
     * };
     *
     *
     * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。
     *
     *
     * 本题含有多组数据。
     *
     *
     * 输入描述:
     * 输入两个整数，分别表示二位数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
     *
     *
     *
     * 输出描述:
     * 左上角到右下角的最短路径，格式如样例所示。
     *
     * 示例1
     * 输入
     * 5 5
     * 0 1 0 0 0
     * 0 1 0 1 0
     * 0 0 0 0 0
     * 0 1 1 1 0
     * 0 0 0 1 0
     * 输出
     * (0,0)
     * (1,0)
     * (2,0)
     * (2,1)
     * (2,2)
     * (2,3)
     * (2,4)
     * (3,4)
     * (4,4)
     */

    public static int[][] directions = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };
    private static Stack<int[]> path;
    private static ArrayList<int[]> minPath;
    private static int[][] matrix;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = null;
        while ((str1 = br.readLine()) != null) {
            String[] arr = str1.split(" ");
            int rows = Integer.parseInt(arr[0]);
            int cols = Integer.parseInt(arr[1]);
            path = new Stack<>();
            minPath = null;
            matrix = new int[rows][cols];
            visited = new boolean[rows][cols];
            for (int i = 0; i < rows; i++) {
                String[] str2 = br.readLine().split(" ");
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = Integer.parseInt(str2[j]);
                }
            }
            dfs(0, 0);

            StringBuilder sb = new StringBuilder();
            for (int[] res : minPath) {
                sb.append('(').append(res[0]).append(',').append(res[1]).append(")\n");
            }
            System.out.print(sb.toString());
        }
    }

    private static void dfs(int i, int j) {
        if (i > matrix.length - 1 || i < 0 || j > matrix[0].length - 1 || j < 0 ||
                visited[i][j] || matrix[i][j] == 1 ||
                (minPath != null && path.size() >= minPath.size())) {
            return;
        }
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            path.add(new int[]{i, j});
            minPath = new ArrayList<>(path);
            path.pop();
            return;
        }
        path.add(new int[]{i, j});
        visited[i][j] = true;
        for (int[] direction : directions) {
            dfs(i + direction[0], j + direction[1]);
        }
        visited[i][j] = false;
        path.pop();
    }
}