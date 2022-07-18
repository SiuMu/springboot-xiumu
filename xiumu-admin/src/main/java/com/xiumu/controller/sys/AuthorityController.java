package com.xiumu.controller.sys;

import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.common.core.result.ResultJSON;
import com.xiumu.pojo.sys.entity.Authority;
import com.xiumu.pojo.sys.model.dto.AuthorityDTO;
import com.xiumu.pojo.sys.model.query.AuthorityQuery;
import com.xiumu.service.sys.service.AuthorityService;


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
 * 权限 Controller
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:15
 */
@RestController
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;


    /**
     * 分页查询
     * 可传递查询参数，按照某些字段分页查询
     *
     * @param pageQuery 分页条件，查询参数
     * @return
     */
    @GetMapping("/authority/page")
    public ResultJSON page(@Validated @RequestBody PageQuery<AuthorityQuery, Authority> pageQuery) {
        return ResultJSON.success(authorityService.listPage(pageQuery));
    }

    /**
     * 查询全部
     * 可传递查询参数，按照某些字段查询
     *
     * @param authority 查询条件
     * @return
     */
    @GetMapping("/authority")
    public ResultJSON list(@RequestBody AuthorityQuery authority) {
        return ResultJSON.success(authorityService.listByAuthority(authority));
    }

    /**
     * 通过 ID 查询
     *
     * @param id ID
     * @return
     */
    @GetMapping("/authority/{id}")
    public ResultJSON find(@PathVariable String id) {
        return ResultJSON.success(authorityService.getById(id));
    }

    /**
     * 创建 权限
     *
     * @param authorityDTO authority 信息
     * @return
     */
    @PostMapping("/authority")
    public ResultJSON create(@Validated @RequestBody AuthorityDTO authorityDTO) {
        return ResultJSON.success(authorityService.create(authorityDTO));
    }

    /**
     * 更新 权限
     * 根据传递的参数更新，字段为空则不更新
     *
     * @param authorityDTO 更新内容
     * @param id 主键 ID
     * @return
     */
    @PutMapping("/authority/{id}")
    public ResultJSON update(@Validated @RequestBody AuthorityDTO authorityDTO, @PathVariable Long id) {
        return ResultJSON.success(authorityService.updateById(authorityDTO, id));
    }

    /**
     * 通过 ID 逻辑删除
     *
     * @param id ID
     * @return
     */
    @DeleteMapping("/authority/{id}")
    public ResultJSON delete(@PathVariable Long id) {
        return ResultJSON.success(authorityService.deleteById(id));
    }
}
