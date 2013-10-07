public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		String url = "http://campusravita.fi/index.php?id=2&week=true";
		String attr1 = "#lunchlist";
		String attr2 = "tr";
		
		Parser parser = new Parser();
		parser.getListAsText(url, attr1, attr2);
	}

}
