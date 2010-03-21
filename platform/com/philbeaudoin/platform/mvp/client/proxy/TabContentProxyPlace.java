package com.philbeaudoin.platform.mvp.client.proxy;

import com.philbeaudoin.platform.mvp.client.Presenter;
import com.philbeaudoin.platform.mvp.client.Tab;

/**
 * A useful mixing class to define a {@link TabContentProxy} that is also
 * a {@link Place}.
 * 
 * @author Philippe Beaudoin
 */
public class TabContentProxyPlace<P extends Presenter> 
extends ProxyPlaceAbstract<P, TabContentProxy<P>>
implements TabContentProxy<P> {

  public TabContentProxyPlace() {
  }
  
  @Override
  public float getPriority() {
    return proxy.getPriority();
  }

  @Override
  public Tab getTab() {
    return proxy.getTab();
  }

  @Override
  public String getText() {
    return proxy.getText();
  }

  @Override
  public String getHistoryToken() {
    return getNameToken();
  }

}
