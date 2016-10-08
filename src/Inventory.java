import java.io.File;
import java.util.*;

public class Inventory {
  private List<Guitar> guitars;

  public Inventory() {
    guitars = new LinkedList<>();
    loadGuitarsFromFile();
  }

  private void addGuitar(String serialNumber, double price,
                        Builder builder, String model,
                        Type type, Wood backWood, Wood topWood) {
    GuitarSpec guitarSpec = new GuitarSpec(builder,
            model, type, backWood, topWood);
    Guitar guitar = new Guitar(serialNumber, price, guitarSpec);
    guitars.add(guitar);
  }

  public Guitar getGuitar(String serialNumber) {
    for (Guitar guitar : guitars) {
      if (guitar.getSerialNumber().equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }

  private void loadGuitarsFromFile() {
    try {
      File guitarsInInventoryFile = new File("guitarsInInventory.txt");
      Scanner in = new Scanner(guitarsInInventoryFile);

      while(in.hasNext()) {
        String line = in.nextLine();
        String[] fields = line.split(", ");
        addGuitar(fields[0].replace("\"", ""),
                Double.parseDouble(fields[1]),
                Builder.parseBuilder(fields[2].replace("\"", "")),
                fields[3].replace("\"", ""),
                Type.parseType(fields[4].replace("\"", "")),
                Wood.parseWood(fields[5].replace("\"", "")),
                Wood.parseWood(fields[6].replace("\"", "")));
      }
    } catch (Exception e){
      e.printStackTrace();
    }
  }

  public List<Guitar> search(GuitarSpec searchGuitarSpec) {
    List<Guitar> results = new LinkedList<>();
    for (Guitar guitar : guitars) {
      GuitarSpec guitarSpec = guitar.getGuitarSpec();
      // Ignore serial number since that's unique
      // Ignore price since that's unique
      if (searchGuitarSpec.getBuilder() != guitarSpec.getBuilder())
        continue;
      String model = searchGuitarSpec.getModel();
      if ((model != null) && (!model.equals("")) &&
          (!model.equals(guitarSpec.getModel())))
        continue;
      if (searchGuitarSpec.getType() != guitarSpec.getType())
        continue;
      if (searchGuitarSpec.getBackWood() != guitarSpec.getBackWood())
        continue;
      if (searchGuitarSpec.getTopWood() != guitarSpec.getTopWood())
        continue;
      results.add(guitar);
    }
    return results;
  }
}
