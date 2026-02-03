 class Entry {
    private String key;
    private String value;
public car(String car ){


}
    public Entry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
    public static void main(String[] args) {
        Entry car= new Entry("bmw");
        System.out.println(entry);
    }
}
