package id.mzennis.epoxyexample.presentation.config;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by meyta on 13/12/17.
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {}
