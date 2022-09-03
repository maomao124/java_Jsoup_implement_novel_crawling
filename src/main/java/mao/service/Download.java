package mao.service;

import mao.entity.Book;
import mao.entity.Catalogue;
import mao.entity.Content;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Project name(项目名称)：java_Jsoup实现小说爬取
 * Package(包名): mao.service
 * Class(类名): Download
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/3
 * Time(创建时间)： 20:51
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Download
{
    public static int getIntRandom(int min, int max)
    {
        if (min > max)
        {
            min = max;
        }
        return min + (int) (Math.random() * (max - min + 1));
    }

    public static void toFile(String urlString) throws IOException, InterruptedException
    {
        //文字数量
        long size = 0;
        //获取目录和书名
        Book book = CatalogueService.getCatalogue(urlString);
        System.out.println("书名：" + book.getName());
        List<Catalogue> list = book.getList();
        System.out.println("一共" + list.size() + "章");
        System.out.println("开始获取正文");
        File file = new File(book.getName() + "txt");
        FileWriter fileWriter = new FileWriter(file);
        for (Catalogue catalogue : list)
        {
            System.out.println("开始缓存：" + catalogue.getName());
            Content content = ContentService.getContent(catalogue.getHref());
            String s = content.getContent();
            size = size + s.length();
            fileWriter.write(content.getTitle() + "\n\n");
            fileWriter.write(s);
            fileWriter.write("\n\n\n\n");
            fileWriter.flush();
            //随机休眠
            Thread.sleep(getIntRandom(200, 1000));

        }
        fileWriter.close();
        System.out.println("缓存完成，本书一共" + size + "字");
    }

    public static void main(String[] args) throws IOException, InterruptedException
    {
        toFile("http://www.biqu5200.net/52_52542/");
    }
}
