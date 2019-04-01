package com.jingqi.util;

/**
 * 分页实体类
 * @author  Huxudong
 * @date    2019-02-17
 */
public class Page {
    /**
     * 每页开始
     */
    private Integer begin;
    /**
     * 当前页
     */
    private Integer currentPage = 1;
    /**
     * 默认每页显示的记录数
     */
    private Integer pageSize = 5;

    public Integer getBegin() {
        begin = (currentPage - 1) * pageSize;
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
