package contact;

public class Service {

	private IDao dao = new Dao ();
	
	public Service () {
		
	}
	
	public void add (String contactName) throws ContactExistException {
		if (contactName == null || contactName.length() < 3 || contactName.length() > 40) {
			throw new IllegalArgumentException("Name should be valid (3 to 40 char)");
		}
		
		Contact contact = this.dao.findByName(contactName);
		if (contact != null) {
			throw new ContactExistException ("There is already a contact with the name : " + contactName);
		}
		Contact newContact = new Contact(contactName);
		dao.add(newContact);
	}
	
	public void delete (String contactName) throws ContactNotExistException {
		if (contactName == null) {
			throw new IllegalArgumentException("Name can't be null");
		}
		
		Contact contact = dao.findByName(contactName);
		if (contact != null) {
			dao.delete(contact);
		} else {
			throw new ContactNotExistException ("contact " + contactName + " not found");
		}
	}
}
