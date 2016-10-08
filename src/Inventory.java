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
                        Type type, int numStrings, Wood backWood, Wood topWood) {
    GuitarSpec guitarSpec = new GuitarSpec(builder,
            model, type, numStrings, backWood, topWood);
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
                Integer.parseInt(fields[5]),
                Wood.parseWood(fields[6].replace("\"", "")),
                Wood.parseWood(fields[7].replace("\"", "")));
      }
    } catch (Exception e){
      e.printStackTrace();
    }
  }

  public List<Guitar> search(GuitarSpec searchGuitarSpec) {
    List<Guitar> results = new LinkedList<>();
    for (Guitar guitar : guitars) {
      GuitarSpec guitarSpec = guitar.getGuitarSpec();
      if (guitarSpec.matches(searchGuitarSpec)) {
        results.add(guitar);
      }
    }
    return results;
  }
}
