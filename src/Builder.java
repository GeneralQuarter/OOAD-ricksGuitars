import java.text.ParseException;

/**
 * Created by Quentin Gangler on 08/10/2016.
 *
 */
public enum Builder {
    FENDER("Fender"),
    COLLINGS("Collings"),
    MARTIN("Martin"),
    GIBSON("Gibson"),
    OLSON("Olson"),
    RYAN("Ryan"),
    PRS("PRS");

    private String builderName;

    Builder(String builderName) {
        this.builderName = builderName;
    }

    @Override
    public String toString() {
        return builderName;
    }

    public static Builder parseBuilder(String builderString) throws ParseException {
        for (Builder builder : Builder.values()) {
            if (builder.builderName.equalsIgnoreCase(builderString)) {
                return builder;
            }
        }
        throw new ParseException(builderString, 0);
    }
}
