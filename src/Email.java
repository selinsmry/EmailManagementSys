import java.text.SimpleDateFormat;
import java.util.Date;

public class Email {

	private int id;
	private String subject;
	private String message;
	private long time; // time is in milliseconds
	boolean read = false;

	// constructor
	public Email(int id, String subject, String message, long time, boolean read) {
		this.id = id;
		this.subject = subject;
		this.message = message;
		this.time = System.currentTimeMillis();
		; // milliseconds
		this.read = false;
	}

	// getter-setter functions
	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getSBJ() {
		return subject;
	}

	public void setSBJ(String subject) {
		this.subject = subject;
	}

	public String getMSG() {
		return message;
	}

	public void setMSG(String message) {
		this.message = message;
	}

	public long getTIME() {
		return time; // milliseconds
	}

	public void setTIME(long time) {
		this.time = time;
	}

	public boolean getISREAD() {
		return read;
	}

	public void setISREAD(boolean read) {
		this.read = read;
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String formattedTime = sdf.format(new Date(time)); // Convert milliseconds to Date object

		return "Email id: " + id + "\n" + "Email subject: " + subject + "\n" + "Message: " + message + "\n"
				+ "Time received: " + formattedTime + "\n" + "Read status: " + (getISREAD() ? "Read" : "Unread");
	}

}
