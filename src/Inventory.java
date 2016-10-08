import java.io.File;
import java.util.*;

public class Inventory {
  private List<Guitar> guitars;

  public Inventory() {
    guitars = new LinkedList<>();
    loadGuitarsFromFile();
  }

  public void addGuitar(String serialNumber, double price,
                        Builder builder, String model,
                        Type type, Wood backWood, Wood topWood) {
    Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    guitars.add(guitar);
  }

  public Guitar getGuitar(String serialNumber) {
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
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

  public List<Guitar> search(Guitar searchGuitar) {
    List<Guitar> results = new LinkedList<>();
    for (Guitar guitar : guitars) {
      // Ignore serial number since that's unique
      // Ignore price since that's unique
      if (searchGuitar.getBuilder() != guitar.getBuilder())
        continue;
      String model = searchGuitar.getModel();
      if ((model != null) && (!model.equals("")) &&
          (!model.equals(guitar.getModel())))
        continue;
      if (searchGuitar.getType() != guitar.getType())
        continue;
      if (searchGuitar.getBackWood() != guitar.getBackWood())
        continue;
      if (searchGuitar.getTopWood() != guitar.getTopWood())
        continue;
      results.add(guitar);
    }
    return results;
  }
}
