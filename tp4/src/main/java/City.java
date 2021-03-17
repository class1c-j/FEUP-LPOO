import java.util.List;

public class City {
    private List<House> houses;

    public City(List<House> houses) {
        this.houses = houses;
    }

    public int sum() {
        int sum = 0;
        for (House house : houses) {
            sum += house.getArea();
        }
        return sum;
    }
}
