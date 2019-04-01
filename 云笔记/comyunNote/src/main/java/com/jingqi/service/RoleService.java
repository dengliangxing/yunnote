package com.jingqi.service;

import com.jingqi.domain.Role;
import org.springframework.stereotype.Service;

/**
 * 角色service层
 * @author   Huxudong
 * @date     2019-02-25
 */
public interface RoleService {
    /**
     * 返回普通用户角色的实体类信息
     * @author      Huxudong
     * @date        2019-02-27
     * @return    一个角色的实体类信息
     */
    public Role findByType();

    /**
     * 根据用户的角色查询角色实体类
     * @author             Huxudong
     * @date               2019-02-27
     * @param roleType    用户的登录的角色
     * @return            用户角色的实体类信息
     */
    public Role findByRoleType(String roleType);
}
