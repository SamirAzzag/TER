import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {

	Parser(){

	}

	public List<ArcShape> parseArcs(String s, boolean reverse){

		List<ArcShape> listArcs = new ArrayList<ArcShape>();

		Pattern compile1 = Pattern.compile("(?<=\\()\\d+(?=,)");
		Pattern compile2 = Pattern.compile("(?<=,)\\d+(?=\\))");
		Matcher matcher1 = compile1.matcher(s);
		Matcher matcher2 = compile2.matcher(s);

		while (matcher1.find() && matcher2.find()) {
			String group1 = matcher1.group();
			String group2 = matcher2.group();
			listArcs.add(new ArcShape(Integer.parseInt(group1), Integer.parseInt(group2), reverse));
		}

		return listArcs;
	}
}
