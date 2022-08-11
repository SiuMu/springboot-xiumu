package com.xiumu.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@MapperScan({"com.xiumu.generator.mapper"})
@SpringBootApplication
public class XiuMuGeneratorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(XiuMuGeneratorApplication.class, args);
//        DefaultDataSourceCreator dataSourceCreator = applicationContext.getBean("dataSourceCreator", DefaultDataSourceCreator.class);
//        DynamicRoutingDataSource dynamicRoutingDataSource = applicationContext.getBean("dataSource", DynamicRoutingDataSource.class);
//        for (String key : dynamicRoutingDataSource.getDataSources().keySet()) {
//            System.out.println("数据源：" + key);
//        }
//        System.out.println("动态添加数据源");
//        DataSourceProperty property = new DataSourceProperty()
//                .setDriverClassName("com.mysql.cj.jdbc.Driver")
//                .setUrl("jdbc:mysql:///xiumu?useUnicode=true&characterEncoding=utf8&useSSL=false")
//                .setUsername("root")
//                .setPassword("root")
//                .setLazy(true);
//        DataSource dataSource = dataSourceCreator.createDataSource(property);
//        dynamicRoutingDataSource.addDataSource("SiuMu", dataSource);
//        for (String key : dynamicRoutingDataSource.getDataSources().keySet()) {
//            System.out.println("数据源：" + key);
//        }
    }
}
