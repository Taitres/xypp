package com.taitres.xypp.config;




import cn.hutool.core.util.RandomUtil;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

/***
 * 创建Swagger配置
 */

@Configuration
@Profile({"dev","test"})
public class SwaggerConfig {
//    @Bean
//    public GroupedOpenApi adminApi() {      // 创建了一个api接口的分组
//        return GroupedOpenApi.builder()
//                .group("admin-api")         // 分组名称
//                .pathsToMatch("/**")  // 接口请求路径规则
//                .build();
//    }
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info() // 基本信息配置
                        .title("校友匹配系统接口文档") // 标题
                        .description("校友匹配系统接口文档") // 描述Api接口文档的基本信息
                        .version("v1") // 版本
                        // 设置OpenAPI文档的联系信息，包括联系人姓名为"robin"，邮箱为"robin@gmail.com"。
                        .contact(new Contact().name("taitres").email("920643082@qq.com"))
                        // 设置OpenAPI文档的许可证信息，包括许可证名称为"Apache 2.0"，许可证URL为"http://springdoc.org"。
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                );

    }
}


