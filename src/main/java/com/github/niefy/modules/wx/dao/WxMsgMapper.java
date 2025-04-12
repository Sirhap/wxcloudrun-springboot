package com.github.niefy.modules.wx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.niefy.modules.wx.entity.WxMsg;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

/**
 * 微信消息
 * 
 * @author com.github.niefy
 * @date 2020-05-14 17:28:34
 */
@Mapper
@CacheNamespace(flushInterval = 10*1000L)//缓存过期时间（毫秒）
public interface WxMsgMapper extends BaseMapper<WxMsg> {
	
}
