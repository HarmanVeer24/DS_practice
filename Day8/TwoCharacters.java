package Day8;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static int alternate(String s) {
        int maxi = 0;
        List<Character> set = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            }
        }

        for (int i = 0; i < set.size() - 1; i++) {
            for (int j = i + 1; j < set.size(); j++) {
                Stack<Character> st = new Stack<>();
                boolean flag = true;

                for (int k = 0; k < s.length(); k++) {
                    char curr = s.charAt(k);

                    if (curr != set.get(i) && curr != set.get(j)) {
                        continue;
                    }

                    if (!st.isEmpty() && st.peek() == curr) {
                        flag = false;
                        break;
                    }

                    st.push(curr);
                }

                if (flag) {
                    maxi = Math.max(maxi, st.size());
                }
            }
        }

        return maxi;
    }
}


public class TwoCharacters{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
