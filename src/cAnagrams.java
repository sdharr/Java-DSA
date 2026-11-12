import java.util.Scanner;

public class cAnagrams {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        boolean isAnagram = true;

        if (s1.length() != s2.length()) {

            isAnagram = false;

        } else {

            int[] frequency = new int[65536];

            for (int i = 0; i < s1.length(); i++) {
                frequency[s1.charAt(i)]++;
            }

            for (int i = 0; i < s2.length(); i++) {
                frequency[s2.charAt(i)]--;
            }

            for (int count : frequency) {

                if (count != 0) {
                    isAnagram = false;
                    break;
                }
            }
        }

        if (isAnagram) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }

        sc.close();
    }
}