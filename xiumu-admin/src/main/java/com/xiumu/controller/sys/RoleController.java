package com.xiumu.controller.sys;

import com.xiumu.common.core.page.PageQuery;
import com.xiumu.common.core.result.ResultJSON;
import com.xiumu.pojo.sys.dto.RoleDTO;
import com.xiumu.pojo.sys.entity.Role;
import com.xiumu.pojo.sys.query.RoleQuery;
import com.xiumu.service.sys.AuthorityService;
import com.xiumu.service.sys.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 角色 Controller
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:52
 */
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthorityService authorityService;

    /**
     * 分页查询
     * 可传递查询参数，按照某些字段分页查询
     *
     * @param pageQuery 分页条件，查询参数
     * @return
     */
    @GetMapping("/role/page")
    public ResultJSON page(@Validated @RequestBody PageQuery<RoleQuery, Role> pageQuery) {
        return ResultJSON.success(roleService.listPage(pageQuery));
    }

    /**
     * 查询全部
     * 可传递查询参数，按照某些字段查询
     *
     * @param role 查询条件
     * @return
     */
    @GetMapping("/role")
    public ResultJSON list(@RequestBody RoleQuery role) {
        return ResultJSON.success(roleService.listByRole(role));
    }

    /**
     * 通过 ID 查询
     *
     * @param id ID
     * @return
     */
    @GetMapping("/role/{id}")
    public ResultJSON find(@PathVariable String id) {
        return ResultJSON.success(roleService.getById(id));
    }

    /**
     * 通过 ID 查询角色下的权限
     *
     * @param id ID
     * @return
     */
    @GetMapping("/role/{id}/auth")
    public ResultJSON authList(@PathVariable String id) {
        return ResultJSON.success(authorityService.listByRoleId(id));
    }

    /**
     * 创建 角色
     *
     * @param roleDTO role 信息
     * @return
     */
    @PostMapping("/role")
    public ResultJSON create(@Validated @RequestBody RoleDTO roleDTO) {
        return ResultJSON.success(roleService.create(roleDTO));
    }

    /**
     * 更新 角色
     * 根据传递的参数更新，字段为空则不更新
     *
     * @param roleDTO 更新内容
     * @param id      主键 ID
     * @return
     */
    @PutMapping("/role/{id}")
    public ResultJSON update(@Validated @RequestBody RoleDTO roleDTO, @PathVariable String id) {
        return ResultJSON.success(roleService.updateById(roleDTO, id));
    }

    /**
     * 通过 ID 逻辑删除
     *
     * @param id ID
     * @return
     */
    @DeleteMapping("/role/{id}")
    public ResultJSON delete(@PathVariable String id) {
        return ResultJSON.success(roleService.deleteById(id));
    }
}
