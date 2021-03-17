public class AreaXMLOutputter {
    private SumProvider sumProvider;

    public AreaXMLOutputter(SumProvider sumProvider) {
        this.sumProvider = sumProvider;
    }

    public String output() {
        return "<area>" + sumProvider.sum() + "</area>";
    }
}
