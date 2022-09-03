package mao.service;

import mao.entity.Book;
import mao.entity.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Project name(项目名称)：java_Jsoup实现小说爬取
 * Package(包名): mao.service
 * Class(类名): ContentService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/3
 * Time(创建时间)： 20:39
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class ContentService
{
    /**
     * 获取内容
     *
     * @param urlString url字符串
     * @return {@link Content}
     * @throws IOException ioexception
     */
    public static Content getContent(String urlString) throws IOException
    {
        String html = Request.get(urlString);
        Document document = Jsoup.parse(html);
        //获取标题
        Element h1 = document.getElementsByTag("h1").first();
        assert h1 != null;
        String title = h1.html();
        //获取内容
        Element content = document.getElementById("content");
        //System.out.println(content);
        assert content != null;
        Elements p = content.getElementsByTag("p");
        StringBuilder stringBuilder = new StringBuilder(512);
        for (Element element : p)
        {
            String s = element.html().strip();
            //System.out.println(s);
            stringBuilder.append(s).append("\n");
        }
        //System.out.println(stringBuilder);
        //System.out.println(stringBuilder.length());
        Content content1 = new Content();
        content1.setTitle(title);
        content1.setContent(stringBuilder.toString());
        return content1;
    }


    public static void main(String[] args) throws IOException
    {
        Content content = getContent("http://www.biqu5200.net/52_52542/20380548.html");
        System.out.println(content);
    }
}
