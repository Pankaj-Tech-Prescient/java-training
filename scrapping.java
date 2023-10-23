import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class scrapping {
    public static void main(String[] args){
        String url = "https://www.bbc.com/news";
        try {
            Document document = Jsoup.connect(url).get();

            Elements headlines = document.select("h1");
            System.out.println("Headlines:");
            for (Element element: headlines){
                System.out.println(element.text());
            }

            Elements links = document.select("a[href]");
            System.out.println("\nLinks:");
            for (Element link: links){
                String href = link.attr("href");
                String text = link.text();
                System.out.println(text + " - " + href);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

// Run this program using below commands
// javac -cp .:libs/jsoup-1.16.2.jar scrapping.java
// java -cp .:libs/jsoup-1.16.2.jar scrapping
