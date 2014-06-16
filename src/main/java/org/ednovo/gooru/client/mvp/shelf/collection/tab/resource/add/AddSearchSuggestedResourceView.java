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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.rating.RatingWidgetView;
import org.ednovo.gooru.client.mvp.rating.events.UpdateRatingsInSearchEvent;
import org.ednovo.gooru.client.mvp.rating.events.UpdateResourceRatingCountEvent;
import org.ednovo.gooru.client.mvp.rating.events.UpdateResourceRatingCountEventHandler;
import org.ednovo.gooru.client.mvp.search.SearchUiUtil;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.search.event.UpdateSearchResultMetaDataEvent;
import org.ednovo.gooru.client.mvp.search.event.UpdateSearchResultMetaDataHandler;
import org.ednovo.gooru.client.mvp.shelf.event.InsertCollectionItemInAddResourceEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionItemInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.uc.ResourceImageUc;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.gargoylesoftware.htmlunit.javascript.host.MouseEvent;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public abstract  class AddSearchSuggestedResourceView extends Composite implements MessageProperties{
	

	public interface AddSearchSuggestedResourceViewUiBinder extends UiBinder<Widget, AddSearchSuggestedResourceView> {
		
	}
	
	public  AddSearchSuggestedResourceViewUiBinder uiBinder=GWT.create(AddSearchSuggestedResourceViewUiBinder.class);
	
	@UiField SearchSuggestedResultWrapperCBundle res;
	

	@UiField HTML lblResourceTitle;
	
	@UiField Image imgNotFriendly;
	
	@UiField
	HTMLEventPanel resourceTitleContainer;

	@UiField
	FlowPanel metaDataFloPanel;

	@UiField
	FlowPanel ratingWidgetPanel,resourceHeaderPanel;
	
	@UiField
	HTML resourceDescriptionHtml;

	@UiField
	ResourceImageUc resourceImageUc;

	@UiField
	FlowPanel standardsFloPanel;
	
	@UiField HTMLPanel suggestedWrapperPanel,addResourceBtnPanel,buttonsPanel;
	
	@UiField
	public BlueButtonUc addResourceBtnLbl;

	ToolTip toolTip = null;

	private ResourceSearchResultDo resourceSearchResultDo;
	
	private RatingWidgetView ratingWidgetView=null;
	
	
	private static final String PLAYER_NAME = "resource";
	
	private static final String VIDEO = "Video";
	
	private static final String QUESTION = "Question";
	
	private static final String PAGES = " "+GL1471;
	
	private static final String VIEW = " "+GL1428;
	
	private static final String VIEWS = " "+GL0934;
	
	private static final String NULL = "null";
	private static String publisherData = "";
	private static String aggregatorData = "";
	private boolean isRatingUpdated=true;
	
	String collectionId = "";
	private AddResourceView addresourceview;
	
	AddSearchSuggestedResourceView() {
		initWidget(uiBinder.createAndBindUi(this));
		res.css().ensureInjected();
	}

	public AddSearchSuggestedResourceView(
			ResourceSearchResultDo resourceSearchResultDo,String collectionid) {
		initWidget(uiBinder.createAndBindUi(this));
		res.css().ensureInjected();
		buttonsPanel.setVisible(false);
		this.collectionId = collectionid;
		addResourceBtnLbl.setText(GL0590);
		addResourceBtnLbl.addClickHandler(new AddClickHandler());
		imgNotFriendly.setTitle(GL0737);
		imgNotFriendly.setAltText(GL0737);
		imgNotFriendly.setUrl("images/mos/ipadFriendly.png");
		AppClientFactory.getEventBus().addHandler(UpdateSearchResultMetaDataEvent.TYPE,setUpdateMetaData);
		AppClientFactory.getEventBus().addHandler(UpdateResourceRatingCountEvent.TYPE,setRatingCount);
		ratingWidgetView=new RatingWidgetView();
		ratingWidgetPanel.add(ratingWidgetView);
		setData(resourceSearchResultDo);
		MouseOutHandler mouseouthandler = new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				// TODO Auto-generated method stub
				buttonsPanel.setVisible(false);
			}
		};
		MouseOverHandler mouseoverhandler = new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				// TODO Auto-generated method stub
				buttonsPanel.setVisible(true);
			}
		};
		suggestedWrapperPanel.addDomHandler(mouseoverhandler, MouseOverEvent.getType());
		suggestedWrapperPanel.addDomHandler(mouseouthandler, MouseOutEvent.getType());
	}
	
	public RatingWidgetView getRatingWidgetView(){
		return ratingWidgetView;
	}
	
	public void updateViews(String count, String contentId, String whatToUpdate){
		if (resourceSearchResultDo.getGooruOid().equalsIgnoreCase(contentId)){
			metaDataFloPanel.clear();
			String category = resourceSearchResultDo.getResourceFormat().getValue() != null ? resourceSearchResultDo.getResourceFormat().getValue() : "webpage";
			boolean shortenMetaLength = category.equalsIgnoreCase(VIDEO) || category.equalsIgnoreCase(QUESTION) ? true : false;
			
			//String source = resourceSearchResultDo.getResourceSource() != null ? resourceSearchResultDo.getResourceSource().getAttribution() : null;
			//SearchUiUtil.renderSourceMetadata(metaDataFloPanel, source ,null, shortenMetaLength ? 15 : 25);
			if(resourceSearchResultDo.getAggregator()!=null){
				 String aggregatorData = "";
				for (String aggregator: resourceSearchResultDo.getAggregator()) {
					if(resourceSearchResultDo.getAggregator().size()>1){
						aggregatorData = aggregatorData+aggregator+",";
					}
					else
					{
						aggregatorData = aggregator;
					}
				}
				if(aggregatorData.endsWith(",")){
					aggregatorData=aggregatorData.substring(0, aggregatorData.length()-1);
				}
				SearchUiUtil.renderSourceMetadata(metaDataFloPanel, aggregatorData ,null, shortenMetaLength ? 15 : 25);
			}
			
			if(resourceSearchResultDo.getPublisher()!=null){
				String publisherData = "";
				for (String publisher: resourceSearchResultDo.getPublisher()) {
					if(resourceSearchResultDo.getPublisher().size()>1){
						publisherData = publisherData+publisher+",";
					}else
					{
						publisherData = publisher;
					}
				
				}
				if(publisherData.endsWith(",")){
					publisherData=publisherData.substring(0, publisherData.length()-1);
				}
				SearchUiUtil.renderSourceMetadata(metaDataFloPanel, publisherData ,null, shortenMetaLength ? 15 : 25);
			}
			SearchUiUtil.renderMetaData(metaDataFloPanel, resourceSearchResultDo.getCourseNames(), shortenMetaLength ? 15 : 18);
			
	        SearchUiUtil.renderMetaData(metaDataFloPanel, count + (Integer.parseInt(count) == 1 ? VIEW : VIEWS));
			if (category.equalsIgnoreCase(VIDEO)) {
				SearchUiUtil.renderMetaData(metaDataFloPanel, StringUtil.stringToTime(resourceSearchResultDo.getDurationInSec()));
			} else if (category.equalsIgnoreCase(QUESTION)) {
				SearchUiUtil.renderMetaData(metaDataFloPanel, StringUtil.getQuestionType(resourceSearchResultDo.getQuestionType() !=null ? resourceSearchResultDo.getQuestionType() : ""));
			}
			if (resourceSearchResultDo.getNumOfPages() != null && !resourceSearchResultDo.getNumOfPages().equals("0") && !resourceSearchResultDo.getNumOfPages().equalsIgnoreCase(NULL) && resourceSearchResultDo.getNumOfPages().length() > 0) {
				SearchUiUtil.renderMetaData(metaDataFloPanel, resourceSearchResultDo.getNumOfPages() + PAGES);
			}
		}
	}
	
	public void setData(ResourceSearchResultDo resourceSearchResultDo) {
		this.resourceSearchResultDo = resourceSearchResultDo;
		ratingWidgetView.getRatingCountLabel().setText(resourceSearchResultDo.getRatings().getCount().toString()); 
		ratingWidgetView.setAvgStarRating(resourceSearchResultDo.getRatings().getAverage()); 
//		ratingWidgetView.setAvgStarRating(2); 
		String category = resourceSearchResultDo.getResourceFormat().getValue() != null ? resourceSearchResultDo.getResourceFormat().getValue() : "webpage";
        String description = resourceSearchResultDo.getDescription();
        String title = "";
        String resourceTitle;
        if (resourceSearchResultDo.getResourceTitle().contains("class")){
        	title = resourceSearchResultDo.getResourceTitle();
        }else{
        	title = StringUtil.truncateText(resourceSearchResultDo.getResourceTitle(), 38);
        }
		boolean shortenMetaLength = category.equalsIgnoreCase(VIDEO) || category.equalsIgnoreCase(QUESTION) ? true : false;
		
		
		//String source = resourceSearchResultDo.getResourceSource() != null ? resourceSearchResultDo.getResourceSource().getAttribution() : null;
		if(resourceSearchResultDo.getAggregator()!=null){
			 String aggregatorData = "";
			for (String aggregator: resourceSearchResultDo.getAggregator()) {
				if(resourceSearchResultDo.getAggregator().size()>1){
					aggregatorData = aggregatorData+aggregator+",";
				}
				else
				{
					aggregatorData = aggregator;
				}
			}
			if(aggregatorData.endsWith(",")){
				aggregatorData=aggregatorData.substring(0, aggregatorData.length()-1);
			}
			SearchUiUtil.renderSourceMetadata(metaDataFloPanel, aggregatorData ,null, shortenMetaLength ? 15 : 25);
		}
		
		if(resourceSearchResultDo.getPublisher()!=null){
			String publisherData = "";
			for (String publisher: resourceSearchResultDo.getPublisher()) {
				if(resourceSearchResultDo.getPublisher().size()>1){
					publisherData = publisherData+publisher+",";
				}else
				{
					publisherData = publisher;
				}
			
			}
			if(publisherData.endsWith(",")){
				publisherData=publisherData.substring(0, publisherData.length()-1);
			}
			SearchUiUtil.renderSourceMetadata(metaDataFloPanel, publisherData ,null, shortenMetaLength ? 15 : 25);
		}
		
		SearchUiUtil.renderMetaData(metaDataFloPanel, resourceSearchResultDo.getCourseNames(), shortenMetaLength ? 15 : 18);
        SearchUiUtil.renderMetaData(metaDataFloPanel, resourceSearchResultDo.getTotalViews() + (resourceSearchResultDo.getTotalViews() == 1 ? VIEW : VIEWS));
		if (category.equalsIgnoreCase(VIDEO)) {
			SearchUiUtil.renderMetaData(metaDataFloPanel, StringUtil.stringToTime(resourceSearchResultDo.getDurationInSec()));
		} else if (category.equalsIgnoreCase(QUESTION)) {
			SearchUiUtil.renderMetaData(metaDataFloPanel, StringUtil.getQuestionType(resourceSearchResultDo.getQuestionType() !=null ? resourceSearchResultDo.getQuestionType() : ""));
		}
		if (resourceSearchResultDo.getNumOfPages() != null && !resourceSearchResultDo.getNumOfPages().equals("0") && !resourceSearchResultDo.getNumOfPages().equalsIgnoreCase(NULL) && resourceSearchResultDo.getNumOfPages().length() > 0) {
			SearchUiUtil.renderMetaData(metaDataFloPanel, resourceSearchResultDo.getNumOfPages() + PAGES);
		}
		title = title.replaceAll("<p>", "").replaceAll("</p>", "");
		lblResourceTitle.setHTML(title);
		resourceTitle=resourceSearchResultDo.getResourceTitle();
		lblResourceTitle.getElement().setId(resourceSearchResultDo.getGooruOid());
		if (lblResourceTitle.getText().length()>38){
		}
		String mediaType = resourceSearchResultDo.getMediaType();
		
		boolean setVisibility = mediaType !=null ?  mediaType.equalsIgnoreCase("not_iPad_friendly") ? true : false : false;
		
		imgNotFriendly.setVisible(setVisibility);
		
		if (imgNotFriendly.isVisible()){
			lblResourceTitle.getElement().getStyle().setFloat(Float.LEFT);
		}else{
			lblResourceTitle.getElement().getStyle().clearFloat();
		}
		
		
		imgNotFriendly.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				toolTip = new ToolTip(GL0454+""+"<img src='/images/mos/ipadFriendly.png' style='margin-top:0px;'/>"+" "+GL04431);
				toolTip.getElement().getStyle().setBackgroundColor("transparent");
				toolTip.getElement().getStyle().setZIndex(9999999);
				toolTip.getElement().getStyle().setPosition(Position.ABSOLUTE);
				toolTip.setPopupPosition(imgNotFriendly.getAbsoluteLeft()-(50+22), imgNotFriendly.getAbsoluteTop()+22);
				toolTip.show();
			}
		});
		imgNotFriendly.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				
				EventTarget target = event.getRelatedTarget();
				  if (Element.is(target)) {
					  if (!toolTip.getElement().isOrHasChild(Element.as(target))){
						  toolTip.hide();
					  }
				  }
			}
		});
		if(description!=null && description.length()>205){
			description = description.trim().substring(0, 205) +"...";	
		}
		resourceDescriptionHtml.setHTML(description);
		resourceTitleContainer.getElement().getStyle().setZIndex(99999);
		resourceImageUc.getElement().getStyle().setZIndex(99999);
		resourceImageUc.renderSearch(category, resourceSearchResultDo.getUrl(), null, resourceSearchResultDo.getGooruOid(), PLAYER_NAME, resourceTitle, false,"","");
		SearchUiUtil.renderStandards(standardsFloPanel, resourceSearchResultDo);
	}
	
	UpdateResourceRatingCountEventHandler setRatingCount =new UpdateResourceRatingCountEventHandler(){
		@Override
		public void setResourceRatingCount(String resourceId,double avg,Integer count) { 
			if(resourceSearchResultDo.getGooruOid().equals(resourceId)){
				ratingWidgetView.getRatingCountLabel().setText(Integer.toString(count)); 
				ratingWidgetView.setAvgStarRating(avg);
				if(count==1 && isRatingUpdated){
					isRatingUpdated=false;
					ratingWidgetView.getRatingCountLabel().getElement().removeAttribute("class");
					ratingWidgetView.getRatingCountLabel().getElement().setAttribute("style", "cursor: pointer;text-decoration: none !important;color: #1076bb;");
					ratingWidgetView.getRatingCountLabel().addClickHandler(new ClickHandler(){

						@Override
						public void onClick(ClickEvent event) {
							AppClientFactory.fireEvent(new UpdateRatingsInSearchEvent(resourceSearchResultDo)); 
						}
						
					});
				}
			}
		}
		
	};
	
	
	
	UpdateSearchResultMetaDataHandler setUpdateMetaData =new UpdateSearchResultMetaDataHandler(){

		@Override
		public void updateSearchResultMetaData(String count, String resourceId,
				String whatToUpdate) {
			if(count!=null){
			updateViews(count, resourceId, whatToUpdate);
			}
		}
	};
	
	@UiHandler("resourceTitleContainer")
	public void onClickResourceTitle(ClickEvent event){
		MixpanelUtil.Preview_Resource_From_Search("ResourceTitleLbl");
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", resourceSearchResultDo.getGooruOid());
		params.put("pn", "resource");
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.RESOURCE_PLAY, params);
	}
	public abstract void closePopup();
	private class AddClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
		addResourceBtnPanel.setVisible(false);
		
	//	loadingTextLbl.setVisible(true);
		AppClientFactory.getInjector().getResourceService().createCollectionItem(collectionId, resourceSearchResultDo.getGooruOid(), new SimpleAsyncCallback<CollectionItemDo>() {

			@Override
			public void onSuccess(CollectionItemDo result) {
				Window.enableScrolling(true);
				closePopup();
				//AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
				AppClientFactory.fireEvent(new RefreshCollectionItemInShelfListEvent(result, RefreshType.INSERT));
				AppClientFactory.fireEvent(new InsertCollectionItemInAddResourceEvent(result, RefreshType.INSERT));
			}
		});
		}
		
	}
}