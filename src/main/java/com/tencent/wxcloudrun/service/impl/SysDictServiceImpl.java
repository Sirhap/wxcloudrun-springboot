package com.tencent.wxcloudrun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tencent.wxcloudrun.dao.SysDictMapper;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.dto.PageResponse;
import com.tencent.wxcloudrun.model.SysDict;
import com.tencent.wxcloudrun.service.SysDictService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author sirhao
* @description 针对表【sys_dict(系统字典表)】的数据库操作Service实现
* @createDate 2025-04-11 23:20:25
*/
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {

    @Override
    public PageResponse<SysDict> getDictList(PageRequest request) {
        List<SysDict> records = baseMapper.getDictList(request);
        long total = baseMapper.getDictCount(request);
        
        PageResponse<SysDict> response = new PageResponse<>();
        response.setRecords(records);
        response.setTotal(total);
        response.setSize(request.getSize());
        response.setCurrent(request.getPage());
        response.setPages((total + request.getSize() - 1) / request.getSize());
        
        return response;
    }

    @Override
    public SysDict getDictById(Long id) {
        return baseMapper.getDictById(id);
    }

    @Override
    public void addDict(SysDict sysDict) {
        baseMapper.addDict(sysDict);
    }

    @Override
    public void updateDict(SysDict sysDict) {
        baseMapper.updateDict(sysDict);
    }

    @Override
    public void deleteDict(Long id) {
        baseMapper.deleteDict(id);
    }
}




