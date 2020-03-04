package Proiect1;
import java.util.*;
public class GuestList  {

	private int guestNumber;
	private int guestCount;
	private ArrayList<Guest> guestList;
	private ArrayList<Guest> waitingList;
	
	
	
	public GuestList(int guestNo) {
		this.guestNumber = guestNo;
		this.guestList = new ArrayList<Guest>(guestNo);
		this.waitingList = new ArrayList<Guest>();
	}
	

	public ArrayList<Guest> getGuestList() {
		return guestList;
	}
	
	public ArrayList<Guest> getWaitingList() {
		return waitingList;
	}
	
		
	// Contains
	public boolean isEqualName(Guest newGuest) {
		if (newGuest == null) {
			System.out.println("Utilizator invalid! Reincercati!");
			return false;
		}
		if(this.guestList.isEmpty()) {
			return false;
		}
		for(int i = 0; i < guestList.size(); i++) {
			if(guestList.get(i).getLastName().equalsIgnoreCase(newGuest.getLastName()) && 
				guestList.get(i).getFirstName().equalsIgnoreCase(newGuest.getFirstName())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isEqualEmail(Guest newGuest) {
		if (newGuest == null) {
			System.out.println("Utilizator invalid! Reincercati!");
			return false;
		}
		if(this.guestList.isEmpty()) {
			return false;
		}
		
		for (int i = 0; i < guestList.size(); i++) {
			if(guestList.get(i).getEmail().equalsIgnoreCase(newGuest.getEmail())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isEqualPhoneNo(Guest newGuest) {
		if (newGuest == null) {
			System.out.println("Utilizator invalid! Reincercati!");
			return false;
		}
		if (this.guestList.isEmpty()) {
			return false;
		}
		for (int i = 0; i < guestList.size(); i++) {
			if(guestList.get(i).getPhoneNumber().equals(newGuest.getPhoneNumber())){
				return true;
			}
		}
		return false;
	}
	
	// Add
	public int add(Guest newGuest) {
		if (newGuest == null) {
			System.out.println("Utilizator invalid! Reincercati!");
		}
		
		if(isEqualName(newGuest) && isEqualEmail(newGuest)
			&& isEqualPhoneNo(newGuest)) {
			System.out.println("Esti deja inscris la eveniment");
			return -1;
		} else if(isEqualEmail(newGuest)) {
			System.out.println("Esti deja inscris la eveniment/Adresa de email coincide "
								+ "cu adresa unei persoane deja inscrise");
			return -1;
		} else if( isEqualPhoneNo(newGuest)) {
			System.out.println("Esti deja inscris la eveniment/ "
								+ "Numarul de telefon coincide cu numarul de telefon al unei persoane deja incrise");
			return -1;
		}
		
		if(this.guestCount < this.guestNumber) {
			this.guestList.add(newGuest);
			this.guestCount++;
			System.out.println(newGuest.getLastName() + " " + newGuest.getFirstName() + " " +
								"Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
			return 0;
		} else {
			this.waitingList.add(newGuest);
			System.out.println(newGuest.getLastName() + " " + newGuest.getFirstName() + " " +
								"Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " + 
								(this.waitingList.size()) 
								+ ". Te vom notifica daca un loc devine disponibil.");
			return this.waitingList.size();
		}
		
	}
	
	// Remove
	public boolean removeByName(String lastName, String firstName) {
		if(lastName == null || firstName == null) {
			System.out.println("Numele sau prenumele este invalid");
			return false;
		}
		if(this.guestList.isEmpty()) {
			System.out.println("Lista invitatilor este goala!");
			return false;
		}
		for (int i = 0; i < guestList.size(); i++) {
			if( this.guestList.get(i).getLastName().equalsIgnoreCase(lastName) && 
				this.guestList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
				this.guestList.remove(i);
				this.guestCount--;
				System.out.println("Persoana a fost stearsa");
				if (!this.waitingList.isEmpty()) {
					this.guestList.add(this.waitingList.get(0));
					this.guestCount++;
					System.out.println(this.waitingList.get(0).getLastName() + " " + 
										this.waitingList.get(0).getFirstName() + " " 
									+ "Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
				
					this.waitingList.remove(0);
				}
				return true;
			}
		}
		return false;
	}
	
	public boolean removeByNameWaitList(String lastName, String firstName) {
		if(lastName == null || firstName == null) {
			System.out.println("Numele sau prenumele este invalid");
			return false;
		}
		
		if(!this.waitingList.isEmpty()) {
			for(int i = 0; i < this.waitingList.size(); i++) {
				if(this.waitingList.get(i).getLastName().equalsIgnoreCase(lastName) && 
					this.waitingList.get(i).getFirstName().equalsIgnoreCase(firstName)){
					this.waitingList.remove(i);
				}
			}
		}
		return false;
	}

	public boolean removeByPhone(String phoneNumber) {
		if(phoneNumber == null) {
			System.out.println("Numar de telefon invalid");
			return false;
		}
		if(this.guestList.isEmpty()) {
			System.out.println("Lista de invitati este goala!");
			return false;
		}
		for (int i = 0; i < guestList.size(); i++) {
			if(this.guestList.get(i).getPhoneNumber().equals(phoneNumber)) {
				this.guestList.remove(i);
				this.guestCount--;
				System.out.println("Persoana a fost stearsa");
				if (!this.waitingList.isEmpty()) {
					this.guestList.add(this.waitingList.get(0));
					this.guestCount++;
					System.out.println(this.waitingList.get(0).getLastName() + " " + 
										this.waitingList.get(0).getFirstName() + " " 
									+ "Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
			 
					this.waitingList.remove(0);
				}
				return true;
			}
			
		
		}
		return false;
	}
	public boolean removeByPhoneWaitList(String phoneNumber) {
		if(phoneNumber == null) {
			System.out.println("Numar de telefon invalid");
			return false;
		}
		if(this.waitingList.isEmpty()) {
			for(int i = 0; i <  this.waitingList.size(); i++) {
				if(this.waitingList.get(i).getPhoneNumber().equals(phoneNumber));{
					this.waitingList.remove(i);
					System.out.println("Persoana a fost stearsa!");
				}
			}
		}
		return false;
	}
	public boolean removeByEmail(String email) {
		if(email == null) {
			System.out.println("Email invalid");
			return false;
		}
		if(this.guestList.isEmpty()) {
			System.out.println("Lista invitatilor este goala!");
			return false;
		}
		for (int i = 0; i < guestList.size(); i++) {
			if(this.guestList.get(i).getEmail().equalsIgnoreCase(email)) {
				this.guestList.remove(i);
				this.guestCount--;
				System.out.println("Persoana a fost stearsa");
				if (!this.waitingList.isEmpty()) {
					this.guestList.add(this.waitingList.get(0));
					this.guestCount++;
					System.out.println(this.waitingList.get(0).getLastName() + " " + 
										this.waitingList.get(0).getFirstName() + " " 
										+ "Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
					this.waitingList.remove(0);
				}
				return true;
			} 
		}
		return false;
	}
	
	public boolean removeByEmailWaitList(String email) {
		if(email == null) {
			System.out.println("Email invalid");
			return false;
		}
		if(this.waitingList.isEmpty()) {
			for (int i = 0; i < this.waitingList.size(); i++) {
				if(this.waitingList.get(i).getEmail().equals(email)) {
					this.waitingList.remove(i);
					System.out.println("Persoana a fost stearsa!");
				}
			}
		}
		return false;
	}
	
	// Search phone
	public boolean searchByPhoneNumber(String phoneNumber) {
		if(phoneNumber == null) {
			System.out.println("Numar de telefon invalid");
			return false;
		}
		if (this.guestList.isEmpty()) {
			System.out.println("Lista invitatilor este goala.");
			return false;
		}
		
		for(int i = 0; i < this.guestList.size(); i++) {
			if(this.guestList.get(i).getPhoneNumber().equals(phoneNumber) ) {
				System.out.println("Persoana este inscrisa eveniment");
				return true;
			}
		} 
		System.out.println("Persoana nu este in lista de invitati");
		return false;
	}
	
	public boolean searchByPhoneWaitList(String phoneNumber) {
		if(phoneNumber == null) {
			System.out.println("Numar de telefon invalid");
			return false;
		}
		if (!this.waitingList.isEmpty()) {
			System.out.println("Lista de asteptare este goala");
			return false;
		}
		for(int i = 0; i < this.waitingList.size(); i++) {
			if(this.waitingList.get(i).getPhoneNumber().equals(phoneNumber)) {
				System.out.println("Persoana este pe lista de asteptare");
				return true;
			}
		}
	
		System.out.println("Persoana nu se afla pe lista de asteptare");
		return false;
	}
	// Search email
	public boolean searchByEmail(String email) {
		if(email == null) {
			System.out.println("Email invalid");
			return false;
		}
		if(this.guestList.isEmpty() ) {
			System.out.println("Lista invitatilor este goala.");
			return false;
		}
		for(int i = 0; i < this.guestList.size(); i++) {
			if(this.guestList.get(i).getEmail().equalsIgnoreCase(email)) {
				System.out.println("Persoana este in lista de asteptare");
				return true;
			}
		}
		
		return false;
	}
	
	public boolean searchByEmailWaitList(String email) {
		if(email == null) {
			System.out.println("Email invalid");
			return false;
		}
		if(this.waitingList.isEmpty()) {
			System.out.println("Lista de asteptare este goala");
			return false;
		}
		
		for(int i = 0; i < this.waitingList.size(); i++) {
			if(this.waitingList.get(i).getEmail().equalsIgnoreCase(email)) {
				System.out.println("Persoana este in lista de asteptare");
				return true;
			}
		}
		
		return false;
	}
	// Search by name
	public boolean searchByName(String lastName, String firstName) {
		if(lastName == null || firstName == null) {
			System.out.println("Numele sau prenumele este invalid");
			return false;
		}
		if(this.guestList.isEmpty()) {
			System.out.println("Lista invitatilor este goala.");
			return false;
		}
		
		for(int i = 0; i < this.guestList.size(); i++) {
			if(this.guestList.get(i).getLastName().equalsIgnoreCase(lastName) &&
				this.guestList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
				System.out.println("Persoana este inscrisa la eveniment");
				return true;
			}
		}
		System.out.println("Persoana nu este in lista de invitati");
		return false;
	}
	public boolean searcByNameWaitList(String lastName, String firstName) {
		if(lastName == null || firstName == null) {
			System.out.println("Numele sau prenumele este invalid");
			return false;
		}
		if(!this.waitingList.isEmpty()) {
			System.out.println("Lista de asteptare este goala");
			return false;
		}
		for(int i = 0; i < this.waitingList.size(); i++) {
			if(this.waitingList.get(i).getLastName().equalsIgnoreCase(lastName) && 
				this.waitingList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
				System.out.println("Persoana este inscrisa la eveniment");
				return true;
			} 
		}
		System.out.println("Persoana nu este in lista de asteptare");
		return false;
	}
	// check
	public Guest checkPhone(String phoneNumber) {
		if(phoneNumber == null) {
			System.out.println("Numar de telefon invalid");
			return null;
		}
		if(!this.guestList.isEmpty()) {
			for(int i = 0; i < this.guestList.size(); i++) {
				if(this.guestList.get(i).getPhoneNumber().equals(phoneNumber)) {
					return this.guestList.get(i);
				}
			}
		} else {
			System.out.println("Lista invitatilor este goala!");
		}
		
		if(!this.waitingList.isEmpty()) {
			for(int i = 0; i < this.waitingList.size(); i++) {
				if(this.waitingList.get(i).getPhoneNumber().equals(phoneNumber)) {
					return this.waitingList.get(i);
				}
			}
		} else {
			System.out.println("Liste de asteptare este goala!");
		}
		
		return null;
	}
	
	public Guest checkName(String lastName, String firstName) {
		if(lastName == null || firstName == null) {
			System.out.println("Numele sau prenumele este invalid");
			return null;
		}
		if(!this.guestList.isEmpty()) {
			for(int i = 0; i < this.guestList.size(); i++) {
				if(this.guestList.get(i).getLastName().equalsIgnoreCase(lastName) && 
					this.guestList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
					return this.guestList.get(i);
				}
			}
		} else {
			System.out.println("Lista invitatilor este goala!");
		}
		
		if(!this.waitingList.isEmpty()) {
			for(int i = 0; i < this.waitingList.size(); i++) {
				if(this.waitingList.get(i).getLastName().equalsIgnoreCase(lastName) && 
					this.waitingList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
					return this.waitingList.get(i);
				}
			}
		} else {
			System.out.println("Liste de asteptare este goala!");
		}
		return null;
	}
	
	public Guest checkEmail(String email) {
		if(email == null) {
			System.out.println("Email invalid");
			return null;
		}
		if(!this.guestList.isEmpty()) {
			for(int i = 0; i < this.guestList.size(); i++) {
				if(this.guestList.get(i).getEmail().equalsIgnoreCase(email)) {
					return this.guestList.get(i);
				}else {
					
				}
			}
		} else {
			System.out.println("Lista invitatilor este goala");
		}
		if(!this.waitingList.isEmpty()) {
			for(int i = 0; i < this.waitingList.size(); i++) {
				if(this.waitingList.get(i).getEmail().equalsIgnoreCase(email)) {
					return this.waitingList.get(i);
				}
			}
		} else {
			System.out.println("Lista de asteptare este goala");
		}
		return null;
	}
	//Update
	public void updatePhoneNumber(Guest newGuest, String newPhoneNb) {
		if(newGuest == null) {
			System.out.println("Persoana pe care o cautati nu se afla in sistem! Reincercati");
		} else {
			newGuest.setPhoneNumber(newPhoneNb);
		}
	}
		
	public void updateEmail(Guest newGuest, String newEmail) {
		if(newGuest == null) {
			System.out.println("Persoana pe care o cautati nu se afla in sistem! Reincercati");
		} else {
			newGuest.setEmail(newEmail);
		}
	}
	
	public void updateLastName(Guest newGuest, String newLastName) {
		if(newGuest == null) {
			System.out.println("Persoana pe care o cautati nu se afla in sistem! Reincercati");
		} else {
			newGuest.setLastName(newLastName);
		}
		
	}
	
	public void updateFirstName(Guest newGuest, String newFirstName) {
		if(newGuest == null) {
			System.out.println("Persoana pe care o cautati nu se afla in sistem! Reincercati");
		} else {
			newGuest.setFirstName(newFirstName);
		}
		
	}
	
	// Search
	
	public void search(String letters) {
		if(letters ==null) {
			System.out.println("Introduceti un sir de caractere valid!");
		}
		for(int i = 0; i < this.guestList.size();i++) {
			if(this.guestList.get(i).getLastName().toLowerCase().contains(letters) || 
				this.guestList.get(i).getFirstName().toLowerCase().contains(letters) ||
				this.guestList.get(i).getEmail().toLowerCase().contains(letters)) {
				System.out.println(this.guestList.get(i));
			}
		}
		
		for(int i = 0; i < this.waitingList.size(); i++) {
			if(this.waitingList.get(i).getLastName().toLowerCase().contains(letters) || 
			this.waitingList.get(i).getFirstName().toLowerCase().contains(letters) ||
			this.waitingList.get(i).getEmail().toLowerCase().contains(letters)) {
			System.out.println(this.waitingList.get(i));
			}
		}
	}
	
	// methods
	
	//5
	public void guestListMembers() {
		if(this.guestList.isEmpty()) {
			System.out.println("The Guest List is empty");
		}
		for(int i = 0; i < this.guestList.size(); i++) {
			System.out.println((i + 1) + " " + this.guestList.get(i));
			
		}
	}
	// 6
	public void waitingListMembers() {
		if (this.waitingList.isEmpty()) {
			System.out.println("Lista de asteptare este goala");
		}
		for(int i = 0; i < this.waitingList.size(); i++) {
			System.out.println((i + 1) + " " + this.waitingList.get(i));
			
		}
	}
	// 7
	public int availableSeats() {
		System.out.print("Numarul de locuri ramase: ");
		if(this.guestCount == this.guestNumber) {
			return 0;
		} else {
			return this.guestNumber - this.guestCount;
		}
	}
	// 8
	public void numberOfParticipants() {
		System.out.println("Numarul de participanti: " + this.guestCount);
	}
	//9
	public int waitingList() {
		System.out.print("Dimensiunea listei de asteptare: ");
		return this.waitingList.size();
	}
	// 10
	public int allPersons() {
		System.out.print("Numarul total de persoane: ");
		return this.guestCount + this.waitingList.size();
	}
	
	
	
}
