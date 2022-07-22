package com.xiumu.controller.sys;

import com.xiumu.common.core.page.PageQuery;
import com.xiumu.common.core.result.ResultJSON;
import com.xiumu.pojo.sys.entity.UserRole;
import com.xiumu.pojo.sys.model.dto.UserRoleDTO;
import com.xiumu.pojo.sys.model.query.UserRoleQuery;
import com.xiumu.service.sys.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 用户角色关联 Controller
 *
 * @author XiuMu
 * @date 2022-07-23 01:07:42
 */
@RestController
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;


    /**
     * 分页查询
     * 可传递查询参数，按照某些字段分页查询
     *
     * @param pageQuery 分页条件，查询参数
     * @return
     */
    @GetMapping("/user/page")
    public ResultJSON page(@Validated @RequestBody PageQuery<UserRoleQuery, UserRole> pageQuery) {
        return ResultJSON.success(userRoleService.listPage(pageQuery));
    }

    /**
     * 查询全部
     * 可传递查询参数，按照某些字段查询
     *
     * @param userRole 查询条件
     * @return
     */
    @GetMapping("/user")
    public ResultJSON list(@RequestBody UserRoleQuery userRole) {
        return ResultJSON.success(userRoleService.listByUserRole(userRole));
    }

    /**
     * 通过 ID 查询
     *
     * @param id ID
     * @return
     */
    @GetMapping("/user/{id}")
    public ResultJSON find(@PathVariable String id) {
        return ResultJSON.success(userRoleService.getById(id));
    }

    /**
     * 创建 用户角色关联
     *
     * @param userRoleDTO userRole 信息
     * @return
     */
    @PostMapping("/user")
    public ResultJSON create(@Validated @RequestBody UserRoleDTO userRoleDTO) {
        return ResultJSON.success(userRoleService.create(userRoleDTO));
    }

    /**
     * 更新 用户角色关联
     * 根据传递的参数更新，字段为空则不更新
     *
     * @param userRoleDTO 更新内容
     * @param id          主键 ID
     * @return
     */
    @PutMapping("/user/{id}")
    public ResultJSON update(@Validated @RequestBody UserRoleDTO userRoleDTO, @PathVariable String id) {
        return ResultJSON.success(userRoleService.updateById(userRoleDTO, id));
    }

    /**
     * 通过 ID 逻辑删除
     *
     * @param id ID
     * @return
     */
    @DeleteMapping("/user/{id}")
    public ResultJSON delete(@PathVariable String id) {
        return ResultJSON.success(userRoleService.deleteById(id));
    }
}
