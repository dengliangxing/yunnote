package com.jingqi.service.impl;

import com.jingqi.dao.RoleDao;
import com.jingqi.domain.Role;
import com.jingqi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色service的实现层
 * @author        Huxudong
 * @date          2019-02-25
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public Role findByType() {
        return this.roleDao.findByType("commonUser");
    }

    @Override
    public Role findByRoleType(String roleType) {
        return this.roleDao.findByRoleType(roleType);
    }
}
