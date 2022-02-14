import java.io.*;

public class Main {
  View v = new View();
  public static void main(String[] args) {
    save();
    load();
  }

  private static void save() {
    try {
      LogEntry l = new LogEntry(v.getMessage(), v.getAuthor());
      ObjectOutputStream outs = new ObjectOutputStream(new FileOutputStream(new File("Logbook")));
      outs.writeObject(l);
      outs.flush();
      outs.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void load() {
    try {
      ObjectInputStream ins = new ObjectInputStream(new FileInputStream(new File("Logbook")));
      LogEntry l = (LogEntry) ins.readObject();
      ins.close();
      System.out.println(l);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }



}