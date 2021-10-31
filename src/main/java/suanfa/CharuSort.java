package suanfa;

public class CharuSort {

    public static void main(String[] args) {
        int[] i = {77,23,43,545,453,4,34234,242};
        Charupaixu(i);

        for (int i1 : i) {
            System.out.println(i1);
        }
    }


    public static void Charupaixu(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1 ; j >= 0 && arr[j + 1] < arr[j]; j--) {
                swap(arr, j, j + 1);
            }
        }

    }

    //二分排序必须有序
    //有序数组中找某个数是否存在 遍历 是O(N)
    //二分 是O(logN)
    //局部最小值问题 数组中arr无序任何相邻数不相等
    public static void ErfenSoirt(){


    }

    public static void swap(int[] arr, int i , int j){
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
}
