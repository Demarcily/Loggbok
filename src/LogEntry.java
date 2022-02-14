import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class LogEntry implements Serializable{
  private Date createdAt;
  private Date updatedAt;
  private String message;
  private String author;
  // Optional ArrayList<LogEntry> history;

  public LogEntry(String message, String author) {
    this.message = message;
    this.author = author;
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
}