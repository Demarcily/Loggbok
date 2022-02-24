import javax.swing.*;
import java.io.*;

public class Model implements Serializable{


  public Model() {

  }

  public void add(String message, String author) {
    Object LogEntry = "Message: " + message + " | Author: " + author + " | Created At: " + " | Updated At: " ;
    try {
      ObjectOutputStream outs = new ObjectOutputStream(new FileOutputStream(new File("Logbook")));
      outs.writeObject(LogEntry);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void save(String message, String author) {
  /*
    try {
      Model l = new Model(v.getMessage(), v.getAuthor());
      ObjectOutputStream outs = new ObjectOutputStream(new FileOutputStream(new File("Logbook")));
      outs.writeObject(l);
      outs.flush();
      outs.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
   */
  }

  public void load(JTextArea input) {
    try {
      ObjectInputStream ins = new ObjectInputStream(new FileInputStream(new File("Logbook")));
      Object Log = ins.readObject();
      ins.close();
      input.setText((String) Log);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  /*
    try {
      ObjectInputStream ins = new ObjectInputStream(new FileInputStream(new File("Logbook")));
      Model l = (Model) ins.readObject();
      ins.close();
      System.out.println(l);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
   */
  }
}