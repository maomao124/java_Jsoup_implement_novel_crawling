package mao;

import mao.entity.Book;
import mao.entity.Catalogue;
import mao.service.CatalogueService;
import mao.service.Download;
import org.jsoup.select.Evaluator;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Project name(项目名称)：java_Jsoup实现小说爬取
 * Package(包名): mao
 * Class(类名): Run
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/3
 * Time(创建时间)： 22:58
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Run
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        System.out.println("----------小说下载-----------");
        System.out.println("数据来自：  http://www.biqu5200.net/");
        System.out.println("防止被检测，设置了随机休眠，可以设置随机休眠的最小时间和最大时间");
        System.out.println("配置文件在类路径下 speed.properties");
        System.out.println("输入要下载的书的目录网址（示例：http://www.biqu5200.net/52_52542/）：");
        Scanner input = new Scanner(System.in);
        String url = input.nextLine();
        int mode;
        System.out.println();
        System.out.println("1.下载保存为一个TXT文件，从头开始下载");
        System.out.println("2.保存为多个TXT文件，一个文件一个章节，从头开始下载");
        System.out.println("3.保存为多个TXT文件，一个文件一个章节，从指定章节开始下载");
        System.out.println("4.保存为多个JSON文件，一个文件一个章节，从头开始下载");
        System.out.println("5.保存为多个JSON文件，一个文件一个章节，从指定章节开始下载");
        System.out.println("6.下载保存为一个TXT文件，从指定章节开始下载");
        System.out.println("7.查看小说目录");
        System.out.println();
        System.out.println("请输入下载模式：");
        mode = input.nextInt();
        if (mode == 1)
        {
            System.out.println("开始下载");
            Download.toFile(url);
        }
        else if (mode == 2)
        {
            System.out.println("开始下载");
            Download.toFileDispersion(url);
        }
        else if (mode == 3)
        {
            System.out.println("请输入开始章节：");
            int start = input.nextInt();
            System.out.println("开始下载");
            Download.toFileDispersion(url, start);
        }
        else if (mode == 4)
        {
            System.out.println("开始下载");
            Download.toJsonFileDispersion(url);
        }
        else if (mode == 5)
        {
            System.out.println("请输入开始章节：");
            int start = input.nextInt();
            System.out.println("开始下载");
            Download.toJsonFileDispersion(url, start);
        }
        else if (mode == 6)
        {
            System.out.println("请输入开始章节：");
            int start = input.nextInt();
            System.out.println("开始下载");
            Download.toFile(url, start);
        }
        else if (mode == 7)
        {
            System.out.println("发起请求...");
            System.out.println("----------------------------------------");

            Book book = CatalogueService.getCatalogue(url);
            String bookName = book.getName();
            List<Catalogue> bookList = book.getList();
            System.out.println("书名：" + bookName);
            System.out.println("----------------------------------------");
            for (int i = 0; i < bookList.size(); i++)
            {
                Catalogue catalogue = bookList.get(i);
                System.out.printf("%-5d\t\t%s\n", i + 1, catalogue.getName());
            }
            System.out.println("----------------------------------------");
            System.out.println("一共" + bookList.size() + "章");

        }
        System.out.println("结束！");
    }
}
