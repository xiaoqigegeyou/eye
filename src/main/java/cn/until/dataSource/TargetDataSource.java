package cn.until.dataSource;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})//设置用于方法跟类
@Retention(RetentionPolicy.RUNTIME)//RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
@Documented//Documented注解表明这个注解是由 javadoc记录的，在默认情况下也有类似的记录工具。 如果一个类型声明被注解了文档化，它的注解成为公共API的一部分。
 public @interface TargetDataSource {
     
     String name() default TargetDataSource.MASTER;
  
     public static String MASTER = "defDataSource";
  
     public static String BRANCH1 = "ZY302DataSource";
 }