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
package org.ednovo.gooru.client.uc;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author Search Team
 *
 */
public class GlassPanelWithLoadingUc extends FlowPanel {

	private VerticalPanel loadingImagePanel;

	private LoadingUc imagePanel;
	
	/**
	 * Class constructor
	 */
	public GlassPanelWithLoadingUc() {
		super();
		UcCBundle.INSTANCE.css().ensureInjected();
		loadingImagePanel = new VerticalPanel();
		imagePanel = new LoadingUc();
		loadingImagePanel.add(imagePanel);
		loadingImagePanel.setCellVerticalAlignment(imagePanel, HasVerticalAlignment.ALIGN_MIDDLE);
		this.add(loadingImagePanel);
		loadingImagePanel.setStyleName(UcCBundle.INSTANCE.css().imageLoadingPanel());
		this.addStyleName(UcCBundle.INSTANCE.css().glassPanelWithLoading());
		this.setVisible(false);
	}

}
