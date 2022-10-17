package com.example.consultactivity.util;

import com.example.consultactivity.bean.Question;

import java.util.ArrayList;
import java.util.List;

public class GetService {
    private String[] questionContent = new String[]{"555分高考哪个学校好？","江西哪个学校最好？","今年理工560分能考进江西财经大学吗？"};

    private String[] questionTime = new String[]{"2016-1-25 03:55","2016-2-2 13:50","2015-1-1 18:30"};

    private String[] answerContent = new String[]{"江西财经大学金融学可以的","江西财经大学录取分数最高#南昌大学是211","差不多有些风险#最好的专业进不了"};

    private String[] answerTime = new String[]{"2016-1-25 06:55","2016-2-2 16:31#2016-2-3 18:30","2015-1-1 16:31#2015-1-2 13:22"};

    public List<Question> setQuestionList(){
        List<Question> questionList = new ArrayList<>();

        for (int i = 0; i < questionContent.length; i++) {
            Question question = new Question();
            question.setQuestionContent(questionContent[i]);
            question.setQuestionTime(questionTime[i]);
            question.setAnswerContent(answerContent[i]);
            question.setAnswerTime(answerTime[i]);
            questionList.add(question);
        }



        return questionList;
    }
}
