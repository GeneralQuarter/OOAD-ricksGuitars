import java.util.List;

public class FindGuitarTester {

  public static void main(String[] args) {
    // Set up Rick's guitar inventory
    Inventory inventory = new Inventory();

    GuitarSpec whatErinLikes = new GuitarSpec(Builder.FENDER, "Stratocastor",
                                      Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER);

    List<Guitar> guitars = inventory.search(whatErinLikes);

    if(!guitars.isEmpty()) {
      System.out.println("Erin, you might like these guitars: ");
      for (Guitar guitar : guitars) {
        System.out.println(guitar);
      }
    } else {
      System.out.println("Sorry, Erin, we have nothing for you.");
    }
  }
}
