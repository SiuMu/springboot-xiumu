package com.xiumu.generator;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.xiumu.generator.constants.Constants;
import com.xiumu.generator.entity.GenTable;
import com.xiumu.generator.entity.GenTableColumn;
import com.xiumu.generator.entity.GenTableDO;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class VelocityUtil {

    /**
     * 项目空间路径
     */
    private static final String PROJECT_PATH = "main/java";

    /**
     * xml文件路径
     */
    private static final String MYBATIS_PATH = "main/resources/mapper";


    /**
     * 创建 VelocityContext
     *
     * @param genTableDO 表和字段信息
     * @return
     */
    public static VelocityContext buildContext(GenTableDO genTableDO) {
        GenTable genTable = genTableDO.getGenTable();
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("tableName", genTable.getTableName());
        velocityContext.put("functionName", genTable.getFunctionName());
        velocityContext.put("ClassName", genTable.getClassName());
        velocityContext.put("className", StringUtils.uncapitalize(genTable.getClassName()));
        velocityContext.put("moduleName", genTable.getModuleName());
        velocityContext.put("BusinessName", StringUtils.capitalize(genTable.getBusinessName()));
        velocityContext.put("businessName", genTable.getBusinessName());
        velocityContext.put("pojoPackageName", genTable.getPojoPackageName());
        velocityContext.put("servicePackageName", genTable.getServicePackageName());
        velocityContext.put("controllerPackageName", genTable.getControllerPackageName());
        velocityContext.put("author", genTable.getFunctionAuthor());
        velocityContext.put("datetime", DateUtil.now());
        velocityContext.put("columns", genTableDO.getColumnList());
        return velocityContext;
    }

    /**
     * 获取文件名
     */
    public static String getFileName(String template, GenTable genTable) {
        // 文件名称
        String fileName = "";
        // 包路径
        String packageName = genTable.getPackageName(template);
        // 模块名
        String moduleName = genTable.getModuleName();
        // 大写类名
        String className = genTable.getClassName();

        String javaPath = PROJECT_PATH + "/" + StringUtils.replace(packageName, ".", "/");
        String mybatisPath = MYBATIS_PATH + "/" + moduleName;

        if (template.contains("entity.java.vm")) {
            fileName = javaPath + "/" + moduleName + "/entity/" + className + ".java";
        } else if (template.contains("entityDTO.java.vm")) {
            fileName = javaPath + "/" + moduleName + "/model/dto/" + className + "DTO.java";
        } else if (template.contains("entityQuery.java.vm")) {
            fileName = javaPath + "/" + moduleName + "/model/query/" + className + "Query.java";
        } else if (template.contains("mapper.xml.vm")) {
            fileName = mybatisPath + "/" + className + "Dao.xml";
        } else if (template.contains("mapper.java.vm")) {
            fileName = javaPath + "/" + moduleName + "/dao/" + className + "Dao.java";
        } else if (template.contains("service.java.vm")) {
            fileName = javaPath + "/" + moduleName + "/service/" + className + "Service.java";
        } else if (template.contains("serviceImpl.java.vm")) {
            fileName = javaPath + "/" + moduleName + "/service/impl/" + className + "ServiceImpl.java";
        } else if (template.contains("controller.java.vm")) {
            fileName = javaPath + "/" + moduleName + "/" + className + "Controller.java";
        }
        return fileName;
    }

    /**
     * 生成代码
     *
     * @param table        表信息
     * @param tableColumns 字段信息
     */
    public static void createCode(GenTable table, List<GenTableColumn> tableColumns) {

        VelocityInitializer.initVelocity();

        VelocityContext context = VelocityUtil.buildContext(new GenTableDO(table, tableColumns));

        for (String template : Constants.VM_LIST) {
            // 渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, Constants.UTF8);
            tpl.merge(context, sw);
            String path = "";
            switch (template) {
                case "entity.java.vm":
                case "entityDTO.java.vm":
                case "entityQuery.java.vm":
                    path = table.getPojoPath();
                    break;
                case "mapper.java.vm":
                case "mapper.xml.vm":
                case "service.java.vm":
                case "serviceImpl.java.vm":
                    path = table.getServicePath();
                    break;
                case "controller.java.vm":
                    path = table.getControllerPath();
                    break;
            }
            path = path + File.separator + VelocityUtil.getFileName(template, table);
            System.out.println(path);
            BufferedWriter writer = FileUtil.getWriter(new File(path), StandardCharsets.UTF_8, false);
            try {
                writer.append(sw.toString()).flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
