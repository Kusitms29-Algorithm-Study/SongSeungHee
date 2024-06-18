
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Queue<Integer> q = new LinkedList<>();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		while(q.size()>1) {
			q.poll();
			int k = q.poll();
			q.add(k);
		}
		System.out.println(q.peek());
	}
	

}