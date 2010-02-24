package com.puzzlebazar.client.presenter;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.philbeaudoin.gwt.presenter.client.BasicPresenter;
import com.philbeaudoin.gwt.presenter.client.EventBus;
import com.philbeaudoin.gwt.presenter.client.PresenterDisplay;
import com.puzzlebazar.client.place.UserSettingsMainPlace;
import com.puzzlebazar.client.resources.Translations;

/**
 * This is the main presenter of the user settings tab presenter
 * 
 * @author beaudoin
 */
public class UserSettingsMainPresenter extends BasicPresenter<UserSettingsMainPresenter.Display, UserSettingsMainPresenter.Wrapper> {

  public interface Display extends PresenterDisplay { }

  public static class Wrapper extends TabPresenterWrapper<UserSettingsMainPresenter, UserSettingsMainPlace> {
    @Inject
    public Wrapper(final EventBus eventBus, final Provider<UserSettingsMainPresenter> presenter, 
        final Provider<UserSettingsMainPlace> place, final Translations translations) {
      super(eventBus, presenter, place, translations);
    }
    @Override
    public String getText() {
      return translations.settings();
    }
  }

  @Inject
  public UserSettingsMainPresenter(final Display display, final EventBus eventBus, 
      final Wrapper wrapper, final UserSettingsPresenter.MainSlot parentSlot) {
    super(display, eventBus, wrapper, parentSlot);
    bind();
  }

  @Override
  protected void onBind() {
  }

  @Override
  protected void onUnbind() {
  }



}
