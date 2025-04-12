package com.tencent.wxcloudrun.dto;

import lombok.Data;
import java.util.List;

@Data
public class PageResponse<T> {
    private List<T> records;
    private long total;
    private long size;
    private long current;
    private long pages;
} 