package com.philbeaudoin.platform.mvp.client;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.philbeaudoin.platform.mvp.client.proxy.Proxy;
import com.philbeaudoin.platform.mvp.client.proxy.TabContentProxy;

/**
 * A presenter that can display many tabs and the content of one of these tabs.
 *
 * @param <V> The specific type of the {@link View}. Must implement {@link TabPanel}.
 * @param <Proxy_> The specific type of the proxy, must be a {@link TabContainerProxy}. 
 * 
 * @author Philippe Beaudoin
 */
public abstract class TabContainerPresenterImpl<V extends View & TabPanel, Proxy_ extends Proxy<?>> 
extends PresenterImpl<V, Proxy_> implements TabContainerPresenter  {

  private final Object tabContentSlot;
  private final Type<RequestTabsHandler> requestTabsEventType;

  /**
   * Create a presenter that can display many tabs and the content of one of these tabs.
   * 
   * @param eventBus The {@link EventBus}.
   * @param view The {@link View}.
   * @param proxy The proxy, a {@link TabContainerProxy}.
   * @param tabContentSlot An opaque object identifying the slot in which the main content should be displayed.
   * @param requestTabsEventType The {@link Type} of the object to fire to identify all the displayed tabs.
   */
  public TabContainerPresenterImpl(
      final EventBus eventBus, 
      final V view, 
      final Proxy_ proxy, 
      final Object tabContentSlot,
      final Type<RequestTabsHandler> requestTabsEventType ) {
    super(eventBus, view, proxy);
    this.tabContentSlot = tabContentSlot;
    this.requestTabsEventType = requestTabsEventType;
  }
  
  @Override
  public Tab addTab( final TabContentProxy<?> tabProxy ) {
    return getView().addTab( tabProxy.getLabel(), tabProxy.getHistoryToken(), tabProxy.getPriority() );
  }

  @Override
  public void setContent( Object slot, PresenterWidget content ) {
    super.setContent(slot, content);
    if( slot == tabContentSlot ) {
      Tab tab = ((TabContentProxy<?>)((Presenter)content).getProxy()).getTab();
      getView().setActiveTab( tab );
    }
  }

  @Override
  protected void onBind() {
    super.onBind();

    // The following call will trigger a series of call to addTab, so
    // we should make sure we clear all the tabs when unbinding.
    eventBus.fireEvent( new RequestTabsEvent(requestTabsEventType, this) );
  }

  @Override
  protected void onUnbind() {  
    super.onUnbind();

    // The tabs are added indirectly in onBind() via the RequestTabsEvent, so we clear them now.
    getView().removeTabs();
  }

}
