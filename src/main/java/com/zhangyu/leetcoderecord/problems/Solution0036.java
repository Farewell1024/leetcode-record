package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 36. 有效的数独
 *
 * @author zhangyu
 * Date: 2020/10/21 14:35
 * @since JDK 1.8
 */
public class Solution0036 {

    public static void main(String[] args) {
        Solution0036 solution = new Solution0036();
        System.out.println(solution.isValidSudoku(new char[][]{
                        new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }
        ));
    }

    private int[] rows = new int[9];
    private int[] columns = new int[9];
    private int[][] blocks = new int[3][3];

    /**
     * 	36 有效的数独
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int digit = rows[i] | columns[j] | blocks[i/3][j/3];
                if (board[i][j] != '.'){
                    if (((digit >> (board[i][j]-'1'))&1)==1){
                        return false;
                    } else {
                        rows[i] |= (1 << (board[i][j] -'1'));
                        columns[j] |= (1 << (board[i][j] -'1'));
                        blocks[i/3][j/3] |= (1 << (board[i][j] -'1'));
                    }
                }
            }
        }
        return true;
    }

}
