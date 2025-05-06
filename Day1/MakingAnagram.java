package Day1;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result1 {

    /*
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
        int n = s1.length()+s2.length();
        int count = 0;
        List<Character> list = new ArrayList<>();
        for(int i=0;i<s1.length();i++){
            list.add(s1.charAt(i));
        }
        for(int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            if(list.contains(ch)){
                count++;
                list.remove(Character.valueOf(ch));
            }
        }
        n = n-(count*2);
        return n;

    }

}

public class MakingAnagram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result1.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
