package com.xzx.xzxms;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * @Author Lzc
 * @Date 2021/3/17 14:48
 * @Version 1.0
 */
public class AutoGeneratorConfig {
    public static void main(String[] args){
        // 需要构建一个 代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();
        // 配置策略
        // 1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("Lzc");
        gc.setOpen(false);
        gc.setFileOverride(false);
        // 是否覆盖
        gc.setServiceName("%sService");
        // 去Service的I前缀
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true); mpg.setGlobalConfig(gc);
        //2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/xzx?useSSL=false&useUnicode=true&characterEncoding=utf-8"); dsc.setDriverName("com.mysql.jdbc.Driver"); dsc.setUsername("root"); dsc.setPassword("root"); dsc.setDbType(DbType.MYSQL); mpg.setDataSource(dsc);
        //3、包的配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("tender");
        pc.setParent("com.xzx.xzxms");
        pc.setEntity("com/xzx/xzxms/tender/bean");
        pc.setMapper("com/xzx/xzxms/tender/dao");
        pc.setService("com/xzx/xzxms/tender/service");
        pc.setController("com/xzx/xzxms/tender/controller");
        mpg.setPackageInfo(pc);
        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 设置要映射的表名
        strategy.setInclude("tender", "tender_tenderer");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        // 自动lombok；
        strategy.setLogicDeleteFieldName("deleted");
        // 自动填充配置
        TableFill createBy = new TableFill("create_by", FieldFill.INSERT);
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateBy = new TableFill("update_by", FieldFill.INSERT_UPDATE);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createBy);
        tableFills.add(createTime);
        tableFills.add(updateBy);
        tableFills.add(updateTime);
        strategy.setTableFillList(tableFills);
        // 乐观锁
        // strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        // localhost:8080/hello_id_2
        mpg.setStrategy(strategy);
        mpg.execute(); //执行
    }
}
