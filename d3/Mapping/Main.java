package d3.Mapping;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Mappable> mappables = new ArrayList<>();
        mappables.add(new Building("Sydney Town Hall", UsageType.GOVERNMENT));
        mappables.add(new Building("Westfield Sydney", UsageType.COMMERCIAL));
        mappables.add(new Building("Sydney Opera House", UsageType.RESIDENTIAL));
        mappables.add(new Building("Sydney Harbour Bridge", UsageType.INDUSTRIAL));

        mappables.add(new UtilityLine("College St", UtilityType.ELECTRICAL));
        mappables.add(new UtilityLine("Pitt St", UtilityType.FIBER_OPTIC));
        mappables.add(new UtilityLine("George St", UtilityType.GAS));
        for (var m : mappables) {
            Mappable.mapIt(m);
        }

    }
}
