package org.ednovo.gooru.client.mvp.play.collection.preview.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class PreviewHomeView_PreviewHomeViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.collection.preview.home.PreviewHomeView>, org.ednovo.gooru.client.mvp.play.collection.preview.home.PreviewHomeView.PreviewHomeViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
    @Template("")
    SafeHtml html2();
     
    @Template("<span id='{0}'></span> <hr> <span id='{1}'></span> <span id='{2}'></span> <hr>")
    SafeHtml html3(String arg0, String arg1, String arg2);
     
    @Template("<hr>")
    SafeHtml html4();
     
    @Template("<h3><span id='{0}'></span></h3> <span id='{1}'></span>")
    SafeHtml html5(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html6(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.collection.preview.home.PreviewHomeView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.collection.preview.home.PreviewHomeView owner;


    final com.google.gwt.event.dom.client.ErrorHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ErrorHandler() {
      public void onError(com.google.gwt.event.dom.client.ErrorEvent event) {
        owner.thumbnailErrorImage(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onassignCollectionBtnClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.oncustomizeCollectionBtnClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onshareCollectionBtnClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ErrorHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ErrorHandler() {
      public void onError(com.google.gwt.event.dom.client.ErrorEvent event) {
        owner.thumbnailEndPageErrorImage(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onviewCollectionSummaryBtnClicked(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.play.collection.preview.home.PreviewHomeView owner) {
      this.owner = owner;
      build_playerStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
    }

    SafeHtml template_html1() {
      return template.html1(get_domId0());
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3(get_domId1(), get_domId2(), get_domId3());
    }
    SafeHtml template_html4() {
      return template.html4();
    }
    SafeHtml template_html5() {
      return template.html5(get_domId4(), get_domId5());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId6(), get_domId7());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.preview.home.PreviewHomeView_PreviewHomeViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.collection.preview.home.PreviewHomeView_PreviewHomeViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.collection.preview.home.PreviewHomeView_PreviewHomeViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.collection.preview.home.PreviewHomeView_PreviewHomeViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.collection.preview.home.PreviewHomeView_PreviewHomeViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for playerStyle called 19 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.preview.home.PreviewHomeView_PreviewHomeViewUiBinderImpl_GenCss_playerStyle playerStyle;
    private org.ednovo.gooru.client.mvp.play.collection.preview.home.PreviewHomeView_PreviewHomeViewUiBinderImpl_GenCss_playerStyle get_playerStyle() {
      return playerStyle;
    }
    private org.ednovo.gooru.client.mvp.play.collection.preview.home.PreviewHomeView_PreviewHomeViewUiBinderImpl_GenCss_playerStyle build_playerStyle() {
      // Creation section.
      playerStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().playerStyle();
      // Setup section.
      playerStyle.ensureInjected();


      return playerStyle;
    }

    /**
     * Getter for f_FlowPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel1() {
      return build_f_FlowPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel1.add(get_collectionImageContainer());
      f_FlowPanel1.add(get_collectionEndImageContainer());
      f_FlowPanel1.add(get_endTextContainer());
      f_FlowPanel1.add(get_previewButtonConatainer());
      f_FlowPanel1.add(get_f_HTMLPanel3());
      f_FlowPanel1.add(get_f_HTMLPanel4());


      return f_FlowPanel1;
    }

    /**
     * Getter for collectionImageContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_collectionImageContainer() {
      return build_collectionImageContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_collectionImageContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel collectionImageContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      collectionImageContainer.add(get_collectionImage());
      collectionImageContainer.setStyleName("" + get_playerStyle().collectionImageContainer() + "");


      owner.collectionImageContainer = collectionImageContainer;

      return collectionImageContainer;
    }

    /**
     * Getter for collectionImage called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Image get_collectionImage() {
      return build_collectionImage();
    }
    private com.google.gwt.user.client.ui.Image build_collectionImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image collectionImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      collectionImage.setStyleName("" + get_playerStyle().collectionImage() + "");
      collectionImage.addErrorHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.collectionImage = collectionImage;

      return collectionImage;
    }

    /**
     * Getter for collectionEndImageContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_collectionEndImageContainer() {
      return build_collectionEndImageContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_collectionEndImageContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel collectionEndImageContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      collectionEndImageContainer.add(get_collectionThumbnail());
      collectionEndImageContainer.add(get_thumbnailContainer());
      collectionEndImageContainer.setStyleName("" + get_playerStyle().collectionEndImageContainer() + "");


      owner.collectionEndImageContainer = collectionEndImageContainer;

      return collectionEndImageContainer;
    }

    /**
     * Getter for collectionThumbnail called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Image get_collectionThumbnail() {
      return build_collectionThumbnail();
    }
    private com.google.gwt.user.client.ui.Image build_collectionThumbnail() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image collectionThumbnail = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      collectionThumbnail.setStyleName("" + get_playerStyle().collectionEndImage() + "");
      collectionThumbnail.addErrorHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);


      owner.collectionThumbnail = collectionThumbnail;

      return collectionThumbnail;
    }

    /**
     * Getter for thumbnailContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_thumbnailContainer() {
      return build_thumbnailContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_thumbnailContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel thumbnailContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      thumbnailContainer.add(get_f_HTMLPanel2());


      owner.thumbnailContainer = thumbnailContainer;

      return thumbnailContainer;
    }

    /**
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_playerStyle().collectionreplay() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1484 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord1484.detach();
      f_HTMLPanel2.addAndReplaceElement(get_replayCollection(), get_domId0Element().get());

      return f_HTMLPanel2;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId0;
    private java.lang.String get_domId0() {
      return domId0;
    }
    private java.lang.String build_domId0() {
      // Creation section.
      domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId0;
    }

    /**
     * Getter for replayCollection called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_replayCollection() {
      return build_replayCollection();
    }
    private com.google.gwt.user.client.ui.Label build_replayCollection() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label replayCollection = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      replayCollection.setStyleName("" + get_playerStyle().collectionreplayText() + "");


      return replayCollection;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId0Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId0Element() {
      return domId0Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId0Element() {
      // Creation section.
      domId0Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId0());
      // Setup section.


      return domId0Element;
    }

    /**
     * Getter for endTextContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_endTextContainer() {
      return build_endTextContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_endTextContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel endTextContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      endTextContainer.setStyleName("" + get_playerStyle().clearfix() + " " + get_playerStyle().collectionbuttons() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1485 = UiBinderUtil.attachToDom(endTextContainer.getElement());
      get_domId1Element().get();
      get_domId2Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord1485.detach();
      endTextContainer.addAndReplaceElement(get_endText(), get_domId1Element().get());
      endTextContainer.addAndReplaceElement(get_backToClasspageButton(), get_domId2Element().get());
      endTextContainer.addAndReplaceElement(get_viewCollectionSummaryBtn(), get_domId3Element().get());

      owner.endTextContainer = endTextContainer;

      return endTextContainer;
    }

    /**
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId1;
    private java.lang.String get_domId1() {
      return domId1;
    }
    private java.lang.String build_domId1() {
      // Creation section.
      domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId1;
    }

    /**
     * Getter for endText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_endText() {
      return build_endText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_endText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel endText = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      endText.setStyleName("" + get_playerStyle().endTitle() + "");


      owner.endText = endText;

      return endText;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId1Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId1Element() {
      return domId1Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId1Element() {
      // Creation section.
      domId1Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId1());
      // Setup section.


      return domId1Element;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId2;
    private java.lang.String get_domId2() {
      return domId2;
    }
    private java.lang.String build_domId2() {
      // Creation section.
      domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId2;
    }

    /**
     * Getter for backToClasspageButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_backToClasspageButton() {
      return build_backToClasspageButton();
    }
    private com.google.gwt.user.client.ui.Button build_backToClasspageButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button backToClasspageButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      backToClasspageButton.setStyleName("backArrowButton");


      owner.backToClasspageButton = backToClasspageButton;

      return backToClasspageButton;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId2Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId2Element() {
      return domId2Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId2Element() {
      // Creation section.
      domId2Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId2());
      // Setup section.


      return domId2Element;
    }

    /**
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId3;
    private java.lang.String get_domId3() {
      return domId3;
    }
    private java.lang.String build_domId3() {
      // Creation section.
      domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId3;
    }

    /**
     * Getter for viewCollectionSummaryBtn called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_viewCollectionSummaryBtn() {
      return build_viewCollectionSummaryBtn();
    }
    private com.google.gwt.user.client.ui.Button build_viewCollectionSummaryBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button viewCollectionSummaryBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      viewCollectionSummaryBtn.setStyleName("primary");
      viewCollectionSummaryBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);


      owner.viewCollectionSummaryBtn = viewCollectionSummaryBtn;

      return viewCollectionSummaryBtn;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId3Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId3Element() {
      return domId3Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId3Element() {
      // Creation section.
      domId3Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId3());
      // Setup section.


      return domId3Element;
    }

    /**
     * Getter for previewButtonConatainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_previewButtonConatainer() {
      return build_previewButtonConatainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_previewButtonConatainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel previewButtonConatainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      previewButtonConatainer.add(get_previewButton());
      previewButtonConatainer.add(get_separationLine());
      previewButtonConatainer.add(get_assignCollectionBtn());
      previewButtonConatainer.add(get_customizeCollectionBtn());
      previewButtonConatainer.add(get_shareCollectionBtn());
      previewButtonConatainer.setStyleName("" + get_playerStyle().clearfix() + " " + get_playerStyle().collectionbuttons() + "");


      owner.previewButtonConatainer = previewButtonConatainer;

      return previewButtonConatainer;
    }

    /**
     * Getter for previewButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_previewButton() {
      return build_previewButton();
    }
    private com.google.gwt.user.client.ui.Button build_previewButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button previewButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      previewButton.setStyleName("" + get_playerStyle().preview() + "");


      owner.previewButton = previewButton;

      return previewButton;
    }

    /**
     * Getter for separationLine called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.InlineHTML get_separationLine() {
      return build_separationLine();
    }
    private com.google.gwt.user.client.ui.InlineHTML build_separationLine() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineHTML separationLine = (com.google.gwt.user.client.ui.InlineHTML) GWT.create(com.google.gwt.user.client.ui.InlineHTML.class);
      // Setup section.
      separationLine.setHTML(template_html4().asString());
      separationLine.setStyleName("");


      owner.separationLine = separationLine;

      return separationLine;
    }

    /**
     * Getter for assignCollectionBtn called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_assignCollectionBtn() {
      return build_assignCollectionBtn();
    }
    private com.google.gwt.user.client.ui.Button build_assignCollectionBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button assignCollectionBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      assignCollectionBtn.setStyleName("secondary");
      assignCollectionBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.assignCollectionBtn = assignCollectionBtn;

      return assignCollectionBtn;
    }

    /**
     * Getter for customizeCollectionBtn called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_customizeCollectionBtn() {
      return build_customizeCollectionBtn();
    }
    private com.google.gwt.user.client.ui.Button build_customizeCollectionBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button customizeCollectionBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      customizeCollectionBtn.setStyleName("secondary");
      customizeCollectionBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.customizeCollectionBtn = customizeCollectionBtn;

      return customizeCollectionBtn;
    }

    /**
     * Getter for shareCollectionBtn called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_shareCollectionBtn() {
      return build_shareCollectionBtn();
    }
    private com.google.gwt.user.client.ui.Button build_shareCollectionBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button shareCollectionBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      shareCollectionBtn.setStyleName("secondary");
      shareCollectionBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);


      owner.shareCollectionBtn = shareCollectionBtn;

      return shareCollectionBtn;
    }

    /**
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1486 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId4Element().get();
      get_domId5Element().get();

      // Detach section.
      attachRecord1486.detach();
      f_HTMLPanel3.addAndReplaceElement(get_learningobjectiveText(), get_domId4Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_collectionGoal(), get_domId5Element().get());

      return f_HTMLPanel3;
    }

    /**
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId4;
    private java.lang.String get_domId4() {
      return domId4;
    }
    private java.lang.String build_domId4() {
      // Creation section.
      domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId4;
    }

    /**
     * Getter for learningobjectiveText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_learningobjectiveText() {
      return build_learningobjectiveText();
    }
    private com.google.gwt.user.client.ui.Label build_learningobjectiveText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label learningobjectiveText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.learningobjectiveText = learningobjectiveText;

      return learningobjectiveText;
    }

    /**
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId4Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId4Element() {
      return domId4Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId4Element() {
      // Creation section.
      domId4Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId4());
      // Setup section.


      return domId4Element;
    }

    /**
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId5;
    private java.lang.String get_domId5() {
      return domId5;
    }
    private java.lang.String build_domId5() {
      // Creation section.
      domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId5;
    }

    /**
     * Getter for collectionGoal called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTML get_collectionGoal() {
      return build_collectionGoal();
    }
    private com.google.gwt.user.client.ui.HTML build_collectionGoal() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML collectionGoal = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      collectionGoal.setStyleName("" + get_playerStyle().goal() + "");


      owner.collectionGoal = collectionGoal;

      return collectionGoal;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId5Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId5Element() {
      return domId5Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId5Element() {
      // Creation section.
      domId5Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId5());
      // Setup section.


      return domId5Element;
    }

    /**
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1487 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId6Element().get();
      get_domId7Element().get();

      // Detach section.
      attachRecord1487.detach();
      f_HTMLPanel4.addAndReplaceElement(get_resourceCountTitle(), get_domId6Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_f_FlowPanel5(), get_domId7Element().get());

      return f_HTMLPanel4;
    }

    /**
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId6;
    private java.lang.String get_domId6() {
      return domId6;
    }
    private java.lang.String build_domId6() {
      // Creation section.
      domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId6;
    }

    /**
     * Getter for resourceCountTitle called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_resourceCountTitle() {
      return build_resourceCountTitle();
    }
    private com.google.gwt.user.client.ui.Label build_resourceCountTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourceCountTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourceCountTitle.setStyleName("" + get_playerStyle().resource_count() + "");


      owner.resourceCountTitle = resourceCountTitle;

      return resourceCountTitle;
    }

    /**
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId6Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId6Element() {
      return domId6Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId6Element() {
      // Creation section.
      domId6Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId6());
      // Setup section.


      return domId6Element;
    }

    /**
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId7;
    private java.lang.String get_domId7() {
      return domId7;
    }
    private java.lang.String build_domId7() {
      // Creation section.
      domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId7;
    }

    /**
     * Getter for f_FlowPanel5 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel5() {
      return build_f_FlowPanel5();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel5 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel5.add(get_previousButton());
      f_FlowPanel5.add(get_resourceCurosalContainer());
      f_FlowPanel5.add(get_nextButton());
      f_FlowPanel5.setStyleName("carousel");


      return f_FlowPanel5;
    }

    /**
     * Getter for previousButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_previousButton() {
      return build_previousButton();
    }
    private com.google.gwt.user.client.ui.Label build_previousButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label previousButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      previousButton.setStyleName("" + get_playerStyle().leftArrow() + "");


      owner.previousButton = previousButton;

      return previousButton;
    }

    /**
     * Getter for resourceCurosalContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_resourceCurosalContainer() {
      return build_resourceCurosalContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_resourceCurosalContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel resourceCurosalContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      resourceCurosalContainer.setStyleName("" + get_playerStyle().resources() + "");


      owner.resourceCurosalContainer = resourceCurosalContainer;

      return resourceCurosalContainer;
    }

    /**
     * Getter for nextButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_nextButton() {
      return build_nextButton();
    }
    private com.google.gwt.user.client.ui.Label build_nextButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label nextButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      nextButton.setStyleName("" + get_playerStyle().rightArrow() + "");


      owner.nextButton = nextButton;

      return nextButton;
    }

    /**
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId7Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId7Element() {
      return domId7Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId7Element() {
      // Creation section.
      domId7Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId7());
      // Setup section.


      return domId7Element;
    }
  }
}