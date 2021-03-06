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
package org.ednovo.gooru.client.mvp.play.collection.preview.home;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ResourceCurosal {
	
	private int widgetsCount=0;
	private Label nextButton;
	private Label previousButton;
	private FlowPanel widgetsPanel=null;
	private boolean isNextButtonActive=false;
	private boolean isPreviousButtonActive=false;
	private static int WIDGET_WIDTH=90;
	private static final int ANIMATION_DURATION=300;
	private double currentMarginLeft=0.0;
	
	public ResourceCurosal(Label nextButton,Label previousButton,FlowPanel widgetsPanel,int widgetsCount, int widgetWidth){
		WIDGET_WIDTH = widgetWidth;
		this.nextButton=nextButton;
		this.previousButton=previousButton;
		this.widgetsPanel=widgetsPanel;
		this.widgetsCount=widgetsCount;
		setTotalWidth();
		nextButton.addClickHandler(new ShowNextWidgetEvent());
		previousButton.addClickHandler(new ShowPreviousWidgetEvent());
		nextButton.addMouseOverHandler(new ButtonMouseOverEvent(true));
		nextButton.addMouseOutHandler(new ButtonMouseOutEvent(true));
		previousButton.addMouseOverHandler(new ButtonMouseOverEvent(false));
		previousButton.addMouseOutHandler(new ButtonMouseOutEvent(false));
		activateNextButton(true);
		activatePreviousButton(false);
	}
	public void setTotalWidth(){
		widgetsPanel.setWidth((widgetsCount*WIDGET_WIDTH)+"px");
		widgetsPanel.getElement().getStyle().setPosition(Position.STATIC);
	}
	public void activateNextButton(boolean isNextButtonActive){
		this.isNextButtonActive=isNextButtonActive;
	}
	public void activatePreviousButton(boolean isPreviousButtonActive){
		this.isPreviousButtonActive=isPreviousButtonActive;
	}
	public class ShowNextWidgetEvent implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			if(isNextButtonActive){
				if((currentMarginLeft+WIDGET_WIDTH)==((widgetsCount-4)*WIDGET_WIDTH)){
					activateNextButton(false);
				}
				new WidgetSlideAnimation(widgetsPanel, "forward").run(ANIMATION_DURATION);
				activatePreviousButton(true);
			}
		}
	}
	public class ShowPreviousWidgetEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			if(isPreviousButtonActive){
				if((currentMarginLeft-WIDGET_WIDTH)==0){
					activatePreviousButton(false);
				}
				new WidgetSlideAnimation(widgetsPanel, "backward").run(ANIMATION_DURATION);
				activateNextButton(true);
			}
		}
	}
	
	public class ButtonMouseOverEvent implements MouseOverHandler{
		private boolean isNextButton=false;
		public ButtonMouseOverEvent(boolean isNextButton){
			this.isNextButton=isNextButton;
		}
		@Override
		public void onMouseOver(MouseOverEvent event) {
			if(isNextButton&&isNextButtonActive){
				nextButton.getElement().setAttribute("style", "border-left: 15px solid #999; cursor: pointer;");
			}else if(!isNextButton&&isPreviousButtonActive){
				previousButton.getElement().setAttribute("style", "border-right: 15px solid #999; cursor: pointer;");
			}
		}
	}
	public class ButtonMouseOutEvent implements MouseOutHandler{
		private boolean isNextButton=false;
		public ButtonMouseOutEvent(boolean isNextButton){
			this.isNextButton=isNextButton;
		}
		@Override
		public void onMouseOut(MouseOutEvent event) {
			if(isNextButton){
				nextButton.getElement().removeAttribute("style");
			}else{
				previousButton.getElement().removeAttribute("style");
			}
		}
	}
	public class WidgetSlideAnimation extends  Animation{
		
		private Widget slideWidget;
		private String slideDirection;
		private double startingMarginLeft;
		private double desiredMarginLeft;
		public WidgetSlideAnimation(Widget widget,String direction){
			this.slideWidget=widget;
			this.slideDirection=direction;
			setAnimationPosition();
		}
		private void setAnimationPosition(){	
			startingMarginLeft=currentMarginLeft;
			if(slideDirection.equalsIgnoreCase("forward")){
				desiredMarginLeft=startingMarginLeft+WIDGET_WIDTH;
			}
			else{
				desiredMarginLeft=startingMarginLeft-WIDGET_WIDTH;
			}
		}
		protected void onStart() {
			super.onStart();
		}
		@Override
		protected void onUpdate(double progress) {
			double marginLeft = -(extractProportionalLength(progress)) ;
			slideWidget.getElement().getStyle().setMarginLeft(marginLeft, Unit.PX);
		}
		 private double extractProportionalLength(double progress) {
	            double marginLeft = startingMarginLeft - (startingMarginLeft - desiredMarginLeft) * progress; // this is for hidding ,eg: startHeight=200,desiredHeight=
	            return marginLeft;
	      }
		 protected double interpolate(double progress) {
			    return (1 + Math.cos(Math.PI + progress * Math.PI)) / 2;
		 }
		protected void onComplete() {
			if(slideDirection.equalsIgnoreCase("forward")){
				desiredMarginLeft=startingMarginLeft+WIDGET_WIDTH;
			}
			else{
				desiredMarginLeft=startingMarginLeft-WIDGET_WIDTH;
			}
			currentMarginLeft=desiredMarginLeft;
			slideWidget.getElement().getStyle().setMarginLeft(-(desiredMarginLeft), Unit.PX);
		}
	}

}
