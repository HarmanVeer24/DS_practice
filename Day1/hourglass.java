package Day1;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        int maxi = Integer.MIN_VALUE;
        for(int row=0;row<=3;row++){
            for(int col=0;col<=3;col++){
                int currsum = arr.get(row).get(col) + arr.get(row).get(col+1) + arr.get(row).get(col+2)
                        + arr.get(row+1).get(col+1)
                        + arr.get(row+2).get(col) + arr.get(row+2).get(col+1) + arr.get(row+2).get(col+2);
                if(currsum>maxi){
                    maxi = currsum;
                }
            }
        }
        return maxi;
    }

}

public class hourglass {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
