package com.zhangyu.leetcoderecord.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Function: 37. 解数独
 *
 * @author zhangyu
 * Date: 2020/10/21 15:06
 * @since JDK 1.8
 */
public class Solution0037 {

    public static void main(String[] args) {
        Solution0037 solution = new Solution0037();
        char[][] sudoku = new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solution.solveSudoku(sudoku);
        Stream.of(sudoku).forEach(x -> System.out.println(Arrays.toString(x)));
    }

    private boolean[][] rows = new boolean[9][9];
    private boolean[][] columns = new boolean[9][9];
    private boolean[][][] blocks = new boolean[3][3][9];
    private List<int[]> spaces = new ArrayList<>();
    boolean valid = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.'){
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '1';
                    rows[i][digit] = columns[j][digit] = blocks[i/3][j/3][digit] = true;
                }
            }
        }
        solveSudoku(board, 0);
    }

    private void solveSudoku(char[][] board, int position) {
        if (position == spaces.size()){
            valid = true;
            return;
        }
        int[] space = spaces.get(position);
        int x = space[0];
        int y = space[1];
        for (int i = 0; i < 9 && !valid; i++) {
            if (! rows[x][i] && ! columns[y][i] && ! blocks[x/3][y/3][i]){
                rows[x][i] = columns[y][i] = blocks[x/3][y/3][i] = true;
                board[x][y] = (char) (i + '1');
                solveSudoku(board, position + 1);
                rows[x][i] = columns[y][i] = blocks[x/3][y/3][i] = false;
            }
        }
    }
}
