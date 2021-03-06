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
package org.ednovo.gooru.client.mvp.play.resource.question;


import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;

public class QuestionAnswerOptionView extends Composite{
	
	public interface QuestionAnswerOptionViewUiBinder extends UiBinder<Widget,QuestionAnswerOptionView>{

	}
	@UiField public Label answerChoiceResult,radioButton;
	@UiField HTML answerOptionText;
	@UiField public RadioButton answerOptionRadioButton;
	//@UiField public CheckBox answerOptionCheckBoxButton;
	private int answerId;
	private boolean isAnswerCorrect;
	private String answerText="";
	public static QuestionAnswerOptionViewUiBinder questionAnswerOptionViewUiBinder=GWT.create(QuestionAnswerOptionViewUiBinder.class);
	
	public QuestionAnswerOptionView(String questionText,String questionSerialNum){ 
		initWidget(questionAnswerOptionViewUiBinder.createAndBindUi(this));
		this.answerText=questionText;
		//optionAlpahabeticSerialNo.setText(questionSerialNum);
		answerOptionText.setHTML(questionSerialNum+" "+removeHtmlTags(questionText));
		
		answerChoiceResult.getElement().setId("lblAnswerChoiceResult");
		radioButton.getElement().setId("lblRadioButton");
		answerOptionText.getElement().setId("htmlAnswerOptionText");
		answerOptionRadioButton.getElement().setId("rdAnswerOptionRadioButton");
	}
	private HTML getHTML(String html){
		html = html.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
		HTML contentHtml=new HTML(html);
		contentHtml.setStyleName("");
		return contentHtml;
	}
	private String removeHtmlTags(String text){
		/**
		 * Commented the following line to fix issue with displaying math symbols. 
		 */
//		text = text.replaceAll("(<\\w+)[^>]*(>)", "$1$2");
		text=text.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
		return text;
	}
	
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public boolean isAnswerCorrect() {
		return isAnswerCorrect;
	}
	public void setAnswerCorrect(boolean isAnswerCorrect) {
		this.isAnswerCorrect = isAnswerCorrect;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	
}
