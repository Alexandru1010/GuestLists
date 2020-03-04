package Proiect1;
import java.util.*;
import java.io.*;
import Proiect1.GuestList;
import java.io.FileNotFoundException;
public class MainTest {
	
	
	public static void help() {
		System.out.println("help - Afiseaza aceasta lista de comenzi" + "\n" +
							"add - Adauga o noua persoana (inscriere)" + "\n" +
							"check - Verifica daca o persoana este inscrisa la eveniment." + "\n" +
							"remove - Sterge o persoana existenta din lista." + "\n" +
							"update - Actualizeaza detaliile unei persoane." + "\n" +
							"guests - Lista de persoane care participa la eveniment." + "\n" +
							"waitlist - Persoanele din lista de asteptare." + "\n" +
							"available - Numarul de locuri libere." + "\n" +
							"guests_no - Numarul de persoane care participa la eveniment." + "\n" +
							"waitlist_no - Numarul de persoane din lista de asteptare." + "\n" +
							"subscribe_no - Numarul total de persoane inscrise." + "\n" +
							"search - Cauta toti invitatii conform sirului de caractere introdus." + "\n" +
							"quit - Inchide aplicatia!" );
		System.out.println();
	}

	public static void add(GuestList newEvent, Scanner sc) {
		System.out.println("Se adauga o noua persoana");
		System.out.println("Introduceti numele de familie:");
		String nume = sc.next();
		System.out.println("Introduceti prenumele:");
		String prenume = sc.next();
		System.out.println("Introduceti email:");
		String email = sc.next();
		System.out.println("Introduceti numar de telefon");
		String telefon = sc.next();
		Guest newGuest = new Guest(nume, prenume, email, telefon);
		newEvent.add(newGuest);
		System.out.println();
	}
	
	public static void check(GuestList newEvent, Scanner sc) {
		System.out.println("Se verifica daca persoana este inscrisa la eveniment");
		System.out.println("Alege modul de autentificare, tastand:" + "\n" +
							"1 - Nume si prenume" + "\n" +
							"2 - Email" + "\n" +
							"3 - Numar de telefon (format: +40733386463)");
		int optiuneCheck = sc.nextInt();
		while(optiuneCheck < 1 || optiuneCheck > 3) {
			System.out.println("Eroare! Introduceti optiunea potrivita");
			optiuneCheck = sc.nextInt();
		}
		
		if(optiuneCheck == 1) {
			System.out.println("Introduceti numele de familie:");
			String nume = sc.next();
			System.out.println("Introduceti prenumele:");
			String prenume = sc.next();
			if(!newEvent.searchByName(nume, prenume)){
				if(!newEvent.searcByNameWaitList(nume, prenume)) {
					System.out.println("Persoana nu exista in baza de date!");
				}
			}
		} else if (optiuneCheck == 2) {
			System.out.println("Introduceti email:");
			String email = sc.next();
			if(!newEvent.searchByEmail(email)) {
				if(!newEvent.searchByEmailWaitList(email)) {
					System.out.println("Persoana nu exista in baza de date!");
				}
			}
		} else if (optiuneCheck == 3) {
			System.out.println("Introduceti numar de telefon");
			String telefon = sc.next();
			if(!newEvent.searchByPhoneNumber(telefon)) {
				if(!newEvent.searchByPhoneWaitList(telefon)) {
					System.out.println("Persoana nu exista in baza de date!");
				}
			}
		} else {
			System.out.println("Optiunea selectata nu exista! Reincercati");
		}
	}
	
	public static void remove(GuestList newEvent, Scanner sc) {
		System.out.println("Se sterge o persoana din lista");
		System.out.println("Alege modul de autentificare, tastand:" + "\n" +
							"1 - Nume si prenume" + "\n" +
							"2 - Email" + "\n" +
							"3 - Numar de telefon (format: +40733386463)");
		int optiuneRemove = sc.nextInt();
		while(optiuneRemove > 3 || optiuneRemove < 1) {
			System.out.println("Eroare! Introduceti optiunea potrivita");
			optiuneRemove = sc.nextInt();
		}
	
		switch (optiuneRemove) {
			case 1:
				System.out.println("Introduceti numele de familie:");
				String nume = sc.next();
				System.out.println("Introduceti prenumele:");
				String prenume = sc.next();
				if(!newEvent.removeByName(nume, prenume)) {
					if(!newEvent.removeByNameWaitList(nume, prenume)) {
						System.out.println("Persoana nu exista in baza de date!");
					}
				}
				break;
			case 2:
				System.out.println("Introduceti email:");
				String email = sc.next();
				if(!newEvent.removeByEmail(email)) {
					if(!newEvent.removeByEmailWaitList(email)) {
						System.out.println("Persoana nu exista in baza de date!");
					}
				}
				break;
			case 3:
				System.out.println("Introduceti numar de telefon");
				String telefon = sc.next();
				if(!newEvent.removeByPhone(telefon)) {
					if(!newEvent.removeByPhoneWaitList(telefon)) {
						System.out.println("Persoana nu exista in baza de date!");
					}
				}
				break;
			default:
				System.out.println("Optiunea selectata nu exista! Reincercati");
		}
	}
	
	public static void update(GuestList newEvent, Scanner sc) {
		System.out.println("Se actualizeaza datele unei persoane");
		System.out.println("Alege modul de autentificare, tastand: " + "\n\t" +
							"1 - Nume si prenume" + "\n\t" +
							"2 - Email" + "\n\t" +
							"3 - Numar de telefon (format: +40733386463)");
		int optiuneUpdate = sc.nextInt();
		while(optiuneUpdate > 3 || optiuneUpdate < 1) {
			System.out.println("Eroare! Introduceti optiunea corecta!");
			optiuneUpdate = sc.nextInt();
		}
		
		switch (optiuneUpdate) {
		case 1:
			System.out.println("Introduceti numele de familie");
			String numeFamilie = sc.next();
			System.out.println("Introduceti prenumele");
			String prenume = sc.next();
			System.out.println("Alege campului de actualizat, tastant:" + "\n" +
								"1 - Nume "  + "\n" +
								"2 - Prenume" + "\n" +
								"3 - Email" + "\n" +
								"4 - Numar de telefon (format:'+40733386463')");
			int optiune1 = sc.nextInt();
			while(optiune1 < 1 || optiune1 > 4) {
				System.out.println("Eroare! Introduceti optiunea potrivita");
				optiune1 = sc.nextInt();
			}
			if(optiune1 ==1) {
				System.out.println("Introduceti numele");
				String nume = sc.next().toUpperCase();
				newEvent.updateLastName(newEvent.checkName(numeFamilie, prenume), nume);
			} else if (optiune1 == 2) {
				System.out.println("Introduceti prenumele");
				String prenume1 = sc.next();
				newEvent.updateFirstName(newEvent.checkName(numeFamilie, prenume), prenume1);
			} else if (optiune1 == 3) {
				System.out.println("Introduceti emailul");
				String email = sc.next();
				newEvent.updateEmail(newEvent.checkName(numeFamilie, prenume), email);
			}  else if (optiune1 == 4) {
				System.out.println("Introduceti nr de telefon");
				String telefon = sc.next();
				newEvent.updatePhoneNumber(newEvent.checkName(numeFamilie, prenume), telefon);
			} else {
				System.out.println("Eroare");
			}
			break;
		case 2:
			System.out.println("Introduceti email:");
			String emailUpdate = sc.next();
			System.out.println("Alege campului de actualizat, tastant:" + "\n" +
								"1 - Nume "  + "\n" +
								"2 - Prenume" + "\n" +
								"3 - Email" + "\n" +
								"4 - Numar de telefon (format:'+40733386463')");
			int optiune2 = sc.nextInt();
			while(optiune2 < 1 || optiune2 > 4) {
				System.out.println("Eroare! Introduceti optiunea potrivita");
				optiune2 = sc.nextInt();
			}
			if(optiune2 ==1) {
				System.out.println("Introduceti numele");
				String nume = sc.next();
				newEvent.updateLastName(newEvent.checkEmail(emailUpdate), nume);
			} else if (optiune2 == 2) {
				System.out.println("Introduceti prenumele");
				String prenume1 = sc.next();
				newEvent.updateFirstName(newEvent.checkEmail(emailUpdate), prenume1);
			} else if (optiune2 == 3) {
				System.out.println("Introduceti emailul");
				String email = sc.next();
				newEvent.updateEmail(newEvent.checkEmail(emailUpdate), email);
			}  else if (optiune2 == 4) {
				System.out.println("Introduceti nr de telefon");
				String telefon = sc.next();
				newEvent.updatePhoneNumber(newEvent.checkEmail(emailUpdate), telefon);
			} else {
				System.out.println("Eroare");
			}
			break;
		case 3 :
			System.out.println("Introduceti nunmarul de telefon:");
			String phoneUpdate = sc.next();
			System.out.println("Alege campului de actualizat, tastant:" + "\n" +
								"1 - Nume "  + "\n" +
								"2 - Prenume" + "\n" +
								"3 - Email" + "\n" +
								"4 - Numar de telefon (format:'+40733386463')");
			int optiune3 = sc.nextInt();
			while(optiune3 < 1 || optiune3 > 4) {
				System.out.println("Eroare! Introduceti optiunea potrivita");
				optiune3 = sc.nextInt();
			}
			if(optiune3 ==1) {
				System.out.println("Introduceti numele");
				String nume = sc.next();
				newEvent.updateLastName(newEvent.checkPhone(phoneUpdate), nume);
			} else if (optiune3 == 2) {
				System.out.println("Introduceti prenumele");
				String prenume1 = sc.next();
				newEvent.updateFirstName(newEvent.checkPhone(phoneUpdate), prenume1);
			} else if (optiune3 == 3) {
				System.out.println("Introduceti emailul");
				String email = sc.next();
				newEvent.updateEmail(newEvent.checkPhone(phoneUpdate), email);
			}  else if (optiune3 == 4) {
				System.out.println("Introduceti nr de telefon");
				String telefon = sc.next();
				newEvent.updatePhoneNumber(newEvent.checkPhone(phoneUpdate), telefon);
			} else {
				System.out.println("Eroare");
			}
			break;
		
		}
			
	}
	public static void guests(GuestList newEvent) {
		newEvent.guestListMembers();
		System.out.println();
	}
	public static void waitlist(GuestList newEvent) {
		newEvent.waitingListMembers();
		System.out.println();
	}
	public static void search(GuestList newEvent, Scanner sc) {
		System.out.println("Introduceti sirul: ");
		String letters = sc.next();
		newEvent.search(letters);
		System.out.println();
	}
	
	public static void available(GuestList newEvent) {
		System.out.println(newEvent.availableSeats());
	}
	
	public static void guestNo(GuestList newEvent) {
		newEvent.numberOfParticipants();
		System.out.println();
	}
	
	public static void waitListNo(GuestList newEvent) {
		System.out.println(newEvent.waitingList());
		System.out.println();
	}
	
	public static void subscribeNo(GuestList newEvent) {
		System.out.println(newEvent.allPersons());
		System.out.println();
	}
	public static void main(String[] args) throws FileNotFoundException{
	
		Scanner sc = new Scanner(new File("C:/Users/Alex/eclipse-workspace-M2/Proiect1/src/Proiect1/text.txt"));
		System.out.println("Bun venit! Introduceti numarul de locuri disponibile");
		int locuriDisponibile = sc.nextInt();
		while(locuriDisponibile < 0) {
			System.out.println("Introduceti o valoare pozitiva");
			locuriDisponibile = sc.nextInt();
		}
		//Scanner sc = new Scanner(System.in);
		GuestList newEvent = new GuestList(locuriDisponibile);
		System.out.println("Asteapta comanda: (Introduceti help - Afiseaza lista de comenzi)");
		String comanda = sc.next().toLowerCase();
		while(!comanda.equals("quit")) {
			if(comanda.equals("help")) {
				help();		
			} else if(comanda.equals("add")) {
				add(newEvent, sc);
			} else if(comanda.equals("check")) {
				check(newEvent, sc);
			} else if (comanda.equals("remove")) {
				remove(newEvent, sc);
			} else if (comanda.equals("update")) {
				update(newEvent, sc);
			} else if (comanda.equals("guests")) {
				guests(newEvent);
			} else if (comanda.equals("waitlist")) {
				waitlist(newEvent);
			} else if (comanda.equals("available")) {
				available(newEvent);
			} else if (comanda.equals("guests_no")) {
				guestNo(newEvent);
			} else if (comanda.equals("waitlist_no")) {
				waitListNo(newEvent);
			} else if (comanda.equals("subscribe_no")) {
				subscribeNo(newEvent);
			} else if (comanda.equals("search")) {
				search(newEvent, sc);
			} else {
				System.out.println("Comanda nu exista!");
			}	
			System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			comanda = sc.next().toLowerCase();
		}
		System.out.println("Aplicatia se inchide");
		sc.close();
	}
}