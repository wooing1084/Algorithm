import java.io.*;
import java.util.*;

class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Main {
	static int[][] sumArr = new int[1000001][2];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Point[] points = new Point[n];
		for(int i = 0; i < n; i++){
			String[] line = br.readLine().split(" ");
			points[i] = new Point(Integer.parseInt(line[0]) + 500000, Integer.parseInt(line[1]) + 500000);
		}

		for(int i = 1; i < n; i++){
			if(points[i - 1].x == points[i].x)
				line(points[i - 1].y, points[i].y, 0);
			else
				line(points[i - 1].x, points[i].x, 1);
		}

		if(points[0].x == points[n - 1].x)
				line(points[0].y, points[n - 1].y, 0);
		else
				line(points[0].x, points[n - 1].x, 1);

		int answer = Integer.MIN_VALUE;
		for(int i = 0; i < 1000001; i++){
			answer = Math.max(answer, Math.max(sumArr[i][0], sumArr[i][1]));
		}
		
		System.out.println(answer);
	}

	static void line(int start, int end, int dim){
		int min = Math.min(start, end);
		int max = Math.max(start, end);
		for(int i = min; i < max; i++){
			sumArr[i][dim]++;
		}
	}
}