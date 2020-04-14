public class WordInfo {
    private String value;
    private int count;

    public WordInfo(String word, int count) {
        this.value = word;
        this.count = count;
    }

    public String getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return String.format("%s %s", getValue(), getCount());
    }
}
