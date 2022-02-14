import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    save();
    load();
  }

  private static void load() throws IOException, ClassNotFoundException {
    ObjectInputStream ins=new ObjectInputStream(new FileInputStream(new File("testSave")));
    LogEntry l = (LogEntry) ins.readObject();
    ins.close();
    System.out.println(l);
  }

  private static void save() throws IOException {
    LogEntry l = new LogEntry("test");
    ObjectOutputStream outs=new ObjectOutputStream(new FileOutputStream(new File("testSave")));
    outs.writeObject(l);
    outs.flush();
    outs.close();
  }

}