import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int N;
	
	static void swapCandy(char[][] board, int row1, int row2, int col1, int col2) {
		char temp = board[row2][col2];
		board[row2][col2] = board[row1][col1];
		board[row1][col1] = temp;
	}
	static int findRow(char[][] board) {
		
		int max=0;
		for(int i=0; i<N; i++) {
			int len =1;
			for(int j=0; j<N-1; j++) {
				if(board[i][j] == board[i][j+1]) {
					len++;
					
				} else {
					max = Math.max(max, len);
					len=1;
					
				}
			}
			max = Math.max(max, len);
		}
		return max;
		
	}
	static int findCol(char[][] board) {
		
		int max=0;
		for(int j=0; j<N; j++) {
			int len=1;
			for(int i=0; i<N-1; i++) {
				if(board[i][j] == board[i+1][j]) {
					len++;
					
				} else {
					max = Math.max(max, len);
					len=1;
					
				}
			}
			max = Math.max(max, len);
		}
		
		return max;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] board = new char[N][N];
		
		int max=0;
		
		//보드 완성 
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(j<N-1&&board[i][j] != board[i][j+1]) {
					swapCandy(board,i,i, j, j+1);
					max = Math.max(max, Math.max(findRow(board), findCol(board)));
					swapCandy(board,i,i, j, j+1);
				}
				if(i<N-1 && board[i][j] != board[i+1][j]) {
					swapCandy(board, i,i+1, j, j);
					max = Math.max(max, Math.max(findRow(board), findCol(board)));
					swapCandy(board, i,i+1, j, j);
				}
				
			}
		
	}
		
		System.out.println(max);
	
	}
 
}