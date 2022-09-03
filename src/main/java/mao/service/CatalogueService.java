package mao.service;

import mao.entity.Book;
import mao.entity.Catalogue;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Project name(项目名称)：java_Jsoup实现小说爬取
 * Package(包名): mao.service
 * Class(类名): CatalogueService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/3
 * Time(创建时间)： 20:06
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class CatalogueService
{
    /**
     * 获取目录
     *
     * @param urlString url字符串
     * @return {@link Book}
     * @throws IOException IOException
     */
    public static Book getCatalogue(String urlString) throws IOException
    {
        String html = Request.get(urlString);
        Document document = Jsoup.parse(html);
        List<Catalogue> list = new ArrayList<>(64);
        //System.out.println(document);
        Element element = document.getElementById("list");
        //System.out.println(element);
        assert element != null;
        Elements a = element.getElementsByTag("a");
        //System.out.println(a);
        for (int i = 0; i < a.size(); i++)
        {
            if (i < 9)
            {
                continue;
            }
            Element element1 = a.get(i);
            //System.out.println(element1);
            String href = element1.attr("href");
            String name = element1.html();
            //System.out.println(href);
            //System.out.println(s);
            Catalogue catalogue = new Catalogue();
            catalogue.setHref(href);
            catalogue.setName(name);
            list.add(catalogue);
        }

        //获取书名
        Elements h1 = document.getElementsByTag("h1");
        //System.out.println(h1);
        String name = h1.html();
        Book book = new Book();
        book.setName(name);
        book.setList(list);
        return book;
    }


    public static void main(String[] args) throws IOException
    {
        Book book = getCatalogue("http://www.biqu5200.net/52_52542/");
        System.out.println(book);
    }
}
