import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int[][] board1;
	static int cnt=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		board1 = new int[5][5];
		int[][] board2 = new int[5][5];
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				board1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				find(Integer.parseInt(st.nextToken()));
				cnt++;
				if(valid() >= 3) {
					answer = cnt;
					break;
				}
				
			}
			if(answer != 0) {
				break;
			}
		}
		
		System.out.println(cnt);
	}	
	
	static void find(int a) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(board1[i][j] == a) {
					board1[i][j] = 0;
				}
			}
		}
	}
	
	static int valid() {
		int line=0;
		int cnt1=0, cnt2 = 0;
		for(int i=0; i<5; i++) {
			cnt1 += board1[i][i];
			cnt2 += board1[i][4-i];
		}
		if(cnt1 == 0) line++;
		if(cnt2 == 0) line++;
		
		//행과열 검사 
		for(int i=0; i<5; i++) {
			int cnt3 = 0;
			int cnt4=0;
			for(int j=0; j<5; j++) {
				if(board1[i][j] == 0) cnt3++;
				if(board1[j][i] == 0) cnt4++;
			}
			if(cnt3 == 5) line++;
			if(cnt4==5) line++;
		}
		return line;
	}
}