public class AreaStringOutputter {
    private AreaAggregator aggregator;

    public AreaStringOutputter(AreaAggregator aggregator) {
        this.aggregator = aggregator;
    }

    public String output() {
        return "Sum of areas: " + aggregator.sum();
    }
}
