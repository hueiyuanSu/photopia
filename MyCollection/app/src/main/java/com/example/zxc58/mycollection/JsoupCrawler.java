package com.example.zxc58.mycollection;

/**
 * Created by KeIS on 20/12/2017.
 */

import java.io.File;
  import java.io.FileOutputStream;
  import java.io.IOException;
  import java.io.InputStream;
  import java.io.OutputStream;
  import java.net.URL;
  import java.net.URLConnection;
 import java.util.ArrayList;

 import org.jsoup.Jsoup;
 import org.jsoup.nodes.Document;
 import org.jsoup.nodes.Element;
 import org.jsoup.select.Elements;


 public class JsoupCrawler {

     private static final String saveImgPath="D:/NTUST/PROJECT/PHOTO";
     //圖片保存路徑

     public void getDoc() throws IOException{
         ArrayList<String> ar = new ArrayList<String>();
                 int n=0;
                 String s;
                 while(n<=19){
                         s="https://www.flickr.com/search/?text=%E9%A2%A8%E6%99%AF";
                     Document doc = Jsoup.connect(s).get();
                     //獲取後綴為png和jpg的圖片的元素集合
                    Elements pngs=null;
                   pngs = doc.select("img[src~=(?i)\\.jpg]");
                    for(Element e : pngs){

                            String src=e.attr("src");//獲取img中的src路徑
                            if(src.indexOf("http:")<0)
                                    src="http:"+src;
                             ar.add(src);
                             break;
                        }
                    n++;
                     }
                 //遍歷元素
                 int imageName=0;
                 for(String e : ar){
                         imageName=imageName+1;
                         System.out.print(e+"\n");
                         URL url = new URL(e);
                         URLConnection uri=url.openConnection();
                         //獲取數據流
                         InputStream is=uri.getInputStream();
                         //寫入數據流
                         OutputStream os = new FileOutputStream(new File(saveImgPath, imageName+".jpg"));
                         byte[] buf = new byte[1024];
                         int l=0;
                         while((l=is.read(buf))!=-1){
                                 os.write(buf, 0, l);
                                 os.flush();
                             }
                     }


                 }


             public static void main(String[] args) throws IOException {
                 new JsoupCrawler().getDoc(); //調用方法
             }
 }