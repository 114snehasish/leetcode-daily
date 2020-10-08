package twtenty20.oct.week1.six;

import java.util.Scanner;

public class Solution {
    private StringBuilder stringBuilder = new StringBuilder();

    public int bitwiseComplement(int N) {
        if (N > 0) {
            stringBuilder.append(1 - (N % 2));
            return bitwiseComplement(N / 2);
        }
        if (stringBuilder.length() == 0)
            stringBuilder.append(1);
        stringBuilder = stringBuilder.reverse();
        int result = 0;
        int length = stringBuilder.length() - 1;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '1') {
                result += Math.pow(2, (length - i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.println(solution.bitwiseComplement(sc.nextInt()));
    }
}
