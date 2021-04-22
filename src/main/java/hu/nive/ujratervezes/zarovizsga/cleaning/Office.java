package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable {

    private String address;
    private int surface;
    private int stocks;

    public Office(String address, int surface, int stocks) {
        this.address = address;
        this.surface = surface;
        this.stocks = stocks;
    }

    @Override
    public int clean() {
        return surface * stocks * 100;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
