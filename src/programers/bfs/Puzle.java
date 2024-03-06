package programers.bfs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Puzle {

    static int[][] game_board = {
            {1,1,0,0,1,0},
            {0,0,1,0,1,0},
            {0,1,1,0,0,1},
            {1,1,0,1,1,1},
            {1,0,0,0,1,0},
            {0,1,1,1,0,0}};

    static int[][] table = {
            {1,0,0,1,1,0},
            {1,0,1,0,1,0},
            {0,1,1,0,1,1},
            {0,0,1,0,0,0},
            {1,1,0,1,1,0},
            {0,1,0,0,0,0}};

    static int[][] game_board1 = {
            {0,0,0},
            {1,1,0},
            {1,1,1}
};

    static int[][] table1 = {
            {1,1,1},
            {1,0,0},
            {0,0,0}
};
    public static void main(String[] args) {
        Puzle puzle = new Puzle();

        System.out.println(puzle.solution(game_board, table));
    }
    final int[] rowArr= {0, 1, 0, -1};
    final int[] colArr= {1, 0, -1, 0};
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        int row = game_board.length;
        int col = game_board[0].length;

        boolean[][] visitBoard = new boolean[row][col];
        boolean[][] visitTable = new boolean[row][col];

        List<Figure> boardList = new ArrayList<>();
        List<Figure> tableList = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int z = 0; z < col; z++) {
                if (!visitBoard[i][z] && game_board[i][z] != 1) {
                    boardList.add(BFS(i, z, game_board, visitBoard,1));
                }

                if (!visitTable[i][z] && table[i][z] != 0) {
                    tableList.add(BFS(i, z, table, visitTable,0));
                }
            }
        }

        for (int i=0;i<boardList.size();i++) {
            Figure boardFigure = boardList.get(i);
            end:for (int z=0;z<tableList.size();z++) {
                Figure tableFigure = tableList.get(z);
                if (boardFigure.blockCnt == tableFigure.blockCnt && isSameFigure(boardFigure, tableFigure)) {
                    answer += boardFigure.blockCnt;
                    tableList.remove(z);
                    break end;
                }
            }
        }
        return answer;
    }

    private Figure BFS(int row, int col, int[][] board, boolean[][] visit,int gb) {
        List<Block> blockList = new ArrayList<>();
        Queue<Block> que = new LinkedList<>();
        int minRow = row;
        int minCol = col;
        int maxRow = row+1;
        int maxCol = col+1;

        que.add(new Block(col, row));
        visit[row][col] = true;

        while (!que.isEmpty()) {
            Block block = que.poll();
            blockList.add(block);

            for (int i = 0; i < 4; i++) {
                row = block.row + rowArr[i];
                col = block.col + colArr[i];
                if (row < visit.length && col< visit.length && row>-1 && col>-1 && !visit[row][col] && board[row][col] != gb) {
                    que.add(new Block(col, row));
                    minRow = Math.min(minRow, row);
                    minCol = Math.min(minCol, col);
                    maxRow = Math.max(maxRow, row+1);
                    maxCol = Math.max(maxCol, col+1);
                    visit[row][col] = true;
                }
            }
        }

        int[][] figure = new int[maxRow - minRow][maxCol - minCol];
        for (Block block : blockList) {
            int initRow = block.row - minRow;
            int initCol = block.col - minCol;
            figure[initRow][initCol] = 1;
            block.row = initRow;
            block.col = initCol;
        }
        return new Figure(blockList.size(), figure, blockList, maxRow - minRow, maxCol - minCol, minRow, minCol);
    }
    private boolean isSameFigure(Figure boardA, Figure boardB) {
        for (int i = 0; i < 4; i++) {
            if (Arrays.deepEquals(boardA.figure, boardB.figure)) {
                return true;
            }
            boardB.figure = lotation(boardB);
        }
        return false;
    }

    private int[][] lotation(Figure figures){
        int len = Math.max(figures.maxcol, figures.maxRow);

        if (figures.maxcol > figures.maxRow) {
            len = figures.maxRow;
        }

        if (figures.maxcol!=figures.maxRow) {
            int temp = figures.maxRow;
            figures.maxRow = figures.maxcol;
            figures.maxcol = temp;
        }


        for (Block block : figures.blockList) {
            int lotCol = len - block.row - 1;
            block.row = block.col;
            block.col = lotCol;
            figures.minRow = Math.min(figures.minRow, block.row);
            figures.minCol = Math.min(figures.minCol, block.col);
        }

        int[][] figure = new int[figures.maxRow][figures.maxcol];
        for (Block block : figures.blockList) {
            int initRow = block.row - figures.minRow;
            int initCol = block.col - figures.minCol;
            figure[initRow][initCol] = 1;
        }
        return figure;
    }
    static class Block{
        int col;
        int row;

        public Block(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }

    static class Figure{
        int blockCnt = 0;
        int[][] figure;
        List<Block> blockList;
        int maxRow = 0;
        int maxcol = 0;
        int minRow = 0;
        int minCol = 0;

        public Figure(int blockCnt, int[][] figure, List<Block> blockList, int maxRow,
                int maxcol, int minRow, int minCol) {
            this.blockCnt = blockCnt;
            this.figure = figure;
            this.blockList = blockList;
            this.maxRow = maxRow;
            this.maxcol = maxcol;
            this.minRow = minRow;
            this.minCol = minCol;
        }
    }
}
