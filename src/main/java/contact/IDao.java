package contact;

import java.util.List;

public interface IDao {

	List<Contact> readAll();

	Contact findByName(String name);

	void add(Contact contact);

	void delete(Contact removedContact);

}