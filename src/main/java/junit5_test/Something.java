package junit5_test;

public class Something {
    private String name;
    private String status;

    public Something(String name) {
        this.name = name;
        this.status = "Not done";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{name: '" + name + "', status: '" + status + "'}";
    }
}
