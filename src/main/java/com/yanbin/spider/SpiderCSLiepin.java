package com.yanbin.spider;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.yanbin.model.Job;
import com.yanbin.service.JobService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by yanbin on 2017/7/17.
 * 猎聘网 长沙 爬虫
 */
@Component
public class SpiderCSLiepin extends BreadthCrawler {

    private JobService jobService;

    @Autowired
    public SpiderCSLiepin(JobService jobService) {
        super("liepin", true);
        this.jobService = jobService;
        String str = "https://www.liepin.com/zhaopin/?industries=040%2C420%2C010%2C030&dqs=180020&key=";
        this.addSeed(str);
        this.addRegex("https://www.liepin.com/job/\\d*.shtml");
    }

    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
        if (page.matchUrl("https://www.liepin.com/job/\\d*.shtml")) {
            Job model = new Job();

            Elements elements2 = page.select("p.basic-infor span ");
            String city = elements2.get(0).text();
            model.setCity(city);
            String txtDate = elements2.get(1).text();
            Date now = new Date();
            String formatDay;
            if (txtDate.contains("分钟前")) {
                String minute = txtDate.replace("分钟前", "");
                formatDay = DateFormatUtils.format(DateUtils.addMinutes(now, -Integer.parseInt(minute)), "yyyy-MM-dd");
            } else if (txtDate.contains("小时前")) {
                String hour = txtDate.replace("小时前", "");
                formatDay = DateFormatUtils.format(DateUtils.addHours(now, -Integer.parseInt(hour)), "yyyy-MM-dd");
            } else if (txtDate.contains("刚刚")) {
                formatDay = DateFormatUtils.format(now, "yyyy-MM-dd");
            } else if (txtDate.contains("个月前")) {
                String month = txtDate.replace("个月前", "");
                formatDay = DateFormatUtils.format(DateUtils.addMonths(now, -Integer.parseInt(month)), "yyyy-MM-dd");
            } else {
                formatDay = txtDate;
            }
            model.setPublicDate(formatDay);
            if (!model.getCity().contains("长沙")) {
                return;
            }

            String position = page.select("div.title-info h1").text();
            String url = page.getUrl();
            String company = page.select("div.title-info h3").text();
            model.setPosition(position);
            model.setUrl(url);
            model.setCompanyName(company);

            StringBuilder advantage = new StringBuilder();
            Elements elements = page.select("div.tag-list span");
            for (Element element : elements) {
                advantage.append(element.text()).append(",");
                jobService.addCompanyKey(element.text());
            }
            model.setAdvantage(advantage.toString());
            String required = page.select("div.job-item.main-message div.content.content-word").text();
            model.setRequired(required);
            jobService.analyzeWord(required);
            Elements elements1 = page.select("div.job-qualifications span");
            StringBuilder qualifications = new StringBuilder();
            for (Element element : elements1) {
                qualifications.append(element.text()).append(",");
                jobService.addCompanyKey(element.text());
            }
            model.setExperience(qualifications.toString());
            String salary = page.select("p.job-item-title").text().split(" ")[0];
            model.setSalary(salary);

            jobService.addJob(model);
        }

    }
}
