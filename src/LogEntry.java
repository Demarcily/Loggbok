import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class LogEntry implements Serializable{
  private Date createdAt;
  private Date updatedAt;
  private String message;
  // Optional ArrayList<LogEntry> history;

  public LogEntry(String message) {
    this.message = message;
    createdAt = new Date();
    updatedAt = new Date();
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "LogEntry{" + "createdAt=" + createdAt
            + ", updatedAt=" + updatedAt + ", message='" + message + '\'' + '}';
  }

  // Optional: add old version to history
  public void update(String newMessage) {

  }
}