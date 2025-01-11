package Basic;

class RecursionTest {
    int[] values;

    RecursionTest(int i){
        values = new int[i];
    }

//    display array -- recursively
    void printArray(int i){
        if(i == 0)
            return;
        else
            printArray(i -1);
        System.out.println("["+(i-1)+"]: "+values[i-1]);
    }
}

public class RecursionPractice2 {
    public static void main(String[] args) {
        RecursionTest recursionTest = new RecursionTest(10);
        int i;

        for (i = 0;i<10;i++)
            recursionTest.values[i] = i;

        recursionTest.printArray(10);
    }
}
