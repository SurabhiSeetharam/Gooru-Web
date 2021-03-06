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
package org.ednovo.gooru.shared.model.content;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.ednovo.gooru.shared.model.code.CodeDo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CollectionQuestionItemDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String sharing;
	private String title;
	private String isLive;
	private String label;
	private String questionText;
	private String explanation;
	private String description;
	private String difficultyLevel;
	private String concept;
	private String typeName;
	private String gooruOid;
	private int timeToCompleteInSecs;
	private HashMap<String,ArrayList<QuestionHintsDo>> hints;
	private HashMap<String,ArrayList<QuestionAnswerDo>> answers;
	private HashMap<String,ArrayList<checkboxSelectedDo>> educationalUse;
	private HashMap<String,ArrayList<CodeDo>> taxonomySet;
	private HashMap<String,ArrayList<checkboxSelectedDo>> depthOfKnowledges;
	
	public CollectionQuestionItemDo(){}
	
	public String getSharing() {
		return sharing;
	}
	public String getTitle() {
		return title;
	}
	public String getIsLive() {
		return isLive;
	}
	public String getLabel() {
		return label;
	}
	public String getQuestionText() {
		return questionText;
	}

	public String getDescription() {
		return description;
	}
	public String getDifficultyLevel() {
		return difficultyLevel;
	}
	public String getConcept() {
		return concept;
	}
	public String getTypeName() {
		return typeName;
	}
	public int getTimeToCompleteInSecs() {
		return timeToCompleteInSecs;
	}
	
	public HashMap<String, ArrayList<QuestionAnswerDo>> getAnswers() {
		return answers;
	}
	public void setSharing(String sharing) {
		this.sharing = sharing;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setIsLive(String isLive) {
		this.isLive = isLive;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public String getGooruOid() {
		return gooruOid;
	}
	public void setGooruOid(String gooruOid) {
		this.gooruOid = gooruOid;
	}
	public void setConcept(String concept) {
		this.concept = concept;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public void setTimeToCompleteInSecs(int timeToCompleteInSecs) {
		this.timeToCompleteInSecs = timeToCompleteInSecs;
	}
	
	public void setAnswers(HashMap<String, ArrayList<QuestionAnswerDo>> answers) {
		this.answers = answers;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public HashMap<String,ArrayList<QuestionHintsDo>> getHints() {
		return hints;
	}
	public void setHints(HashMap<String,ArrayList<QuestionHintsDo>> hints) {
		this.hints = hints;
	}

	public HashMap<String, ArrayList<CodeDo>> getTaxonomySet() {
		return taxonomySet;
	}

	public void setTaxonomySet(HashMap<String, ArrayList<CodeDo>> taxonomySet) {
		this.taxonomySet = taxonomySet;
	}

	public HashMap<String, ArrayList<checkboxSelectedDo>> getDepthOfKnowledges() {
		return depthOfKnowledges;
	}

	public void setDepthOfKnowledges(
			HashMap<String, ArrayList<checkboxSelectedDo>> depthOfKnowledges) {
		this.depthOfKnowledges = depthOfKnowledges;
	}

	public HashMap<String, ArrayList<checkboxSelectedDo>> getEducationalUse() {
		return educationalUse;
	}

	public void setEducationalUse(
			HashMap<String, ArrayList<checkboxSelectedDo>> educationalUse) {
		this.educationalUse = educationalUse;
	}
	
}
