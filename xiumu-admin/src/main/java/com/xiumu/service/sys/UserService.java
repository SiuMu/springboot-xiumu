package com.xiumu.service.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.pojo.sys.entity.User;
import com.xiumu.pojo.sys.dto.LoginDTO;
import com.xiumu.pojo.sys.dto.UserDTO;
import com.xiumu.pojo.sys.query.UserQuery;
import com.xiumu.pojo.sys.vo.UserRoleAuthVO;

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
    boolean updateById(UserDTO userDTO, Long id);

    /**
     * 根据 id 逻辑删除
     *
     * @param id id
     * @return
     */
    boolean deleteById(Long id);

    /**
     * 用户登录方法
     *
     * @param loginDTO 登录凭证
     * @return
     */
    String login(LoginDTO loginDTO);

    /**
     * 获取用户的信息，角色以及权限
     *
     * @param userId 用户ID
     * @return
     */
    UserRoleAuthVO findUserRoleAuthVOByUserId(Long userId);

    /**
     * 设置用户角色
     *
     * @param id         用户 ID
     * @param roleIdList 角色 ID 集合
     * @return
     */
    boolean setRole(Long id, List<Long> roleIdList);
}
