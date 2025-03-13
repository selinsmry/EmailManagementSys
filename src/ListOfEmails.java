import java.util.LinkedList;

public class ListOfEmails {

	private LinkedList<Email> email; // a linked list of EMAIL OBJECTS!

	public ListOfEmails() { // constructor
		this.email = new LinkedList<>();
	}

	public void add(Email myEmail) {
		// adds new email to the list
		email.add(myEmail);
	}

	public boolean read(int id) {
		// Show current Email details with the given email id.

		for (Email myEmail : email) {
			if (myEmail.getID() == id) {
				myEmail.setISREAD(true);
				System.out.println(myEmail);
				System.out.println("Status: Sent \n");
				return true;
			}
		}
		return false;
	}

	public Email delete(int id) {
		// Delete the Email with the given email id, and return the corresponding Email
		// object.

		for (Email myEmail : email) {
			if (myEmail.getID() == id) {
				email.remove(myEmail);
				return myEmail;
			}
		}

		return null;

	}

	public void showAll(boolean flag) {
		// Print all emails’ details in the list. If the flag is true, all emails are
		// shown. If the flag is false, only unread emails will be shown.

		// System.out.printf helps us to print formatted text. since we want our text to
		// be in a specific
		// alignment, we use system.out.printf here.

		System.out.printf("%-10s %-25s %-40s %-15s %-4s%n", "ID", "Subject", "Message", "Time", "Read");

		for (Email myEmail : email) {
			if (flag || !myEmail.getISREAD()) { // If showAll is true, show all emails; otherwise, only unread
				String subject = myEmail.getSBJ().length() > 25 ? myEmail.getSBJ().substring(0, 22) + "..."
						: myEmail.getSBJ();
				String message = myEmail.getMSG().length() > 40 ? myEmail.getMSG().substring(0, 37) + "..."
						: myEmail.getMSG();
				System.out.printf("%-10d %-25s %-40s %-15d %-4s%n", myEmail.getID(), subject, message,
						myEmail.getTIME(), myEmail.getISREAD() ? "Yes" : "No");
			}
		}

	}

	public void clear() {
		email.clear();
	}

	public int getSize() {
		return email.size();
	}

	public Email removeEmail(int index) {
		return email.remove(index);
	}

}
