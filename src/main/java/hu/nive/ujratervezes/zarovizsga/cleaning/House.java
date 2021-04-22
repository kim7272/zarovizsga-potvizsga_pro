package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable {

    private String address;
    private int surface;

    public House(String address, int surface) {
        this.address = address;
        this.surface = surface;
    }

    @Override
    public int clean() {
        return surface * 80;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
