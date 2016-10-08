import java.util.List;

public class FindGuitarTester {

  public static void main(String[] args) {
    // Set up Rick's guitar inventory
    Inventory inventory = new Inventory();

    Guitar whatErinLikes = new Guitar("", 0, Builder.FENDER, "Stratocastor",
                                      Type.ELECTRIC, Wood.ALDER, Wood.ALDER);

    List<Guitar> guitars = inventory.search(whatErinLikes);

    if(!guitars.isEmpty()) {
      System.out.println("Erin, you might like these guitars: ");
      for (Guitar guitar : guitars) {
        System.out.println("We have a " +
                guitar.getBuilder() + " " + guitar.getModel() + " " +
                guitar.getType() + " guitar:\n   " +
                guitar.getBackWood() + " back and sides,\n   " +
                guitar.getTopWood() + " top.\nYou can have it for only $" +
                guitar.getPrice() + "!\n --- ");
      }
    } else {
      System.out.println("Sorry, Erin, we have nothing for you.");
    }
  }
}
