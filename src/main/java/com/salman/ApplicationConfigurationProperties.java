package com.salman;

import io.micronaut.context.annotation.ConfigurationProperties;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.validation.constraints.NotNull;
@ConfigurationProperties("application")
@EnableTransactionManagement
public class ApplicationConfigurationProperties implements ApplicationConfiguration {
    @Override
    public @NotNull Integer getMax() {
        return 50;
    }
    protected final Integer DEFAULT_MAX = 10;

    private Integer max = DEFAULT_MAX;

    public void setMax(Integer max) {
        if(max != null) {
            this.max = max;
        }
    }
}
