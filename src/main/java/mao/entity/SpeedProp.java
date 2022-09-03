package mao.entity;

import java.io.InputStream;
import java.util.Properties;

/**
 * Project name(项目名称)：java_Jsoup实现小说爬取
 * Package(包名): mao.entity
 * Class(类名): SpeedProp
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/3
 * Time(创建时间)： 21:54
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class SpeedProp
{
    /**
     * 最小睡眠时间
     */
    private static int minSleepTime = 200;

    /**
     * 最大值睡眠时间
     */
    private static int maxSleepTime = 1000;

    static
    {
        InputStream inputStream = SpeedProp.class.getClassLoader().getResourceAsStream("speed.properties");
        Properties properties = new Properties();
        try
        {
            properties.load(inputStream);
            String minSleepTime1 = properties.getProperty("minSleepTime");
            String maxSleepTime1 = properties.getProperty("maxSleepTime");
            int min = Integer.parseInt(minSleepTime1);
            int max = Integer.parseInt(maxSleepTime1);
            if (max < min)
            {
                throw new Exception();
            }
            if (max < 0 || min < 0)
            {
                throw new Exception();
            }
            maxSleepTime = max;
            minSleepTime = min;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 得到最小睡眠时间
     *
     * @return int
     */
    public static int getMinSleepTime()
    {
        return minSleepTime;
    }

    /**
     * 得到最大值睡眠时间
     *
     * @return int
     */
    public static int getMaxSleepTime()
    {
        return maxSleepTime;
    }
}
