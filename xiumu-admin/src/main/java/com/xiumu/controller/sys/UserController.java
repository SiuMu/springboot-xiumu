package com.xiumu.controller.sys;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.common.core.result.ResultJSON;
import com.xiumu.pojo.sys.dto.UserDTO;
import com.xiumu.pojo.sys.entity.Role;
import com.xiumu.pojo.sys.entity.User;
import com.xiumu.pojo.sys.query.UserQuery;
import com.xiumu.pojo.sys.vo.UserRoleAuthVO;
import com.xiumu.service.sys.RoleService;
import com.xiumu.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 用户 Controller
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:37
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    /**
     * 分页查询
     * 可传递查询参数，按照某些字段分页查询
     *
     * @param pageQuery 分页条件，查询参数
     * @return
     */
    @PostMapping("/page/user")
    public ResultJSON<IPage<User>> page(@RequestBody PageQuery<UserQuery, User> pageQuery) {
        return ResultJSON.querySuccess(userService.listPage(pageQuery));
    }

    /**
     * 查询全部
     * 可传递查询参数，按照某些字段查询
     *
     * @param user 查询条件
     * @return
     */
    @GetMapping("/user")
    public ResultJSON<List<User>> list(UserQuery user) {
        return ResultJSON.querySuccess(userService.listByUser(user));
    }

    /**
     * 通过 ID 查询
     *
     * @param id ID
     * @return
     */
    @GetMapping("/user/{id}")
    public ResultJSON<User> find(@PathVariable String id) {
        return ResultJSON.querySuccess(userService.getById(id));
    }

    /**
     * 通过 ID 查询用户下的角色
     *
     * @param id ID
     * @return
     */
    @GetMapping("/user/{id}/role")
    public ResultJSON<List<Role>> roleList(@PathVariable String id) {
        return ResultJSON.querySuccess(roleService.listByUserId(id));
    }

    /**
     * 创建 用户
     *
     * @param userDTO user 信息
     * @return
     */
    @PostMapping("/user")
    public ResultJSON<Boolean> create(@Validated @RequestBody UserDTO userDTO) {
        return ResultJSON.createSuccess(userService.create(userDTO));
    }

    /**
     * 更新 用户
     * 根据传递的参数更新，字段为空则不更新
     *
     * @param userDTO 更新内容
     * @param id      主键 ID
     * @return
     */
    @PutMapping("/user/{id}")
    public ResultJSON<Boolean> update(@Validated @RequestBody UserDTO userDTO, @PathVariable String id) {
        return ResultJSON.modifySuccess(userService.updateById(userDTO, id));
    }

    /**
     * 通过 ID 逻辑删除
     *
     * @param id ID
     * @return
     */
    @DeleteMapping("/user/{id}")
    public ResultJSON<Boolean> delete(@PathVariable Long id) {
        return ResultJSON.deleteSuccess(userService.deleteById(id));
    }


    /**
     * 获取用户的信息，角色以及权限
     *
     * @return
     */
    @GetMapping("/user/user&role&auth&menu")
    public ResultJSON<UserRoleAuthVO> userRoleAuth() {
        return ResultJSON.querySuccess(userService.findUserRoleAuthVOByUserId(StpUtil.getLoginIdAsString()));
    }
}
