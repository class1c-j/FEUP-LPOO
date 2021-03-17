import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

public class AreaAggregator implements SumProvider {
    private List<HasArea> shapes = new ArrayList<>();

    public void addShape(HasArea shape) {
        shapes.add(shape);
    }

    public double sum() {
        double sum = 0;
        for (HasArea shape: shapes) {
            sum += shape.getArea();
        }
        return sum;
    }


}