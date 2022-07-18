package com.xiumu.controller.sys;

import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.common.core.result.ResultJSON;
import com.xiumu.pojo.sys.entity.User;
import com.xiumu.pojo.sys.model.dto.UserDTO;
import com.xiumu.pojo.sys.model.query.UserQuery;
import com.xiumu.service.sys.service.UserService;


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
 * 用户 Controller
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:37
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 分页查询
     * 可传递查询参数，按照某些字段分页查询
     *
     * @param pageQuery 分页条件，查询参数
     * @return
     */
    @GetMapping("/user/page")
    public ResultJSON page(@Validated @RequestBody PageQuery<UserQuery, User> pageQuery) {
        return ResultJSON.success(userService.listPage(pageQuery));
    }

    /**
     * 查询全部
     * 可传递查询参数，按照某些字段查询
     *
     * @param user 查询条件
     * @return
     */
    @GetMapping("/user")
    public ResultJSON list(@RequestBody UserQuery user) {
        return ResultJSON.success(userService.listByUser(user));
    }

    /**
     * 通过 ID 查询
     *
     * @param id ID
     * @return
     */
    @GetMapping("/user/{id}")
    public ResultJSON find(@PathVariable String id) {
        return ResultJSON.success(userService.getById(id));
    }

    /**
     * 创建 用户
     *
     * @param userDTO user 信息
     * @return
     */
    @PostMapping("/user")
    public ResultJSON create(@Validated @RequestBody UserDTO userDTO) {
        return ResultJSON.success(userService.create(userDTO));
    }

    /**
     * 更新 用户
     * 根据传递的参数更新，字段为空则不更新
     *
     * @param userDTO 更新内容
     * @param id 主键 ID
     * @return
     */
    @PutMapping("/user/{id}")
    public ResultJSON update(@Validated @RequestBody UserDTO userDTO, @PathVariable Long id) {
        return ResultJSON.success(userService.updateById(userDTO, id));
    }

    /**
     * 通过 ID 逻辑删除
     *
     * @param id ID
     * @return
     */
    @DeleteMapping("/user/{id}")
    public ResultJSON delete(@PathVariable Long id) {
        return ResultJSON.success(userService.deleteById(id));
    }
}
