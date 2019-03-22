package Spiders.url;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyMatcher {
    static int num=0;
    String type=null;//存放查找目标的正则表达式
    public MyMatcher(String type){this.type=type;}
    //查找目标，找打返回目标
    public String getGoal(String data){
        Pattern pattern=Pattern.compile(type);
        Matcher matcher=pattern.matcher(data);

        if(matcher.find()){
            System.out.println(num+++" "+matcher.group());
            return matcher.group();
        }

        return null;
    }
//    public static void main(String[] arge){
//        System.out.println(new MyMatcher("http://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?").getGoal(
//                "<link rel=\"dns-prefetch http://www.baidu.com\" href=\"https://assets-cdn.github.com\">"
//        ));
//
//    }
}
