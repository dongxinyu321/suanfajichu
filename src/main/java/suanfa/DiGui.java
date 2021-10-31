package suanfa;

public class DiGui {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
                //{12,232,1,342,343,23,5,45,45,4,2,32,34,234,23,42,342};


        int guibing = guibing(arr, 0, arr.length - 1);
        System.out.println("小和: " + guibing);

        for (int i : arr) {
            System.out.print(i + "  ");
        }

    }
    //二分递归查最大值 L => R 范围  压栈
    //递归的时间复杂度 master公式
    //子问题等规模  T(N)= 2T * (N/2) + O(1) => O(N) 等于遍历一遍

    //归并排序 数据量是N的规模 子问题是N/2规模
    // T(N) = 2T(N/2) + O(N) a=2 ,b=2, d=1 log a b = d
    //时间复杂度 O(N * logN)

    public static int process(int[] arr, int L, int R){
        if(L == R){
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax  = process(arr , L, mid);
        int rightMax = process(arr, mid + 1,R);
        return Math.max(leftMax, rightMax);
    }

    public static int guibing(int[] arr, int L, int R){
        if (L == R){
            return 0;
        }
        //取中点位运算
        int mid = L +  ((R - L) >> 1);
        return
        guibing(arr, L, mid) +
        guibing(arr,mid + 1, R) +
        merge(arr, L, mid, R);
    }

    //小和问题
    public static int merge(int[] arr, int L,int mid, int R){

        int[] help = new int[R - L + 1];
        int res = 0;
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <= R) {
              res += arr[p1] < arr[p2] ?  (R - p2 + 1) * arr[p1] : 0;
              help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid){
            help[i++] = arr[p1++];
        }

        while (p2 <= R){
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[L++] = help[i];
        }

        return res;
    }


}
