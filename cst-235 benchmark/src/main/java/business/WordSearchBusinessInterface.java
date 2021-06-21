package business;

import beans.Bible;

public interface WordSearchBusinessInterface {

	public String[] breakDown(String string);
	
	public int returnOccurences(Bible bible);

	public Bible getBible();
}
