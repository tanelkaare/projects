package ee.tanker.tvkava;

import ee.tanker.tvkava.KavaElement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import org.apache.commons.lang.StringEscapeUtils;

public class KavaReader {
	KavaElement[] kavaElement;
	String test;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void collectElements(String url, String channel) throws IOException{
		//kas see meetod peaks olema KavaElement klassis?
		kavaElement = new KavaElement[100];
		Document kavaLeht = Jsoup.connect(url).get();
		String htmlData = kavaLeht.html();
		//Document kavaLeht = Jsoup.parseBodyFragment(bodyHtml, baseUri)
		//Elements kavaList = kavaLeht.select("li[class=event]");
		htmlData = StringEscapeUtils.unescapeJava(htmlData);
		htmlData = htmlData.replace("&quot;", "");
		htmlData = StringEscapeUtils.unescapeHtml(htmlData);
		test = htmlData;
		kavaLeht = Jsoup.parse(htmlData);
		Elements kavaList = kavaLeht.select("li[class=event]");
		//test =  test + "\nsain kokku " + kavaList.size();
		int count = 0;
		for (Element kavaItem: kavaList){
			if ((!kavaItem.select("span[class=type]").isEmpty()) && (kavaItem.select("span[class=type]").first().text() == "Film")){
				kavaElement[count] = new KavaElement();
				//kavaElement[count].test = kavaItem.html();
				kavaElement[count].time = kavaItem.select("span[class=time]").first().html();
				kavaElement[count].titleEst = kavaItem.select("span[class=event-title]").first().html();
			count++;
			}
		}
	}
}
