import javax.swing.*;
import java.io.*;
import java.util.Date;

public class Model implements Serializable{
  Object LogEntry = null;

  public Model() {

  }

  public void add(String message, String author, Date createdAt, Date updatedAt) {
    Object LogEntry = "Message: " + message + " | Author: " + author + " | Created At: " +
            createdAt + " | Updated At: " + updatedAt + "\n";
    try {
      ObjectOutputStream outs = new ObjectOutputStream(new FileOutputStream(new File("Logbook")));
      outs.writeObject(LogEntry);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void load(JTextArea output) {
    try {
      ObjectInputStream ins = new ObjectInputStream(new FileInputStream(new File("Logbook")));
      Object Log = ins.readObject();
      ins.close();
      output.setText((String) Log);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }


}