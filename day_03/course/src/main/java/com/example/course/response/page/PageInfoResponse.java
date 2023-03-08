package com.example.course.response.page;

import java.util.List;

public interface PageInfoResponse<T> {
    List<T> getData();

    Integer getCurrentPage();

    Integer getPageSize();

    Integer getTotalPage();

    Integer getTotalElement();
}
