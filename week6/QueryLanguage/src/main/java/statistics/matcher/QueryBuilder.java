package statistics.matcher;

public class QueryBuilder {

    Matcher matcher;

    public QueryBuilder() {
        matcher = new All();
    }

    public Matcher build() {
        return matcher;
    }

    public QueryBuilder oneOf(Matcher ...matchers) {
        matcher = new Or(matchers);
        return this;
    }

    public QueryBuilder playsIn(String team) {
        matcher = new And(new PlaysIn(team), matcher);
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        matcher =  new And(new HasAtLeast(value, category), matcher);
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        matcher = new And(new HasFewerThan(value, category), matcher);
        return this;
    }
}
