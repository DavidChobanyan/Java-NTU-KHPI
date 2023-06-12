public class Main {
    public static void main(String[] args) {
        int arr[] = new int[300];
        for (int a = 0; a < arr.length; a++) {
            arr[a] = a + 1;
        }
        for(int a = 0; a < arr.length; a++) {
            arr[0] = -1;
            if (arr[a] != -1) {
                for (int b = 2; a*b < arr.length; b++) {
                    for (int c = a+1; c < arr.length; c++) {
                        if (arr[a]*b == arr[c]) {
                            arr[c] = -1;
                        }
                    }
                }
            }
        }
        for(int a = 0;a < arr.length; a++){
            if(arr[a] != -1)
                System.out.print("["+arr[a]+"]");
            if(a%30==0 && a != 0)
                System.out.println();
        }
    }
}