package com.github.niefy.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 系统配置信息
 * @author Mark sunlightcs@gmail.com
 */
@Data
@TableName("sys_config")
public class SysConfigEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;
    @NotBlank(message = "参数名不能为空")
    private String paramKey;
    @NotBlank(message = "参数值不能为空")
    private String paramValue;
    private String remark;

}
