package com.shj.todo.gateway.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 聚合各个服务的swagger接口
 *
 * @author ksyzz
 * @since <pre>2019/04/09</pre>
 */
@Component
public class SwaggerProvider implements SwaggerResourcesProvider {

    /**
     * swagger2默认的url后缀
     */
    private static final String SWAGGER2URL = "/v2/api-docs";

    /**
     * 网关路由
     */
    private final RouteLocator routeLocator;

    /**
     * 网关应用名称
     */
    @Value("${spring.application.name}")
    private String self;

    @Autowired
    public SwaggerProvider(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        Set<String> dealed = new HashSet<>();
        routeLocator.getRoutes().filter(route -> route.getUri().getHost() != null)
                .filter(route -> !self.equals(route.getUri().getHost()))
                .subscribe(route -> {
                    String url = "/" + route.getUri().getHost() + SWAGGER2URL;
                    if (!dealed.contains(url)) {
                        dealed.add(url);
                        SwaggerResource swaggerResource = new SwaggerResource();
                        swaggerResource.setUrl(url);
                        swaggerResource.setName(route.getUri().getHost());
                        resources.add(swaggerResource);
                    }
                });
        return resources;
    }
}

