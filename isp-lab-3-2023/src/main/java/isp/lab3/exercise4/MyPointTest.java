import isp.lab3.exercise4.MyPoint;

public class MyPointTest {
    public static <MyPoint> void main(String[] args) {
        MyPoint p1 = new MyPoint(1, 2, 3);
        MyPoint p2 = new MyPoint(4, 5, 6);
        System.out.println("Distance between p1 and (4, 5, 6) is " + p1.distance(4, 5, 6));
        System.out.println("Distance between p1 and p2 is " + p1.distance(p2));
    }
}
