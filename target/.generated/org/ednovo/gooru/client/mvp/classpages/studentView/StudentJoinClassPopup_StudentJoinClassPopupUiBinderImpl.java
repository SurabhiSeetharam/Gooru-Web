package org.ednovo.gooru.client.mvp.classpages.studentView;

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

public class StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup>, org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup.StudentJoinClassPopupUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("")
    SafeHtml html2();
     
    @Template("")
    SafeHtml html3();
     
    @Template("")
    SafeHtml html4();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html5(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html6(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>  <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span>")
    SafeHtml html7(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html8(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html9(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html10(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnCloseBtn(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnJoinLaterBtn(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnJoinClassBtn(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3();
    }
    SafeHtml template_html4() {
      return template.html4();
    }
    SafeHtml template_html5() {
      return template.html5(get_domId12(), get_domId13());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId11());
    }
    SafeHtml template_html7() {
      return template.html7(get_domId5(), get_domId6(), get_domId7(), get_domId8(), get_domId9(), get_domId10());
    }
    SafeHtml template_html8() {
      return template.html8(get_domId2(), get_domId3(), get_domId4());
    }
    SafeHtml template_html9() {
      return template.html9(get_domId1());
    }
    SafeHtml template_html10() {
      return template.html10(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 14 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_style().popupGlass() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1266 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord1266.detach();
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel2(), get_domId0Element().get());

      return f_HTMLPanel1;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_style().popup() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1267 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId1Element().get();

      // Detach section.
      attachRecord1267.detach();
      f_HTMLPanel2.addAndReplaceElement(get_f_HTMLPanel3(), get_domId1Element().get());

      return f_HTMLPanel2;
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
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_style().popupInner() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1268 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId2Element().get();
      get_domId3Element().get();
      get_domId4Element().get();

      // Detach section.
      attachRecord1268.detach();
      f_HTMLPanel3.addAndReplaceElement(get_headerPanel(), get_domId2Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_closeLbl(), get_domId3Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_f_HTMLPanel4(), get_domId4Element().get());

      return f_HTMLPanel3;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for headerPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_headerPanel() {
      return build_headerPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_headerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel headerPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      headerPanel.setStyleName("" + get_style().popupHeader() + "");


      owner.headerPanel = headerPanel;

      return headerPanel;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for closeLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_closeLbl() {
      return build_closeLbl();
    }
    private com.google.gwt.user.client.ui.Label build_closeLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label closeLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      closeLbl.setStyleName("" + get_style().closeButton() + "");
      closeLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.closeLbl = closeLbl;

      return closeLbl;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_style().popupContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1269 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId5Element().get();
      get_domId6Element().get();
      get_domId7Element().get();
      get_domId8Element().get();
      get_domId9Element().get();
      get_domId10Element().get();

      // Detach section.
      attachRecord1269.detach();
      f_HTMLPanel4.addAndReplaceElement(get_welcomePanel(), get_domId5Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_classNamePanel(), get_domId6Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_descPanel(), get_domId7Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_htmlAgree(), get_domId8Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_htmlInformation(), get_domId9Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel5(), get_domId10Element().get());

      return f_HTMLPanel4;
    }

    /**
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for welcomePanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_welcomePanel() {
      return build_welcomePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_welcomePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel welcomePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      welcomePanel.setStyleName("" + get_style().h1() + "");


      owner.welcomePanel = welcomePanel;

      return welcomePanel;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for classNamePanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_classNamePanel() {
      return build_classNamePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_classNamePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel classNamePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      classNamePanel.setStyleName("" + get_style().h2() + "");


      owner.classNamePanel = classNamePanel;

      return classNamePanel;
    }

    /**
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for descPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_descPanel() {
      return build_descPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_descPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel descPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      descPanel.setStyleName("" + get_style().headerdesc() + "");


      owner.descPanel = descPanel;

      return descPanel;
    }

    /**
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 5.
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

    /**
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId8;
    private java.lang.String get_domId8() {
      return domId8;
    }
    private java.lang.String build_domId8() {
      // Creation section.
      domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId8;
    }

    /**
     * Getter for htmlAgree called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTML get_htmlAgree() {
      return build_htmlAgree();
    }
    private com.google.gwt.user.client.ui.HTML build_htmlAgree() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML htmlAgree = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      htmlAgree.setStyleName("" + get_style().desc() + "");


      owner.htmlAgree = htmlAgree;

      return htmlAgree;
    }

    /**
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId8Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId8Element() {
      return domId8Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId8Element() {
      // Creation section.
      domId8Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId8());
      // Setup section.


      return domId8Element;
    }

    /**
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId9;
    private java.lang.String get_domId9() {
      return domId9;
    }
    private java.lang.String build_domId9() {
      // Creation section.
      domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId9;
    }

    /**
     * Getter for htmlInformation called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTML get_htmlInformation() {
      return build_htmlInformation();
    }
    private com.google.gwt.user.client.ui.HTML build_htmlInformation() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML htmlInformation = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      htmlInformation.setStyleName("" + get_style().descInformation() + "");


      owner.htmlInformation = htmlInformation;

      return htmlInformation;
    }

    /**
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId9Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId9Element() {
      return domId9Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId9Element() {
      // Creation section.
      domId9Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId9());
      // Setup section.


      return domId9Element;
    }

    /**
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId10;
    private java.lang.String get_domId10() {
      return domId10;
    }
    private java.lang.String build_domId10() {
      // Creation section.
      domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId10;
    }

    /**
     * Getter for f_HTMLPanel5 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel5() {
      return build_f_HTMLPanel5();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      f_HTMLPanel5.setStyleName("" + get_style().signInContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1270 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
      get_domId11Element().get();

      // Detach section.
      attachRecord1270.detach();
      f_HTMLPanel5.addAndReplaceElement(get_f_HTMLPanel6(), get_domId11Element().get());

      return f_HTMLPanel5;
    }

    /**
     * Getter for domId11 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId11;
    private java.lang.String get_domId11() {
      return domId11;
    }
    private java.lang.String build_domId11() {
      // Creation section.
      domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId11;
    }

    /**
     * Getter for f_HTMLPanel6 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel6() {
      return build_f_HTMLPanel6();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1271 = UiBinderUtil.attachToDom(f_HTMLPanel6.getElement());
      get_domId12Element().get();
      get_domId13Element().get();

      // Detach section.
      attachRecord1271.detach();
      f_HTMLPanel6.addAndReplaceElement(get_joinLaterBtn(), get_domId12Element().get());
      f_HTMLPanel6.addAndReplaceElement(get_joinClassBtn(), get_domId13Element().get());

      return f_HTMLPanel6;
    }

    /**
     * Getter for domId12 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId12;
    private java.lang.String get_domId12() {
      return domId12;
    }
    private java.lang.String build_domId12() {
      // Creation section.
      domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId12;
    }

    /**
     * Getter for joinLaterBtn called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Button get_joinLaterBtn() {
      return build_joinLaterBtn();
    }
    private com.google.gwt.user.client.ui.Button build_joinLaterBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button joinLaterBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      joinLaterBtn.setStyleName("secondary " + get_style().btnJoin() + "");
      joinLaterBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.joinLaterBtn = joinLaterBtn;

      return joinLaterBtn;
    }

    /**
     * Getter for domId12Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId12Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId12Element() {
      return domId12Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId12Element() {
      // Creation section.
      domId12Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId12());
      // Setup section.


      return domId12Element;
    }

    /**
     * Getter for domId13 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId13;
    private java.lang.String get_domId13() {
      return domId13;
    }
    private java.lang.String build_domId13() {
      // Creation section.
      domId13 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId13;
    }

    /**
     * Getter for joinClassBtn called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Button get_joinClassBtn() {
      return build_joinClassBtn();
    }
    private com.google.gwt.user.client.ui.Button build_joinClassBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button joinClassBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      joinClassBtn.setStyleName("primary " + get_style().btnJoin() + "");
      joinClassBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.joinClassBtn = joinClassBtn;

      return joinClassBtn;
    }

    /**
     * Getter for domId13Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId13Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId13Element() {
      return domId13Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId13Element() {
      // Creation section.
      domId13Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId13());
      // Setup section.


      return domId13Element;
    }

    /**
     * Getter for domId11Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId11Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId11Element() {
      return domId11Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId11Element() {
      // Creation section.
      domId11Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId11());
      // Setup section.


      return domId11Element;
    }

    /**
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId10Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId10Element() {
      return domId10Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId10Element() {
      // Creation section.
      domId10Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId10());
      // Setup section.


      return domId10Element;
    }

    /**
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
  }
}