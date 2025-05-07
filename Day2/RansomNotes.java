package Day2;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        boolean flag = helper(magazine,note);
        if(flag==true){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
    public static boolean helper(List<String> mag , List<String> not){
        if(not.size()>mag.size()){
            return false;
        }
        Map<String,Integer> map = new HashMap<>();
        for(String str : mag){
            if(map.containsKey(str)){
                map.put(str, map.get(str)+1);
            }
            else{
                map.put(str,1);
            }
        }
        for(String str : not){
            if(!map.containsKey(str)|| map.get(str)==0){
                return false;
            }
            else{
                map.put(str,map.get(str)-1);
            }
        }
        return true;
    }

}

public class RansomNotes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "));

        List<String> note = Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "));

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}

