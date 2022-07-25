package com.xiumu.service.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.pojo.sys.entity.User;
import com.xiumu.pojo.sys.model.dto.UserDTO;
import com.xiumu.pojo.sys.model.query.UserQuery;

import java.util.List;

/**
 * 用户 Service 接口
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:37
 */
public interface UserService extends IService<User> {

    /**
     * 分页查询
     *
     * @param pageQuery 分页条件
     * @return
     */
    IPage<User> listPage(PageQuery<UserQuery, User> pageQuery);

    /**
     * 根据条件查询 用户
     *
     * @param user 查询条件
     * @return
     */
    List<User> listByUser(UserQuery user);

    /**
     * 创建 用户
     *
     * @param userDTO user 信息
     * @return
     */
    boolean create(UserDTO userDTO);

    /**
     * 更新 用户
     *
     * @param userDTO 更新内容
     * @param id      主键 ID
     * @return
     */
    boolean updateById(UserDTO userDTO, String id);

    /**
     * 根据 id 逻辑删除
     *
     * @param id id
     * @return
     */
    boolean deleteById(Long id);
}
