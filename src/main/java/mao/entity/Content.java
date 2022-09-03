package mao.entity;

/**
 * Project name(项目名称)：java_Jsoup实现小说爬取
 * Package(包名): mao.entity
 * Class(类名): Content
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/3
 * Time(创建时间)： 20:09
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public class Content
{
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;

    /**
     * Instantiates a new Content.
     */
    public Content()
    {

    }

    /**
     * Instantiates a new Content.
     *
     * @param title   the title
     * @param content the content
     */
    public Content(String title, String content)
    {
        this.title = title;
        this.content = content;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent()
    {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(String content)
    {
        this.content = content;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("title：").append(title).append('\n');
        stringbuilder.append("content：").append(content).append('\n');
        return stringbuilder.toString();
    }
}
