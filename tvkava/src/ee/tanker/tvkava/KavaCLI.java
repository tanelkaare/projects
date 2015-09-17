package ee.tanker.tvkava;

import java.io.IOException;
import ee.tanker.tvkava.KavaReader;

public class KavaCLI {

	public KavaCLI() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		KavaReader kReader = new KavaReader();
		//response.setContentType("text/html");
		
		kReader.collectElements("http://m.kava.delfi.ee/tvguide/fe/service.php?action=load_m_channel_events&t=m_guide_content&language_id=112&id=13&date=20150918", "b");
		//kReader.collectElements("http://m.kava.delfi.ee/kava/","b");
		System.out.println("sisu:");
		System.out.println(kReader.test);
		/*
		System.out.println("<table>");
		for (int i=0; i < kReader.kavaElement.length; i++){
			if (kReader.kavaElement[i] != null){
				System.out.println("<tr>");
				System.out.println("<td>" + kReader.kavaElement[i].time + "</td>");
				System.out.println("<td>" + kReader.kavaElement[i].titleEst + "</td>");
				System.out.println("</tr>");
			}
		}
		System.out.println("</table>");
		*/
	}

}
