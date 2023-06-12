import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        loop();
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println();
        nonloop();
    }
    public static void loop(){
        int[][] matrix = new int[5][4];
        for(int a = 0; a < 5; a++){
            for(int b = 0; b < 4; b++){
                matrix[a][b] = (int) (Math.random() * 24);
                while(matrix[a][b] % 2 != 0){
                    matrix[a][b] = (int) (Math.random() * 24);
                }
            }
        }
        int counter = 0;
        int[] mmatrix = new int[5];

        for(int a = 0; a < 5; a++){
            mmatrix[counter] = matrix[a][0];
            for(int b = 1; b < 4; b++){
                if(mmatrix[counter] > matrix[a][b])
                    mmatrix[counter] = matrix[a][b];
            }
            counter++;
        }
        for(int a = 0; a < 5; a++){
            for(int b = a; b < 5; b++){
                if(mmatrix[a] > mmatrix[b]){
                    int temp = mmatrix[a];
                    mmatrix[a] = mmatrix[b];
                    mmatrix[b] = temp;
                }
            }
        }

        for(int a = 0; a< 5; a++){
            for(int b = 0; b < 4; b++){
                System.out.print("[" + matrix[a][b] + "]");
            }
            System.out.println();
        }
        System.out.println();


        String []smatrix = new String[5];

        for(int a = 0; a < 5; a++)
            smatrix[a] = "";

        for(int a = 0; a< 5; a++){
            for(int b = 0; b < mmatrix[a]; b++){
                smatrix[a] = smatrix[a].concat("*");
            }
        }

        for(int a = 0; a < 5; a++) {
            System.out.println(smatrix[a]);
        }
    }
    public static void nonloop(){
        int[][] matrix = new int[5][4];
        Random rand = new Random();
        Arrays.setAll(matrix, index -> fill(rand));

        for(int a = 0; a< 5; a++){
            for(int b = 0; b < 4; b++){
                System.out.print("[" + matrix[a][b] + "]");
            }
            System.out.println();
        }
        System.out.println();


        int[] mmatrix = new int[5];

        Arrays.setAll(mmatrix, a -> Min(matrix, a));
        Arrays.sort(mmatrix);

        String[] symbols = new String[5];

        Arrays.setAll(symbols, index -> "*".repeat(mmatrix[index]));
        Arrays.sort(symbols);
        System.out.println(Arrays.toString(symbols));
    }

    public static int[] fill(Random rand){
        int[] arr = new int[4];
        Arrays.setAll(arr, index -> (rand.nextInt(13))*2);
        return arr;
    }
    public static int Min(int[][] arr, int a){
        int[] column = new int[arr.length-1];
        Arrays.setAll(column, i -> arr[a][i]);
        Arrays.sort(column);
        return column[0];
    }
}