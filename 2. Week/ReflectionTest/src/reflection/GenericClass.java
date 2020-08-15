package reflection;

import java.util.List;

public class GenericClass {
	public List<String> stringList;
	
	public List<String> getStringList(){
		return this.stringList;
	}
	
	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}

}
