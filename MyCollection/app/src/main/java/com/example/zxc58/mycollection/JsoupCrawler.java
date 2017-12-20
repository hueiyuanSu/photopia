package com.example.zxc58.mycollection;

/**
 * Created by KeIS on 20/12/2017.
 */


import java.net.URL;
        import java.util.Iterator;
        import org.jsoup.Jsoup;
        import org.jsoup.nodes.Document;
        import org.jsoup.nodes.Element;
        import org.jsoup.select.Elements;

public class JsoupCrawler {

    public static void main(String[] args) throws Exception{
        URL url = new URL("https://mmtstock.com/2");
        Document doc = Jsoup.parse(url, 3000);

        Elements tables = doc.select("img");
        tables.html();
    }

}