package mao.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：java_Jsoup实现小说爬取
 * Package(包名): mao.service
 * Class(类名): Request
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/3
 * Time(创建时间)： 19:54
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Request
{
    /**
     * get请求
     *
     * @param urlString url字符串
     * @return {@link String}
     * @throws IOException IOException
     */
    public static String get(String urlString) throws IOException
    {
        return get(urlString, "gbk");
    }

    /**
     * get请求
     *
     * @param urlString   url字符串
     * @param charsetName 字符集名称
     * @return {@link String}
     * @throws IOException IOException
     */
    public static String get(String urlString, String charsetName) throws IOException
    {
        URL url = new URL(urlString);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.102 Safari/537.36 Edg/104.0.1293.70");
        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charsetName);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s;
        StringBuilder stringBuilder = new StringBuilder(10240);
        while ((s = bufferedReader.readLine()) != null)
        {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println(Request.get("http://www.biqu5200.net/52_52542/"));
    }
}
