package com.xiumu.controller.sys;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.common.core.result.ResultJSON;
import com.xiumu.common.core.tree.XiuMuTreeUtil;
import com.xiumu.pojo.sys.dto.AuthorityDTO;
import com.xiumu.pojo.sys.entity.Authority;
import com.xiumu.pojo.sys.query.AuthorityQuery;
import com.xiumu.service.sys.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
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
    @PostMapping("/authority/page")
    public ResultJSON<IPage<Authority>> page(@RequestBody PageQuery<AuthorityQuery, Authority> pageQuery) {
        return ResultJSON.querySuccess(authorityService.listPage(pageQuery));
    }

    /**
     * 查询全部
     * 可传递查询参数，按照某些字段查询
     *
     * @param authority 查询条件
     * @return
     */
    @GetMapping("/authority")
    public ResultJSON<List<Tree<String>>> list(AuthorityQuery authority) {
        List<Authority> authorityList = authorityService.listByAuthority(authority);
        return ResultJSON.querySuccess(XiuMuTreeUtil.buildTree(authorityList,"0"));
    }

    /**
     * 通过 ID 查询
     *
     * @param id ID
     * @return
     */
    @GetMapping("/authority/{id}")
    public ResultJSON<Authority> find(@PathVariable String id) {
        return ResultJSON.querySuccess(authorityService.getById(id));
    }

    /**
     * 创建 权限
     *
     * @param authorityDTO authority 信息
     * @return
     */
    @PostMapping("/authority")
    public ResultJSON<Boolean> create(@Validated @RequestBody AuthorityDTO authorityDTO) {
        return ResultJSON.createSuccess(authorityService.create(authorityDTO));
    }

    /**
     * 更新 权限
     * 根据传递的参数更新，字段为空则不更新
     *
     * @param authorityDTO 更新内容
     * @param id           主键 ID
     * @return
     */
    @PutMapping("/authority/{id}")
    public ResultJSON<Boolean> update(@Validated @RequestBody AuthorityDTO authorityDTO, @PathVariable String id) {
        return ResultJSON.modifySuccess(authorityService.updateById(authorityDTO, id));
    }

    /**
     * 通过 ID 逻辑删除
     *
     * @param id ID
     * @return
     */
    @DeleteMapping("/authority/{id}")
    public ResultJSON<Boolean> delete(@PathVariable Long id) {
        return ResultJSON.deleteSuccess(authorityService.deleteById(id));
    }
}
