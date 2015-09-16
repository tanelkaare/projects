package ee.tanker.tvkava;

import ee.tanker.tvkava.KavaElement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class KavaReader {
	KavaElement[] kavaElement;
	String test;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void collectElements(String date, String channel) throws IOException{
		//kas see meetod peaks olema KavaElement klassis?
		kavaElement = new KavaElement[100];
		Document kavaLeht = Jsoup.connect("http://m.kava.delfi.ee/tvguide/fe/service.php?action=load_m_channel_events&t=m_guide_content&language_id=112&id=13&date=20150917").get();
		Elements kavaList = kavaLeht.select("li[class=event]");
		test = "sain kokku " + kavaList.size();
		int count = 0;
		for (Element kavaItem: kavaList){
			kavaElement[count] = new KavaElement();
			//kavaElement[count].test = kavaItem.html();
			kavaElement[count].time = kavaItem.select("span[class]").first().html();
			kavaElement[count].titleEst = kavaItem.select("span[class]").last().html();
			count++;
		}
	}
}
