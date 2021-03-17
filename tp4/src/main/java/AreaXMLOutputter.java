public class AreaXMLOutputter {
    private AreaAggregator aggregator;

    public AreaXMLOutputter(AreaAggregator aggregator) {
        this.aggregator = aggregator;
    }

    public String output() {
        return "<area>" + aggregator.sum() + "</area>";
    }
}
