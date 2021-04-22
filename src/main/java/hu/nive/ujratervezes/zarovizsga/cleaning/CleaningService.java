package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();


    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public int cleanAll() {
        List<Cleanable> forRemove = new ArrayList<>();
        int totalCosts = 0;
        for (Cleanable cleanable : cleanables){
            totalCosts = totalCosts + cleanable.clean();
            forRemove.add(cleanable);
        }
        cleanables.removeAll(forRemove);
        return totalCosts;
    }

    public int cleanOnlyOffices() {
        int totalCosts = 0;
        List<Cleanable> forRemove = new ArrayList<>();
        for (Cleanable cleanable : cleanables) {
            if (cleanable instanceof Office) {
                totalCosts = totalCosts + cleanable.clean();
                forRemove.add(cleanable);
            }
        }
            cleanables.removeAll(forRemove);
            return totalCosts;
    }

    public List<Cleanable> findByAddressPart(String addressPart) {
        List<Cleanable> selectedProperties = new ArrayList<>();
        for (Cleanable cleanable : cleanables){
            if (cleanable.getAddress().contains(addressPart)) {
                selectedProperties.add(cleanable);
            }
        }
        return selectedProperties;
    }

    public String getAddresses() {
        String result = "";
        StringBuilder sb = new StringBuilder();
        for (Cleanable cleanable : cleanables){
            sb.append(cleanable.getAddress() + ", ");
        }
        sb.delete(sb.length()-2, sb.length());
        result = sb.toString();

      //  result = sb.substring(0, sb.length()-2);
        return result;
    }

  /*  public static void main(String[] args) {
        CleaningService service = new CleaningService();

            service.add(new House("Bp. Fo ut 1.", 130));
            service.add(new House("Bp. Fo ut 2.", 300));
            service.add(new Office("Bp. Fo ut 3.", 300, 3));
            service.add(new Office("Bp. Fo ut 4.", 300, 4));

        System.out.println(service.getAddresses());
    }

   */
}
