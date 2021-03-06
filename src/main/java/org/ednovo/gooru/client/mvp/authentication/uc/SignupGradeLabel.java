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
package org.ednovo.gooru.client.mvp.authentication.uc;

import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.authentication.SignUpCBundle;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.user.ProfileDo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Label;

/**
 * @author DOTS
 *
 */
public class SignupGradeLabel extends Label implements ClickHandler {
	
	private static final List<String> gradeList = new ArrayList<String>();
	
	ProfileDo profileDo = null;
	
	private static final String KIDER_GARTEN = "Kindergarten";
	
	private static final String HIGHER_EDUCATION = "Higher Education";
	
	private static final String REGISTER_USER_LEVEL = "settings";
	
	/**
	 * Class constructor
	 * @param label name of the {@link Label}
	 * @param collectionDo instance of {@link CollectionDo}
	 */
	public SignupGradeLabel(String label, ProfileDo profileDo){
		super(label);
		SignUpCBundle.INSTANCE.css().ensureInjected();
		addDomHandler(this, ClickEvent.getType());
		this.profileDo = profileDo;
		this.addStyleName(SignUpCBundle.INSTANCE.css().gradeOption());
		if(label.equals(KIDER_GARTEN)||label.equals(HIGHER_EDUCATION)){
			this.addStyleName(SignUpCBundle.INSTANCE.css().longWidth());
		}
	}

	@Override
	public void onClick(ClickEvent event) {
		if(this.getStyleName().toString().contains("active")){
			removeGrade(this.getText());
			this.removeStyleName(SignUpCBundle.INSTANCE.css().active());
		} else {
			updateGrade(this.getText());
			this.addStyleName(SignUpCBundle.INSTANCE.css().active());
		}
	}
	
	private void updateGrade(String grade){
		AppClientFactory.getInjector().getProfilePageService().addGradeUserProfile(grade, REGISTER_USER_LEVEL, new SimpleAsyncCallback<Void>(){
				@Override
				public void onSuccess(Void result) {
					
				}
		});
	}

	private void removeGrade(String grade){
		AppClientFactory.getInjector().getProfilePageService().deleteGradeUserProfile(grade, REGISTER_USER_LEVEL, new SimpleAsyncCallback<Void>(){
				@Override
				public void onSuccess(Void result) {
					
				}
		});
	}

}
