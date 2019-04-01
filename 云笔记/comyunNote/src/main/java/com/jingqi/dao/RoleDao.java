package com.jingqi.dao;

import com.jingqi.domain.Role;
import org.springframework.stereotype.Repository;

/**
 * 角色dao层
 * @author      Huxudong
 * @date        2019-02-25
 */
@Repository
public interface RoleDao {
    /**
     * 角色实体类信息
     * @author                Huxudong
     * @date                  2019-02-27
     * @param roleType        普通用户角色类型
     * @return                角色实体类信息
     */
    public Role findByType(String roleType);

    /**
     * 角色实体类信息
     * @author                Huxudong
     * @date                  2019-02-27
     * @param roleType        普通用户角色类型
     * @return                角色实体类信息
     */
    public Role findByRoleType(String roleType);
}
