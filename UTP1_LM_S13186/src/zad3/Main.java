/**
 *
 *  @author Lipińska Martyna S13186
 *
 */

package zad3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

  public static void main(String[] args) {
    // Lista destynacji: port_wylotu port_przylotu cena_EUR 
    List<String> dest = Arrays.asList(
      "bleble bleble 2000",
      "WAW HAV 1200",
      "xxx yyy 789",
      "WAW DPS 2000",
      "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;
    List<String> result = dest.stream().filter( x -> x.startsWith("WAW"))
    		.map(s -> {
         	   String tokens[] = s.split(" "); 
         	   return "to " + tokens[1] + " - price in PLN: " + (int)(Double.parseDouble(tokens[2]) * ratePLNvsEUR);
    		}).collect(ArrayList::new, ArrayList::add,
                    ArrayList::addAll);
    /*<-- tu należy dopisać fragment
     * przy czym nie wolno używać żadnych własnych klas, jak np. ListCreator
     * ani też żadnych własnych interfejsów
     * Podpowiedź: należy użyć strumieni
     */

    for (String r : result) System.out.println(r);
  }
}
