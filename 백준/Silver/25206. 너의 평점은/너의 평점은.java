import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        double sum = 0;
        double grade = 0;
        while((line = br.readLine()) != null){
            String[] lines = line.split(" ");
            double credit = Double.parseDouble(lines[1]);
            if(lines[2].equals("P"))
                continue;
            else if(lines[2].equals("F")){
                sum += credit;
                continue;
            }

            float score = 0;
            if(lines[2].charAt(1) == '+')
                score += 0.5;

            int diff = lines[2].charAt(0) - 'A';
            score += 4 - diff;

            sum += credit;
            grade += score * credit;
        }

        System.out.println(grade / sum);
        
    }
}