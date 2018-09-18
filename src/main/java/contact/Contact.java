package contact;

public class Contact {

	private String name;
		
	public Contact () {
		
	}
	
	public Contact (String name) {
		int nameLength = name.length();
		if (nameLength >= 3 && nameLength <= 40) {
			this.name = name;
		} else {
			System.out.println("Bad name length");
		}
	}
	
	public String getName () {
		return this.name;
	}

	public void setName(String name) {
		if (name != null) {
			this.name = name;	
		}
	}
}
