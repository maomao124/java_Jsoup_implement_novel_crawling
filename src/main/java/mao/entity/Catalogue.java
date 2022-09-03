package mao.entity;

/**
 * Project name(项目名称)：java_Jsoup实现小说爬取
 * Package(包名): mao.entity
 * Class(类名): Catalogue
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/3
 * Time(创建时间)： 20:14
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public class Catalogue
{
    /**
     * 名字
     */
    private String name;
    /**
     * href
     */
    private String href;

    /**
     * Instantiates a new Catalogue.
     */
    public Catalogue()
    {

    }

    /**
     * Instantiates a new Catalogue.
     *
     * @param name the name
     * @param href the href
     */
    public Catalogue(String name, String href)
    {
        this.name = name;
        this.href = href;
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
     * Gets href.
     *
     * @return the href
     */
    public String getHref()
    {
        return href;
    }

    /**
     * Sets href.
     *
     * @param href the href
     */
    public void setHref(String href)
    {
        this.href = href;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("name：").append(name).append('\n');
        stringbuilder.append("href：").append(href).append('\n');
        return stringbuilder.toString();
    }
}
