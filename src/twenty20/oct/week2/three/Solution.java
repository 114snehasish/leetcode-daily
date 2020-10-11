package twenty20.oct.week2.three;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //[[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]
        //[[0,9],[1,8],[7,8],[1,6],[9,16],[7,13],[7,10],[6,11],[6,9],[9,13]]
        //int[][] balloons = new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        //int[][] balloons = new int[][]{{0, 9}, {1, 8}, {7, 8}, {1, 6}, {9, 16}, {7, 13}, {7, 10}, {6, 11}, {6, 9}, {9, 13}};
        //int[][] balloons = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        //[[-2147483646,-2147483645],[2147483646,2147483647]]
        int[][] balloons = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
        //int[][] balloons = new int[][]{{-2, -1}, {1, 2}};
        //int[][] balloons = new int[][]{{1, 2}};
        //int[][] balloons = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        //int[][] balloons = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(solution.findMinArrowShots(balloons));
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        else {
            points=sort(points);
            //Arrays.sort(points, (a, b) -> a[1] - b[1]);
            int arrowPos = points[0][1];
            int arrowCnt = 1;
            for (int i = 1; i < points.length; i++) {
                if (arrowPos >= points[i][0]) {
                    continue;
                }
                arrowCnt++;
                arrowPos = points[i][1];
            }
            return arrowCnt;
        }
    }

    private int[][] sort(int[][] points) {
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][1] > points[j][1]) {
                    int temp0 = points[i][0];
                    int temp1 = points[i][1];
                    points[i][0] = points[j][0];
                    points[i][1] = points[j][1];
                    points[j][0] = temp0;
                    points[j][1] = temp1;
                }
            }
        }
        return points;
    }
}
