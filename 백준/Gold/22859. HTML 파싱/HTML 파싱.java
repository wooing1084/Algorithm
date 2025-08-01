import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        
        // remove main
        String html = input.substring("<main>".length(), input.length() - "</main>".length());

        // title
        html = html.replaceAll("<div title=\"([\\w\\s]*)\">", "title : $1\n");
        html = html.replaceAll("</div>", "");
        
        // remove <p>
        html = html.replaceAll("<p>(.*?)</p>", "$1\n");
        html = html.replaceAll("<([\\w /]*)>", "");
        
        // trim p
        html = html.replaceAll(" ?\n ?", "\n");

        // compact double space
        html = html.replaceAll(" {2,}", " ");

        System.out.println(html);
        
    }
}