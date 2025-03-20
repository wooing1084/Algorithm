import java.io.*;
class Main {
	static int H1, W1;
	static int H2, W2;
	static String[][] map1;
	static String[][] map2;
	static int coinCnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line1 = br.readLine().split(" ");
		H1 = Integer.parseInt(line1[0]);
		W1 = Integer.parseInt(line1[1]);
		map1 = new String[H1][W1];
		for(int i = 0; i < H1; i++){
			String[] l = br.readLine().split("");
			for(int j = 0; j < W1; j++){
				map1[i][j] = l[j];
				if(map1[i][j].equals("O"))
					coinCnt++;
			}
		}
		
		String[] line2 = br.readLine().split(" ");
		H2 = Integer.parseInt(line2[0]);
		W2 = Integer.parseInt(line2[1]);
		map2 = new String[H2][W2];
		for(int i = 0; i < H2; i++){
			String[] l = br.readLine().split("");
			for(int j = 0; j < W2; j++){
				map2[i][j] = l[j];
			}
		}

		int maxCnt = 0;
		for(int i = H1 * -1; i <= H1; i++){
			for(int j = W1 * -1; j <= W1; j++){
				int cnt = check(j, i);
				if(cnt > maxCnt)
					maxCnt = cnt;
			}
		}

		for(int i = H2 * -1; i <= H2; i++){
			for(int j = W2 * -1; j <= W2; j++){
				int cnt = check(j, i);
				if(cnt > maxCnt)
					maxCnt = cnt;
			}
		}

		System.out.println(coinCnt - maxCnt);
	}

	static int check(int diffX, int diffY){
		int cnt = 0;
		for (int i = 0; i < H1; i++){
			for(int j = 0; j < W1; j++){
				int newX = j + diffX;
				int newY = i + diffY;
				if(newX < 0 || newX >= W2 || newY < 0 || newY >= H2)
					continue;
				if(map1[i][j].equals("O") && map2[newY][newX].equals("O"))
					cnt++;
			}
		}

		return cnt;
	}
}