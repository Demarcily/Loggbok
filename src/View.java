import javax.swing.*;
import java.util.Date;

public class View {
  private Date createdAt = new Date();
  private Date updatedAt = new Date();
  private String message = "Hello";
  private String author = "Liam";

  public View() {

  }

  public String getMessage() {
    return message;
  }

  public String getAuthor() {
    return author;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public String toString() {
    return "LogEntry {" + "createdAt = " + createdAt
            + ", updatedAt = " + updatedAt + ", message = '" + message + "', author = '" + author + "'}";
  }
}
