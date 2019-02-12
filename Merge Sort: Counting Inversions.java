import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        int n = arr.length;
        long result = mergesort(arr, 0, n-1);
        return result;
    }

    static long mergesort(int[] arr, int l, int r)
    {
        long result = 0;
        if(l<r)
        {
            int m = (l+r)/2;
            result = mergesort(arr, l, m) + mergesort(arr, m+1, r) + merge(arr, l, m, r);
            return result;
        }
        return result;
    }

    static long merge(int[] arr, int l, int m, int r)
    {
        int n1 = m - l + 1; 
        int n2 = r - m; 
        long count = 0;

        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        for (int i=0; i<n1; i++) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; j++) 
            R[j] = arr[m + 1+ j]; 

        int i = 0, j =0, k = l;
        while(i<n1 && j<n2)
        {
            if(L[i]<=R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
                count += n1-i;
            }
            k++;
        }
        while(i<n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j<n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
        return count;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
