public class MyPoint {
    private int x;
    private int y;
    private int z;

    public MyPoint() {
        x = 0;
        y = 0;
        z = 0;
    }

    public MyPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void setXYZ(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public double distance(int x, int y, int z) {
        int dx = this.x - x;
        int dy = this.y - y;
        int dz = this.z - z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public double distance(MyPoint another) {
        int dx = this.x - another.getX();
        int dy = this.y - another.getY();
        int dz = this.z - another.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}

public class MyPointTest {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(1, 2, 3);
        MyPoint p2 = new MyPoint(4, 5, 6);
        System.out.println("Distance between p1 and (4, 5, 6) is " + p1.distance(4, 5, 6));
        System.out.println("Distance between p1 and p2 is " + p1.distance(p2));
    }
}
