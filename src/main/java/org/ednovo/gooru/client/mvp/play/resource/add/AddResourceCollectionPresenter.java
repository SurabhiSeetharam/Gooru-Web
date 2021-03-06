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
package org.ednovo.gooru.client.mvp.play.resource.add;


import java.util.ArrayList;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.CollectionItemsList;
import org.ednovo.gooru.shared.model.folder.FolderListDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;

public class AddResourceCollectionPresenter extends PresenterWidget<IsAddResourceCollectionView> implements AddResourceCollectionUiHandlers{

	private int pageNum=1;
	private int pageSize=20;
	@Inject
	public AddResourceCollectionPresenter(EventBus eventBus, IsAddResourceCollectionView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
	}
	@Override
	protected void onBind() {
		super.onBind();
	}
	
	@Override
	protected void onReset() {
		super.onReset();
	}
	
	public Label getAddCollectionViewButton(){
		return getView().getAddCollectionViewButton();
	}
	
	public Label getAddNewCollectionButton(){
		return getView().getAddNewCollectionLabel();
	}
	
	public void setCollectionItemData(String collectionId,CollectionItemDo collectionItemDo){
		getView().setCollectionItemData(collectionId, collectionItemDo);
		pageNum=1;
		//getUserWorkspace(true);
		getUserShelfData();
	}
	
	@Override
	public void copyCollectionItem(String collectionItemId, final String collectionId) {
		AppClientFactory.getInjector().getPlayerAppService().copyCollectionItem(collectionItemId, collectionId, new SimpleAsyncCallback<String>() {
			@Override
			public void onSuccess(String result) {
				updateWorkSpaceLink(collectionId);
			}
		});
	}
	
	public void updateWorkSpaceLink(String collectionId){
		getView().updateWorkSpaceLink(collectionId);
		pageNum=1;
		getUserShelfData();
	}
	@Override
	public void getUserShelfCollections(int dropdownListContainertWidgetCount) {
		pageNum++;
		getUserWorkspace(false);
	}
	
	public void getUserWorkspace(final boolean isClearPanel){
		AppClientFactory.getInjector().getPlayerAppService().getWorkspaceCollections("", pageNum+"", pageSize+"", new SimpleAsyncCallback<ArrayList<CollectionItemsList>>() {
			@Override
			public void onSuccess(ArrayList<CollectionItemsList> userCollectionsList) {
				getView().addCollectionItems(userCollectionsList, isClearPanel);
			}
		});
	}		
	
	public void getUserShelfData(){
		getView().resetSelectionData();
		getWorkspaceData(0,20,true);
	}
	
	public void getWorkspaceData(int offset,int limit,final boolean clearShelfPanel){
		AppClientFactory.getInjector().getResourceService().getFolderWorkspace(offset, limit,null, null, new SimpleAsyncCallback<FolderListDo>() {
			@Override
			public void onSuccess(FolderListDo folderListDo) {
				getView().displayWorkspaceData(folderListDo,clearShelfPanel);
			}
		});
	}

	@Override
	public void getFolderItems(final TreeItem item,String parentId) {
		AppClientFactory.getInjector().getfolderService().getChildFolders(0, 20, parentId,null, null, new SimpleAsyncCallback<FolderListDo>() {
			@Override
			public void onSuccess(FolderListDo folderListDo) {
				getView().setFolderItems(item,folderListDo);
			}
		});
	}

}
