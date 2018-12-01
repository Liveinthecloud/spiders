package Spiders.url;

import java.util.LinkedList;

public class MyQueue {
    LinkedList<String> urllist;
    public MyQueue(){ urllist=new LinkedList<String>(); }
    public void addUrl(String url){
        urllist.addLast(url);
        System.out.println(url);
    }
    public String getUrl(){
        return urllist.removeFirst();
    }
    public String toString(){
        return urllist.toString();
    }
    public int size(){
        return urllist.size();
    }
}
