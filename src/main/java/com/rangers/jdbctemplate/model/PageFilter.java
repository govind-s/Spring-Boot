package com.rangers.jdbctemplate.model;

public class PageFilter {

  private int offset = 0;
  private int limit = 10;
  private boolean pagedList = false;

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public boolean isPagedList() {
    return pagedList;
  }

  public void setPagedList(boolean pagedList) {
    this.pagedList = pagedList;
  }

}
