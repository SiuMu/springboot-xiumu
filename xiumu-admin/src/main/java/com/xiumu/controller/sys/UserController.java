package com.xiumu.controller.sys;

import com.xiumu.common.core.page.PageQuery;
import com.xiumu.common.core.result.ResultJSON;
import com.xiumu.pojo.sys.entity.User;
import com.xiumu.pojo.sys.dto.UserDTO;
import com.xiumu.pojo.sys.query.UserQuery;
import com.xiumu.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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
     * @param id      主键 ID
     * @return
     */
    @PutMapping("/user/{id}")
    public ResultJSON update(@Validated @RequestBody UserDTO userDTO, @PathVariable String id) {
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
