import java.util.Scanner;

public class Application {
	private static int emailCounter = 0;
	private ListOfEmails INBOX;
	private ListOfEmails ARCHIVE;
	private ListOfEmails SENT;

	// constructor:
	public Application() {
		INBOX = new ListOfEmails();
		ARCHIVE = new ListOfEmails();
		SENT = new ListOfEmails();

	}

	public void start() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Commands: N , R <id>, A <id>, D <id>, S <folder>, U <folder>, C <folder>, Q.\n");
		
		while (true) {
			System.out.print("Enter command: ");
			String input;
			input = scanner.nextLine(); // read the whole line
			String[] inputParts = input.split(" "); // splits the input into parts by space character.

			if (inputParts.length > 0) {
				String character = inputParts[0];

				switch (character) {

				case "N":
				case "n":
					System.out.print("Enter subject: ");
					String subject = scanner.nextLine();

					System.out.print("Enter message: ");
					String message = scanner.nextLine();

					System.out.println("\n");

					emailCounter++;

					Email newEmail = new Email(emailCounter, subject, message, (int) System.currentTimeMillis(), false);

					SENT.add(newEmail);

					break;

				case "R":
				case "r":
					if (inputParts.length == 2) { // checks if the input is in the right format ( R <num> ).

						try {
							int id;
							id = Integer.parseInt(inputParts[1]);

							boolean found = false;

							if (INBOX.read(id) || ARCHIVE.read(id) || SENT.read(id)) {
								found = true;
							}
							if (!found) {
								System.out.println("No such email.\n");

							}
						} catch (NumberFormatException e) {

							System.out.println("Invalid ID. Please enter a number. Example : R 0\n");   // Error message
																										// without
																										// ending
																										// the program.

						}

					} else {
						System.out.println("Invalid input. Correct way : R <id>\n");

					}
					break;

				case "A":
				case "a":
					if (inputParts.length == 2) { // checks if the input is in the right format ( A <num> ).

						try {
							int id;
							id = Integer.parseInt(inputParts[1]);
							newEmail = INBOX.delete(id);
							if (newEmail == null) { // If not found in INBOX, check ARCHIVE
								newEmail = ARCHIVE.delete(id);
							}
							if (newEmail == null) { // If not found in ARCHIVE, check SENT
								newEmail = SENT.delete(id);
							}

							// If we found the email, add it to ARCHIVE
							if (newEmail != null) {
								ARCHIVE.add(newEmail);
								System.out.println("Email has been archived.\n");

							} else {
								System.out.println("No email found with ID: " + id + "\n");

							}
						} catch (NumberFormatException e) {

							System.out.println("Invalid ID. Please enter a number.\n"); // Error message without ending
																						// the
																						// program.

						}

					} else {
						System.out.println("Invalid input. Correct way : A <id>\n");

					}
					break;

				case "D":
				case "d":
					if (inputParts.length == 2) { // checks if the input is in the right format ( D <num> ).
						try {
							int id = Integer.parseInt(inputParts[1]); // Parse the ID from input

							boolean emailDeleted = false; // Flag to track if an email was deleted

							Email deletedEmail = INBOX.delete(id);
							if (deletedEmail != null) {
								System.out.println("Email " + id + " is deleted from Inbox.\n");

								emailDeleted = true; // Set flag to true
							}

							deletedEmail = ARCHIVE.delete(id);
							if (deletedEmail != null) {
								System.out.println("Email " + id + " is deleted from Archive.\n");

								emailDeleted = true;
							}

							deletedEmail = SENT.delete(id);
							if (deletedEmail != null) {
								System.out.println("Email " + id + " is deleted from Sent.\n");

								emailDeleted = true;

								// If no email was deleted from any list
								if (!emailDeleted) {
									System.out.println("No email found with ID: " + id + " in any list.\n"); // Print if
																												// not
																												// found

								}
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid ID. Please enter a number.\n"); // Error message for invalid
																						// number
																						// format

						}

					} else {
						System.out.println("Invalid input. Correct way : D <id>\n");

					}
					break;

				case "S":
				case "s":

					if (inputParts.length == 2) {
						String folder = inputParts[1].toUpperCase();

						switch (folder) {
						case "INBOX":
						case "İNBOX":
							if (INBOX.getSize() != 0) {
								System.out.println("Displaying Inbox:");
								INBOX.showAll(true);
								System.out.println("\n");
							} else {
								System.out.println("This folder is empty!\n");
							}

							break;

						case "ARCHIVE":
						case "ARCHİVE":
							if (ARCHIVE.getSize() != 0) {
								System.out.println("Displaying Archive:");
								ARCHIVE.showAll(true);
								System.out.println("\n");
							} else {
								System.out.println("This folder is empty!\n");
							}
							break;

						case "SENT":
							if (SENT.getSize() != 0) {
								System.out.println("Displaying Sent:");
								SENT.showAll(true);
								System.out.println("\n");
							} else {
								System.out.println("This folder is empty!\n");
							}
							break;

						default:
							System.out.println("Invalid folder. Choose from INBOX, ARCHIVE, SENT.\n");

							break;
						}

					} else {
						System.out.println("Invalid input. Correct way : S <folder>\n");

					}
					break;

				case "U":
				case "u":

					if (inputParts.length == 2) {
						String folder = inputParts[1].toUpperCase();

						switch (folder) {
						case "INBOX":
						case "İNBOX":
							if (INBOX.getSize() != 0) {
								System.out.println("Displaying Inbox:");
								INBOX.showAll(false);
								System.out.println("\n");
							} else {
								System.out.println("This folder is empty!\n");

							}
							break;

						case "ARCHIVE":
						case "ARCHİVE":
							if (ARCHIVE.getSize() != 0) {
								System.out.println("Displaying Archive:\n");
								ARCHIVE.showAll(false);
								System.out.println("\n");

							} else {
								System.out.println("This folder is empty!\n");

							}
							break;

						case "SENT":
							if (SENT.getSize() != 0) {
								System.out.println("Displaying Sent:\n");
								SENT.showAll(false);
								System.out.println("\n");

							} else {
								System.out.println("This folder is empty!\n");

							}
							break;

						default:
							System.out.println("Invalid folder. Choose from INBOX, ARCHIVE, SENT.\n");

							break;
						}

					} else {
						System.out.println("Invalid input. Correct way : U <folder>\n");

					}
					break;

				case "C":
				case "c":

					if (inputParts.length == 2) {
						String folder = inputParts[1].toUpperCase();

						switch (folder) {

						case "ARCHIVE":
						case "ARCHİVE":

							ARCHIVE.clear();
							System.out.println("Archive has been cleared. \n");

							break;

						case "INBOX":
						case "İNBOX":

							while (INBOX.getSize() > 0) {
								Email email = INBOX.removeEmail(0);
								ARCHIVE.add(email);

							}
							System.out.println("All emails in INBOX folder has been moved to ARCHIVE folder.\n");

							break;

						case "SENT":
							while (SENT.getSize() > 0) {
								Email email = SENT.removeEmail(0);
								ARCHIVE.add(email);

							}
							System.out.println("All emails in SENT folder has been moved to ARCHIVE folder.\n");

							break;

						default:
							System.out.println("Invalid folder. Choose from INBOX, ARCHIVE, SENT.\n");

							break;
						}

					} else {
						System.out.println("Invalid input. Correct way : C <folder>\n");

					}
					break;

				default:
					System.out.println(
							"Invalid command. Please enter:\nN, R <id>, A <id>, D <id>, S <Folder>, U <Folder>, C <Folder>.\n");
					break;
					
				case "Q":
                case "q":
                    System.out.println("Exiting the application.");
                    scanner.close(); 
                    return; // Exit the method and end the program
				}

			}
		}
	}
}
