package com.erica.quizapplication;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by schif_000 on 3/10/2016.
 */
public class LevelOneQs {

    public static void addQuestions(DbHelper dbHelper) {
        Question q1 = new Question("How many dragons does Daenery’s have", "0", "4", "2","3", "3");
        dbHelper.addQuestion(q1);
        Question q2 = new Question("What is the sigil of house Lannister","Rose","Lion","Stag","Mockingbird", "Lion");
        dbHelper.addQuestion(q2);
        Question q3 = new Question("Who is the youngest Stark child","Bran","Arya","Rickon","Tommen","Rickon");
        dbHelper.addQuestion(q3);
        Question q4 = new Question("Who was the lover of Renly Baratheon","Loras Tyrell","Margaery Tyrell","Brienne of Tarth","Tommen", "Loras Tyrell");
        dbHelper.addQuestion(q4);
        Question q5 = new Question("Who is the most trusted advisor of the King","The Master of Coin","The Hand of the King","Chief Advisor","Tommen", "The Hand of the King");
        dbHelper.addQuestion(q5);
        Question q6 = new Question("Where is Winterfell","The Crownlands","North of the Wall","The North","The West", "The North");
        dbHelper.addQuestion(q6);
        Question q7 = new Question("How many kingdoms are there in Westeros","6","7","8","4", "7");
        dbHelper.addQuestion(q7);
        Question q8 = new Question("Who are the Wardens of the West","The Lannisters","The Starks","The Freys", "The Tyrells", "The Lannisters");
        dbHelper.addQuestion(q8);
        Question q9 = new Question("Where is Brienne from?","The Reach","Qarth","Storm's End","Tarth","Tarth");
        dbHelper.addQuestion(q9);
        Question q10 = new Question("Jamie is Cersei’s...","Husband","Twin Brother","Father","Cousin","Twin Brother");
        dbHelper.addQuestion(q10);
        Question q11 = new Question("What does Ramsey Bolton take away from Theon","His manhood","His title","His money","his lunch", "His manhood");
        dbHelper.addQuestion(q11);
        Question q12 = new Question("Who sentences Ned Stark to death","Robert Baratheon","Tywin Lannister","John Arryn","Joffrey Baratheon","Joffrey Baratheon");
        dbHelper.addQuestion(q12);
        Question q13 = new Question("What is the capital of Westeros","Highgarden","King's Landing","Casterly Rock","Storm's End", "King's Landing");
        dbHelper.addQuestion(q13);
        Question q14 = new Question("Who helps Arya and her friends escape from Harrenhal","Jaqen h'ghar","Gendry","Tywin Lannister","Roose Bolton", "Jaqen h'ghar");
        dbHelper.addQuestion(q14);
        Question q15 = new Question("What god(s) do the Northerners follow","The Seven","The Drowned God","The Old Gods","The Great Other", "The Old Gods");
        dbHelper.addQuestion(q15);
        Question q16 = new Question("What were the last word of the Mad King?","Burn them all","End it quick","Traitor","I will burn you", "Burn them all");
        dbHelper.addQuestion(q16);
        Question q17 = new Question("What is Jamie Lannister commonly known as?","The Kinslayer","The Kingslayer","The Half-man","The Hand of the King", "The Kingslayer");
        dbHelper.addQuestion(q17);
        Question q18 = new Question("Where is the Iron Throne situated","The Sept of Baelor","Flea Bottom","The Dragon Pit","The Red Keep", "The Red Keep");
        dbHelper.addQuestion(q18);
        Question q19 = new Question("What the name of Ned Stark’s wife","Lysa","Cersei","Catelyn","Sansa", "Catelyn");
        dbHelper.addQuestion(q19);
        Question q20 = new Question("Who killed Ned Stark’s father?","The Wildlings","The Mad King","Roose Bolton","Jamie Lannister", "The Mad King");
        dbHelper.addQuestion(q20);
        Question q21 = new Question("Who pushes Bran from the tower at Winterfell?","Jamie Lannister","Cersei Lannister","Maester Luwin","Sansa Stark", "Jamie Lannister");
        dbHelper.addQuestion(q21);
    }

}
