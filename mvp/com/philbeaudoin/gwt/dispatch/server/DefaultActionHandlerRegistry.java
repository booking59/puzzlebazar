package com.philbeaudoin.gwt.dispatch.server;

import java.util.HashMap;
import java.util.Map;

import com.philbeaudoin.gwt.dispatch.shared.Action;
import com.philbeaudoin.gwt.dispatch.shared.Result;

import com.google.inject.Singleton;

@Singleton
public class DefaultActionHandlerRegistry implements InstanceActionHandlerRegistry {

  private final Map< Class<? extends Action<? extends Result>>, 
      ActionHandler<? extends Action<? extends Result>, ? extends Result> > handlers;

  public DefaultActionHandlerRegistry() {
    handlers = new HashMap< Class<? extends Action<? extends Result>>, 
        ActionHandler<? extends Action<? extends Result>, ? extends Result> >( 100 );
  }

  @Override
  public <A extends Action<R>, R extends Result> void addHandler( ActionHandler<A, R> handler ) {
    handlers.put( handler.getActionType(), handler );
  }

  @Override
  public <A extends Action<R>, R extends Result> boolean removeHandler( ActionHandler<A, R> handler ) {
    return handlers.remove( handler.getActionType() ) != null;
  }

  @SuppressWarnings("unchecked")
  public <A extends Action<R>, R extends Result> ActionHandler<A, R> findHandler( A action ) {
    return (ActionHandler<A, R>) handlers.get( action.getClass() );
  }

  public void clearHandlers() {
    handlers.clear();
  }

}