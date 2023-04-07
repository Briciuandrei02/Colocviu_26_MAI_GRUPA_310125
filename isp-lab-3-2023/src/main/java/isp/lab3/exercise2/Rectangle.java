package isp.lab3.exercise2;

public class Rectangle {

    private int length;
    private int width;
    private String color;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
        this.color = "rosu";
    }

    public Rectangle(int length, int width, String color) {
        this.length = length;
        this.width = width;
        this.color = color;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public int getPerimeter() {
        return 2 * (length + width);
    }

    public int getArea() {
        return length * width;
    }

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(5, 10);
        Rectangle rectangle2 = new Rectangle(7, 3, "albastru");

        System.out.println("Rectangle 1:");
        System.out.println("Lungime: " + rectangle1.getLength());
        System.out.println("Latime: " + rectangle1.getWidth());
        System.out.println("Culoare: " + rectangle1.getColor());
        System.out.println("Perimetru: " + rectangle1.getPerimeter());
        System.out.println("Arie: " + rectangle1.getArea());

        System.out.println("\nRectangle 2:");
        System.out.println("Lungime: " + rectangle2.getLength());
        System.out.println("Latime: " + rectangle2.getWidth());
        System.out.println("Culoare: " + rectangle2.getColor());
        System.out.println("Perimetru: " + rectangle2.getPerimeter());
        System.out.println("Arie: " + rectangle2.getArea());
    }
}
