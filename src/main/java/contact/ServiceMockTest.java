package contact;

import org.easymock.EasyMock;
import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

public class ServiceMockTest extends EasyMockSupport {

	@Rule
	public EasyMockRule rule = new EasyMockRule(this);
	
	@TestSubject
	private Service service = new Service();
	
	@Mock
	private IDao dao;
	
	@Test (expected = ContactExistException.class)
	public void testAddContact() throws ContactExistException {
		//1 - Enregistrement des comportements de Mocks
		Contact contact = new Contact();
		EasyMock.expect(dao.findByName("Gloups")).andReturn(contact);
		//2 - Fin d'enregistrement
		replayAll();
		//3 - Test
		service.add("Gloups");
	}
	
	@Test (expected = ContactNotExistException.class)
	public void testDeleteContact() throws ContactNotExistException {
		//
		EasyMock.expect(dao.findByName("Slurp")).andReturn(null);
		//
		replayAll();
		//
		service.delete("Slurp");
	}
	
	@Test
	public void testDeleteContactExist() throws ContactNotExistException {
		//
		Contact contact = new Contact();
		contact.setName("UnexistedContact");
		EasyMock.expect(dao.findByName(contact.getName())).andReturn(contact);
		dao.delete(contact);
		//
		replayAll();
		//
		service.delete(contact.getName());
	}
}
