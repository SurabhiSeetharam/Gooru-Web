package org.ednovo.gooru.client.mvp.play.collection.preview;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$IsPreviewPlayerProxy$_annotation$$none$$(org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter.IsPreviewPlayerProxy injectee) {
    
  }
  
  public native void org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter_playerAppService_fieldInjection(org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter injectee, org.ednovo.gooru.client.service.PlayerAppServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter::playerAppService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection___________________________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter_playerAppService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$PlayerAppServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerView$_annotation$$none$$(org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.collection.preview.IsPreviewPlayerView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  public org.ednovo.gooru.client.mvp.play.collection.preview.IsPreviewPlayerView get_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$IsPreviewPlayerView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.collection.preview.IsPreviewPlayerView result = get_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerView$_annotation$$none$$();
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter.IsPreviewPlayerProxy singleton_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$IsPreviewPlayerProxy$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter.IsPreviewPlayerProxy get_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$IsPreviewPlayerProxy$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$IsPreviewPlayerProxy$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter.IsPreviewPlayerProxy.class);
    assert created instanceof org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter.IsPreviewPlayerProxy;
    org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter.IsPreviewPlayerProxy result = (org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter.IsPreviewPlayerProxy) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$IsPreviewPlayerProxy$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$IsPreviewPlayerProxy$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$IsPreviewPlayerProxy$_annotation$$none$$;
    
  }
  
  private org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter singleton_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter get_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter result = org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter_org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter_methodInjection(injector.getFragment_org_ednovo_gooru_client_mvp_play_collection_preview_metadata().get_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$metadata$PreviewPlayerMetadataPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_play_resource_body().get_Key$type$org$ednovo$gooru$client$mvp$play$resource$body$ResourcePlayerMetadataPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_play_collection_toc().get_Key$type$org$ednovo$gooru$client$mvp$play$collection$toc$CollectionPlayerTocPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_play_collection_share().get_Key$type$org$ednovo$gooru$client$mvp$play$collection$share$CollectionSharePresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_play_collection_info().get_Key$type$org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_play_resource_narration().get_Key$type$org$ednovo$gooru$client$mvp$play$resource$narration$ResourceNarrationPresenter$_annotation$$none$$(), injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$IsPreviewPlayerView$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$IsPreviewPlayerProxy$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_play_resource_add().get_Key$type$org$ednovo$gooru$client$mvp$play$resource$add$AddResourceCollectionPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_play_collection_add().get_Key$type$org$ednovo$gooru$client$mvp$play$collection$add$AddCollectionPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_shelf_collection().get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$CollectionFormInPlayPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_play_collection_flag().get_Key$type$org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_play_resource_flag().get_Key$type$org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_authentication().get_Key$type$org$ednovo$gooru$client$mvp$authentication$SignUpPresenter$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter_org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter_methodInjection(org.ednovo.gooru.client.mvp.play.collection.preview.metadata.PreviewPlayerMetadataPresenter _0, org.ednovo.gooru.client.mvp.play.resource.body.ResourcePlayerMetadataPresenter _1, org.ednovo.gooru.client.mvp.play.collection.toc.CollectionPlayerTocPresenter _2, org.ednovo.gooru.client.mvp.play.collection.share.CollectionSharePresenter _3, org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoPresenter _4, org.ednovo.gooru.client.mvp.play.resource.narration.ResourceNarrationPresenter _5, com.google.gwt.event.shared.EventBus _6, org.ednovo.gooru.client.mvp.play.collection.preview.IsPreviewPlayerView _7, org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter.IsPreviewPlayerProxy _8, org.ednovo.gooru.client.mvp.play.resource.add.AddResourceCollectionPresenter _9, org.ednovo.gooru.client.mvp.play.collection.add.AddCollectionPresenter _10, org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayPresenter _11, org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagPresenter _12, org.ednovo.gooru.client.mvp.play.resource.flag.ResourceFlagPresenter _13, org.ednovo.gooru.client.mvp.authentication.SignUpPresenter _14) {
    return new org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter(_0, _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$_annotation$$none$$());
            }
            public void onFailure(Throwable ex) { 
               callback.onFailure(ex); 
            } 
        }); 
        }
     };
    
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView singleton_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerView$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView get_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerView$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerView$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView result = org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerView_org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerView_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerView$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerView$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerView_org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerView_methodInjection(com.google.gwt.event.shared.EventBus _0) {
    return new org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView(_0);
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector;
  public org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment(org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector) {
    this.injector = injector;
  }
  
  public void initializeEagerSingletons() {
    // Eager singleton bound at:
    //   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter$IsPreviewPlayerProxy
    get_Key$type$org$ednovo$gooru$client$mvp$play$collection$preview$PreviewPlayerPresenter$IsPreviewPlayerProxy$_annotation$$none$$();
    
  }
  
}