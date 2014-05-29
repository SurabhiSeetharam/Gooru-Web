package org.ednovo.gooru.client.mvp.rating;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.effects.FadeInAndOut;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.rating.events.UpdateRatingOnDeleteEvent;
import org.ednovo.gooru.client.mvp.rating.events.UpdateRatingsGraphEvent;
import org.ednovo.gooru.client.mvp.rating.events.UpdateUserStarReviewEvent;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.SetStyleForProfanity;
import org.ednovo.gooru.shared.model.content.StarRatingsDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class RatingUserWidgetView extends Composite implements MessageProperties {

	@UiField HTMLEventPanel reviewContainer;
	
	@UiField Label userName, timeStamp, review,mouseOverStarValue,starValue,mandatoryDescLblForSwareWords,errorLbl;
	
	@UiField Button editReview,editReviewBtn,cancelReviewBtn,deleteReview;
	
	@UiField HTMLPanel editReviewTextareaContainer,editReviewLabelContainer;
	
	@UiField InlineHTML starOne,starTwo,starThree,starFour,starFive;
	
	@UiField TextArea editReviewText;
	
	@UiField InlineHTML userratingOne,userratingTwo,userratingThree,userratingFour,userratingFive;
	
	@UiField RatingAndReviewStyleBundle style;

	
	private static final String DATE_FORMAT="MMMM dd, yyyy";
	
	private static final String ONE_STAR="oneStar";
	private static final String TWO_STAR="twoStar";
	private static final String THREE_STAR="threeStar";
	private static final String FOUR_STAR="fourStar";
	private static final String FIVE_STAR="fiveStar";
	
	private StarRatingsDo starRatingsDo;
	private static final String POOR=GL1846;
	private static final String FAIR=GL1845;
	private static final String GOOD=GL1844;
	private static final String VERY_GOOD=GL1843;
	private static final String EXCELLENT=GL1842;
	
	int currentRating=0,clickedRating;
	private static final String FILLED_BLUE = "filled filledBlue";
	private static final String CONTENT_ADMIN_ROLE = "Content_Admin";
	private static RatingUserWidgetViewUiBinder uiBinder = GWT
			.create(RatingUserWidgetViewUiBinder.class);

	interface RatingUserWidgetViewUiBinder extends
			UiBinder<Widget, RatingUserWidgetView> {
	}

	public RatingUserWidgetView(StarRatingsDo starRatingsDo,String createrName) {
		initWidget(uiBinder.createAndBindUi(this));
		setData(starRatingsDo,createrName);
		this.starRatingsDo = starRatingsDo;
		deleteReview.setVisible(false);
		editReviewText.addKeyUpHandler(new KeyUpHandler(){
			@Override
			public void onKeyUp(KeyUpEvent event) {
				editReviewText.getElement().setAttribute("style", "border-color: rgb(169, 169, 169);");
				mandatoryDescLblForSwareWords.setVisible(false);
			}
		});
	}
	
	public void setData(final StarRatingsDo starRatingsDo,final String createrName) {
		editReview.setText(GL1860);
		editReviewBtn.setText(GL0141);
		String commentTime = getCreatedTime(Long.toString(starRatingsDo.getCreatedDate())); 
		long lastModifiedOn = starRatingsDo.getLastModifiedOn();
		timeStamp.setText(commentTime +""+ (lastModifiedOn > 0 ? " " + GL_GRR_Hyphen + " " + GL1434 : ""));
		deleteReview.setText(GL1861);
		
		review.setText(starRatingsDo.getFreeText());
		editReviewText.setText(starRatingsDo.getFreeText());
		editReview.setVisible(false);
		deleteReview.addStyleName(style.deleteButtonAlign());
		
		editReviewTextareaContainer.setVisible(false);
		if(starRatingsDo.getCreator().getUsername().equals(AppClientFactory.getLoggedInUser().getUsername())){
			reviewContainer.setVisible(true);
			editReviewLabelContainer.setVisible(true);
			userName.setText(starRatingsDo.getCreator().getUsername());
			clearAllStarsReadOnly();
			this.currentRating = starRatingsDo.getScore();
			if(starRatingsDo.getScore() == 1)
			{
				setStarRatings(starRatingsDo);
			}
			else if(starRatingsDo.getScore() == 2)
			{
				setStarRatings(starRatingsDo);
			}
			else if(starRatingsDo.getScore() == 3)
			{
				setStarRatings(starRatingsDo);
			}
			else if(starRatingsDo.getScore() == 4)
			{
				setStarRatings(starRatingsDo);
			}
			else if(starRatingsDo.getScore() == 5)
			{
				setStarRatings(starRatingsDo);
			}
			
		  if(starRatingsDo.getFreeText()!=null && !starRatingsDo.getFreeText().equals("")){
			reviewContainer.setVisible(true);
			editReviewLabelContainer.setVisible(true);
		  }else{
			//reviewContainer.setVisible(false);
			userName.setText(starRatingsDo.getCreator().getUsername());
			//editReviewLabelContainer.setVisible(false);
		}
			
		}else{
			userName.setText(starRatingsDo.getCreator().getUsername());
			clearAllStarsReadOnly();
			this.currentRating = starRatingsDo.getScore();
			if(starRatingsDo.getScore() == 1)
			{
				starOne.addStyleName(style.filled());
				starTwo.removeStyleName(style.filled());
				starThree.removeStyleName(style.filled());
				starFour.removeStyleName(style.filled());
				starFive.removeStyleName(style.filled());
			}
			else if(starRatingsDo.getScore() == 2)
			{
				starOne.addStyleName(style.filled());
				starTwo.addStyleName(style.filled());
				starThree.removeStyleName(style.filled());
				starFour.removeStyleName(style.filled());
				starFive.removeStyleName(style.filled());
			}
			else if(starRatingsDo.getScore() == 3)
			{
				starOne.addStyleName(style.filled());
				starTwo.addStyleName(style.filled());
				starThree.addStyleName(style.filled());
				starFour.removeStyleName(style.filled());
				starFive.removeStyleName(style.filled());
			}
			else if(starRatingsDo.getScore() == 4)
			{
				starOne.addStyleName(style.filled());
				starTwo.addStyleName(style.filled());
				starThree.addStyleName(style.filled());
				starFour.addStyleName(style.filled());
				starFive.removeStyleName(style.filled());
			}
			else if(starRatingsDo.getScore() == 5)
			{
				starOne.addStyleName(style.filled());
				starTwo.addStyleName(style.filled());
				starThree.addStyleName(style.filled());
				starFour.addStyleName(style.filled());
				starFive.addStyleName(style.filled());
			}
			if(starRatingsDo.getFreeText()!=null && !starRatingsDo.getFreeText().equals("")){
				reviewContainer.setVisible(true);
				editReviewLabelContainer.setVisible(true);
			}else{
				//reviewContainer.setVisible(false);
				//editReviewLabelContainer.setVisible(false);
			}
		}
		
		if(starRatingsDo.getCreator().getUsername().equals(AppClientFactory.getLoggedInUser().getUsername())) {
			//reviewContainer.addStyleName(style.creatorReviewPanel());
			editReview.addStyleName(style.editReview());
			editReviewBtn.removeStyleName(style.editReview());
			cancelReviewBtn.removeStyleName(style.editReview());
			//editReview.setVisible(true);
			userName.setText(GL1850);
			deleteReview.removeStyleName(style.editReview());
		} else {
			editReview.removeStyleName(style.editReview());
			deleteReview.removeStyleName(style.editReview());
			
		}
/*		reviewContainer.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(starRatingsDo.getCreator().getUsername().equals(AppClientFactory.getLoggedInUser().getUsername())) {
					editReview.setVisible(true);
				}
				
				if(!AppClientFactory.isAnonymous() && AppClientFactory.getLoggedInUser().getUserRoleSetString().contains(CONTENT_ADMIN_ROLE)){
					deleteReview.setVisible(true);     
				}
			}
		});*/
/*		reviewContainer.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				editReview.setVisible(false);
				deleteReview.setVisible(false);
				
			}
		});*/
		
	}
	
	private void setStarRatings(StarRatingsDo starRatingsDo) {
		if(starRatingsDo.getScore()==1){
			clearAllStarsReadOnly();
			if(starRatingsDo.getCreator().getUsername().equals(AppClientFactory.getLoggedInUser().getUsername())){
				starOne.addStyleName(style.filled());
				starOne.getElement().addClassName(FILLED_BLUE);
				starTwo.removeStyleName(style.filled());
				starThree.removeStyleName(style.filled());
				starFour.removeStyleName(style.filled());
				starFive.removeStyleName(style.filled());
				starTwo.removeStyleName(FILLED_BLUE);
				starThree.removeStyleName(FILLED_BLUE);
				starFour.removeStyleName(FILLED_BLUE);
				starFive.removeStyleName(FILLED_BLUE);
			}else{
				starOne.addStyleName(style.filled());
				starTwo.removeStyleName(style.filled());
				starThree.removeStyleName(style.filled());
				starFour.removeStyleName(style.filled());
				starFive.removeStyleName(style.filled());
			}
			
		}else if(starRatingsDo.getScore()==2){
			clearAllStarsReadOnly();
			if(starRatingsDo.getCreator().getUsername().equals(AppClientFactory.getLoggedInUser().getUsername())){
				starOne.addStyleName(style.filled());
				starTwo.addStyleName(style.filled());
				starOne.getElement().addClassName(FILLED_BLUE);
				starTwo.getElement().addClassName(FILLED_BLUE);
				starThree.removeStyleName(style.filled());
				starFour.removeStyleName(style.filled());
				starFive.removeStyleName(style.filled());
				starThree.removeStyleName(FILLED_BLUE);
				starFour.removeStyleName(FILLED_BLUE);
				starFive.removeStyleName(FILLED_BLUE);
			}else{
				starOne.addStyleName(style.filled());
				starTwo.addStyleName(style.filled());
				starThree.removeStyleName(style.filled());
				starFour.removeStyleName(style.filled());
				starFive.removeStyleName(style.filled());
			}
			
		}else if(starRatingsDo.getScore()==3){
			clearAllStarsReadOnly();
			if(starRatingsDo.getCreator().getUsername().equals(AppClientFactory.getLoggedInUser().getUsername())){
				starOne.addStyleName(style.filled());
				starTwo.addStyleName(style.filled());
				starThree.addStyleName(style.filled());
				starOne.getElement().addClassName(FILLED_BLUE);
				starTwo.getElement().addClassName(FILLED_BLUE);
				starThree.getElement().addClassName(FILLED_BLUE);
				starFour.removeStyleName(style.filled());
				starFive.removeStyleName(style.filled());
				starFour.removeStyleName(FILLED_BLUE);
				starFive.removeStyleName(FILLED_BLUE);
			}else{
				starOne.addStyleName(style.filled());
				starTwo.addStyleName(style.filled());
				starThree.addStyleName(style.filled());
				starFour.removeStyleName(style.filled());
				starFive.removeStyleName(style.filled());
			}
			
		} else if(starRatingsDo.getScore()==4){
			clearAllStarsReadOnly();
			if(starRatingsDo.getCreator().getUsername().equals(AppClientFactory.getLoggedInUser().getUsername())){
				starOne.addStyleName(style.filled());
				starTwo.addStyleName(style.filled());
				starThree.addStyleName(style.filled());
				starFour.addStyleName(style.filled());
				starOne.getElement().addClassName(FILLED_BLUE);
				starTwo.getElement().addClassName(FILLED_BLUE);
				starThree.getElement().addClassName(FILLED_BLUE);
				starFour.getElement().addClassName(FILLED_BLUE);
				starFive.removeStyleName(style.filled());
				starFive.removeStyleName(FILLED_BLUE);
			}else{
				starOne.addStyleName(style.filled());
				starTwo.addStyleName(style.filled());
				starThree.addStyleName(style.filled());
				starFour.addStyleName(style.filled());
				starFive.removeStyleName(style.filled());
			}
			
		}else if(starRatingsDo.getScore()==5){
			clearAllStarsReadOnly();
			if(starRatingsDo.getCreator().getUsername().equals(AppClientFactory.getLoggedInUser().getUsername())){
				starOne.addStyleName(style.filled());
				starTwo.addStyleName(style.filled());
				starThree.addStyleName(style.filled());
				starFour.addStyleName(style.filled());
				starFive.addStyleName(style.filled());
				starOne.getElement().addClassName(FILLED_BLUE);
				starTwo.getElement().addClassName(FILLED_BLUE);
				starThree.getElement().addClassName(FILLED_BLUE);
				starFour.getElement().addClassName(FILLED_BLUE);
				starFive.getElement().addClassName(FILLED_BLUE);
			}else{
				starOne.addStyleName(style.filled());
				starTwo.addStyleName(style.filled());
				starThree.addStyleName(style.filled());
				starFour.addStyleName(style.filled());
				starFive.addStyleName(style.filled());
			}
		}
	}


	@UiHandler("editReview")
	public void editReview(ClickEvent event) {
		editReviewTextareaContainer.setVisible(true);
		//editReviewLabelContainer.setVisible(false);
		if(currentRating==1){
			userratingOne.getElement().addClassName(FILLED_BLUE);
			userratingTwo.removeStyleName(FILLED_BLUE);
			userratingThree.removeStyleName(FILLED_BLUE);
			userratingFour.removeStyleName(FILLED_BLUE);
			userratingFive.removeStyleName(FILLED_BLUE);
		}else if(currentRating==2){
			userratingOne.getElement().addClassName(FILLED_BLUE);
			userratingTwo.getElement().addClassName(FILLED_BLUE);
			userratingThree.removeStyleName(FILLED_BLUE);
			userratingFour.removeStyleName(FILLED_BLUE);
			userratingFive.removeStyleName(FILLED_BLUE);
		}else if(currentRating==3){
			userratingOne.getElement().addClassName(FILLED_BLUE);
			userratingTwo.getElement().addClassName(FILLED_BLUE);
			userratingThree.getElement().addClassName(FILLED_BLUE);
			userratingFour.removeStyleName(FILLED_BLUE);
			userratingFive.removeStyleName(FILLED_BLUE);
		}else if(currentRating==4){
			userratingOne.getElement().addClassName(FILLED_BLUE);
			userratingTwo.getElement().addClassName(FILLED_BLUE);
			userratingThree.getElement().addClassName(FILLED_BLUE);
			userratingFour.getElement().addClassName(FILLED_BLUE);
			userratingFive.removeStyleName(FILLED_BLUE);
		}else if(currentRating==5){
			userratingOne.getElement().addClassName(FILLED_BLUE);
			userratingTwo.getElement().addClassName(FILLED_BLUE);
			userratingThree.getElement().addClassName(FILLED_BLUE);
			userratingFour.getElement().addClassName(FILLED_BLUE);
			userratingFive.getElement().addClassName(FILLED_BLUE);
		}
		
		userratingOne.addMouseOverHandler(new OnStarMouseOver(ONE_STAR));
		userratingTwo.addMouseOverHandler(new OnStarMouseOver(TWO_STAR));
		userratingThree.addMouseOverHandler(new OnStarMouseOver(THREE_STAR));
		userratingFour.addMouseOverHandler(new OnStarMouseOver(FOUR_STAR));
		userratingFive.addMouseOverHandler(new OnStarMouseOver(FIVE_STAR));
		
		userratingOne.addMouseOutHandler(new OnStarMouseOut(ONE_STAR));
		userratingTwo.addMouseOutHandler(new OnStarMouseOut(TWO_STAR));
		userratingThree.addMouseOutHandler(new OnStarMouseOut(THREE_STAR));
		userratingFour.addMouseOutHandler(new OnStarMouseOut(FOUR_STAR));
		userratingFive.addMouseOutHandler(new OnStarMouseOut(FIVE_STAR));
		editReviewBtn.removeStyleName(style.editReview());
		cancelReviewBtn.removeStyleName(style.editReview());
	}
	@UiHandler("editReviewText")
	public void keyRatingTextArea(KeyUpEvent event){
		String review=editReviewText.getText();
		errorLbl.setText("");
		if(review.length()>0){
			errorLbl.setText("");
		}
		if(review.length()==500){
			errorLbl.setText(GL0143);
			errorLbl.setVisible(true);
		//	fieldValidationStaus=false;
		}else{
			errorLbl.setVisible(false);
		}
	}
	@UiHandler("editReviewBtn")
	public void editReviewForEditingReview(ClickEvent event) {
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("text", editReviewText.getText());
		AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean result) {
				if(!result){
				// TODO Auto-generated method stub
				AppClientFactory.getInjector().getPlayerAppService().updateResourceStarReviews(starRatingsDo.getDeleteRatingGooruOid(),currentRating, editReviewText.getText(), new SimpleAsyncCallback<ArrayList<StarRatingsDo>>(){
					@Override
					public void onSuccess(ArrayList<StarRatingsDo> result) {
						if(result.size()>0){
							AppClientFactory.fireEvent(new UpdateUserStarReviewEvent(result));
							editReviewTextareaContainer.setVisible(false);
							review.setText(result.get(0).getFreeText());
							editReviewLabelContainer.setVisible(true);
							editReviewBtn.removeStyleName(style.editReview());
							cancelReviewBtn.removeStyleName(style.editReview());
							updateStars(result.get(0));
							starRatingsDo.setScore(result.get(0).getScore());
							starRatingsDo.setFreeText(result.get(0).getFreeText());
							AppClientFactory.fireEvent(new UpdateRatingsGraphEvent(starRatingsDo.getAssocGooruOid()));  
						}
					}
				}); 
			}
				SetStyleForProfanity.SetStyleForProfanityForTextArea(editReviewText, mandatoryDescLblForSwareWords, result);
	   }
			
		});
	}
	
	private void updateStars(StarRatingsDo starRatingsDo) {
		clearAllStarsReadOnly();
		// TODO Auto-generated method stub
		if(starRatingsDo.getScore() == 1)
		{

			starOne.addStyleName(style.filled());
			starTwo.removeStyleName(style.filled());
			starThree.removeStyleName(style.filled());
			starFour.removeStyleName(style.filled());
			starFive.removeStyleName(style.filled());
		}
		else if(starRatingsDo.getScore() == 2)
		{
			starOne.addStyleName(style.filled());
			starTwo.addStyleName(style.filled());
			starThree.removeStyleName(style.filled());
			starFour.removeStyleName(style.filled());
			starFive.removeStyleName(style.filled());
		}
		else if(starRatingsDo.getScore() == 3)
		{
			starOne.addStyleName(style.filled());
			starTwo.addStyleName(style.filled());
			starThree.addStyleName(style.filled());
			starFour.removeStyleName(style.filled());
			starFive.removeStyleName(style.filled());
		}
		else if(starRatingsDo.getScore() == 4)
		{
			starOne.addStyleName(style.filled());
			starTwo.addStyleName(style.filled());
			starThree.addStyleName(style.filled());
			starFour.addStyleName(style.filled());
			starFive.removeStyleName(style.filled());
		}
		else if(starRatingsDo.getScore() == 5)
		{
			starOne.addStyleName(style.filled());
			starTwo.addStyleName(style.filled());
			starThree.addStyleName(style.filled());
			starFour.addStyleName(style.filled());
			starFive.addStyleName(style.filled());
		}
	}
	
	
	@UiHandler("userratingOne")
	public void userratingOne(ClickEvent event) {
		this.currentRating =1;
		userratingOne.addStyleName(FILLED_BLUE);
		userratingTwo.removeStyleName(FILLED_BLUE);
		userratingThree.removeStyleName(FILLED_BLUE);
		userratingFour.removeStyleName(FILLED_BLUE);
		userratingFive.removeStyleName(FILLED_BLUE);
		
	}

	@UiHandler("userratingTwo")
	public void userratingTwo(ClickEvent event) {
		this.currentRating =2;
		userratingOne.addStyleName(FILLED_BLUE);
		userratingTwo.addStyleName(FILLED_BLUE);
		userratingThree.removeStyleName(FILLED_BLUE);
		userratingFour.removeStyleName(FILLED_BLUE);
		userratingFive.removeStyleName(FILLED_BLUE);
	
	}
	@UiHandler("userratingThree")
	public void userratingThree(ClickEvent event) {
		this.currentRating =3;
		userratingOne.addStyleName(FILLED_BLUE);
		userratingTwo.addStyleName(FILLED_BLUE);
		userratingThree.addStyleName(FILLED_BLUE);
		userratingFour.removeStyleName(FILLED_BLUE);
		userratingFive.removeStyleName(FILLED_BLUE);
	}
	@UiHandler("userratingFour")
	public void userratingFour(ClickEvent event) {
		this.currentRating =4;
		userratingOne.addStyleName(FILLED_BLUE);
		userratingTwo.addStyleName(FILLED_BLUE);
		userratingThree.addStyleName(FILLED_BLUE);
		userratingFour.addStyleName(FILLED_BLUE);
		userratingFive.removeStyleName(FILLED_BLUE);
	}
	@UiHandler("userratingFive")
	public void userratingFive(ClickEvent event) {
		this.currentRating =5;
		userratingOne.addStyleName(FILLED_BLUE);
		userratingTwo.addStyleName(FILLED_BLUE);
		userratingThree.addStyleName(FILLED_BLUE);
		userratingFour.addStyleName(FILLED_BLUE);
		userratingFive.addStyleName(FILLED_BLUE);
	}
	@UiHandler("cancelReviewBtn")
	public void cancelReview(ClickEvent event) {
		this.currentRating =starRatingsDo.getScore();
		editReviewText.setText(starRatingsDo.getFreeText());
		editReviewTextareaContainer.setVisible(false);
		editReviewLabelContainer.setVisible(true);
		editReviewBtn.removeStyleName(style.editReview());
		cancelReviewBtn.removeStyleName(style.editReview());
	}

	@UiHandler("deleteReview")
	public void onClickDeleteReview(ClickEvent event){

		AppClientFactory.getInjector().getPlayerAppService().deleteRating(starRatingsDo.getDeleteRatingGooruOid(), new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				reviewContainer.clear();
				reviewContainer.addStyleName(style.deletePanel());
				final HTMLPanel deletePanel = new HTMLPanel("");
				Label deleteMsg = new Label();
				deleteMsg.setText(MessageProperties.GL1853);
				deleteMsg.setStyleName(style.lbldeleteMsg());
				deletePanel.add(deleteMsg);
				reviewContainer.add(deletePanel);
				new FadeInAndOut(deletePanel.getElement(), 1000);
				Timer timer = new Timer()
		        {
		            @Override
		            public void run()
		            {
		            	int deleteIndex = reviewContainer.getWidgetIndex(deletePanel);
		            	reviewContainer.remove(deleteIndex);
		            	//reviewContainer.setVisible(false);
		            	AppClientFactory.fireEvent(new UpdateRatingOnDeleteEvent(true)); 
					
		            }
		        };
		        timer.schedule(1000);
			}
			
			@Override
			public void onFailure(Throwable caught) {
			
				
			}
		});
}
	
	private String getCreatedTime(String commentCreatedTime) {
		String createdTime = null;
		Long currentTime = System.currentTimeMillis();
		Long commentTime = Long.parseLong(commentCreatedTime);
		Long elapsedTime = (currentTime - commentTime);
		int seconds = (int) (elapsedTime / 1000) % 60 ;
		int minutes = (int) ((elapsedTime / (1000*60)) % 60);
		int hours   = (int) ((elapsedTime / (1000*60*60)) % 24);
		int days = (int) (elapsedTime / (1000*60*60*24));
		Date currentDate = new Date(commentTime);
		DateTimeFormat fmt = DateTimeFormat.getFormat (DATE_FORMAT);
		if(days>6){
			createdTime = fmt.format (currentDate);
		}
		else if(days>0&&days<=6) {
			createdTime = days + getTimePrefix(days," "+GL0562, GL0579, GL0580);
		} else if(hours>0&&hours<24) {
			createdTime = hours + getTimePrefix(hours," "+GL0563, GL1435, GL1436);
		} else if(minutes>0&&minutes<60) {
			createdTime = minutes + getTimePrefix(minutes," "+GL0564, GL1437, GL1438);
		} else if(seconds<=60) {
			createdTime = GL0561;
		}
		return createdTime;

	}
	
	public class OnStarMouseOver implements MouseOverHandler{
		private String starScore="";
		/**
		 * Class Constructor.
		 * @param starScore {@link String}
		 */
		public OnStarMouseOver(String starScore) {
			this.starScore=starScore;
		}
		@Override
		public void onMouseOver(MouseOverEvent event) {
			clearAllStars();
			if(starScore.equalsIgnoreCase(ONE_STAR)){
				mouseOverStarValue.setText(POOR);
				userratingOne.getElement().addClassName(FILLED_BLUE);
			}else if(starScore.equalsIgnoreCase(TWO_STAR)){
				mouseOverStarValue.setText(FAIR);
				userratingOne.getElement().addClassName(FILLED_BLUE);
				userratingTwo.getElement().addClassName(FILLED_BLUE);
			}else if(starScore.equalsIgnoreCase(THREE_STAR)){
				mouseOverStarValue.setText(GOOD);
				userratingOne.getElement().addClassName(FILLED_BLUE);
				userratingTwo.getElement().addClassName(FILLED_BLUE);
				userratingThree.getElement().addClassName(FILLED_BLUE);
			}else if(starScore.equalsIgnoreCase(FOUR_STAR)){
				mouseOverStarValue.setText(VERY_GOOD);
				userratingOne.getElement().addClassName(FILLED_BLUE);
				userratingTwo.getElement().addClassName(FILLED_BLUE);
				userratingThree.getElement().addClassName(FILLED_BLUE);
				userratingFour.getElement().addClassName(FILLED_BLUE);
			}else if(starScore.equalsIgnoreCase(FIVE_STAR)){
				mouseOverStarValue.setText(EXCELLENT);
				userratingOne.getElement().addClassName(FILLED_BLUE);
				userratingTwo.getElement().addClassName(FILLED_BLUE);
				userratingThree.getElement().addClassName(FILLED_BLUE);
				userratingFour.getElement().addClassName(FILLED_BLUE);
				userratingFive.getElement().addClassName(FILLED_BLUE);
			}
		}
		
	}
	
	public class OnStarMouseOut implements MouseOutHandler{
		private String starScore="";
		public OnStarMouseOut(String starScore) {
			this.starScore=starScore;
		}

		@Override
		public void onMouseOut(MouseOutEvent event) {
			clearAllStars();
			if(starScore.equalsIgnoreCase(ONE_STAR)){
				starValue.setVisible(true);
				mouseOverStarValue.setText("");
			}else if(starScore.equalsIgnoreCase(TWO_STAR)){
				starValue.setVisible(true);
				mouseOverStarValue.setText("");
			}else if(starScore.equalsIgnoreCase(THREE_STAR)){
				starValue.setVisible(true);
				mouseOverStarValue.setText("");
			}else if(starScore.equalsIgnoreCase(FOUR_STAR)){
				starValue.setVisible(true);
				mouseOverStarValue.setText("");
			}else if(starScore.equalsIgnoreCase(FIVE_STAR)){
				starValue.setVisible(true);
				mouseOverStarValue.setText("");
			}
			setStarRatingValue(currentRating);
		}

		private void setStarRatingValue(int currentRating) {
			clearAllStars();
			if(currentRating==1){
				userratingOne.getElement().addClassName(FILLED_BLUE);
			}else if(currentRating==2){
				userratingOne.getElement().addClassName(FILLED_BLUE);
				userratingTwo.getElement().addClassName(FILLED_BLUE);
			}else if(currentRating==3){
				userratingOne.getElement().addClassName(FILLED_BLUE);
				userratingTwo.getElement().addClassName(FILLED_BLUE);
				userratingThree.getElement().addClassName(FILLED_BLUE);
			}else if(currentRating==4){
				userratingOne.getElement().addClassName(FILLED_BLUE);
				userratingTwo.getElement().addClassName(FILLED_BLUE);
				userratingThree.getElement().addClassName(FILLED_BLUE);
				userratingFour.getElement().addClassName(FILLED_BLUE);
			}else if(currentRating==5){
				userratingOne.getElement().addClassName(FILLED_BLUE);
				userratingTwo.getElement().addClassName(FILLED_BLUE);
				userratingThree.getElement().addClassName(FILLED_BLUE);
				userratingFour.getElement().addClassName(FILLED_BLUE);
				userratingFive.getElement().addClassName(FILLED_BLUE);
			}else{
				clearAllStars();
			}
		}
	}
	
	public void clearAllStars(){
		userratingOne.getElement().removeClassName(FILLED_BLUE);
		userratingTwo.getElement().removeClassName(FILLED_BLUE);
		userratingThree.getElement().removeClassName(FILLED_BLUE);
		userratingFour.getElement().removeClassName(FILLED_BLUE);
		userratingFive.getElement().removeClassName(FILLED_BLUE);
	}
	public void clearAllStarsReadOnly(){
		starOne.removeStyleName(style.filled());
		starTwo.removeStyleName(style.filled());
		starThree.removeStyleName(style.filled());
		starFour.removeStyleName(style.filled());
		starFive.removeStyleName(style.filled());
	}

	private String getTimePrefix(int count, String msg, String regex, String replacement) {
		if(count==1) {
			msg = msg.replaceAll(regex, replacement);
		}
		return msg;
	}
	
}