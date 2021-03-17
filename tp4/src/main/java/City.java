import java.util.List;

public class City implements SumProvider {
    private List<House> houses;

    public City(List<House> houses) {
        this.houses = houses;
    }

    public double sum() {
        double sum = 0;
        for (House house : houses) {
            sum += house.getArea();
        }
        return sum;
    }
}
