package com.eduardocp.lunaexambuilder.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Eduardo on 06/06/2017.
 */
@XmlRootElement
public class Exam {
	@XmlAttribute
	public String title;
	@XmlAttribute
	public String author;
	@XmlElement(name = "question")
	public List<Question> questions = new ArrayList<>();

	public Exam(){}

	public Exam(String title, String author) {
		this.title = title;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Exam{" +
				"title='" + title + '\'' +
				", author='" + author + '\'' +
				", questions=" + questions +
				'}';
	}

	public void addQuestion(Question question){questions.add(question);}

	public void addQuestion(String title, int correct, String... options){
		questions.add(new Question(title,correct,options));
	}

	public void addQuestion(String title, int value,int correct, String... options){
		questions.add(new Question(title,value,correct,options));
	}

	public void shuffle(){Collections.shuffle(questions);}

	/**
	 * getPretty
	 *
	 * Returns a pretty version of the exam in a String.
	 */
	public String getPretty(){
		String pretty = title + "\r\n" + "Author: " + author + "\r\n";
		int i = 1;
		for (Question q: questions) {pretty+= i + ".-" + q.getTitle() + "\r\n" + q.getPrettyOptions() + "\r\n";i++;}
		return pretty;
	}

	public String getAnswers() {
		String answers = "";
		int i = 1;
		for (Question question: questions) {answers += i + question.getCorrectLetter();i++;}
		return answers;
	}
}
