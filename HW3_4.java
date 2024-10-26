
public class HW3_4 {

    private double x;
    private double y;
    private double width;
    private double height;

    public HW3_4() {
        this(0, 0, 1, 1);
    }

    public HW3_4(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean contains(double x, double y) {
        return (x > this.x - width / 2 && x < this.x + width / 2
                && y > this.y - height / 2 && y < this.y + height / 2);
    }

    public boolean contains(HW3_4 r) {
        return (r.getX() - r.getWidth() / 2 >= this.x - this.width / 2
                && r.getX() + r.getWidth() / 2 <= this.x + this.width / 2
                && r.getY() - r.getHeight() / 2 >= this.y - this.height / 2
                && r.getY() + r.getHeight() / 2 <= this.y + this.height / 2);
    }

    public boolean overlaps(HW3_4 r) {
        return !(r.getX() - r.getWidth() / 2 > this.x + this.width / 2
                || r.getX() + r.getWidth() / 2 < this.x - this.width / 2
                || r.getY() - r.getHeight() / 2 > this.y + this.height / 2
                || r.getY() + r.getHeight() / 2 < this.y - this.height / 2);
    }

    public static void main(String[] args) {
        HW3_4 r1 = new HW3_4(2, 2, 5.5, 4.9);
        HW3_4 r2 = new HW3_4(4, 5, 10.5, 3.2);
        HW3_4 r3 = new HW3_4(3, 3, 2.3, 5.4);

        System.out.println("r1的面積: " + r1.getArea());
        System.out.println("r1的周長: " + r1.getPerimeter());
        System.out.println("r1是否包含點(3, 3): " + r1.contains(3, 3));
        System.out.println("r1是否包含r3: " + r1.contains(r3));
        System.out.println("r1是否與r2重疊: " + r1.overlaps(r2));
    }
}
