import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Controller {
  private View view = new View();
  private Model model = new Model();
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

    //Create Add button
    button = new JButton("Add");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        model.add(view.getMessage(), view.getAuthor());
      }
    });
    panel.add(button);

    //Create Save button
    button = new JButton("Save");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        model.save(view.getMessage(), view.getAuthor());
      }
    });
    panel.add(button);

    //Create Load button
    button = new JButton("Load");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        model.load();
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
}