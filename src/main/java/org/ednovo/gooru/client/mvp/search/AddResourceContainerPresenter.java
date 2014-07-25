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
package org.ednovo.gooru.client.mvp.search;



import java.util.HashMap;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.folders.event.RefreshFolderType;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.RefreshFolderItemEvent;

import org.ednovo.gooru.client.mvp.shelf.event.CopyDraggedCollectionEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CreateCollectionItemEvent;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.folder.FolderDo;
import org.ednovo.gooru.shared.model.folder.FolderListDo;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;

/**
 * 
 * @fileName : AddAssignmentContainerPresenter.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 27-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class AddResourceContainerPresenter extends PresenterWidget<IsAddResourceContainerView> implements AddResourceContainerUiHandlers{
	
	ResourceSearchResultDo searchResultDo =null;
	CollectionItemDo collectionItemDo;
	boolean isPlayer=false;
	@Inject
	public AddResourceContainerPresenter(EventBus eventBus, IsAddResourceContainerView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}
	
	@Override
	public void getWorkspaceData(int offset,int limit, final boolean clearShelfPanel,final String searchType){
		AppClientFactory.getInjector().getResourceService().getFolderWorkspace(offset, limit,"public,anyonewithlink", null, new SimpleAsyncCallback<FolderListDo>() {
			@Override
			public void onSuccess(FolderListDo folderListDo) {
				if(folderListDo!=null && folderListDo.getCount()!=null){
				if(folderListDo.getCount()==0){
					getView().displayNoCollectionsMsg();
				}else{
					getView().displayWorkspaceData(folderListDo,clearShelfPanel,searchType);
				}
			}else{
				getView().displayNoCollectionsMsg();
			}
			}
		});
	}

	@Override
	public void getFolderItems(final TreeItem item,String parentId) {
		AppClientFactory.getInjector().getfolderService().getChildFolders(0, 20, parentId,"public,anyonewithlink", null, new SimpleAsyncCallback<FolderListDo>() {
			@Override
			public void onSuccess(FolderListDo folderListDo) {
				getView().setFolderItems(item,folderListDo);
			}
		});
	}
	
	@Override
	public void getUserShelfData(ResourceSearchResultDo searchResultDo,String searchType) {
		// TODO Auto-generated method stub
		this.searchResultDo =searchResultDo;
		getView().clearShelfData();
		getWorkspaceData(0,20,true,searchType);
		getView().setSearchResultDo(this.searchResultDo);
	}
	@Override
	public void getUserShelfCollectionsData(CollectionSearchResultDo searchResultDo,String searchType) {
		// TODO Auto-generated method stub
		this.searchResultDo =searchResultDo;
		getView().clearShelfData();
		getWorkspaceData(0,20,true,searchType);
	}
	
	@Override
	public void addResourceToCollection(final String selectedFolderOrCollectionid,String searchType) {
			final CollectionDo collection = new CollectionDo();
			if(searchType.equalsIgnoreCase("collection")){
			collection.setGooruOid(searchResultDo.getGooruOid());
			AppClientFactory.fireEvent(new CopyDraggedCollectionEvent(collection,searchResultDo.getGooruOid(),selectedFolderOrCollectionid));
		}else if(searchType.equalsIgnoreCase("resource")){
			AppClientFactory.getInjector().getfolderService().getCollectionResources(selectedFolderOrCollectionid,null, null, new SimpleAsyncCallback<FolderListDo>(){
				@Override
				public void onSuccess(FolderListDo result) {
					getView().getButtonVisiblity();
					if (result.getCount()<25){
					
						
						if(isPlayer){
							AppClientFactory.getInjector().getResourceService().createCollectionItem(selectedFolderOrCollectionid, collectionItemDo.getResource().getGooruOid(), new AsyncCallback<CollectionItemDo>() {
								
								@Override
								public void onSuccess(CollectionItemDo result) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									
								}
							});
							//	AppClientFactory.fireEvent(new CreateCollectionItemEvent(selectedFolderOrCollectionid,collectionItemDo.getResource().getGooruOid()));	
						}
						else{
							AppClientFactory.fireEvent(new CreateCollectionItemEvent(selectedFolderOrCollectionid,searchResultDo.getGooruOid()));
						}
						}else{
						getView().restrictionToAddResourcesData();
					}
					}
    		});
		}
	}

	@Override
	public void createFolderInParent(String folderName, final String parentId,final HashMap<String, String> params) {
		boolean addToShelf = false;
		if(parentId.isEmpty()) {
			addToShelf = true;
		}
		AppClientFactory.getInjector().getfolderService().createFolder(folderName, parentId, addToShelf, new SimpleAsyncCallback<FolderDo>() {
			@Override
			public void onSuccess(FolderDo result) {
				result.setType("folder");
				params.put("from", "AddResourcePresenter");
				AppClientFactory.fireEvent(new RefreshFolderItemEvent(result, RefreshFolderType.INSERT, params));
				final CollectionDo collection = new CollectionDo();
				collection.setGooruOid(searchResultDo.getGooruOid());
				AppClientFactory.fireEvent(new CopyDraggedCollectionEvent(collection,searchResultDo.getGooruOid(),result.getGooruOid())); 
				
			}
		});
		
	}

	@Override
	public void setCollectionItemData(String collectionId,
			CollectionItemDo collectionItemDo) {
		this.collectionItemDo = collectionItemDo;
		getView().clearShelfData();
		getWorkspaceData(0,20,true,"resource");
		
	}

	@Override
	public void setplayerStyle() {
		isPlayer=true;
		getView().setPlayerStyle(isPlayer);
		
	}

	@Override
	public void removePlayerStyle() {
		isPlayer=false;
		getView().removePlayerStyle(isPlayer);
		
	}

	@Override
	public Anchor getAddButton() {
		return getView().getAddButton();
	}
	
}