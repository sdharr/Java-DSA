import java.util.Scanner;
import java.util.Arrays;

public class eReverseChar {

    static void reverse(char[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverse(arr, left + 1, right - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        char[] arr = input.toCharArray();

        reverse(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

        sc.close();
    }
} 