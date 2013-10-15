import java.io.IOException;
import java.util.LinkedList;
import org.jsoup.*;
import org.jsoup.select.*;
import org.jsoup.nodes.*;

//http://campusravita.fi/index.php?id=2&week=true
//#lunchlist
//tr
class Parser {
	
	LinkedList<String> content = new LinkedList();
	Document doc;
	Elements lunchlist;
	
	public Parser() {

	}

	/**
	 * Parses HTML by given attributes.
	 * 
	 * @param url	URL to parse
	 * @param attr1	HTML element or id to parse
	 * @param attr2	HTML element or id to parse
	 */
	public void getListAsText(String url, String attr1, String attr2) {
		
		try {
			doc = Jsoup.connect(url).timeout(10000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lunchlist = doc.select(attr1);
		lunchlist = lunchlist.select(attr2);

		for(int i = 0; i < lunchlist.size(); i++) {
			content.add(lunchlist.get(i).text());
			System.out.println(content.get(i));
		}
	}
	
	/**
	 * Parses HTML by given attributes.
	 * 
	 * @param url 	URL to parse
	 * @param attr1	HTML element or id to parse
	 */
	public void getListAsHTML(String url, String attr1) {
		
		try {
			doc = Jsoup.connect(url).timeout(10000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lunchlist = doc.select(attr1);

		for(int i = 0; i < lunchlist.size(); i++) {
			content.add(lunchlist.get(i).text());
			System.out.println(content.get(i));
		}
	}
    
    /** Returns parsed list 
     *
     * @return processed list
     */
	public LinkedList<String> getList() {
		return content;
	}

	


}
