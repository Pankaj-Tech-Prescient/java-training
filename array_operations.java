import java.util.Arrays;

public class array_operations {
    public static void main(String[] args){
        int[] numbers = {5, 4, 7, 9, 1};
        int max = findMax(numbers);
        int min = findMin(numbers);

        System.out.println("Original Array: " + Arrays.toString(numbers));
        System.out.println("Max Number is: " + max);
        System.out.println("Min Number is: " + min);

        Arrays.sort(numbers);
        System.out.println("Sorted Array is: " + Arrays.toString(numbers));

        reverseArray(numbers);
        System.out.println("Sorted Array in reverse order is: " + Arrays.toString(numbers));
    }

    public static int findMax(int[] arr){
        int max = arr[0];
        for(int num: arr){
            if (num > max){
                max = num;
            }
        }
        return max;
    }

    public static int findMin(int[] arr){
        int min = arr[0];
        for (int num: arr){
            if(num < min){
                min = num;
            }
        }
        return min;
    }

    public static void reverseArray(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
