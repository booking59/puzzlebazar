package com.puzzlebazar.client.gin;

import com.philbeaudoin.platform.mvp.client.DefaultEventBus;
import com.philbeaudoin.platform.mvp.client.EventBus;
import com.philbeaudoin.platform.mvp.client.gin.AbstractPresenterModule;
import com.philbeaudoin.platform.mvp.client.proxy.ParameterTokenFormatter;
import com.philbeaudoin.platform.mvp.client.proxy.PlaceManager;
import com.philbeaudoin.platform.mvp.client.proxy.ProxyBase;
import com.philbeaudoin.platform.mvp.client.proxy.TokenFormatter;
import com.philbeaudoin.platform.mvp.client.proxy.RootProxy;

import com.puzzlebazar.client.ActionCallback;
import com.puzzlebazar.client.CurrentUser;
import com.puzzlebazar.client.PuzzlebazarPlaceManager;
import com.puzzlebazar.client.core.presenter.AdminGeneralPresenter;
import com.puzzlebazar.client.core.presenter.AdminTabPresenter;
import com.puzzlebazar.client.core.presenter.AdminUsersPresenter;
import com.puzzlebazar.client.core.presenter.PagePresenter;
import com.puzzlebazar.client.core.presenter.LinkColumnPresenter;
import com.puzzlebazar.client.core.presenter.MainPagePresenter;
import com.puzzlebazar.client.core.presenter.NewsItemPresenter;
import com.puzzlebazar.client.core.presenter.PuzzlePresenter;
import com.puzzlebazar.client.core.presenter.SplitMainPresenter;
import com.puzzlebazar.client.core.presenter.TabbedPresenterBundle;
import com.puzzlebazar.client.core.presenter.TopBarPresenter;
import com.puzzlebazar.client.core.presenter.UserSettingsAccountsPresenter;
import com.puzzlebazar.client.core.presenter.UserSettingsGeneralPresenter;
import com.puzzlebazar.client.core.presenter.UserSettingsTabPresenter;
import com.puzzlebazar.client.core.proxy.AdminGeneralProxy;
import com.puzzlebazar.client.core.proxy.AdminTabProxy;
import com.puzzlebazar.client.core.proxy.AdminUsersProxy;
import com.puzzlebazar.client.core.proxy.PageProxy;
import com.puzzlebazar.client.core.proxy.LinkColumnProxy;
import com.puzzlebazar.client.core.proxy.MainPageProxy;
import com.puzzlebazar.client.core.proxy.PuzzleProxy;
import com.puzzlebazar.client.core.proxy.SplitMainProxy;
import com.puzzlebazar.client.core.proxy.UserSettingsAccountsProxy;
import com.puzzlebazar.client.core.proxy.UserSettingsGeneralProxy;
import com.puzzlebazar.client.core.proxy.UserSettingsTabProxy;
import com.puzzlebazar.client.core.view.AdminGeneralView;
import com.puzzlebazar.client.core.view.AdminUsersView;
import com.puzzlebazar.client.core.view.AdminTabView;
import com.puzzlebazar.client.core.view.PageView;
import com.puzzlebazar.client.core.view.LinkColumnView;
import com.puzzlebazar.client.core.view.MainPageView;
import com.puzzlebazar.client.core.view.NewsItemView;
import com.puzzlebazar.client.core.view.PuzzleView;
import com.puzzlebazar.client.core.view.SplitMainView;
import com.puzzlebazar.client.core.view.TopBarView;
import com.puzzlebazar.client.core.view.UserSettingsAccountsView;
import com.puzzlebazar.client.core.view.UserSettingsGeneralView;
import com.puzzlebazar.client.core.view.UserSettingsTabView;
import com.puzzlebazar.client.resources.Resources;
import com.puzzlebazar.client.resources.Translations;
import com.puzzlebazar.client.ui.ShortMessageBox;
import com.puzzlebazar.client.ui.SimpleTabPanel;
import com.puzzlebazar.client.util.ChangeMonitor;
import com.puzzlebazar.client.util.DefaultChangeMonitor;

import com.google.inject.Singleton;

public class PuzzlebazarClientModule extends AbstractPresenterModule {

  @Override
  protected void configure() {  

    // NOTE: Commented lines are unused classes. They are commented out to make sure
    //       the GWT compiler does not include them.
    
    // Singletons
    bind(Resources.class).in(Singleton.class);
    bind(Translations.class).in(Singleton.class);
    bind(EventBus.class).to(DefaultEventBus.class).in(Singleton.class);
    bind(PlaceManager.class).to(PuzzlebazarPlaceManager.class).in(Singleton.class);
    bind(TokenFormatter.class).to(ParameterTokenFormatter.class).in(Singleton.class);
    bind(CurrentUser.class).asEagerSingleton();
    bind(RootProxy.class).asEagerSingleton();

    // Non-singletons
    bind(ChangeMonitor.class).to(DefaultChangeMonitor.class);
    
    // Static injection for classes that don't participate in dependency injection.
    // Right now this includes:
    //  - Widget classes instantiated in UIBinder.
    //  - Classes often instantiated as anonymous classes.    
//    requestStaticInjection(RoundTab.class);
    requestStaticInjection(SimpleTabPanel.class);
    requestStaticInjection(ShortMessageBox.class);
    requestStaticInjection(ActionCallback.class);
    
    // Presenter widget
    bindPresenterWidget(NewsItemPresenter.class, NewsItemPresenter.MyView.class, NewsItemView.class);
    bindPresenterWidget(TopBarPresenter.class, TopBarPresenter.MyView.class, TopBarView.class );

    // Presenter bundles
    bind(TabbedPresenterBundle.class).in(Singleton.class);

    // Presenters
    bind(ProxyBase.class).annotatedWith(DefaultPlace.class).to(MainPageProxy.class);
    bindPresenter(PagePresenter.class,PagePresenter.MyView.class, PageView.class, PagePresenter.MyProxy.class, PageProxy.class);
    bindPresenter(SplitMainPresenter.class, SplitMainPresenter.MyView.class, SplitMainView.class, SplitMainPresenter.MyProxy.class, SplitMainProxy.class );
    bindPresenter(LinkColumnPresenter.class, LinkColumnPresenter.MyView.class, LinkColumnView.class, LinkColumnPresenter.MyProxy.class, LinkColumnProxy.class );
    bindPresenter(UserSettingsTabPresenter.class, UserSettingsTabPresenter.MyView.class, UserSettingsTabView.class, UserSettingsTabPresenter.MyProxy.class, UserSettingsTabProxy.class );
    bindPresenter(UserSettingsGeneralPresenter.class, UserSettingsGeneralPresenter.MyView.class, UserSettingsGeneralView.class, UserSettingsGeneralPresenter.MyProxy.class, UserSettingsGeneralProxy.class);
    bindPresenter(UserSettingsAccountsPresenter.class, UserSettingsAccountsPresenter.MyView.class, UserSettingsAccountsView.class, UserSettingsAccountsPresenter.MyProxy.class, UserSettingsAccountsProxy.class);
    bindPresenter(AdminTabPresenter.class, AdminTabPresenter.MyView.class, AdminTabView.class, AdminTabPresenter.MyProxy.class, AdminTabProxy.class );
    bindPresenter(AdminGeneralPresenter.class, AdminGeneralPresenter.MyView.class, AdminGeneralView.class, AdminGeneralPresenter.MyProxy.class, AdminGeneralProxy.class);
    bindPresenter(AdminUsersPresenter.class, AdminUsersPresenter.MyView.class, AdminUsersView.class, AdminUsersPresenter.MyProxy.class, AdminUsersProxy.class);
    bindPresenter(MainPagePresenter.class, MainPagePresenter.MyView.class, MainPageView.class, MainPagePresenter.MyProxy.class, MainPageProxy.class);
    bindPresenter(PuzzlePresenter.class, PuzzlePresenter.MyView.class, PuzzleView.class, PuzzlePresenter.MyProxy.class, PuzzleProxy.class);
    
  }
}
