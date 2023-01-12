package com.example.liquibasedemo.service;

import cn.hutool.core.bean.BeanUtil;
import com.example.liquibasedemo.mapper.RoleMapper;
import com.example.liquibasedemo.po.Role;
import com.example.liquibasedemo.request.BasePageRequest;
import com.example.liquibasedemo.util.PageInfoUtils;
import com.example.liquibasedemo.vo.RoleVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    public Role selectByPrimaryKey(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public PageInfo<RoleVo> list(BasePageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Role> roles = roleMapper.selectAll();
        //
        PageInfo<Role> rolePageInfo = new PageInfo<>(roles);
        PageInfo<RoleVo> roleVoPageInfo = PageInfoUtils.Po2Vo(rolePageInfo, role -> {
            RoleVo roleVo = new RoleVo();
            BeanUtil.copyProperties(role, roleVo);
            return roleVo;
        });
//        List<RoleVo> roleVos = roles.stream().map(
//                role -> {
//                    RoleVo roleVo = new RoleVo();
//                    BeanUtil.copyProperties(role, roleVo);
//                    return roleVo;
//                }
//        ).collect(Collectors.toList());
        //PageInfo<RoleVo> roleVoPageInfo = new PageInfo<>(roleVos);
        return roleVoPageInfo;
    }
}
