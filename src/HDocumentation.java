import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;

public class HDocumentation {
  private String title;
  private final List<String> toc = new ArrayList<String>();
  private final List<String> notes = new ArrayList<String>();
  private final List<String> summarys = new ArrayList<String>();

  public HDocumentation() {
    title = "";
  }

  public void setTitle(String newTitle) {
    title = newTitle;
  }

  public String getTitle() {
    return title;
  }

  public void addBlock(String blockTitle, String note, String summary) {
    toc.add(blockTitle);
    notes.add(note);
    summarys.add(summary);
  }

  public void preview() {
    System.out.println("!!! " + title + " !!!");
    System.out.println("————————");
    System.out.println();
    for (int i = 0; i < toc.size(); i++) {
      System.out.printf("# %s  ", toc.get(i));
      if (notes.get(i).equals("none")) {
        System.out.println();
      } else {
        System.out.printf("(%s)\n", notes.get(i));
      }
      System.out.println("  " + summarys.get(i));
      System.out.println();
    }
  }

  public void print() {
    File markdownFile = new File(title + ".md");
    PrintWriter writer;
    try {
      writer = new PrintWriter(markdownFile, StandardCharsets.UTF_8);
    } catch (Exception e) {
      System.out.println("HDocumentation: File write failed!");
      return;
    }
    writer.println("# " + title);
    writer.println();
    writer.println("[toc]");
    writer.println();
    for (int i = 0; i < toc.size(); i++) {
      writer.printf("## %s", toc.get(i));
      if (notes.get(i).equals("none")) {
        writer.println("\n");
      } else {
        writer.printf(" <sub>%s</sub>\n\n", notes.get(i));
      }
      writer.println(summarys.get(i));
      writer.println("\n");
    }
    writer.close();
  }
}
