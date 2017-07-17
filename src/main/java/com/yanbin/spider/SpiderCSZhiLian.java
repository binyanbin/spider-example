package com.yanbin.spider;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.yanbin.enmus.ZlKey;
import com.yanbin.model.Job;
import com.yanbin.service.JobService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * Created by yanbin on 2017/7/14.
 * 智联招聘 长沙 爬虫
 */
@Component
public class SpiderCSZhiLian extends BreadthCrawler {


    private JobService jobService;

    /**
     */
    @Autowired
    public SpiderCSZhiLian(JobService jobService) {
        super("zhilian", true);
        this.jobService = jobService;

        for (int i = 1; i <= 100; i++) {
            this.addSeed("http://sou.zhaopin.com/jobs/searchresult.ashx?bj=160000&in=210500%3b160400%3b160000%3b160500%3b160200%3b300100%3b160100%3b160600&jl=%E9%95%BF%E6%B2%99&isadv=0&p=" + i);
        }
        this.addRegex("http://jobs.zhaopin.com/\\d*\\.htm");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void visit(Page page, CrawlDatums next) {
        if (page.matchUrl("http://jobs.zhaopin.com/\\d*\\.htm")) {
            Job model = new Job();
            Elements elements = page.select("div ul.terminal-ul.clearfix li");
            for (Element element : elements) {
                String[] elementArray = new String[2];
                if (element.children().size() < 2) {
                    continue;
                }
                for (int i = 0; i < 2; i++) {
                    Element element1 = element.children().get(i);
                    elementArray[i] = element1.text();
                }
                ZlKey key = ZlKey.parse(elementArray[0]);
                if (key == ZlKey.city) {
                    model.setCity(elementArray[1]);
                } else if (key == ZlKey.companyAddress) {
                    model.setCompanyAddress(elementArray[1]);
                } else if (key == ZlKey.companyIndustry) {
                    model.setCompanyIndustry(elementArray[1]);
                } else if (key == ZlKey.companySize) {
                    model.setCompanySize(elementArray[1]);
                } else if (key == ZlKey.companyType) {
                    model.setCompanyType(elementArray[1]);
                } else if (key == ZlKey.education) {
                    model.setEducation(elementArray[1]);
                } else if (key == ZlKey.experience) {
                    model.setExperience(elementArray[1]);
                } else if (key == ZlKey.number) {
                    if (elementArray[1].equals("若干")) {
                        model.setNumber(0);
                    } else {
                        model.setNumber(Integer.parseInt(elementArray[1].replace("人", "")));
                    }
                } else if (key == ZlKey.position) {
                    model.setPosition(elementArray[1]);
                } else if (key == ZlKey.salary) {
                    model.setSalary(elementArray[1]);
                } else if (key == ZlKey.publicDate) {
                    Date now = new Date();
                    Date publicDate;
                    if (elementArray[1].contains("天前")) {
                        publicDate = DateUtils.addDays(now, -Integer.parseInt(elementArray[1].replace("天前", "")));
                    } else {
                        publicDate = now;
                    }
                    model.setPublicDate(DateFormatUtils.format(publicDate, "yyyy-MM-dd"));
                }
            }
            if (!model.getCity().contains("长沙"))
                return;

            Elements elementsTitle = page.select(".fixed-inner-box div h1");
            if (isExists(elementsTitle)) {
                jobService.analyzeWord(elementsTitle.text());
                model.setTitle(elementsTitle.text());
            }
            Elements elementsName = page.select(".fixed-inner-box div h2 a");
            if (isExists(elementsName)) {
                model.setCompanyName(page.select(".fixed-inner-box div h2 a").text());
            }
            Elements advantageElements = page.select(".fixed-inner-box div.welfare-tab-box span");
            StringBuilder advantage = new StringBuilder();
            for (Element element : advantageElements) {
                String key = element.text();
                jobService.addCompanyKey(key);
                advantage.append(key).append(",");
            }
            model.setAdvantage(advantage.toString());


            Elements elements1 = page.select("div.tab-cont-box div.tab-inner-cont");
            if (isExists(elements1)) {
                String content = elements1.first().text();
                jobService.analyzeWord(content);
                model.setRequired(content);
            }
            model.setUrl(page.getUrl());
            jobService.addJob(model);
        }
    }

    private boolean isExists(Elements elements) {
        if (elements != null) {
            if (elements.first() != null &&
                    StringUtils.isNotBlank(elements.first().text())) {
                return true;
            }
        }
        return false;
    }
}
