import java.util.*;

/** Sorting Strings in Unicode order. */
class SortStringsNoLocale {

  public static void main(String[] aArgs){
    List<String> insects = Arrays.asList("Wasp", "ant", "", "Bee");
    sortList(insects);
    System.out.println(String.valueOf(insects)); 
  }

  private static void sortList(List<String> aItems){
    Collections.sort(aItems, String.CASE_INSENSITIVE_ORDER);
  }
}