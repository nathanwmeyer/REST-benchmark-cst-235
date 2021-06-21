package business;

import javax.ejb.Local;

import beans.Bible;

@Local
public interface WordSearchBusinessInterface {

	public String[] breakDown(String string);
	
	public int returnOccurences(Bible bible);

	public Bible getBible();
}
