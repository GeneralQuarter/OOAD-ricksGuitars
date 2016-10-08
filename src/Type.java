import java.text.ParseException;

/**
 * Created by Quentin Gangler on 08/10/2016.
 *
 */
public enum Type {
    ACOUSTIC("Acoustic"),
    ELECTRIC("Electric");

    private String typeName;

    Type(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }

    public static Type parseType(String typeNameString) throws ParseException {
        for (Type type : Type.values()) {
            if (type.typeName.equalsIgnoreCase(typeNameString)) {
                return type;
            }
        }
        throw new ParseException(typeNameString, 0);
    }
}
