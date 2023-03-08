package com.example.course.response.page;

import com.example.course.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class PageInfoResponseImpl<T> implements PageInfoResponse<T> {
    private final List<T> data;
    private final Integer currentPage;
    private final Integer pageSize;

    @Override
    public List<T> getData() throws BadRequestException {
        int beignOffset = currentPage * pageSize;
        log.info("beignOffset : {}", beignOffset);

        int endOffset = beignOffset + pageSize;
        log.info("endOffset : {}", endOffset);

        if (endOffset > data.size()) {
            return data.subList(beignOffset, data.size());
        }
        return data.subList(beignOffset, endOffset);
    }

    @Override
    public Integer getCurrentPage() {
        return currentPage + 1;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    @Override
    public Integer getTotalPage() throws BadRequestException {
        int totalPage = (data.size() + pageSize - 1) / pageSize;
        log.info("totalPage : {}", totalPage);

        return totalPage;
    }

    @Override
    public Integer getTotalElement() {
        return data.size();
    }
}
