package com.yanbin.service;

import com.yanbin.dao.CompanyKeyMapper;
import com.yanbin.dao.ContentKeyMapper;
import com.yanbin.dao.JobMapper;
import com.yanbin.model.CompanyKey;
import com.yanbin.model.ContentKey;
import com.yanbin.model.Job;
import com.yanbin.model.JobExample;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yanbin on 2017/7/15.
 */
@Service
public class JobService {

    private JobMapper jobMapper;
    private CompanyKeyMapper companyKeyMapper;
    private ContentKeyMapper contentKeyMapper;

    @Autowired
    public JobService(JobMapper jobMapper, CompanyKeyMapper companyKeyMapper, ContentKeyMapper contentKeyMapper) {
        this.jobMapper = jobMapper;
        this.contentKeyMapper = contentKeyMapper;
        this.companyKeyMapper = companyKeyMapper;
    }

    public void addJob(Job job) {
        JobExample jobExample = new JobExample();
        jobExample.createCriteria().andUrlEqualTo(job.getUrl());
        int count = jobMapper.countByExample(jobExample);
        if (count == 0) {
            jobMapper.insert(job);
        }
    }

    public synchronized void addCompanyKey(String key) {
        CompanyKey companyKey = companyKeyMapper.selectByPrimaryKey(key);
        if (companyKey == null) {
            companyKey = new CompanyKey();
            companyKey.setTextKey(key);
            companyKey.setCount(1);
            companyKeyMapper.insert(companyKey);
        } else {
            companyKey.setCount(companyKey.getCount() + 1);
            companyKeyMapper.updateByPrimaryKey(companyKey);
        }
    }


    private synchronized void addContentKey(String key) {
        ContentKey contentKey = contentKeyMapper.selectByPrimaryKey(key);
        if (contentKey == null) {
            contentKey = new ContentKey();
            contentKey.setTextKey(key);
            contentKey.setCount(1);
            contentKeyMapper.insert(contentKey);
        } else {
            contentKey.setCount(contentKey.getCount() + 1);
            contentKeyMapper.updateByPrimaryKey(contentKey);
        }
    }

    public void analyzeWord(String content) {
        Result wordResult = ToAnalysis.parse(content);
        List<Term> terms = wordResult.getTerms();
        for (Term term : terms) {
            String key = term.getName().replaceAll("[\\pP‘’“”]", "");
            if (StringUtils.isNotBlank(key)) {
                addContentKey(key);
            }
        }
    }
}

