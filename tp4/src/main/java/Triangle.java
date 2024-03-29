public class Triangle implements AreaShape {
    private double height;
    private double base;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public double getBase() {
        return base;
    }

    @Override
    public double getArea() {
        return height * base / 2;
    }

    @Override
    public void draw() {
        System.out.println("Triangle");
    }
}
