package Spiders.url;

import java.io.IOException;
import java.util.HashSet;

public class Use {
    public static void main(String[] arge){
        String beginurl="http://www.cqyti.com/";//爬取网站
        String regular="http://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";//目标正则表达式
        MyQueue myQueue=new MyQueue();//url容器
        FindData findData=new FindData(beginurl,regular,myQueue);
        try {
            findData.find();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=0;
        while (i<2){
            try {
                findData.find(myQueue.getUrl());
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
       HashSet <String> urlSet=new HashSet<String>(myQueue.getList());
        System.out.println(urlSet);
        System.out.println(myQueue.size());
    }
}
