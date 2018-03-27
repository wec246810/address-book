package com.ysk.addressbook.util;

import com.ysk.addressbook.entity.Student;
import com.ysk.addressbook.spider.HeaderCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Component
public class HttpUtils {

    @Autowired
    private HeaderCreate headerCreate;

    private  BufferedReader in = null;
    private  PrintWriter out = null;
    private  String result = null;
    private  URL realUrl = null;
    private  HttpURLConnection connection = null;

    /**
     *
     * @param url
     * @param param
     * @return
     */
    public  String doGet(String url, String... param) throws IOException {
//        System.setProperty("jsse.enableSNIExtension", "false");
            for (String s : param) {
                url += s;
            }
            initConnection(url);
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            close();
        return result;
    }
    /**
     *
     * @param testUrl
     * @param param
     * @return
     */
    public  String doPost(String testUrl, String param) throws IOException {
        initConnection(testUrl);
            out = new PrintWriter(connection.getOutputStream());
            out.print(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            close();
        System.out.println(param);
        System.out.println(result);
        return result;
    }

    /**
     *  下载图片
     * @param urlString
     * @param filename
     * @param savePath
     * @throws Exception
     */
    public  void download(String urlString, String filename, String savePath) throws Exception {
        initConnection(urlString);
        connection.setConnectTimeout(5 * 1000);
        InputStream is = connection.getInputStream();
        byte[] bs = new byte[1024];
        int len;
        File sf = new File(savePath);
        if (!sf.exists()) {
            sf.mkdirs();
        }
        OutputStream os = new FileOutputStream(sf.getPath() + "//" + filename);
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        close();
    }

    /**
     *
     */
    private  void close() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out != null) {
            out.close();
        }
    }

    /**
     *
     * @param urlstring
     */
    private  void initConnection(String urlstring) {
        try {
            realUrl = new URL(urlstring);
            connection = (HttpURLConnection) realUrl.openConnection();
            connection.setConnectTimeout(10000);
            connection.setRequestProperty("Charset", "UTF-8");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko Core/1.53.2372.400 QQBrowser/9.5.10548.400");
            connection.setRequestProperty("Accept",
                    "text/html, application/xhtml+xml, image/jxr, */*");
            connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
            connection.setRequestProperty("Accept-Language", "zh-Hans-CN,zh-Hans;q=0.5");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.connect();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedReader getBufferedReader(HttpURLConnection connection) throws IOException {
            return new BufferedReader(new InputStreamReader(connection.getInputStream()));
    }

     /**
     * 生成图片，并调用下载，放到指定位置
     * @param student
     * @throws Exception
     */
    public void saveHeaderImg(Student student) throws Exception {
        String path=new File(ResourceUtils.getURL("classpath:").getPath()).toString()+"/static/img/";
        String param="FontInfoId=392&FontSize=150&FontSize=#000000&ImageWidth=640&ImageHeight=640&ImageBgColor=#FFFFFF&Content="+student.getName()+"&ActionCategory=1";
        this.download(headerCreate.getHeaderURI(this.doPost("http://www.diyiziti.com/",param)),student.getSid()+".png",path);
    }
    /**
     * 设置cookie
     * @param response
     * @param name  cookie名字
     * @param value cookie值
     * @param maxAge cookie生命周期  以秒为单位
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        if(maxAge>0)  cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }


    /**
     * 根据名字获取cookie
     * @param request
     * @param name cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name){
        Map<String,Cookie> cookieMap = ReadCookieMap(request);
        if(cookieMap.containsKey(name)){
            Cookie cookie = (Cookie)cookieMap.get(name);
            return cookie;
        }else{
            return null;
        }
    }

    /**
     * 将cookie封装到Map里面
     * @param request
     * @return
     */
    private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

}
