package pers.zv.url;

import java.io.IOException;

public class Use {
    public static void main(String[]arge) throws IOException {
        URLDemo02.get("https://github.com/explore");
        for(String temp:URLDemo02.urlList){
            System.out.println(temp);
        }
    }
}
