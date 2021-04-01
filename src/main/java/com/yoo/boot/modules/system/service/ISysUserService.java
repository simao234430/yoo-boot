package com.yoo.boot.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoo.boot.common.api.vo.Result;
import com.yoo.boot.modules.system.entity.SysUser;

public interface ISysUserService extends IService<SysUser> {
    /**
     * 校验用户是否有效
     * @param sysUser
     * @return
     */
    Result checkUserIsEffective(SysUser sysUser);
}
