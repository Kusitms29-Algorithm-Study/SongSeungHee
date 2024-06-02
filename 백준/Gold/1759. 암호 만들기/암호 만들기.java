import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int L;
	static int C;
	static char[] total;
	static char[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		StringTokenizer sr = new StringTokenizer(br.readLine(), " ");
		total = new char[C];
		result = new char[L];
		for(int i=0; i<C; i++) {
			total[i] = sr.nextToken().charAt(0);
		}
		//오름차순 정렬 
		Arrays.sort(total);
		dfs(0,0);
	}
	static void dfs(int depth, int start) {
		if(depth==L) {
			if(isValid(result)) {
				for(char c: result) {
					System.out.print(c);
				}
				System.out.println();
			}
			return;
		}
		for(int i=start; i<C; i++) {
			result[depth] = total[i];
			dfs(depth+1, i+1);
		}
	}
	
	static boolean isValid(char[] result) {
		int a  = 0; //자음 
		int b  = 0; //모음 
		for(int i=0; i<L; i++) {
			if(result[i] == 'a' || result[i] == 'e'|| result[i] == 'i' || result[i] == 'o' || result[i] == 'u') {
				b++;
			} else {
				a++;
			}
		}
		if(b>=1 && a>=2) {
			return true;
		} else {
			return false;
		}
	}
 
}