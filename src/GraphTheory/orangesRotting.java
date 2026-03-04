package GraphTheory;

import java.util.*;

public class orangesRotting {

    public static int orangesRotting(int[][] grid) {
        Queue<int[]> que= new LinkedList<>();
        int res = 0;
        int cnt = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) cnt++;
                if(grid[i][j] == 2) que.offer(new int[]{i, j});
            }
        }
        while(cnt > 0 && !que.isEmpty()) {
            int n = que.size();;
            res++;
            while (n-- > 0) {
                int[] tmp = que.poll();
                int r = tmp[0];
                int c = tmp[1];

                if(r + 1 < grid.length && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    cnt--;
                    que.offer(new int[]{r + 1, c});
                }
                if(r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    cnt--;
                    que.offer(new int[]{r - 1, c});
                }
                if(c + 1 < grid[0].length && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    cnt--;
                    que.offer(new int[]{r, c + 1});
                }
                if(c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    cnt--;
                    que.offer(new int[]{r, c - 1});
                }
            }
        }
        return cnt > 0 ? -1 : res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.print(orangesRotting(grid));
    }
}
