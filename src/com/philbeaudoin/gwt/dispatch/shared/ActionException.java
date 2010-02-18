package com.philbeaudoin.gwt.dispatch.shared;

import com.philbeaudoin.gwt.dispatch.server.Dispatch;

import java.io.Serializable;

/**
 * These are thrown by {@link Dispatch#execute(Action)} if there is a
 * problem executing a particular {@link Action}.
 * 
 * @author David Peterson
 */
public class ActionException extends Exception implements Serializable {

  private static final long serialVersionUID = -1423773155541528952L;

  public ActionException() {
  }

  public ActionException( String message ) {
    super( message );
  }

  public ActionException( Throwable cause ) {
    super( cause.getMessage() );
  }

  public ActionException( String message, Throwable cause ) {
    super( message + " (" + cause.getMessage() + ")" );
  }

}
