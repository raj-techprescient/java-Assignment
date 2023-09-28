import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScraper {
    public static void main(String[] args){
        String url = "https://www.techprescient.com/";
        try {
            Document document = Jsoup.connect(url).get();

            Elements headlines = document.select("h1, h2, h3");

            System.out.println("Headlines:");
            for (Element headline : headlines) {
                System.out.println(headline.text());
            }

            Elements links = document.select("a");

            System.out.println("\nLinks:");
            for (Element link : links) {
                String linkText = link.text();
                String linkHref = link.attr("href");
                System.out.println(linkText + " (" + linkHref + ")");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


// To run this program java -cp .\jsoup-1.16.1.jar .\src\WebScraper.java

