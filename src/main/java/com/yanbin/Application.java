package com.yanbin;

import com.yanbin.spider.SpiderCSLiepin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yanbin on 2017/7/16.
 */
public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext factory = new ClassPathXmlApplicationContext(
                "bean.xml");
        SpiderCSLiepin crawler = factory.getBean("spiderCSLiepin", SpiderCSLiepin.class);
        crawler.setThreads(25);
        crawler.setTopN(500);
        crawler.start(500);
    }
}
