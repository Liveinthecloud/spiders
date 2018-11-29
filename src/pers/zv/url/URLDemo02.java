package pers.zv.url;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zengwei
 * @date 2018/9/29 0029-上午 10:03
 * 获取资源：源代码
 */
public class URLDemo02 {
   static List<String> urlList=new ArrayList<>();
    public static void main(String[] Q_Q) throws IOException {
        URL url=new URL("https://www.csdn.net/gather_2f/MtTaUgzsMDUzNi1ibG9n.html");
        /*
        //获取资源 网路流
        InputStream is=url.openStream();

        //中间容器
        byte [] beff=new byte[1024];
        int len;
        while(-1!=(len=is.read(beff))){
            System.out.println(new String(beff,0,len));
        }
        is.close();
        */
        BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
        //输入到文件
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test.html"),
                "UTF-8"));
        String msg=null;
        while (null!=(msg=br.readLine())){
            URLDemo02.MyMatcher(msg);//读取一行，正则表达式提取url
            bw.write(msg);//写入test.html
            bw.newLine();
        }
        for(String temp:URLDemo02.urlList){
            System.out.println(temp);
        }
        bw.flush();
        br.close();
        bw.close();
    }
    public static void MyMatcher(String str){
        String wz=null;
        //网站正则表达式
        String wangzhi="[a-zA-Z]+://[^\\s]*";
        //Pattern对象
        Pattern pattern=Pattern.compile(wangzhi);
        //创建Matcher对象
        Matcher matcher=pattern.matcher(str);
        if(matcher.find())
        {
            //System.out.println(matcher.group());
            urlList.add(matcher.group());
        }
    }
}

