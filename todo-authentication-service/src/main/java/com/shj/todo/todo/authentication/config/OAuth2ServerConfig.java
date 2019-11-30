package com.shj.todo.todo.authentication.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


@Configuration
@EnableAuthorizationServer
public class OAuth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    @Value("${oauth.config.clientId}")
    private String clientId;
    @Value("${oauth.config.clientSecret}")
    private String clientSecret;

    private final AuthenticationManager authenticationManager;

    public OAuth2ServerConfig(@Qualifier("authenticationManagerBean") AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * 定义客户端信息
     * 。客户端信息有两种存储方式，基于内存，和jdbc，这里用内存
     * @param clients clients
     * @throws Exception exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() // 使用in-memory存储
                .withClient(this.clientId) // client_id
                .secret(new BCryptPasswordEncoder().encode(this.clientSecret)) // client_secret
                .scopes("read", "write", "trust")
                .authorizedGrantTypes("authorization_code", "implicit", "password", "client_credentials", "refresh_token")
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(18000);
    }
    @Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
        .allowFormAuthenticationForClients();
    }
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints.authenticationManager(authenticationManager)
                .tokenStore(new JwtTokenStore(new JwtAccessTokenConverter()))
                .accessTokenConverter(new JwtAccessTokenConverter());
    }

}
