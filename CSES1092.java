import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class CSES1092 {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
 
        int n = fs.nextInt();
 
        long sum = 0;
        if ((n & 1) > 0) {
            sum = (long) ((n + 1) >> 1) * n;
        } else {
            sum = (long) (n >> 1) * (n + 1);
        }
 
        if ((sum & 1) > 0) {
            pw.println("NO");
            pw.close();
            return;
        }
 
        long currentSum = 0;
        long target = sum / 2;
 
        pw.println("YES");
 
        StringBuilder l1 = new StringBuilder();
        StringBuilder l2 = new StringBuilder();
        int part1Size = 0;
        int part2Size = 0;
 
        for (long i = n; i >= 1; i--) {
            if (i + currentSum > target) {
                part1Size++;
                l1.append(i).append(" ");
            } else {
                part2Size++;
                currentSum += i;
                l2.append(i).append(" ");
            }
        }
 
        pw.println(part1Size);
        pw.println(l1);
        pw.println(part2Size);
        pw.println(l2);
 
        pw.close();
    }
 
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
 
        String nextLine() {
            String s = "";
 
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }
 
        String next() {
            while (!st.hasMoreTokens()) try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        float nextFloat() {
            return Float.parseFloat(next());
        }
 
        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }
 
    }
 
}