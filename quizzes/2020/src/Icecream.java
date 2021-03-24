import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Icecream {

    List<Flavor> scoops = new ArrayList<>();
    Set<Flavor> flavors = new HashSet<>();

    public void addScoop(Flavor flavor) {
        this.scoops.add(flavor);
        this.flavors = new HashSet<>(scoops);
    }

    public void removeScoop(Flavor flavor) {
        this.scoops.remove(flavor);
        this.flavors = new HashSet<>(scoops);
    }

    public int getScoopCount() {
        return this.scoops.size();
    }

    public boolean contains(String flavor) {
        return this.scoops.contains(new Flavor(flavor));
    }

    public int getFlavorCount() {
        return this.flavors.size();
    }
}
