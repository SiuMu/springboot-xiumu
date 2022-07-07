package com.xiumu.springbootxiumu.utils.tree;

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
 * 树形结构构造工具                         <br/>
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
     * 对象的排序字段
     */
    private static String WEIGHT_KEY = "weight";

    /**
     * 构造树形结构
     *
     * @param objectList 对象数组
     * @param parentId   最顶层父节点ID
     * @return
     */
    public static List<Tree<Long>> buildTree(List<?> objectList, Long parentId) {
        List<TreeNode<Long>> nodeList = CollUtil.newArrayList();

        // 将对象转化成树节点
        for (Object obj : objectList) {
            Map<String, Object> bean = BeanUtil.beanToMap(obj);
            final Long id = Convert.toLong(bean.get(ID_KEY));
            final Long objParentId = Convert.toLong(bean.get(PARENT_ID_KEY));
            final Long weight = Convert.toLong(bean.get(WEIGHT_KEY));
            nodeList.add(new TreeNode<Long>(id, objParentId, "", weight).setExtra(bean));
        }

        // 还原配置
        configKeys(null,null,null);

        return build(nodeList, parentId);
    }

    /**
     * 配置节点ID的 key
     * @param idKey       节点ID
     * @param parentIdKey 父节点ID
     * @param weightKey   权重
     */
    public static void configKeys(String idKey, String parentIdKey, String weightKey) {
        if (StrUtil.isNotBlank(idKey)){
            ID_KEY = idKey;
        }else {
            ID_KEY = "id";
        }
        if (StrUtil.isNotBlank(parentIdKey)){
            PARENT_ID_KEY = parentIdKey;
        }else {
            PARENT_ID_KEY = "parentId";
        }
        if (StrUtil.isNotBlank(weightKey)){
            WEIGHT_KEY = weightKey;
        }else {
            WEIGHT_KEY = "weight";
        }

    }


}
