package com.xiumu.common.core.tree;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.StrUtil;

import java.util.List;
import java.util.Map;

/**
 * 树形结构构造工具
 *
 * @Author XiuMu
 * @Date 2022/7/16
 */
public class XiuMuTreeUtil extends TreeUtil {


    /**
     * 对象的节点字段
     */
    private static String ID_KEY = "id";
    /**
     * 对象的父节点字段
     */
    private static String PARENT_ID_KEY = "parentId";
    /**
     * 对象的排序字段, 值越小越靠前
     */
    private static String WEIGHT_KEY = "weight";

    /**
     * 构造树形结构
     *
     * @param objectList 对象数组
     * @param parentId   最顶层父节点ID
     * @return
     */
    public static List<Tree<String>> buildTree(List<?> objectList, String parentId) {
        List<TreeNode<String>> nodeList = CollUtil.newArrayList();

        // 将对象转化成树节点
        for (Object obj : objectList) {
            Map<String, Object> bean = BeanUtil.beanToMap(obj);
            final String id = Convert.toStr(bean.get(ID_KEY));
            final String objParentId = Convert.toStr(bean.get(PARENT_ID_KEY));
            final Long weight = Convert.toLong(bean.get(WEIGHT_KEY));
            nodeList.add(new TreeNode<String>(id, objParentId, "", weight).setExtra(bean));
        }

        // 还原配置
        configKeys(null, null, null);

        return build(nodeList, parentId);
    }

    /**
     * 配置节点ID的 key
     * 该方法用来设置需要构建树形结构的对象的，节点 父节点，排序字段 key，默认是 id, parentId, weight
     * 如果有的对象是根据其他字段 key 构建树，如 code， parentCode， sort
     * 就可以先设置 key XiuMuTreeUtil.configKeys("code", "parentCode", "sort")
     * 再调用 XiuMuTreeUtil.buildTree(objectList, parentCodeValue)
     *
     * @param idKey       节点ID
     * @param parentIdKey 父节点ID
     * @param weightKey   排序权重，值越小越靠前
     */
    public static void configKeys(String idKey, String parentIdKey, String weightKey) {
        if (StrUtil.isNotBlank(idKey)) {
            ID_KEY = idKey;
        } else {
            ID_KEY = "id";
        }
        if (StrUtil.isNotBlank(parentIdKey)) {
            PARENT_ID_KEY = parentIdKey;
        } else {
            PARENT_ID_KEY = "parentId";
        }
        if (StrUtil.isNotBlank(weightKey)) {
            WEIGHT_KEY = weightKey;
        } else {
            WEIGHT_KEY = "weight";
        }

    }


}
