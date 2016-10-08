import java.text.ParseException;

/**
 * Created by Quentin Gangler on 08/10/2016.
 *
 */
public enum Wood {
    INDIANROSEWOOD("Indian Rosewood"),
    SITKA("Sitka"),
    ALDER("Alder"),
    MAHOGANY("Mahogany"),
    ADIRONDACK("Adirondack"),
    BRAZILIANROSEWOOD("Brazilian Rosewood"),
    MAPLE("Maple"),
    CEDAR("Cedar"),
    COCOBOLO("Cocobolo");

    private String woodName;

    Wood(String woodName) {
        this.woodName = woodName;
    }

    @Override
    public String toString() {
        return woodName;
    }

    public static Wood parseWood(String woodNameString) throws ParseException {
        for(Wood wood : Wood.values()) {
            if (wood.woodName.equalsIgnoreCase(woodNameString)) {
                return wood;
            }
        }
        throw new ParseException(woodNameString, 0);
    }
}
