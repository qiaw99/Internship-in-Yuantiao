package reflection;

public class PrivateObject {
	private String privateString;
	
	public PrivateObject(String privateString) {
		this.privateString = privateString;
	}
	
	@SuppressWarnings("unused")
	private String getPrivateString() {
		return this.privateString;
	}
}
