package com.salman;

import io.micronaut.context.annotation.ConfigurationProperties;

import javax.validation.constraints.NotNull;


public interface ApplicationConfiguration {
    @NotNull Integer getMax();
}
