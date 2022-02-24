import java.util.Date;

public class View {
  private Date createdAt = new Date();
  private Date updatedAt = new Date();
  private String message;
  private String author;

  public View() {

  }

  //Gets
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

  //Sets
  public void setMessage(String message) {
    this.message = message;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
