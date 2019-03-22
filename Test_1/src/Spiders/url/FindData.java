package Spiders.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class FindData {
    private String url1=null;//开始网址
    private String regular=null;//正则表达式
    private MyQueue queue;//url队列容器
    public FindData(String url,String regular,MyQueue myQueue){
        this.regular=regular;
        this.queue=myQueue;
        this.url1=url;
    }

    public void find() throws IOException {
        if(url1==null){
            System.out.println("URL为空");
        }
        URL url=new URL(url1);
        //打开输入流
        BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
        String msg=null;
        //筛选器
        MyMatcher myMatcher=new MyMatcher(regular);
        while(null!=(msg=br.readLine())){
            String a=myMatcher.getGoal(msg);
            if(a!=null)
                queue.addUrl(a);
        }
        br.close();
    }
    public void find(String url2) throws IOException {
        URL url=new URL(url2);
        //打开输入流
        BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
        String msg=null;
        //筛选器
        MyMatcher myMatcher=new MyMatcher(regular);
        while(null!=(msg=br.readLine())){
            String a=myMatcher.getGoal(msg);
            if(a!=null)
                queue.addUrl(a);
        }
        br.close();
    }
}
