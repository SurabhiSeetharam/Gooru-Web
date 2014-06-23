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
package org.ednovo.gooru.client.mvp.library.sausd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SeoTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.library.ProfileLibraryDo;
import org.ednovo.gooru.shared.model.library.ProfileLibraryListDo;
import org.ednovo.gooru.shared.model.library.SubjectDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public abstract class SausdMenuNav extends Composite implements MessageProperties{

	@UiField HTMLPanel tabsInner, scienceCourses, mathCourses, socialCourses, elaCourses,learnCourses;
	
	@UiField HTMLEventPanel sciencePanel, mathPanel, socialPanel, elaPanel,learnPanel;
	
	@UiField Label scienceText,mathText,socialSciencesText,languageArtsText,learnText;
	
	@UiField SausdStyleBundle sausdStyleUc;
	
	@UiField Anchor aboutGooruAnr;
	
	private static final String SCIENCE = "science", MATH = "math", SOCIAL="social-sciences", LANGUAGE="language-arts", LEARNING = "elementary";
	
	private static final String LIBRARY_PAGE = "page";
	
	private static final String SUBJECT = "subject";
	
	private static final String ACTIVE = "active";
	
	private boolean isScienceHovered = false, isMathHovered = false, isSocialHovered = false, isLanguageHovered = false, isLearningHovered = false;
	
	private Map<String, String> subjectIdList = new HashMap<String, String>();
	
	private String placeToken = null;
	
    private static SausdMenuNavUiBinder uiBinder = GWT.create(SausdMenuNavUiBinder.class);

	interface SausdMenuNavUiBinder extends UiBinder<Widget, SausdMenuNav> {
	}

	public SausdMenuNav(String placeToken) {
		initWidget(uiBinder.createAndBindUi(this));
		setPlaceToken(placeToken);
		setAssets();
		
		sciencePanel.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(!isScienceHovered) {
					isScienceHovered = true;
					getTaxonomyData(subjectIdList.get(SCIENCE), SCIENCE);
				}
			}
		});
		
		mathPanel.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(!isMathHovered) {
					isMathHovered = true;
					getTaxonomyData(subjectIdList.get(MATH),MATH);
				}
			}
		});

		socialPanel.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(!isSocialHovered) {
					isSocialHovered = true;
					getTaxonomyData(subjectIdList.get(SOCIAL),SOCIAL);
				}
			}
		});
		
		elaPanel.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(!isLanguageHovered) {
					isLanguageHovered = true;
					getTaxonomyData(subjectIdList.get(LANGUAGE),LANGUAGE);
				}
			}
		});

		learnPanel.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(!isLearningHovered) {
					isLearningHovered = true;
					getTaxonomyData(subjectIdList.get(LEARNING),LEARNING);
				}
			}
		});
	}
	
	private void setAssets() {
		scienceText.setText(GL1000);
		mathText.setText(GL1001);
		socialSciencesText.setText("Social Studies");
		languageArtsText.setText(GL1003);
		learnText.setText("Elementary");
		if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SAUSD_LIBRARY)) {
			aboutGooruAnr.setText(GL1899);
			aboutGooruAnr.setHref(GL1900);
		}
		aboutGooruAnr.setTarget("_blank");
		aboutGooruAnr.addStyleName(sausdStyleUc.aboutGooruAnrPadding());
		aboutGooruAnr.addClickHandler(new MixPanelEventClick());
		
		scienceText.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		mathText.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		socialSciencesText.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		languageArtsText.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		learnText.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		aboutGooruAnr.getElement().getStyle().setTextAlign(TextAlign.CENTER);
	}
	
	public void getTaxonomyData(final String subjectCode, final String subjectName) {
		AppClientFactory.getInjector().getLibraryService().getLibraryPaginationWorkspace(subjectCode, "public", 14, new AsyncCallback<ProfileLibraryListDo>() {
			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(ProfileLibraryListDo profileLibraryListDo) {
				setTaxonomyData(subjectName, subjectCode, profileLibraryListDo);
			}
		});
	}
	
	public boolean getSubjectSelected(String subjectName) {
		boolean isSelected = false;
		if(subjectName.equalsIgnoreCase(SCIENCE)&&scienceCourses.getWidgetCount()>0) {
			isSelected = true;
		} else if(subjectName.equalsIgnoreCase(MATH)&&mathCourses.getWidgetCount()>0) {
			isSelected = true;
		} else if(subjectName.equalsIgnoreCase(SOCIAL)&&socialCourses.getWidgetCount()>0) {
			isSelected = true;
		} else if(subjectName.equalsIgnoreCase(LANGUAGE)&&elaCourses.getWidgetCount()>0) {
			isSelected = true;
		} else if(subjectName.equalsIgnoreCase(LEARNING)&&learnCourses.getWidgetCount()>0) {
			isSelected = true;
		}
		return isSelected;
	}
	
	protected void setTaxonomyData(final String subjectname, final String subjectCode, ProfileLibraryListDo profileLibraryListDo) {
		if (profileLibraryListDo.getSearchResult() != null) {
			for (final ProfileLibraryDo profileLibraryDo : profileLibraryListDo.getSearchResult()) {
					Label courseTitle = new Label(profileLibraryDo.getTitle());
					courseTitle.setStyleName(sausdStyleUc.courseOption());
					final String courseId = profileLibraryDo.getGooruOid().toString();
					courseTitle.addClickHandler(new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							setTabSelection(subjectname);
							clickOnCourse(profileLibraryDo.getCollectionItems(), courseId, profileLibraryDo);
						}
					});
					if(subjectname.equalsIgnoreCase(SCIENCE)) {
						scienceCourses.add(courseTitle);
					} else if(subjectname.equalsIgnoreCase(MATH)) {
						mathCourses.add(courseTitle);
					} else if(subjectname.equalsIgnoreCase(SOCIAL)) {
						socialCourses.add(courseTitle);
					} else if(subjectname.equalsIgnoreCase(LANGUAGE)) {
						elaCourses.add(courseTitle);
					} else if(subjectname.equalsIgnoreCase(LEARNING)) {
						learnCourses.add(courseTitle);
					}
			}
		}
	}
	
	private void setHeaderBrowserTitle(String courseLabel) {
		AppClientFactory.setBrowserWindowTitle(SeoTokens.COURSE_PAGE_TITLE+courseLabel);	
	}
	
	public void setSubjectPanelIds(ProfileLibraryListDo profileLibraryListDo) {
		for (ProfileLibraryDo profileListDo : profileLibraryListDo.getSearchResult()) {
			if(profileListDo.getTitle().toLowerCase().contains("social")) {
				subjectIdList.put(SOCIAL, profileListDo.getGooruOid());
			} else if(profileListDo.getTitle().toLowerCase().contains("math")) {
				subjectIdList.put(MATH, profileListDo.getGooruOid());
			} else if(profileListDo.getTitle().toLowerCase().contains("science")) {
				subjectIdList.put(SCIENCE, profileListDo.getGooruOid());
			} else if(profileListDo.getTitle().toLowerCase().contains("language")) {
				subjectIdList.put(LANGUAGE, profileListDo.getGooruOid());
			} else {
				subjectIdList.put(LEARNING, profileListDo.getGooruOid());
			}
		}
	}
	
	public String getSubjectNameBySubjectId(HashMap<String, SubjectDo> subjectList, String subjectId) {
		for (Map.Entry<String, SubjectDo> entry : subjectList.entrySet()) {
			if(entry.getValue().getCode().equals(subjectId)) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	public String getSubjectIdBySubjectName(Map<String,String> subjectList, String subject) {
		for (Map.Entry<String, String> entry : subjectList.entrySet()) {
			if(entry.getKey().equalsIgnoreCase(subject)) {
				return entry.getValue();
			}
		}
		return null;
	}
	
	public void setTabSelection(String subjectName) {
		clearSelectionTabs();
		if(subjectName.equals(SCIENCE)) {
			sciencePanel.addStyleName(ACTIVE);
		} else if(subjectName.equals(MATH)) {
			mathPanel.addStyleName(ACTIVE);
		} else if(subjectName.equals(SOCIAL)) {
			socialPanel.addStyleName(ACTIVE);
		} else if(subjectName.equals(LANGUAGE)) {
			elaPanel.addStyleName(ACTIVE);
		} else if(subjectName.equals(LEARNING)) {
			learnPanel.addStyleName(ACTIVE);
		}
	}
	
	private void clearSelectionTabs() {
		sciencePanel.removeStyleName(ACTIVE);
		mathPanel.removeStyleName(ACTIVE);
		socialPanel.removeStyleName(ACTIVE);
		elaPanel.removeStyleName(ACTIVE);
		learnPanel.removeStyleName(ACTIVE);
	}
	
	public String getPlaceToken() {
		return placeToken;
	}

	private void setPlaceToken(String placeToken) {
		this.placeToken = placeToken;
	}

	private class MixPanelEventClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			MixpanelUtil.mixpanelEvent("Sausd_Library_Click_AboutGooru");
		}
	}
	
	public abstract void clickOnCourse(ArrayList<ProfileLibraryDo> unitList, String courseId, ProfileLibraryDo profileLibraryDo);
}