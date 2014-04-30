/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 * 
 *  http://www.goorulearning.org/
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.ednovo.gooru.client.mvp.play.collection.preview.metadata;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.assignments.AddAssignmentContainerCBundle;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;

/**
 * @fileName : CopyConfirmPopupVc.java
 * 
 * @description :This class is used to copy collection in self page
 * 
 * @version : 5.5
 * 
 * @date: Apr 17, 2013
 * 
 * @Author :Gooru Team
 * 
 * @Reviewer:
 */
public abstract class NavigationConfirmPopup extends PopupPanel implements MessageProperties{
	
	@UiField Button continueButton,backToResponseButton;
	@UiField Label popupHeader,popupText;
	

	private static NavigationConfirmPopupUiBinder uiBinder = GWT.create(NavigationConfirmPopupUiBinder.class);

	interface NavigationConfirmPopupUiBinder extends UiBinder<Widget, NavigationConfirmPopup> {
	}
	
	/**
	 * default constructor of CopyConfirmPopupVc
	 */
	public NavigationConfirmPopup() {
		super();
		this.setWidget(uiBinder.createAndBindUi(this));
		setStaticTexts();
		AddAssignmentContainerCBundle.INSTANCE.css().ensureInjected();
		this.getElement().getStyle().setZIndex(999999);
		this.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().copyResourcePopupContainer());
		this.setGlassEnabled(true);
		this.setAutoHideOnHistoryEventsEnabled(true);
		this.getGlassElement().getStyle().setZIndex(999999);
		this.show();
		this.center();
		this.setModal(true);
	}
	public void setStaticTexts(){
		popupHeader.setText(GL1660);
		popupText.setText(GL1661);
		continueButton.setText(GL1663);
		backToResponseButton.setText(GL1662);
		continueButton.getElement().setId("backtoresponse");
		backToResponseButton.getElement().setId("continue");
	}
	

	/**
	 * for close copy collection popup
	 * 
	 * @param clickEvent
	 */
	@UiHandler("backToResponseButton")
	public void onCancelClick(ClickEvent clickEvent) {
		hide();
	}


	@UiHandler("continueButton")
	public void onClickCopyBtn(ClickEvent clickEvent){
		navigateToNextResource();
	}
	
	public void hide(){
		super.hide();
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
	}
	
	public abstract void navigateToNextResource();

}