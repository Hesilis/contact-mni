package contact;

import java.util.ArrayList;
import java.util.List;

public class Dao implements IDao {

	private List<Contact> contacts;
	
	public Dao () {
		contacts = new ArrayList<Contact>();
	}
	
	/* (non-Javadoc)
	 * @see IDao#readAll()
	 */
	@Override
	public List<Contact> readAll () {
		return contacts;
	}
	
	/* (non-Javadoc)
	 * @see IDao#findByName(java.lang.String)
	 */
	@Override
	public Contact findByName (String name){
		if (name != null) {
			if (name.length() > 3 & name.length() <= 40) {
				for ( int i = 0; i < contacts.size(); i++) {
					if (name.equals(contacts.get(i).getName())) {
						return contacts.get(i);
					}
				}
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see IDao#add(Contact)
	 */
	@Override
	public void add (Contact contact) {
		/*if (contact != null) {
			if (contact.getName() != null) {
				if (contacts.size() == 0) {
					contacts.add(contact);
				} else if (findByName(contact.getName()) == null) {*/
					contacts.add(contact);
				/*} else {
					System.out.println("Le nom du contact est deja present en base");
				}
			}
		}*/
	}
	
	@Override
	public void delete (Contact contact) {
		/*if (contact != null) {
			if (contact.getName() != null) {
				if (contacts.size() == 0) {
					System.out.println("No contact in the list");
				} else if (findByName(contact.getName()) != null) {*/
					contacts.remove(contact);
				/*} else {
					System.out.println("Le contact n'est pas present en base");
				}
			}
		}*/
	}
}
