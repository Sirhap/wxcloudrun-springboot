package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.dto.PageResponse;
import com.tencent.wxcloudrun.model.SysDict;

/**
* @author sirhao
* @description 针对表【sys_dict(系统字典表)】的数据库操作Service
* @createDate 2025-04-11 23:20:25
*/
public interface SysDictService {
    PageResponse<SysDict> getDictList(PageRequest request);
    SysDict getDictById(Long id);
    void addDict(SysDict sysDict);
    void updateDict(SysDict sysDict);
    void deleteDict(Long id);
}
