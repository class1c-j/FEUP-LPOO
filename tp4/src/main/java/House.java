public class House implements HasArea {
    private double area;

    public House(int area) {
        this.area = area;
    }

    @Override
    public double getArea() {
        return area;
    }
}
