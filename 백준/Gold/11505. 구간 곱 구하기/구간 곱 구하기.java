import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, K, M;
    static long[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);
        M = Integer.parseInt(line[2]);

        arr = new long[N + 1];
        for(int i = 1; i <= N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        long[] tree = new long[4 * N];
        init(tree, 1, N, 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M + K; i++){
            line = br.readLine().split(" ");

            if(Integer.parseInt(line[0]) == 1){
                int idx = Integer.parseInt(line[1]);
                long value = Long.parseLong(line[2]);
                arr[idx] = value;
                update(tree, 1, N, 1, idx, value);
                
            }
            else{
                int l = Integer.parseInt(line[1]);
                int r = Integer.parseInt(line[2]);

                long s = mul(tree, 1, N, 1, l, r) % 1000000007;
                sb.append(s + "\n");
            }
        }

        System.out.println(sb.toString());
        
    }

    static long init(long[] tree, int start, int end, int node){
        if(start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;
        return tree[node] = (init(tree, start, mid, node * 2) * init(tree, mid + 1, end, node * 2 + 1)) % 1000000007;
    }

    static long update(long[] tree, int start, int end, int node, int idx, long diff){
        if(end < idx || idx < start) return tree[node];
        if(start == end) return tree[node] = diff;


        int mid = (start + end) / 2;
        return tree[node] = (update(tree, start, mid, node * 2, idx, diff) * update(tree, mid + 1, end, node * 2 + 1, idx, diff)) % 1000000007;
        
    }

    static long mul(long[] tree, int start, int end, int node, int left, int right){
        if(end < left || right < start) return 1;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return (mul(tree, start, mid, node * 2, left, right) * mul(tree, mid + 1, end, node * 2 + 1, left, right)) % 1000000007;
        
    }
}