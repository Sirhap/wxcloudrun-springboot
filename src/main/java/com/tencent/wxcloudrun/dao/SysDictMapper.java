package com.tencent.wxcloudrun.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.SysDict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author sirhao
* @description 针对表【sys_dict(系统字典表)】的数据库操作Mapper
* @createDate 2025-04-11 23:20:25
* @Entity com.tencent.wxcloudrun.model.SysDict
*/
@Mapper
public interface SysDictMapper extends BaseMapper<SysDict> {
    List<SysDict> getDictList(PageRequest request);
    long getDictCount(PageRequest request);
    SysDict getDictById(@Param("id") Long id);
    void addDict(SysDict sysDict);
    void updateDict(SysDict sysDict);
    void deleteDict(@Param("id") Long id);
}




