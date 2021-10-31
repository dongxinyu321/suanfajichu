package suanfa;


import java.util.Arrays;


public class Test {
    public static void main(String[] args) {

         Result(5000000);

    }

    public static void Result(int num){
        boolean b;
        for (int i = 0; i < num; i++) {
            b = TestSot();
            if(!b){
                System.out.println("对比失败！！");
                return;
            }
        }
        System.out.println("对比成功！！");
    }


    public static boolean TestSot(){
        int max = 100;
        int maxValue = 100;
        boolean x = true;
        //随机长度数组
        int[] arr = new int[(int) ((max + 1) * Math.random())];

        //
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }

        int arrnew[] = new int[arr.length];

        int[] clone = arr.clone();

        CharuSort.Charupaixu(arr);
        Arrays.sort(clone);

        for (int i = 0; i < arr.length; i++) {
            if(clone[i] != arr[i]){
                x = false;
                break;
            }
        }
        return x;
    }
}
