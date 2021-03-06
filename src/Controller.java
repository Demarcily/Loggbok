import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Controller {
  private View view = new View();
  private Model model = new Model();
  private JFrame frame;
  private JPanel panel;
  private JButton button;
  private JTextArea outputText;
  private JTextArea authorText;
  private JTextArea messageText;



  public static void main(String[] args) {
    new Controller();
  }

  public Controller() {
    frame = new JFrame("Log Entry");
    panel = new JPanel();
    frame.setPreferredSize(new Dimension(800,700));
    frame.add(panel);
    //OutputWindow
    outputText = new JTextArea(30, 70);
    outputText.setPreferredSize(new Dimension(30,70));
    outputText.setLineWrap(true);
    outputText.setEditable(false);
    panel.add(outputText);
    //MessageInput
    messageText = new JTextArea(2, 20);
    messageText.setLineWrap(true);
    panel.add(messageText);
    //AuthorInput
    authorText = new JTextArea(2, 20);
    authorText.setLineWrap(true);
    panel.add(authorText);

    messageText.setText("Message");
    authorText.setText("Author");

    //Create Add button
    button = new JButton("Add");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        view.setMessage(messageText.getText());
        view.setAuthor(authorText.getText());
        if (messageText.getText().isEmpty() || authorText.getText().isEmpty()) {
          outputText.setText("Text Missing");
        } else {
          model.add(view.getMessage(), view.getAuthor(), view.getCreatedAt(), view.getUpdatedAt());
        }
      }
    });
    panel.add(button);

    //Create Load button
    button = new JButton("Load");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        model.load(outputText);
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