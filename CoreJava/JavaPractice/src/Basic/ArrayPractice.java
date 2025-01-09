package Basic;

public class ArrayPractice {
    public static void main(String[] args) {
//        int[] month_days = new int[12];

//        var myArray = new int[10];

//        twoDimensionalArray();
        stairCaseTwoDImensional();
    }

    private static void stairCaseTwoDImensional() {
        int twoD[][] = new int[4][];
        twoD[0] = new int[1];
        twoD[1] = new int[2];
        twoD[2] = new int[3];
        twoD[3] = new int[4];
        int i,j,k=0;

        for(i=0;i<4;i++){
            for(j=0;j<i+1;j++){
                twoD[i][j] = k;
                k++;
            }
        }

        for (i=0;i<4;i++){
            for(j=0;j<i+1;j++){
                System.out.print(twoD[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void twoDimensionalArray() {
        int[][] twoD = new int[4][5];
        int i,j,k=0;

        for(i=0;i<4;i++){
            for(j=0;j<5;j++){
                twoD[i][j] = k;
                k++;
            }
        }

        for (i=0;i<4;i++){
            for(j=0;j<5;j++){
                System.out.print(twoD[i][j] + " ");
            }
            System.out.println();
        }
    }
}
