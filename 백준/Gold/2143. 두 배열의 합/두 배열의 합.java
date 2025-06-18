import java.util.*;
import java.io.*;
public class Main {
    static long T;
    static int n, m;
    static int[] arr1, arr2;
    static List<Integer> list1, list2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr1 = new int[n];
        for(int i=0; i<n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr2 = new int[m];
        for(int i=0; i<m; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        list1 = partialSum(arr1);
        list2 = partialSum(arr2);

        Collections.sort(list1);
        Collections.sort(list2);

        bw.write(select(list1, list2) + " ");
        bw.close();

    }
    static List<Integer> partialSum(int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            int sum = 0;
            for(int j=i; j>=0; j--){
                sum += arr[j];
                list.add(sum);
            }
        }
        return list;
    }
    static long select(List<Integer> list1, List<Integer> list2){
        //이중 포인터로 두 부분집합의 합이 T인 경우를 count
        long count = 0;
        int leftPointer = 0;
        int rightPointer = list2.size() - 1;

        while(leftPointer < list1.size() && rightPointer >= 0){
            long leftNum = list1.get(leftPointer);
            long rightNum = list2.get(rightPointer);
            long sum = leftNum + rightNum;

            if(sum == T){
                long leftSameNumSize = 0;
                long rightSameNumSize = 0;
                while(leftPointer < list1.size() && list1.get(leftPointer) == leftNum){
                    leftSameNumSize++;
                    leftPointer++;
                }
                while(rightPointer >= 0 && list2.get(rightPointer) == rightNum){
                    rightSameNumSize++;
                    rightPointer--;
                }
                count += leftSameNumSize * rightSameNumSize;
            }else if(sum < T){
                leftPointer++;
            }else {
                rightPointer--;
            }
        }
        return count;
    }
}