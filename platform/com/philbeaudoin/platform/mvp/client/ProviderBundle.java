package com.philbeaudoin.platform.mvp.client;

import com.google.inject.Provider;

/**
 * This class can be used to contain a group of providers that
 * should all sit behind the same split point. That is, if the
 * code for one provided object is loaded, so is the code for
 * the others. This is useful when the provided objects share
 * the bulk of their code, which would end up in the left-overs
 * if the objects were behind their individual split points.
 * <p />
 * Here is an example use of {@link ProviderBundle}:
 * 
 * <pre>
 * public class MyPresenterBundle extends ProviderBundle {
 *   public final static int ID_Object1 = 0;
 *   public final static int ID_Object2 = 1;
 *   public final static int BUNDLE_SIZE = 2;
 *
 *   &#064;Inject
 *   MyPresenterBundle(
 *       final Provider<Object1> object1Provider,
 *       final Provider<Object2> object2Provider) {
 *     super( BUNDLE_SIZE );
 *     providers[ID_Object1] = object1Provider;
 *     providers[ID_Object2] = object2Provider;
 *   }  
 * }</pre>
 * 
 * @author Philippe Beaudoin
 */
public class ProviderBundle {

  protected final Provider<?> providers[] ;

  /**
   * Constructs a {@link ProviderBundle} containing
   * a given number of providers. After calling this constructor
   * you should set the provider manually like so:
   * <pre>
   *     providers[0] = object1Provider;
   *     providers[1] = object2Provider;
   *     ...
   *     providers[bundleSize-1] = objectNProvider;</pre>
   * @param bundleSize The number of providers in the bundle.
   */
  public ProviderBundle( int bundleSize ) {
    providers = new Provider<?>[bundleSize];
  }

  /**
   * Accesses a provider given its id.
   * 
   * @param providerId The id of the provider to access.
   * @return The provider.
   */
  public Provider<?> get(int providerId) {
    return providers[providerId];
  }

}