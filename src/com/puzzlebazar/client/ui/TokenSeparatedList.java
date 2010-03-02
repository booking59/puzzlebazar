package com.puzzlebazar.client.ui;

import java.util.NoSuchElementException;

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.InlineHyperlink;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;

public class TokenSeparatedList extends FlowPanel  {

  private final String token;
  
  private int leftmostVisibleIndex = 0;
  
  public @UiConstructor TokenSeparatedList( String token ) {
    this.token = token;
  }
  
  /**
   * Adds a widget to the token separated list. You should
   * only add inline widgets (not block widget), such as
   * {@link Anchor}, {@link InlineLabel}, {@link InlineHyperlink}
   * or {@link InlineHTML}. 
   *
   * @param widget The widget to add.
   */
  @Override
  public void add(Widget widget) {
    if( getWidgetCount() > 0 )
      super.add( new InlineHTML(token) );    
    super.add( widget );
    updateVisibility();
  }

  /**
   * Adds a widget to the token separated list before the specified
   * widget. You should only add inline widgets (not block widget), 
   * such as {@link Anchor}, {@link InlineLabel}, {@link 
   * InlineHyperlink} or {@link InlineHTML}. 
   *
   * @param widgetToAdd The widget to add.
   * @param nextWidget The widget before which to add. Pass <code>null</code> to insert at the end.
   */
  public void addBefore(Widget widgetToAdd, Widget nextWidget) {
    if( nextWidget == null ) {
      add( widgetToAdd );
      return;
    }
    int index = getWidgetIndex(nextWidget);
    if( index < 0 )
      throw new NoSuchElementException( "Next widget not found." );
    insert( new InlineHTML(token), index );
    insert( widgetToAdd, index );
    updateVisibility();
  }
  

  /**
   * Call this to make a widget visible or invisible. You should not call
   * setVisible() directly on the widget, otherwise its separating token
   * will be lost.
   * 
   * @param widget The widget on which to change visibility.
   * @param visible The desired visibility.
   */
  public void setWidgetVisible( Widget widget, boolean visible ) {
    int index = getWidgetIndex( widget );
    if( index < 0 )
      throw new NoSuchElementException( "Widget not found." );
    widget.setVisible(visible);
    
    //TODO Temp, test
    updateVisibility();
    return;
    /*
    // Check special cases
    if( index < leftmostVisibleIndex && visible ) {
      // Making a widget visible to the left of the current leftmost visible widget.

      // Make visible the separator of the previous leftmost visible widget, unless none were visible.
      if( leftmostVisibleIndex < getWidgetCount() )
        getWidget(leftmostVisibleIndex-1).setVisible(true);
      leftmostVisibleIndex = index;
    }
    else if( index == leftmostVisibleIndex && !visible ) {
      // Making the leftmost visible widget invisible.
      
      // Find the new leftmost visible widget.
      leftmostVisibleIndex += 2;
      while( leftmostVisibleIndex < getWidgetCount() ) {
        if( getWidget(leftmostVisibleIndex).isVisible() )
          break;
        leftmostVisibleIndex += 2;
      }
      
      // Make invisible the separator of the new leftmost visible widget, unless they are all invisible
      if( leftmostVisibleIndex < getWidgetCount() )
        getWidget(leftmostVisibleIndex-1).setVisible(false);
    }
    else {
      // Typical case, apply the same visibility to the widget's separator.
      if( index > 0 )
        getWidget(index-1).setVisible(visible);
    } */
  }

  /**
   * Ensures the visibility status of all widget is right
   */
  private void updateVisibility() {
    if( getWidget(0).isVisible() )
      leftmostVisibleIndex = 0;
    else
      leftmostVisibleIndex = getWidgetCount();
    
    for( int index = 2; index < getWidgetCount(); index+=2 ) {
      if( getWidget(index).isVisible() ) {
        if( leftmostVisibleIndex == getWidgetCount() ) {
          leftmostVisibleIndex = index;
        } else
          getWidget(index-1).setVisible(true);
      }
      else
        getWidget(index-1).setVisible(false);
    }
  }
  
  
}
