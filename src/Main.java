import java.util.*;

public class Main {
  private final static Scanner cin = new Scanner(System.in);
  private static Map<String, HDocumentation> map = new HashMap<String, HDocumentation>();

  private static void addBlock(String[] arr) {
    if (!map.containsKey(arr[0])) {
      System.out.printf("HDocumentation: '%s' not found!\n", arr[0]);
      return;
    }
    System.out.print("What is the title: ");
    String title = cin.nextLine();
    System.out.print("What is the note(or none): ");
    String note = cin.nextLine();
    System.out.print("What is the summary: ");
    String summary = cin.nextLine();
    map.get(arr[0]).addBlock(title, note, summary);
  }

  private static void preview(String[] arr) {
    if (!map.containsKey(arr[0])) {
      System.out.printf("HDocumentation: '%s' not found!\n", arr[0]);
      return;
    }
    map.get(arr[0]).preview();
  }

  private static void print(String[] arr) {
    if (!map.containsKey(arr[0])) {
      System.out.printf("HDocumentation: '%s' not found!\n", arr[0]);
      return;
    }
    map.get(arr[0]).print();
  }

  private static void del(String[] arr) {
    if (!map.containsKey(arr[0])) {
      return;
    }
    map.remove(arr[0]);
  }

  public static void main(String[] args) {
    while (true) {
      System.out.print("HDocumentation 1.0.0v > ");
      String input = cin.nextLine();
      if (input.equals("quit")) {
        break;
      }
      String[] arr = input.split(" ");
      if (arr.length == 2 && arr[0].equals("new")) {
        map.put(arr[1], new HDocumentation());
        map.get(arr[1]).setTitle(arr[1]);
      } else if (arr.length == 2 && arr[1].equals("add")) {
        addBlock(arr);
      } else if (arr.length == 2 && arr[1].equals("preview")) {
        preview(arr);
      } else if (arr.length == 2 && arr[1].equals("print")) {
        print(arr);
      } else if (arr.length == 2 && arr[1].equals("del")) {
        del(arr);
      } else if (arr.length != 0) {
        System.out.println("HDocumentation: Command not found!");
      }
    }
  }
}