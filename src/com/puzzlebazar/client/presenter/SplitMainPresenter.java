package com.puzzlebazar.client.presenter;

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.philbeaudoin.gwt.presenter.client.BasicPresenter;
import com.philbeaudoin.gwt.presenter.client.EventBus;
import com.philbeaudoin.gwt.presenter.client.PresenterDisplay;
import com.philbeaudoin.gwt.presenter.client.BasicPresenterWrapper;
import com.philbeaudoin.gwt.presenter.client.Slot;



public class SplitMainPresenter extends BasicPresenter<SplitMainPresenter.Display, SplitMainPresenter.Wrapper> {

  public interface Display extends PresenterDisplay {
    void setSideBarContent( Widget sideBarContent );
    void setCenterContent( Widget centerContent );
  }
  
  public static class SideBarSlot extends Slot<SplitMainPresenter> {
    @Inject
    public SideBarSlot(Provider<SplitMainPresenter> presenter) {
      super(presenter);
    }
    @Override
    protected void displayContent() {
      if( content != null )
        getPresenter().getDisplay().setSideBarContent( content.getWidget() );
    }
  }

  public static class CenterSlot extends Slot<SplitMainPresenter> {
    @Inject
    public CenterSlot(Provider<SplitMainPresenter> presenter) {
      super(presenter);
    }
    @Override
    protected void displayContent() {
      if( content != null )
        getPresenter().getDisplay().setCenterContent( content.getWidget() );
    }
  }

  public static class Wrapper extends BasicPresenterWrapper<SplitMainPresenter> {
    @Inject
    public Wrapper(EventBus eventBus, Provider<SplitMainPresenter> presenter ) {
      super(eventBus, presenter);
    }
  }

  private final SideBarSlot sideBarSlot;
  private final LinkColumnPresenter linkColumnPresenter;

  @Inject
  public SplitMainPresenter(final Display display, final EventBus eventBus, final Wrapper wrapper,
      final SideBarSlot sideBarSlot,
      final LinkColumnPresenter  linkColumnPresenter ) {
    super(display, eventBus, wrapper, null);

    this.sideBarSlot = sideBarSlot;
    this.linkColumnPresenter = linkColumnPresenter;
    
    bind();
  }  

  @Override
  protected void onBind() {
    sideBarSlot.setContent( linkColumnPresenter );
  }

  @Override
  protected void onUnbind() {
  }

}