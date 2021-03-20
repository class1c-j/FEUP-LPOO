public class Flavor {
    private final String name;

    public Flavor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Flavor flavor = (Flavor) obj;
        return this.name.equals(flavor.getName());
    }
}
