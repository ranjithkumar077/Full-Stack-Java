import java.util.*;

public class Main {

    static int firstOccurrence(int[] arr, int x) {
        int l = 0, r = arr.length - 1, ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x) {
                ans = m;
                r = m - 1;   // search left side
            } else if (arr[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    static int lastOccurrence(int[] arr, int x) {
        int l = 0, r = arr.length - 1, ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x) {
                ans = m;
                l = m + 1;   // search right side
            } else if (arr[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int first = firstOccurrence(arr, x);
        int last = lastOccurrence(arr, x);

        if (first == -1)
            System.out.println("-1 -1");
        else
            System.out.println(first + " " + last);
    }
}