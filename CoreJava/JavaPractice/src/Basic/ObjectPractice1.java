package Basic;

class Box {
    double width;
    double height;
    double depth;

    Box(double width, double height, double depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    double volume(){
        return width * height * depth;
    }
}

public class ObjectPractice1 {
    public static void main(String[] args) {
//        declare, allocate and initialize box objects
        Box mybox1 = new Box(10, 20, 15);
        Box mybox2 = new Box(3, 6, 9);

        double vol;

        vol = mybox1.volume();
        System.out.println("Volume for mybox1 is: "+vol);

        vol = mybox2.volume();
        System.out.println("Volume for mybox2 is: "+vol);
    }
}
