package solution;

/**
 * @author Zed
 * @date 2020/2/23 下午12:33
 * @contact shadowl91@163.com
 */
public class Solution {
    public void rotate(int[][] matrix) {

        int length = matrix.length - 1;
        int temp = 0;
        for (int i = 0; i <= length / 2; i++) {
            for (int j = i; j < length - i; j++) {
                temp = matrix[j][length - i];
                matrix[j][length - i] = matrix[i][j];
                matrix[i][j] = matrix[length - j][i];
                matrix[length - j][i] = matrix[length - i][length - j];
                matrix[length - i][length - j] = temp;
            }
        }
    }


}
