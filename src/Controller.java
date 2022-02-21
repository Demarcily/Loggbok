import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Controller {
  private static View v = new View();
  private JFrame frame;
  private JPanel panel;
  private JButton button;
  private JTextArea text;



  public static void main(String[] args) {
    new Controller();
  }

  public Controller() {
    frame = new JFrame("Log Entry");
    panel = new JPanel();
    text = new JTextArea(30, 70);
    frame.add(panel);
    panel.add(text);

    // Create first button
    button = new JButton("Save");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        save();
      }
    });
    panel.add(button);

    // Create second button
    button = new JButton("Load");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        load();
      }
    });
    panel.add(button);



    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(true);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.requestFocus();
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