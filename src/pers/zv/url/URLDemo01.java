package pers.zv.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author zengwei
 * @date 2018/9/29 0029-上午 9:48
 * URL四部分:协议、存放资源的主机域名、端口、资源名(端口之后)
 */
public class URLDemo01 {
    public static void main(String[] Q_Q) throws MalformedURLException {
        URL url=new URL("http://www.baidu.com:80/index.html");
        System.out.println("协议:"+url.getProtocol());
        System.out.println("域名:"+url.getHost());
        System.out.println("端口:"+url.getPort());
        System.out.println("资源路径:"+url.getFile());
        System.out.println(url.toString());
    }
}
