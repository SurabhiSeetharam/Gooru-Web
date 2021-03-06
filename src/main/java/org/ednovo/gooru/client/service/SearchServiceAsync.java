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
package org.ednovo.gooru.client.service;

import java.util.Map;

import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.search.AutoSuggestKeywordSearchDo;
import org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.model.search.SearchFilterDo;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Search Team
 * 
 */
public interface SearchServiceAsync extends BaseServiceAsync {

	void getSearchFilters(String type, AsyncCallback<SearchFilterDo> callback);

	void getResourceSearchResults(SearchDo<ResourceSearchResultDo> searchInput, AsyncCallback<SearchDo<ResourceSearchResultDo>> callback);

	void getCollectionSearchResults(SearchDo<CollectionSearchResultDo> searchInput, AsyncCallback<SearchDo<CollectionSearchResultDo>> callback);

//	void getCollectionResources(SearchDo<ResourceSearchResultDo> searchDo, AsyncCallback<SearchDo<ResourceSearchResultDo>> callback);
	
	void getCollectionItems(String collectionId,AsyncCallback<SearchDo<CollectionItemSearchResultDo>> callback) throws GwtException;

	void getResourceCollections(SearchDo<CollectionSearchResultDo> searchDo, AsyncCallback<SearchDo<CollectionSearchResultDo>> callback);

//	void getSuggestSearchQuery(SearchDo<List<String>> searchDo, AsyncCallback<List<String>> callback);
	
	void getSuggestSource(SearchDo<String> searchDo, AsyncCallback<SearchDo<String>> callback);
	
	void getSuggestStandard(SearchDo<CodeDo> searchDo, AsyncCallback<SearchDo<CodeDo>> callback);
	
	void getShortenShareUrl(String contentGooruOid, Map<String, String> params,  AsyncCallback<Map<String, String>> callback);
	
	void getShortenShareUrlforAssign(String contentGooruOid, Map<String, String> params,  AsyncCallback<Map<String, String>> callback);
	
	void getGoogleSignin(String parms, AsyncCallback<String> callback);
	
	void getCollectionPlayDirectLink(String params, AsyncCallback<String> callback);
	
	void getHomeEndPointUrl(AsyncCallback<String> callback);
	
	void getSuggestSearchResultForResourceNoResult(SearchDo<ResourceSearchResultDo> searchInput,AsyncCallback<SearchDo<ResourceSearchResultDo>> callback);
	
	void getSuggestedAutokeyword(SearchDo<AutoSuggestKeywordSearchDo> searchDo, AsyncCallback<SearchDo<AutoSuggestKeywordSearchDo>> callback);
//	void getSuggestedSearchResultForCollectionNoResult(SearchDo<CollectionSearchResultDo> searchInput,AsyncCallback<SearchDo<CollectionSearchResultDo>> callback);
	
	void getGoogleSignin(String placeToken, Map<String, String> parms, AsyncCallback<String> callback);
	
	public void getSuggestStandardByFilterCourseId(SearchDo<CodeDo> searchDo,AsyncCallback<SearchDo<CodeDo>> callback);
	
	void getSuggestedAggregator(SearchDo<String> searchDo, AsyncCallback<SearchDo<String>> callback);
	
	void getCollectionSuggestedResourceSearchResults(SearchDo<ResourceSearchResultDo> searchInput,String contentGorruOid, AsyncCallback<SearchDo<ResourceSearchResultDo>> callback);
	
	void getGoogleDrive(String url, Map<String, String> parms, AsyncCallback<String> callback);
}
