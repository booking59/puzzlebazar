package com.philbeaudoin.platform.mvp.client.proxy;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.philbeaudoin.platform.mvp.client.EventBus;
import com.philbeaudoin.platform.mvp.client.Presenter;
import com.philbeaudoin.platform.mvp.client.RequestTabsEvent;
import com.philbeaudoin.platform.mvp.client.RequestTabsHandler;
import com.philbeaudoin.platform.mvp.client.Tab;
import com.philbeaudoin.platform.mvp.client.TabContainerPresenter;

public class TabContentProxyImpl<P extends Presenter> 
extends ProxyImpl<P> implements TabContentProxy<P> {

  protected Type<RequestTabsHandler> requestTabsEventType;
  protected float priority;
  protected String text;
  protected String historyToken;

  private Tab tab = null;

  /**
   * Creates a {@link Proxy} for a {@link Presenter} that 
   * is meant to be contained within at {@link TabContainerPresenter}.
   * As such, these proxy hold a string that can be displayed on the 
   * tab. 
   */
  public TabContentProxyImpl() {}

  @Override
  public Tab getTab() {
    return tab;
  }
  
  @Inject
  protected void bind( EventBus eventBus ) {
    eventBus.addHandler(requestTabsEventType, new RequestTabsHandler(){
      @Override
      public void onRequestTabs(RequestTabsEvent event) {
        tab = event.getTabContainer().addTab( TabContentProxyImpl.this );
      }
    } );
  }

  @Override
  public float getPriority() {
    return priority;
  }

  @Override
  public String getText() {
    return text;
  }

  @Override
  public String getHistoryToken() {
    return historyToken;
  }
  
}
