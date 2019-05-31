package com.example.ptitquiz.Model;

import java.io.Serializable;

public class QuestionNotify implements Serializable {
    private String question;
    private String answer;

    public QuestionNotify() {
    }

    public QuestionNotify(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
