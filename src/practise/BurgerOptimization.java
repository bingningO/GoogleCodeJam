package practise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BurgerOptimization {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // times
        int k;

        for (int i = 0; i < t; i++) {
            k = in.nextInt();
            int[] dList = new int[k];
            for (int num = 0; num < k; num++) {
                int val = in.nextInt();
                dList[num] = val;
            }
            System.out.println("Case #" + (i + 1) + ": " + getOptimization(k, dList));
        }
    }

    private static int getOptimization(int k, int[] dList) {
        int[] resultList = new int[k];
        Arrays.sort(dList);
        int dHead = 0;
        for (int i = 0; i < k / 2 && dHead < k; i++) {
            resultList[i] = dList[dHead++];
            if (i == k - 1 - i) break;
            resultList[k - 1 - i] = dList[dHead++];
        }

        return countValue(k, resultList);
    }

    private static int countValue(int k, int[] dList) {
        int value = 0;
        for (int i = 0; i < k / 2; i++) {
            value += Math.pow(i - dList[i], 2);
            if (i == k - 1 - i) break;
            value += Math.pow(i - dList[k - 1 - i], 2);
        }
        return value;
    }
}
