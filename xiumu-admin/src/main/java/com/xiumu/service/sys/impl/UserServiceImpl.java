package com.xiumu.service.sys.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.common.core.constants.XiuMuConst;
import com.xiumu.common.core.enums.YesNo;
import com.xiumu.common.core.exception.sys.SysException;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.common.core.utils.AssertUtil;
import com.xiumu.dao.sys.UserDao;
import com.xiumu.pojo.sys.entity.User;
import com.xiumu.pojo.sys.model.dto.LoginDTO;
import com.xiumu.pojo.sys.model.dto.UserDTO;
import com.xiumu.pojo.sys.model.query.UserQuery;
import com.xiumu.service.sys.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户 Service 业务层处理
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:37
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Override
    public IPage<User> listPage(PageQuery<UserQuery, User> pageQuery) {
        return this.baseMapper.selectPage(pageQuery, pageQuery.getCondition());
    }

    @Override
    public List<User> listByUser(UserQuery user) {
        return this.baseMapper.selectByUser(user);
    }

    @Override
    @Transactional
    public boolean create(UserDTO userDTO) {
        User user = BeanUtil.toBean(userDTO, User.class);
        return this.save(user);
    }

    @Override
    @Transactional
    public boolean updateById(UserDTO userDTO, String id) {
        User user = BeanUtil.copyProperties(userDTO, User.class);
        user.setId(id);
        return updateById(user);
    }

    @Override
    public boolean deleteById(Long id) {
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<User>()
                .set(User::getDeleteFlag, YesNo.YES)
                .eq(User::getId, id);
        return this.update(updateWrapper);
    }

    @Override
    public String login(LoginDTO loginDTO) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, loginDTO.getUsername())
                .eq(User::getPassword, SecureUtil.md5(loginDTO.getPassword()));
        User user = this.getOne(queryWrapper);
        AssertUtil.notNull(user, SysException.PASSWD_ERROR);
        StpUtil.login(user.getId());
        StpUtil.getSession().set(XiuMuConst.USERNAME, user.getUsername());
        return StpUtil.getTokenInfo().tokenValue;
    }

    /**
     * 重写 list 方法，查询未逻辑删除的记录
     *
     * @return
     */
    @Override
    public List<User> list() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>().eq(User::getDeleteFlag, YesNo.NO);
        return this.baseMapper.selectList(queryWrapper);
    }

    /**
     * 重写 list 方法，查询未逻辑删除的记录
     *
     * @return
     */
    public List<User> list(LambdaQueryWrapper<User> queryWrapper) {
        if (ObjectUtil.isNull(queryWrapper)) {
            queryWrapper = new LambdaQueryWrapper<User>();
        }
        queryWrapper.eq(User::getDeleteFlag, YesNo.NO);
        return this.baseMapper.selectList(queryWrapper);
    }
}
