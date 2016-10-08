import java.util.List;

public class FindGuitarTester {

  public static void main(String[] args) {
    // Set up Rick's guitar inventory
    Inventory inventory = new Inventory();

    GuitarSpec whatErinLikes = new GuitarSpec(Builder.FENDER, "Stratocastor",
                                      Type.ELECTRIC, Wood.ALDER, Wood.ALDER);

    List<Guitar> guitars = inventory.search(whatErinLikes);

    if(!guitars.isEmpty()) {
      System.out.println("Erin, you might like these guitars: ");
      for (Guitar guitar : guitars) {
        GuitarSpec guitarSpec = guitar.getGuitarSpec();
        System.out.println("We have a " +
                guitarSpec.getBuilder() + " " + guitarSpec.getModel() + " " +
                guitarSpec.getType() + " guitar:\n   " +
                guitarSpec.getBackWood() + " back and sides,\n   " +
                guitarSpec.getTopWood() + " top.\nYou can have it for only $" +
                guitar.getPrice() + "!\n --- ");
      }
    } else {
      System.out.println("Sorry, Erin, we have nothing for you.");
    }
  }
}
