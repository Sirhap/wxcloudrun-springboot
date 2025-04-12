package com.tencent.wxcloudrun.dto;

import lombok.Data;

@Data
public class PageRequest {
    private Integer page = 1;
    private Integer size = 10;
    private String keyword;
    
    public Integer getOffset() {
        return size * (page - 1);
    }
} 