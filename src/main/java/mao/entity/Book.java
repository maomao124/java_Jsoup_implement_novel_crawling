package mao.entity;

import java.util.List;

/**
 * Project name(项目名称)：java_Jsoup实现小说爬取
 * Package(包名): mao.entity
 * Class(类名): Book
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/3
 * Time(创建时间)： 20:32
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public class Book
{
    /**
     * 名字
     */
    private String name;
    /**
     * 列表
     */
    private List<Catalogue> list;

    /**
     * Instantiates a new Book.
     */
    public Book()
    {
    }

    /**
     * Instantiates a new Book.
     *
     * @param name the name
     * @param list the list
     */
    public Book(String name, List<Catalogue> list)
    {
        this.name = name;
        this.list = list;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets list.
     *
     * @return the list
     */
    public List<Catalogue> getList()
    {
        return list;
    }

    /**
     * Sets list.
     *
     * @param list the list
     */
    public void setList(List<Catalogue> list)
    {
        this.list = list;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("name：").append(name).append('\n');
        stringbuilder.append("list：").append(list).append('\n');
        return stringbuilder.toString();
    }
}
