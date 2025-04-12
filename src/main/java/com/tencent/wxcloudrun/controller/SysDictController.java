package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.dto.PageResponse;
import com.tencent.wxcloudrun.model.SysDict;
import com.tencent.wxcloudrun.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sysDict")
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;

    @GetMapping("/list")
    public ApiResponse<PageResponse<SysDict>> list(PageRequest request) {
        return ApiResponse.ok(sysDictService.getDictList(request));
    }

    @GetMapping("/{id}")
    public ApiResponse<SysDict> getById(@PathVariable Long id) {
        return ApiResponse.ok(sysDictService.getDictById(id));
    }

    @PostMapping("/add")
    public ApiResponse<Void> add(@RequestBody SysDict sysDict) {
        sysDictService.addDict(sysDict);
        return ApiResponse.ok();
    }

    @PostMapping("/update")
    public ApiResponse<Void> update(@RequestBody SysDict sysDict) {
        sysDictService.updateDict(sysDict);
        return ApiResponse.ok();
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        sysDictService.deleteDict(id);
        return ApiResponse.ok();
    }
} 