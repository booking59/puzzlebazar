package com.puzzlebazar.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.puzzlebazar.client.resources.Resources;

/**
 * A centered message box containing a one-line message.
 * 
 * @author Philippe Beaudoin
 */
public class ShortMessageBox extends Composite implements HasText {

  interface Binder extends UiBinder<Widget, ShortMessageBox> { }
  private static final Binder binder = GWT.create(Binder.class);

  @Inject 
  static Resources resources;
  
  @UiField
  Label message;
  
  public ShortMessageBox() {
    super();
    initWidget( binder.createAndBindUi( this ) );
  }
  
  @UiFactory
  public static Resources getResources() {
    return resources;
  }

  @Override
  public String getText() {
    return message.getText();
  }

  @Override
  public void setText(String text) {
    message.setText( text );
  }
  }