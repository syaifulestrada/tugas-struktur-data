import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {

        int[] arr = {8, 3, 5, 1, 9, 4, 7, 2, 6};

        System.out.println("Before:");
        System.out.println(Arrays.toString(arr));

        int[] sorted = countingSort(arr);

        System.out.println("After:");
        System.out.println(Arrays.toString(sorted));
    }

     public static int[] countingSort(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return new int[0];
        }

        int maxVal = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        int[] countArr = new int[maxVal + 1];
        for (int i = 0; i <= maxVal; i++) {
            countArr[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            countArr[arr[i]]++;
        }

        for (int i = 1; i <= maxVal; i++) {
            countArr[i] += countArr[i - 1];
        }

        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int value = arr[i];
            result[countArr[value] - 1] = value;
            countArr[value]--;
        }

        for (int i = 0; i < n / 2; i++) {
            int temp = result[i];
            result[i] = result[n - 1 - i];
            result[n - 1 - i] = temp;
        }

        return result;
    }



    /*
		Referensi:
		GeeksforGeeks. (2025, September 29). Counting Sort. GeeksforGeeks. https://www.geeksforgeeks.org/dsa/counting-sort/
		Dian, N. & Unggul, T, S. (2023). Struktur Data (halaman 6.3 modul 6). Universitas Terbuka
    */

}
