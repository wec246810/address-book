package com.ysk.addressbook.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class HeaderCreate {
    Document document = null;
   public String  getHeaderURI(String html){
       document = Jsoup.parse(html);
       System.out.println( document.getElementById("imgResult").attr("src").toString());
      return document.getElementById("imgResult").attr("src").toString();
    }
}
