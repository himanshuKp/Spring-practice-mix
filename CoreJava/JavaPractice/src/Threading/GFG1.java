package Threading;

class Shot extends Thread {
    public void show(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Shot");
        }
    }
}

class Miss extends Thread {
    public void show(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Miss");
        }
    }
}

public class GFG1 {
    public static void main(String[] args) {
        Shot obj1 = new Shot();
        Miss obj2 = new Miss();

        obj1.show();
        obj2.show();
    }
}
