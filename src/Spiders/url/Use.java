package Spiders.url;

import java.io.IOException;

public class Use {
    public static void main(String[] arge){
        String beginurl="https://www.qq.com/";//爬取网站
        String regular="http://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";//目标正则表达式
        MyQueue myQueue=new MyQueue();//url容器
        FindData findData=new FindData(beginurl,regular,myQueue);
        try {
            findData.find();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=0;
        while (i<50){
            try {
                findData.find(myQueue.getUrl());
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
        System.out.println(myQueue.size());
    }
}
