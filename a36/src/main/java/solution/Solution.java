package solution;

import java.util.HashSet;

/**
 * @author Zeluo
 * @date 2019/9/3 9:11
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !col.add(board[j][i]))
                    return false;
                int rowIndex = 3 * (i/3) + j/3;
                int colIndex = 3 * (i%3) + j%3;
                if (board[rowIndex][colIndex] != '.' && !cube.add(board[rowIndex][colIndex]))
                    return false;
            }
        }
        return true;
    }
}
