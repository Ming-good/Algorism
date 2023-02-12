package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 체스판 다시 칠하기 2시간 */
public class Main12 {

	static int cnt = 0;
	static int min = 99999999;
	
	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sizeStr = br.readLine();
		String[] sizeArr = sizeStr.split(" ");
		int N = Integer.parseInt(sizeArr[0]);
		int M = Integer.parseInt(sizeArr[1]);
		
		char[][] board = new char[N][M];
		char[] bw = new char[2];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			
			for(int z=0;z<M;z++) {
				board[i][z] = str.charAt(z);
			}
		}
		
		for(int i=0; i<N-7;i++) {
			for(int z=0;z<M-7;z++) {
				initBw(bw, 'B');
				checkBoard(z, 8+z, i, 8+i, board, bw);
				initCnt();
				
				initBw(bw, 'W');
				checkBoard(z, 8+z, i, 8+i, board, bw);
				initCnt();				
			}
		}
		
		System.out.println(min);
	}
	
	private static void checkBoard(int sx, int ex, int sy, int ey, char[][] board, char[] bw) {
		
		for(int i=sy; i<ey;i++ ) {
			changeBW(bw, 0);
			
			for(int z=sx; z<ex;z++) {
				countBW(bw[1], board[i][z]);
				changeBW(bw, 1);
			}
			bw[1] = bw[0];
		}
		min = Math.min(cnt, min);
	}
	
	private static void initBw(char[] bw, char ch) {
		bw[0] = ch;
		bw[1] = ch;
	}

	private static void changeBW(char[] bw, int i) {
		if(bw[i] == 'B') {
			bw[i] = 'W';
			return;
		}
		
		if(bw[i] == 'W') {
			bw[i] = 'B';
			return;
		}
	}
	
	private static void countBW(char bwCh, char boardCh) {
		if(bwCh != boardCh) 
			cnt++;
	}
	
	private static void initCnt() {
		cnt = 0;
	}
}
