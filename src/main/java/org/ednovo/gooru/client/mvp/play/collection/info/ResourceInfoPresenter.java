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
package org.ednovo.gooru.client.mvp.play.collection.info;


import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.service.PlayerAppServiceAsync;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.ResoruceCollectionDo;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;

public class ResourceInfoPresenter extends PresenterWidget<IsResourceInfoView> implements ResourceInfoUiHandlers{

	private CollectionItemDo collectionItemDo=null;
	
	public String mycollectionTitle;
	
	
	@Inject
	private PlayerAppServiceAsync playerAppService;
	
	@Inject
	public ResourceInfoPresenter(EventBus eventBus, IsResourceInfoView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
	}
	
	public void setResoruceDetails(CollectionItemDo collectionItemDo){
		if(this.collectionItemDo!=null){
			if(this.collectionItemDo.getResource().getGooruOid().equals(collectionItemDo.getResource().getGooruOid())){
				return;
			}else{
				this.collectionItemDo=collectionItemDo;
				getView().setCollectionTitle(mycollectionTitle);
				getView().setResourceMedaDataInfo(collectionItemDo);
			}		
		}
		else{
			this.collectionItemDo=collectionItemDo;
			getView().setCollectionTitle(mycollectionTitle);
			getView().setResourceMedaDataInfo(collectionItemDo);
		}
	}
	
	public void updateViewsCount(String viewCount){
		getView().setResourceViewsCount(viewCount);
	}
	
	public void updateLikesCount(int likesCount){
		//getView().setResourceLikesCount(likesCount);
	}

	@Override
	public void getCollectionList(String resourceGooruOid,String pageNum,String pageSize) {
		this.playerAppService.getResourceCollectionsList(resourceGooruOid, pageNum, pageSize, new SimpleAsyncCallback<ResoruceCollectionDo>() {
			@Override
			public void onSuccess(ResoruceCollectionDo resoruceCollectionDo) {
				getView().loadResourceCollection(resoruceCollectionDo);
			}
		});
	}
	
	public void resetResourceInfo(){
		collectionItemDo=null;
	}

	public void setMycollectionTitle(String mycollectionTitle) {
		this.mycollectionTitle = mycollectionTitle;
	}
	
	public String getMycollectionTitle() {
		return mycollectionTitle;
	}

}
