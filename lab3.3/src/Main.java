class Swap<T>{
    public static<T> void swap(T[] arr, int first, int second){
        for(; second < arr.length; second++){
            T temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
            first++;
        }
    }
    public static<T> void swapTwo(T[] arr){
        for(int a = 0; a < arr.length; a+=2){
            T temp = arr[a];
            arr[a] = arr[a+1];
            arr[a+1] = temp;
        }
    }

    public static<T> void replace(T[] arr, int start, int finish, T[] rep){
        for(int i = start; i < finish && i-start < rep.length; i++){
            arr[i] = rep[i-start];
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Integer arr[] = {1, 2, 3, 4, 5, 6};
        Integer arr2[] = {1, 2, 3, 4, 5, 6};
        Integer arr3[] = {1, 2, 3, 4, 5, 6};
        Double arr4[] = {1.5, -3.2, 0.3, 4.1, -6.2, 6.0};
        Double arr5[] = {1.5, -3.2, 0.3, 4.1, -6.2, 6.0};
        Double arr6[] = {1.5, -3.2, 0.3, 4.1, -6.2, 6.0};
        System.out.println("Common Swap: ");
        String arr7[] = {"abcd", "hello", "there", "general", "Kenobi", "Neo"};
        String arr8[] = {"abcd", "hello", "there", "general", "Kenobi", "Neo"};
        String arr9[] = {"abcd", "hello", "there", "general", "Kenobi", "Neo"};
        new Swap().swap(arr, 1, 2);
        new Swap().swap(arr4, 1, 2);
        new Swap().swap(arr7, 1, 2);
        for(int a = 0; a < arr.length; a++)
            System.out.print("[" + arr[a] + "]");
        System.out.println();
        for(int a = 0; a < arr.length; a++)
            System.out.print("[" + arr4[a] + "]");
        System.out.println();
        for(int a = 0; a < arr.length; a++)
            System.out.print("[" + arr7[a] + "]");
        System.out.println();
        System.out.println();
        System.out.println("Odd Swap: ");
        new Swap().swapTwo(arr2);
        new Swap().swapTwo(arr5);
        new Swap().swapTwo(arr8);
        for(int a = 0; a < arr2.length; a++)
            System.out.print("[" + arr2[a] + "]");
        System.out.println();
        for(int a = 0; a < arr2.length; a++)
            System.out.print("[" + arr5[a] + "]");
        System.out.println();
        for(int a = 0; a < arr2.length; a++)
            System.out.print("[" + arr8[a] + "]");
        System.out.println();
        System.out.println();
        Integer replace[] = {0, 0, 0};
        Double replace2[] = {1.5, 1.5, 1.5};
        String replace3[] = {"Wake", "up", "Neo"};
        System.out.println("Replace ");
        new Swap().replace(arr3, 0, 3, replace);
        new Swap().replace(arr6, 0, 3, replace2);
        new Swap().replace(arr9, 0, 3, replace3);
        for(int a = 0; a < arr2.length; a++)
            System.out.print("[" + arr3[a] + "]");
        System.out.println();
        for(int a = 0; a < arr2.length; a++)
            System.out.print("[" + arr6[a] + "]");
        System.out.println();
        for(int a = 0; a < arr2.length; a++)
            System.out.print("[" + arr9[a] + "]");
        System.out.println();
    }
}