import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, M, K;
    static long[] arr, tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        K = Integer.parseInt(line[2]);

        arr = new long[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // int h = (int)Math.ceil(Math.log(N) / Math.log(2)) + 1;
        // int treeSize = (int)Math.pow(2, h) - 1;
        tree = new long[4 * N];
        init(0, N - 1, 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M + K; i++){
            line = br.readLine().split(" ");

            // 바꾸기
            if(Integer.parseInt(line[0]) == 1){
                int idx = Integer.parseInt(line[1]) - 1;
                long value = Long.parseLong(line[2]);

                long diff = value - arr[idx];
                update(0, N - 1, 1, idx, diff);
                arr[idx] = value;
            }
            else{ // 합
                int l = Integer.parseInt(line[1]) - 1;
                int r = Integer.parseInt(line[2]) - 1;

                long s = sum(0, N - 1, 1, l, r);
                sb.append(s + "\n");
            }
        }

        System.out.println(sb.toString());
    }

    static long init(int s, int e, int idx){
        if(s == e) return tree[idx] = arr[s];
        int mid = (s + e) / 2;

        return tree[idx] = init(s, mid, idx * 2) + init(mid + 1, e, idx * 2 + 1);
    }

    static void update(int s, int e, int node, int idx, long diff){
        if(s <= idx && idx <= e){
            tree[node] += diff;
        } 
        else return;
        if(s == e) return;

        int mid = (s + e) / 2;
        update(s, mid, node * 2, idx, diff);
        update(mid + 1, e, node * 2 + 1, idx, diff);
    }

    static long sum(int s, int e, int node, int l, int r){
        if(r < s || l > e) return 0;
        if(l <= s && e <= r) return tree[node];

        int mid = (s + e) / 2;
        return sum(s, mid, node * 2, l, r) + sum(mid + 1, e, node * 2 + 1, l, r);
    }
}