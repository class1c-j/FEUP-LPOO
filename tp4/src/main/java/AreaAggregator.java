import java.util.ArrayList;
import java.util.List;

public class AreaAggregator {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public double sum() {
        double sum = 0;
        for (Shape shape: shapes) {
            sum += shape.getArea();
        }
        return sum;
    }


}