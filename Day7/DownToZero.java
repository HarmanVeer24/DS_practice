package Day7;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'downToZero' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int downToZero(int n) {
        if (n == 0) return 0;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(n);
        visited.add(n);
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size>0) {
                int curr = queue.poll();
                if (curr == 0) return moves;
                for (int i = 2; i <= Math.sqrt(curr); i++) {
                    if (curr % i == 0) {
                        int a = i;
                        int b = curr / i;
                        int next = Math.max(a, b);
                        if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
                if (!visited.contains(curr - 1)) {
                    queue.offer(curr - 1);
                    visited.add(curr - 1);
                }
                size--;
            }
            moves++;
        }

        return -1;
    }
}

public class DownToZero {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            int result = Result.downToZero(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
