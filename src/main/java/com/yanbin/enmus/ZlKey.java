package com.yanbin.enmus;

/**
 * Created by yanbin on 2017/7/15.
 */
public enum ZlKey {
    salary("职位月薪："),
    city("工作地点："),
    type("工作性质："),
    experience("工作经验："),
    education("最低学历："),
    number("招聘人数："),
    position("职位类别："),
    companySize("公司规模："),
    companyType("公司性质："),
    companyIndustry("公司行业："),
    companyAddress("公司地址："),
    publicDate("发布日期："),
    ;


    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    ZlKey(String key){
        this.key = key;
    }

    public static ZlKey parse(String value){
        if (null == value) {
            return null;
        }
        ZlKey[] coll = values();
        for (ZlKey item : coll) {
            if (item.getKey().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
