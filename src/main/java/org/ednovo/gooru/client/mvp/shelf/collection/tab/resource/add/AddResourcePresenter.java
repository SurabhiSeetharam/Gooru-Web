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
/**
* @fileName : AddResourcePresenter.java 
*
* @description :This file is a UiBinder for AddResourcePresenter.
*
* @version :5.1
*
* @date: Apr 6 2013
   	
* @Author  Gooru Team
* 
* @Reviewer 
*
*/


import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.IsCollectionResourceTabView;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.drive.DrivePresenter;
import org.ednovo.gooru.client.mvp.shelf.event.AddResouceImageEvent;
import org.ednovo.gooru.client.service.ResourceServiceAsync;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo;
import org.ednovo.gooru.shared.model.content.ExistsResourceDo;
import org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo;
import org.ednovo.gooru.shared.model.content.ResourceTagsDo;
import org.ednovo.gooru.shared.model.drive.GoogleDriveItemDo;
import org.ednovo.gooru.shared.model.user.MediaUploadDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;

public class AddResourcePresenter extends PresenterWidget<IsAddResourceView> implements AddResourceUiHandlers{
	
	private ImageUploadPresenter imageUploadPresenter;
	
//	private ExistsResourcePresenter alreadyExistsResourcePresenter;
	
	private SimpleAsyncCallback<CollectionDo> collectionAsyncCallback;
	
	private SimpleAsyncCallback<CollectionItemDo> collectionItemAsyncCallback;
	
	private AsyncCallback<CollectionItemDo> userResourceCollectionItemAsyncCallback;
	
	private SimpleAsyncCallback<ResourceMetaInfoDo> resoureMetaInfoAsyncCallback;
	
	private SimpleAsyncCallback<ExistsResourceDo> resoureCheckAsyncCallback;
	
	private SimpleAsyncCallback<CollectionItemDo> addQuestionResourceAsyncCallback;
	
	private SimpleAsyncCallback<CollectionItemDo> updateQuestionResourceAsyncCallback;
	
	private SimpleAsyncCallback<Void> removeQuestionImageAsyncCallback; 
	
	private static final String KEY_OER = "resourceLicense";
	private static final String VAL_OER = "OER";
	
	public SimpleAsyncCallback<CollectionItemDo> getAddQuestionResourceAsyncCallback() {
		return addQuestionResourceAsyncCallback;
	}

	public void setAddQuestionResourceAsyncCallback(
			SimpleAsyncCallback<CollectionItemDo> addQuestionResourceAsyncCallback) {
		this.addQuestionResourceAsyncCallback = addQuestionResourceAsyncCallback;
	}

	IsCollectionResourceTabView isCollResourceTabView=null;
	
	private DrivePresenter drivePresenter=null;
	
	public DrivePresenter getDrivePresenter() {
		return drivePresenter;
	}

	public void setDrivePresenter(DrivePresenter drivePresenter) {
		this.drivePresenter = drivePresenter;
	}


	@Inject
	private ResourceServiceAsync resourceService;
	
	CollectionDo collectionDo;
	
	String clickType;
	
	@Inject
	public AddResourcePresenter(IsCollectionResourceTabView isCollResourceTabView, EventBus eventBus, IsAddResourceView view,ImageUploadPresenter imageUploadPresenter,DrivePresenter drivePresenter) {
		super(eventBus, view);
		this.setImageUploadPresenter(imageUploadPresenter);
		getView().setUiHandlers(this);
		addRegisteredHandler(AddResouceImageEvent.TYPE, this);
		
		this.isCollResourceTabView = isCollResourceTabView;
		this.drivePresenter=drivePresenter;

//		,ExistsResourcePresenter alreadyExistsResourcePresenter
//		this.alreadyExistsResourcePresenter = alreadyExistsResourcePresenter;

	}

	@Override
	public void resourceImageUpload() {
		addToPopupSlot(imageUploadPresenter);
		imageUploadPresenter.setCollectionImage(false);
		imageUploadPresenter.setQuestionImage(false);
		imageUploadPresenter.setEditResourceImage(false);
		imageUploadPresenter.setUserOwnResourceImage(false);
		imageUploadPresenter.setEditUserOwnResourceImage(false);
		imageUploadPresenter.getView().isFromEditQuestion(true);
		
	}
	
	@Override
	public void userOwnResourceImageUpload() {
		addToPopupSlot(imageUploadPresenter);
		imageUploadPresenter.setCollectionImage(false);
		imageUploadPresenter.setQuestionImage(false);
		imageUploadPresenter.setEditResourceImage(false);
		imageUploadPresenter.setEditUserOwnResourceImage(false);
		imageUploadPresenter.setUserOwnResourceImage(true);
		imageUploadPresenter.getView().isFromEditQuestion(true);
	}
	@Override
	public void questionImageUpload() {
		addToPopupSlot(imageUploadPresenter);
		imageUploadPresenter.setCollectionImage(false);
		imageUploadPresenter.setQuestionImage(true);
		imageUploadPresenter.setEditResourceImage(false);
		imageUploadPresenter.setUserOwnResourceImage(false);
		imageUploadPresenter.setEditUserOwnResourceImage(false);
		imageUploadPresenter.getView().isFromEditQuestion(true);
	}
	
	@Override
	public void questionImageUpload(String collectionItemId) {
		addToPopupSlot(imageUploadPresenter);
		imageUploadPresenter.setCollectionImage(false);
		imageUploadPresenter.setUpdateQuestionImage(true);
		imageUploadPresenter.setCollectionItemId(collectionItemId);
		imageUploadPresenter.setEditResourceImage(false);
        imageUploadPresenter.setQuestionImage(false);
        imageUploadPresenter.setUserOwnResourceImage(false);
        imageUploadPresenter.setEditUserOwnResourceImage(false);
        imageUploadPresenter.getView().isFromEditQuestion(true);
	}

	public ImageUploadPresenter getImageUploadPresenter() {
		return imageUploadPresenter;
	}

	public void setImageUploadPresenter(ImageUploadPresenter imageUploadPresenter) {
		this.imageUploadPresenter = imageUploadPresenter;
	}
	
//	public void setImageUrl(String fileName,boolean isQuestionImage){
//		getView().setImageUrl(fileName,isQuestionImage);
//	}

	@Override
	public void setResourceImageUrl(String fileName,String fileNameWithoutRepository,boolean isQuestionImage,boolean isUserOwnResourceImage) {
	    getView().setImageUrl(fileName,fileNameWithoutRepository,isQuestionImage,isUserOwnResourceImage);	
	}

	@Override
	protected void onBind() {
		super.onBind();
		
		setUserResourceCollectionItemAsyncCallback(new SimpleAsyncCallback<CollectionItemDo>() {

			@Override
			public void onSuccess(CollectionItemDo result) {
				getView().hide();
				tagResourceAsOER(result); 
//				isCollResourceTabView.insertData(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				super.onFailure(caught);
				Window.enableScrolling(true);
			}
		});
		
		setCollectionItemAsyncCallback(new SimpleAsyncCallback<CollectionItemDo>() {

			@Override
			public void onSuccess(CollectionItemDo result) {
				
				getView().hide();
//				isCollResourceTabView.insertData(result);
				/**
				 * enabled for 6.5 release
				 */
				tagResourceAsOER(result);
				MixpanelUtil.AddResourceByUrl();
				
//				updateShare("private");
				
			}
		});
		setResoureMetaInfoAsyncCallback(new SimpleAsyncCallback<ResourceMetaInfoDo>() {

			@Override
			public void onSuccess(ResourceMetaInfoDo result) {
				getView().setNewResourcePopupData(result);

			}
		});
		
		setResoureCheckAsyncCallback(new SimpleAsyncCallback<ExistsResourceDo>() {
			@Override
			public void onSuccess(ExistsResourceDo result) {
				
				if (result.getNativeurl()!=null)
					getView().setExistingResourceData(result, getCollectionDo());
			}
		});
		setAddQuestionResourceAsyncCallback(new SimpleAsyncCallback<CollectionItemDo>() {
            @Override
            public void onSuccess(CollectionItemDo result) {
            		getView().hide();
            		/**
    				 * Tagging Quest resource for 6.5 release
    				 */
            		tagResourceAsOER(result); 
//                    isCollResourceTabView.insertData(result);
                    MixpanelUtil.AddQuestion();
            }
		});
		setRemoveQuestionImageAsyncCallback(new SimpleAsyncCallback<Void>(){
			@Override
			public void onSuccess(Void result) {
				getView().removeQuestionEditImage();
			}	
		});
		setUpdateQuestionResourceAsyncCallback(new SimpleAsyncCallback<CollectionItemDo>() {
            @Override
            public void onSuccess(CollectionItemDo result) {
            		getView().hide();
            		redirect(Window.Location.getHref());
                  //  isCollResourceTabView.updateCollectionItem(result);
                    //MixpanelUtil.AddQuestion();
            }
		});
		
	}
	protected void tagResourceAsOER(final CollectionItemDo collectionItemDo) {
		List<String> tagList = new ArrayList<String>();
		tagList.add("\"" +KEY_OER+"  :"+VAL_OER+"\"");
		AppClientFactory.getInjector().getResourceService().addTagsToResource(collectionItemDo.getGooruOid(), tagList.toString(), new SimpleAsyncCallback<List<ResourceTagsDo>>() {

			@Override
			public void onSuccess(List<ResourceTagsDo> result) {
				isCollResourceTabView.insertData(collectionItemDo); 
			}
			
		});
	}

	native void redirect(String url)
    /*-{
            $wnd.location.reload();
    }-*/;
	@Override
	public void addResource(String idStr, String urlStr,String titleStr, String descriptionStr, String categoryStr, String thumbnailImgSrcStr, Integer endTime,String edcuationalUse,String momentsOfLearning,List<CodeDo> standards) {
		getResourceService().addNewResource("", collectionDo.getGooruOid(), urlStr, titleStr, descriptionStr, categoryStr, thumbnailImgSrcStr, endTime,edcuationalUse,momentsOfLearning,standards, getCollectionItemAsyncCallback());
	}
	
	@Override
	public void getResourceMetaInfo(String url){
		getResourceService().getResourceMetaInfo(url, resoureMetaInfoAsyncCallback);
	}
	
	@Override
	public void getResourceExists(String url){
		getResourceService().checkResourceExists(url, resoureCheckAsyncCallback);
	}
	
	public SimpleAsyncCallback<ResourceMetaInfoDo> getResoureMetaInfoAsyncCallback() {
		return resoureMetaInfoAsyncCallback;
	}
	
	public void setResoureMetaInfoAsyncCallback(
			SimpleAsyncCallback<ResourceMetaInfoDo> resoureMetaInfoAsyncCallback) {
		this.resoureMetaInfoAsyncCallback = resoureMetaInfoAsyncCallback;
	}

	public SimpleAsyncCallback<CollectionDo> getCollectionAsyncCallback() {
		return collectionAsyncCallback;
	}

	public void setCollectionAsyncCallback(SimpleAsyncCallback<CollectionDo> collectionAsyncCallback) {
		this.collectionAsyncCallback = collectionAsyncCallback;
	}
	
	public ResourceServiceAsync getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceServiceAsync resourceService) {
		this.resourceService = resourceService;
	}

	/*@Override
	public void updateShare(String shareType) {
		AppClientFactory.getInjector().getResourceService().updateCollectionMetadata(collectionDo.getGooruOid(), null, null, null, shareType, null, null, null, null, new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
				collectionDo = result;
				getView().hide();
			}
		});
	}*/
	public CollectionDo getCollectionDo() {
		return collectionDo;
	}
	public void setCollectionDo(CollectionDo collectionDo) {
		
		this.collectionDo = collectionDo;
	}
	public void setCollectionItemDo(CollectionItemDo collectionItemDo){
		getView().setCollectionItemDo(collectionItemDo);
	}
	
	public SimpleAsyncCallback<CollectionItemDo> getCollectionItemAsyncCallback() {
		return collectionItemAsyncCallback;
	}

	public void setCollectionItemAsyncCallback(SimpleAsyncCallback<CollectionItemDo> collectionItemAsyncCallback) {
		this.collectionItemAsyncCallback = collectionItemAsyncCallback;
	}
	
	public SimpleAsyncCallback<ExistsResourceDo> getResoureCheckAsyncCallback() {
		return resoureCheckAsyncCallback;
	}

	public void setResoureCheckAsyncCallback(SimpleAsyncCallback<ExistsResourceDo> resoureCheckAsyncCallback) {
		this.resoureCheckAsyncCallback = resoureCheckAsyncCallback;
	}

	@Override
	public void addQeustionResource(String mediaFileName, CollectionQuestionItemDo collectionQuestionItemDo) {
		getResourceService().addQuestionResource(collectionDo.getGooruOid(), mediaFileName, collectionQuestionItemDo, getAddQuestionResourceAsyncCallback());
		
	}
	@Override
	public void updateQuestionResource(CollectionItemDo collectionItemDo,CollectionQuestionItemDo collectionQuestionItemDo,String thumbnailUrl) {
		getResourceService().updateQuestionResource(collectionItemDo, collectionQuestionItemDo,thumbnailUrl, getUpdateQuestionResourceAsyncCallback());
	}

	@Override
	public CollectionDo getParentCollectionDetails() {
		return this.collectionDo;
	}

	public void setCollectionDoAndType(CollectionDo collectionDo, String clickType) {
		this.collectionDo = collectionDo;
		this.clickType=clickType;
		getView().setPopup(clickType);
	}

	@Override
	public void isShortenUrl(final String userUrlStr) {
		AppClientFactory.getInjector().getResourceService().checkShortenUrl(userUrlStr.trim(),new SimpleAsyncCallback<String>(){
			@Override
			public void onSuccess(String result) {
				if(result.equalsIgnoreCase("True")){
					getView().setShortenUrlAlertMsg();
				}else{
					getView().getResourceMetaInfo(userUrlStr);
				}
				
			}
			
		});
	}
	@Override
	public void onHide(){
		super.onHide();
		getView().closePopUp();
	}

	@Override
	public void userOwnResourceUpload() {
		addToPopupSlot(imageUploadPresenter);
		
	}

	@Override
	public void addUserOwnResource(String jsonString) {
		MixpanelUtil.Add_Resource_Computer_Success();
		getResourceService().addNewUserResource(jsonString, collectionDo.getGooruOid(), getUserResourceCollectionItemAsyncCallback());
	}

	public AsyncCallback<CollectionItemDo> getUserResourceCollectionItemAsyncCallback() {
		return userResourceCollectionItemAsyncCallback;
	}

	public void setUserResourceCollectionItemAsyncCallback(AsyncCallback<CollectionItemDo> asyncCallback) {
		this.userResourceCollectionItemAsyncCallback = asyncCallback;
	}

	@Override
	public void saveUserResource(String filePath) {
		AppClientFactory.getInjector().getResourceService().saveUserOwnResource(filePath,new SimpleAsyncCallback<MediaUploadDo>() {

			@Override
			public void onSuccess(MediaUploadDo result) {
				getView().uploadResource(result);
			}
		});
	}
	

	@Override
	public void removeQuestionImage(String collectionItemId) {
		getResourceService().removeQuestionImage(collectionItemId, getRemoveQuestionImageAsyncCallback());
	}

	public SimpleAsyncCallback<Void> getRemoveQuestionImageAsyncCallback() {
		return removeQuestionImageAsyncCallback;
	}

	public void setRemoveQuestionImageAsyncCallback(
			SimpleAsyncCallback<Void> removeQuestionImageAsyncCallback) {
		this.removeQuestionImageAsyncCallback = removeQuestionImageAsyncCallback;
	}

	public SimpleAsyncCallback<CollectionItemDo> getUpdateQuestionResourceAsyncCallback() {
		return updateQuestionResourceAsyncCallback;
	}

	public void setUpdateQuestionResourceAsyncCallback(
			SimpleAsyncCallback<CollectionItemDo> updateQuestionResourceAsyncCallback) {
		this.updateQuestionResourceAsyncCallback = updateQuestionResourceAsyncCallback;
	}

	@Override
	public void showDriveResoureView(HTMLPanel tabContainer) {
		//if(AppClientFactory.getLoggedInUser().getAccessToken()!=null){
			drivePresenter.setAddResourcePresenter(this);
			drivePresenter.getGoogleDriveFiles(null, null, true);
			drivePresenter.setBreadCrumbLabel(null,null);
		//}else{
			//drivePresenter.showDriveNotConnectedErrorMessage();
		//}
		tabContainer.add(drivePresenter.getWidget());
		tabContainer.getElement().setId("pnlTabViewContainer");
	}
	
	public void showAddWebResourceWidget(boolean isGoogleDriveFile,FlowPanel googleDriveContainer,GoogleDriveItemDo googleDriveItemDo){
		googleDriveContainer.clear();
		getView().showAddWebResourceWidget(isGoogleDriveFile,googleDriveContainer,googleDriveItemDo);
	}
	

}

