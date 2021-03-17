import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();
        aggregator.addShape(new Circle(3));
        aggregator.addShape(new Square(3));
        aggregator.addShape(new Ellipse(3, 3));
        aggregator.addShape(new Triangle(3, 3));
        aggregator.addShape(new House(3));

        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());
    }
}
