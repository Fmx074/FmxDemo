package cn.bdqn.pojo;

import java.util.List;

public class PageBean<UserPojo> {
    private int totalPageCount = 0;
    private int pageSize;
    private int totalCount;
    private int currPageNo;
    private List<UserPojo> lists;

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        this.currPageNo = currPageNo;
    }

    public List<UserPojo> getLists() {
        return lists;
    }

    public void setLists(List<UserPojo> lists) {
        this.lists = lists;
    }
}
