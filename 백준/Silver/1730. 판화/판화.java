import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		char [][] board = new char[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				board[i][j] = '.';
			}
		} // 목판 초기화 완료 
		char[] arr = br.readLine().toCharArray();
		int startr = 0;
		int startc = 0;
		//경로의 흔적을 남기기 위해 
		boolean[][] passVertical = new boolean[N][N];
		boolean[][] passHorizontal = new boolean[N][N];
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 'D') {
				if(startr == N-1) continue; //범위밖이므로 무시한다 
				passVertical[startr][startc] = passVertical[startr+1][startc] = true;
				startr++;
			} else if(arr[i] == 'U') {
				if(startr ==0) continue; 
				passVertical[startr][startc] = passVertical[startr-1][startc] = true;
				startr--;
			}
			else if(arr[i] == 'L') {
				if(startc ==0) continue;
				passHorizontal[startr][startc] = passHorizontal[startr][startc-1] = true;
				startc--;
			} else {
				if(startc ==N-1) continue;
				passHorizontal[startr][startc] = passHorizontal[startr][startc+1] = true;
				startc++;
			}
		}
		for(int i=0; i<N; i++) {
		
			for(int j=0; j<N; j++) {
				if(passVertical[i][j] && passHorizontal[i][j]) {
					board[i][j] = '+';
					System.out.print(board[i][j]);
				} else if(passVertical[i][j]) {
					board[i][j] = '|';
					System.out.print(board[i][j]);
				}
				else if(passHorizontal[i][j]) {
					board[i][j] = '-';
					System.out.print(board[i][j]);
				} else {
					System.out.print(board[i][j]);
				}
			}
			System.out.println();
		}
	}
 
}
 	