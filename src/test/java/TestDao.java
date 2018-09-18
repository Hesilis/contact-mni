import contact.Contact;
import contact.ContactExistException;
import contact.Dao;
import contact.IDao;

public class TestDao {
	
	private static IDao dao;
	
	public static void testAdd () throws ContactExistException {
		int nbTest = 5;
		int nbSuccess = 0;
		dao = new Dao();
		
		if (testAddNullContact()) {
			nbSuccess++;
		}
		if (testAddShortName()) {
			nbSuccess++;
		}
		if (testAddLongName()) {
			nbSuccess++;
		}
		if (testAddWorkingContact()) {
			nbSuccess++;
		}
		if (testAddDejaVu()) {
			nbSuccess++;
		}
		
		System.out.println(nbSuccess + "/" + nbTest + " Success");
	}
	
	public static boolean testAddNullContact () throws ContactExistException {
		final Contact nullContact = null;
		System.out.println("=-=-=-=-=-=-=-=\nTest for null contact");
		dao.add(nullContact);
		if (dao.readAll().size() == 0) {
			System.out.println("OK");
			return true;
		} else {
			System.out.println("Fail");
			return false;
		}
	}
	
	public static boolean testAddShortName () throws ContactExistException {
		final Contact shortName = new Contact("ab");
		System.out.println("=-=-=-=-=-=-=-=\nTest for short name");
		dao.add(shortName);
		if (dao.readAll().size() == 0) {
			System.out.println("OK");
			return true;
		} else {
			System.out.println("Fail");
			return false;
		}
	}
	
	public static boolean testAddLongName () throws ContactExistException {
		final Contact longName = new Contact("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println("=-=-=-=-=-=-=-=\nTest for long name");
		dao.add(longName);
		if (dao.readAll().size() == 0) {
			System.out.println("OK");
			return true;
		} else {
			System.out.println("Fail");
			return false;
		}
	}
	
	public static boolean testAddWorkingContact () throws ContactExistException {
		final Contact workingContact = new Contact ("Gloups");
		System.out.println("=-=-=-=-=-=-=-=\nTest for working contact");
		dao.add(workingContact);
		if (dao.readAll().size() == 1) {
			System.out.println("OK");
			return true;
		} else {
			System.out.println("Fail");
			return false;
		}
	}
	
	public static boolean testAddDejaVu () throws ContactExistException {
		final Contact dejaVu = new Contact ("Gloups");
		System.out.println("=-=-=-=-=-=-=-=\nTest for Deja Vu name");
		dao.add(dejaVu);
		if (dao.readAll().size() == 1) {
			System.out.println("OK");
			return true;
		} else {
			System.out.println("Fail");
			return false;
		}
	}
	
	public static void main (String[] src) throws ContactExistException {
		System.out.println("================\nTest de Add");
		testAdd();
	}
}
