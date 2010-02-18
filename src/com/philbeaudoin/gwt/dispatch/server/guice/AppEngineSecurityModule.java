package com.philbeaudoin.gwt.dispatch.server.guice;

import com.philbeaudoin.gwt.dispatch.server.appengine.AppEngineSecureSessionValidator;
import com.philbeaudoin.gwt.dispatch.server.secure.SecureSessionValidator;

import com.google.inject.AbstractModule;

/**
 * This is a Guice configuration module for projects being configured for
 * security and deployment in the Google App Engine environment.
 * 
 * @author David Peterson
 */
public class AppEngineSecurityModule extends AbstractModule {

    @Override
    protected void configure() {
        bind( SecureSessionValidator.class ).to( AppEngineSecureSessionValidator.class );
    }
}
