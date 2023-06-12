import java.util.Scanner;

public class Main {
    public static void fib(long arr[],long n){
            for (int a = 0; a < n; a++) {
                if (a < 2)
                    arr[a] = 1;
                else
                    arr[a] = arr[a - 2] + arr[a - 1];
            }
    }
    public static void main(String[] args) {
        System.out.print("Enter the number from 1 to 92: ");
        Scanner get = new Scanner(System.in);
        int n = get.nextInt();
        if(n<1 || n > 92)
            return;
        long[] arr = new long[n];
        fib(arr, n);
        System.out.println(arr[n-1]);
        for(int a = 0; a < n; a++){
            System.out.print("["+arr[a]+"]");
            if(a < 60) {
                if (a != 0 && a % 10 == 0)
                    System.out.println();
            }
            else{
                if(a % 4 == 0)
                    System.out.println();
            }
        }
        System.out.println();
        while(true){
            System.out.print("Enter the index from 1 to 92 or 0 to finish: ");
            Scanner get2 = new Scanner(System.in);
            int index = get2.nextInt();
            if(index == 0)
                break;
            if(index <= n && index > 0)
                System.out.println(arr[index-1]);
            else if(index >= n && index < 93){
                arr = new long[index];
                fib(arr, index);
                System.out.println(arr[index-1]);
                for(int a = 0; a < index; a++){
                    System.out.print("["+arr[a]+"]");
                    if(a < 60) {
                        if (a != 0 && a % 10 == 0)
                            System.out.println();
                    }
                    else{
                        if(a % 4 == 0)
                            System.out.println();
                    }
                }
                System.out.println();
            }
        }
    }
}