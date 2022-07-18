package com.xiumu.controller.sys;

import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.common.core.result.ResultJSON;
import com.xiumu.pojo.sys.entity.Role;
import com.xiumu.pojo.sys.model.dto.RoleDTO;
import com.xiumu.pojo.sys.model.query.RoleQuery;
import com.xiumu.service.sys.service.RoleService;


/**
 * 使用 restful 风格。
 * URI 使用资源名称，而不是动作来描述：
 * 理论上 URI 不应该有动作，但是分页查询与全部查询怎么分开？
 * 错误命名:
 * GET     /getUser/1    查询 ID 是 1 的用户
 * POST    /createUser   新建一个用户
 * PUT     /updateUser/1 修改 ID 是 1 的用户
 * DELETE  /deleteUser/1 删除 ID 是 1 的用户
 * 正确命名:
 * GET     /user/1 查询 ID 是 1 的用户
 * POST    /user   新建一个用户
 * PUT     /user/1 修改 ID 是 1 的用户
 * DELETE  /user/1 删除 ID 是 1 的用户
 *
 * 角色 Controller
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:52
 */
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;


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
     * @param id 主键 ID
     * @return
     */
    @PutMapping("/role/{id}")
    public ResultJSON update(@Validated @RequestBody RoleDTO roleDTO, @PathVariable Long id) {
        return ResultJSON.success(roleService.updateById(roleDTO, id));
    }

    /**
     * 通过 ID 逻辑删除
     *
     * @param id ID
     * @return
     */
    @DeleteMapping("/role/{id}")
    public ResultJSON delete(@PathVariable Long id) {
        return ResultJSON.success(roleService.deleteById(id));
    }
}
