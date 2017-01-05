package com.liveperson.hackathon.jobview.jobview.controller;

import android.net.Uri;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.liveperson.hackathon.jobview.jobview.dataObjects.AbstractAnswer;
import com.liveperson.hackathon.jobview.jobview.dataObjects.AnsweredQuestion;
import com.liveperson.hackathon.jobview.jobview.dataObjects.OccupationalDomain;
import com.liveperson.hackathon.jobview.jobview.dataObjects.Question;
import com.liveperson.hackathon.jobview.jobview.dataObjects.ReviewMetric;
import com.liveperson.hackathon.jobview.jobview.dataObjects.ReviewMetricScore;
import com.liveperson.hackathon.jobview.jobview.dataObjects.SystemAnswer;
import com.liveperson.hackathon.jobview.jobview.dataObjects.User;
import com.liveperson.hackathon.jobview.jobview.dataObjects.UserAnswer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by litalh on 1/4/17.
 */

public  class SessionManager {

    private static SessionManager instance = new SessionManager();
    private static final String SCHEMA_NAME = "jobView";
    private static final String USERS_TABLE_NAME = "users";
    private static final String QUESTIONS_TABLE_NAME = "questions";

    private User mUser;
    private HashMap <String,ArrayList<String>> domainToQuestionIds = new HashMap<>();
    private HashMap <String,Question> questionIdToQuestionData = new HashMap<>();
    private HashMap <String,AbstractAnswer> answerIdsToAnswerData = new HashMap<>();
    private ArrayList <ReviewMetric> reviewMetricList= new ArrayList<>();
    private HashMap <String,ArrayList<ReviewMetricScore>> answerIdToMetricReviewScore = new HashMap<>();

    FirebaseDatabase database;
    private SessionManager()
    {
        database = FirebaseDatabase.getInstance();
        database.setPersistenceEnabled(true);
        createPredefinedQuestionsList();
        createPredefinedReviewMetrics();

    }

    public static SessionManager getInstance(){

        return instance;
    }

    public void updateUser (User user){
        mUser = user;
        database.getReference(SCHEMA_NAME).child(USERS_TABLE_NAME).child(user.getUserId()).setValue(user);

    }

    // This getter method is void since the onDataChange is async method
    public void getUserDB (String userId){

        database.getReference(SCHEMA_NAME).child(USERS_TABLE_NAME).child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Map<String, Object> userMap = (HashMap<String, Object>) dataSnapshot.getValue();
                    String userId = (String) userMap.get("userId");
                    String email = (String) userMap.get("mEmail");
                    String name = (String) userMap.get("mName");
                    User user = new User();
                    user.setUserId(userId);
                    user.setmEmail(email);
                    user.setmName(name);
// if need to update the UI this is the place..

                }


            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {

            }
        });
    }


    public User getUser() {
        return mUser;
    }

    public String getUserDomain(){
        return mUser.getOccupationalDomains().getDomainName();
    }

    public void setUserDomain(String domain){
        mUser.setOccupationalDomains(new OccupationalDomain(domain));
        // DB update
    }



    private void createPredefinedQuestionsList (){
        ArrayList<String> HRQuestionsList = new ArrayList<>();

        SystemAnswer Q1answer1 = new SystemAnswer("התמקד בדברים החיוביים שהספקת לעשות בתקופה זו: הקדשת זמן למשפחה, חברים, תחביבים והרחבת הידע בתחומים שמעניינים אותך.", null);
        SystemAnswer Q1answer2 = new SystemAnswer("השתדל לא להישמע כאילו היית חסר מעש וללא אנרגיות. הימנע מלהזכיר תחושות דכאון או קושי שלא הצלחת להתגבר עליו.\"",null);
        Question question1 = new Question ("מה קרה כשמצאת עצמך ללא עבודה ?",Q1answer1.getAnswerId(),
                Q1answer2.getAnswerId(), null);

        SystemAnswer Q2answer1 = new SystemAnswer("תכנן את תשובתך באופן שאפשר יהיה לראות בחולשה שלך תכונה חיובית (דהיינו, אל תאמר: \"אני לא אוהב פיקוח-יתר כי אני שופע יזמה\". \"אני אוהב לצפות מראש בעיות, לפני שהן מתעוררות\\", null);
        SystemAnswer Q2answer2 = new SystemAnswer("אל תספק רשימה גדולה של חולשות - הסתפק באחת. מצד שני הימנע מלהגיד שאין לך חולשות.",null);
        Question question2 = new Question ("מהי החולשה הגדולה ביותר שלך ?",Q2answer1.getAnswerId(),
                Q2answer2.getAnswerId(), null);

        SystemAnswer Q3answer1 = new SystemAnswer("ענה לשאלה זו באמצעות תגובה קצרה כגון, \"האתגר\", \"הזדמנויות הקידום\", \"תחומי האחריות המגוונים\", וכו'. אם תרצה לפרט, תינתן לך הזדמנות לעשות זאת", null);
        SystemAnswer Q3answer2 = new SystemAnswer("הימנע מלענות תשובה שמעידה על חוסר איכפתיות או איזכורים של משכורת והטבות.",null);
        Question question3 = new Question ("מה מעניין אותך במשרה זו ?",Q3answer1.getAnswerId(),
                Q3answer2.getAnswerId(), null);

        SystemAnswer Q4answer1 = new SystemAnswer("שאלה זו דומה לשאלה הקודמת, אך תשובתך לשאלה זו יכולה להיבדק בדקדקנות רבה יותר. מעסיקים נזהרים מאוד מאנשים הקופצים מעבודה לעבודה! אם היו לך הרבה מאוד עבודות קצרות-טווח, עליך לשכנע את המראיין שימים אלו כבר חלפו ושזוהי המשרה (ההזדמנות) שחיכית \n" +
                "לה. עליך להיות כן וישר ולגרום למראיין לדעת ששינויי המשרה התכופים שלך לא היו קשורים ישירות בביצועי העבודה שלך.\n", null);
        SystemAnswer Q4answer2 = new SystemAnswer("הימנע מלהאשים את המקומות הקודמים שעבדת בהם וכמובן לא את הממונים עליך בהם. ",null);
        Question question4 = new Question ("מדוע החלפת עבודות לעיתים קרובות כל כך ? ",Q4answer1.getAnswerId(),
                Q4answer2.getAnswerId(), null);

        HRQuestionsList.add(question1.getQuestionId());
        HRQuestionsList.add(question2.getQuestionId());
        HRQuestionsList.add(question3.getQuestionId());
        HRQuestionsList.add(question4.getQuestionId());
        domainToQuestionIds.put("HR", HRQuestionsList);

        ArrayList<String> financeQuestionsList = new ArrayList<>();
        SystemAnswer Q5answer1 = new SystemAnswer("התמקד בכך שאתה רוצה לעבוד בסביבה דינמית שמאפשרת התנסויות מגוונות ועניין משתנה.", null);
        SystemAnswer Q5answer2 = new SystemAnswer("השתדל להימנע מלבטא ביקורת גלויה על אופן התנהלות העבודה בבנק, התמקד בדברים החיוביים בעבודה בבית השקעות.\"",null);
        Question question5 = new Question ("מדוע אתה מעדיף עבודה בבית השקעות ולא בבנק ?",Q5answer1.getAnswerId(),
                Q5answer2.getAnswerId(), null);

        domainToQuestionIds.put("פיננסים", financeQuestionsList);
        questionIdToQuestionData.put(question1.getQuestionId(),question1);
        questionIdToQuestionData.put(question2.getQuestionId(),question2);
        questionIdToQuestionData.put(question3.getQuestionId(),question3);
        questionIdToQuestionData.put(question4.getQuestionId(),question4);
        questionIdToQuestionData.put(question5.getQuestionId(),question5);
        answerIdsToAnswerData.put(Q1answer1.getAnswerId(), Q1answer1);
        answerIdsToAnswerData.put(Q1answer2.getAnswerId(), Q1answer2);
        answerIdsToAnswerData.put(Q2answer1.getAnswerId(), Q2answer1);
        answerIdsToAnswerData.put(Q2answer2.getAnswerId(), Q2answer2);
        answerIdsToAnswerData.put(Q3answer1.getAnswerId(), Q3answer1);
        answerIdsToAnswerData.put(Q3answer2.getAnswerId(), Q3answer2);
        answerIdsToAnswerData.put(Q4answer1.getAnswerId(), Q4answer1);
        answerIdsToAnswerData.put(Q4answer2.getAnswerId(), Q4answer2);
        answerIdsToAnswerData.put(Q5answer1.getAnswerId(), Q5answer1);
        answerIdsToAnswerData.put(Q5answer2.getAnswerId(), Q5answer2);

        database.getReference(SCHEMA_NAME).child(QUESTIONS_TABLE_NAME).child(question1.getQuestionId()).setValue(question1);
        database.getReference(SCHEMA_NAME).child(QUESTIONS_TABLE_NAME).child(question2.getQuestionId()).setValue(question2);
        database.getReference(SCHEMA_NAME).child(QUESTIONS_TABLE_NAME).child(question3.getQuestionId()).setValue(question3);
        database.getReference(SCHEMA_NAME).child(QUESTIONS_TABLE_NAME).child(question4.getQuestionId()).setValue(question4);
        database.getReference(SCHEMA_NAME).child(QUESTIONS_TABLE_NAME).child(question5.getQuestionId()).setValue(question5);

    }

    public Question getQuestionById (String questionId) {
        Question questionData = questionIdToQuestionData.get(questionId);
       if (questionData != null){
           return questionData;
       }
        else{
           //TODO - go to DB
           return null;
       }
    }

    public AbstractAnswer getAnswerById (String answerId){
        AbstractAnswer answerData = answerIdsToAnswerData.get(answerId);
        if (answerData != null){
            return answerData;
        }
        else{
            //TODO - go to DB
            return null;
        }
    }

    public ArrayList<Question> fetchQuestionsByDomain(String domainName) {

        ArrayList<String> questionIds = new ArrayList<>();
        ArrayList<Question> questions = new ArrayList<>();
        if (domainToQuestionIds.get(domainName) == null){
             return questions;
        }
        questionIds.addAll(domainToQuestionIds.get(domainName));
        for(String questionId : questionIds){
            questions.add(questionIdToQuestionData.get(questionId));
        }


       database.getReference(SCHEMA_NAME).child(QUESTIONS_TABLE_NAME).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    System.out.println("ffff ");
                    Map<String, Object> questionsMap = (HashMap<String, Object>) dataSnapshot.getValue();
                    System.out.println("questionsMap " +questionsMap);
// if need to update the UI this is the place..


                }


            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {

            }
        });

        return questions;

    }

    public ArrayList<Question> fetchGeneralQuestions(){
        ArrayList<String> questionIds = new ArrayList<>();
        ArrayList<Question> questions = new ArrayList<>();

        questionIds.addAll(domainToQuestionIds.get("HR"));
        for(String questionId : questionIds){
            questions.add(questionIdToQuestionData.get(questionId));
        }
        return questions;

    }


    public void updateUserAnswer(String questionId, Uri fileUri){
        UserAnswer userAnswer = new UserAnswer(null,fileUri);
        AnsweredQuestion answeredQuestion = new AnsweredQuestion(questionId, userAnswer.getAnswerId());
        mUser.addAnsweredQuestions(answeredQuestion.getId());
        answerIdsToAnswerData.put(userAnswer.getAnswerId(),userAnswer);

    }

    public void createPredefinedReviewMetrics(){

        ReviewMetric reviewMetric1 = new ReviewMetric("שפת גוף");
        ReviewMetric reviewMetric2 = new ReviewMetric("טון הדיבור");
        ReviewMetric reviewMetric3 = new ReviewMetric("מהירות הדיבור");
        ReviewMetric reviewMetric4 = new ReviewMetric("מראה כללי");
        reviewMetricList.add(reviewMetric1);
        reviewMetricList.add(reviewMetric2);
        reviewMetricList.add(reviewMetric3);
        reviewMetricList.add(reviewMetric4);


    }

    public ArrayList<ReviewMetric> getAllReviewMetrics(){
      return reviewMetricList;
    }

    public void addMetricReviewScore(String answerId, String metricId, int score) {
        ArrayList<ReviewMetricScore> metricScoreList = answerIdToMetricReviewScore.get(answerId);
        ReviewMetricScore reviewMetricScore;
        if (metricScoreList == null) {
            reviewMetricScore = new ReviewMetricScore(metricId, score);
            metricScoreList = new ArrayList<>();
            metricScoreList.add(reviewMetricScore);
            answerIdToMetricReviewScore.put(answerId, metricScoreList);

        } else {
            reviewMetricScore = new ReviewMetricScore(metricId, score);
            metricScoreList.add(reviewMetricScore);
        }

        AbstractAnswer answerData = answerIdsToAnswerData.get(answerId);
        if (answerData != null && answerData instanceof UserAnswer) {
            ((UserAnswer) answerData).addReviewId(reviewMetricScore.getId());
        }
    }



}

