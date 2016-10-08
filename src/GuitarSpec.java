/**
 * Created by Quentin Gangler on 08/10/2016.
 *
 */
public class GuitarSpec {
    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood;
    private Wood topWood;
    private int numStrings;

    public GuitarSpec(Builder builder, String model, Type type, int numStrings, Wood backWood, Wood topWood) {
        this.builder = builder;
        this.model = model;
        this.numStrings = numStrings;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public boolean matches(GuitarSpec otherSpec) {
        String model = otherSpec.getModel();
        return otherSpec.getBuilder() == builder &&
                !((model != null) && (!model.equals("")) &&
                !model.equals(this.model))
                && otherSpec.getType() == type
                && otherSpec.getBackWood() == backWood
                && otherSpec.getTopWood() == topWood
                && otherSpec.getNumStrings() == numStrings;
    }

    @Override
    public String toString() {
        return builder + " " + model + " " +
                numStrings + "-strings " +
                type + " guitar:\n\t" +
                backWood + " back and sides,\n\t" +
                topWood + " top.\n";
    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }

    public int getNumStrings() {
        return numStrings;
    }
}
