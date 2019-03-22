package 宽度优先示例;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RetrivePage {
    private static HttpClient httpClient = new HttpClient();

    static {
        httpClient.getHostConfiguration().setProxy("172.17.93.10", 8080);
    }

    public static boolean downloadPage(String path) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        //获取post方法
        PostMethod postMethod = new PostMethod(path);
        //设置post的方法参数
        NameValuePair[] postData = new NameValuePair[2];
        postData[0] = new NameValuePair("name", "lietu");
        postData[1] = new NameValuePair("password", "******");
        postMethod.addParameters(postData);
        int statusCode = httpClient.executeMethod(postMethod);
        System.err.println(statusCode);
        if (statusCode == HttpStatus.SC_OK) {
            input = postMethod.getResponseBodyAsStream();
            String filename = path.substring(path.lastIndexOf('/') + 1);
            output = new FileOutputStream(filename);
            int data = -1;
            while ((data = input.read()) > 0) {
                output.write(data);
            }
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
            return true;
        }

        return false;
    }

    public static void main(String[] arge) throws IOException {
       // RetrivePage.downloadPage("http://www.lietu.com");
        HttpClient httpClient = new HttpClient();
        //GetMethod getMethod = new GetMethod("http://www.baidu.com");
        //System.out.println(httpClient.executeMethod(getMethod));
        //System.out.println("response"+getMethod.getResponseBodyAsString());
        //getMethod.releaseConnection();
        PostMethod postMethod = new PostMethod("http://www.google.com");
        NameValuePair[] postData = new NameValuePair[2];
        postData[0]=new NameValuePair("武器","枪");
        postData[1]=new NameValuePair("什么枪","神枪");
        postMethod.addParameters(postData);
        int i = httpClient.executeMethod(postMethod);
        System.out.println(i+"\tresponse"+postMethod.getResponseBodyAsString());
        postMethod.releaseConnection();

    }
}
