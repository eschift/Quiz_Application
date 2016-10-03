package com.erica.quizapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by schif_000 on 2/10/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 7;

    // Database Name
    private static final String DATABASE_NAME = "Quiz";

    // Table name
    private static final String TABLE_QUESTION = "question";

    // Table Columns names
    private static final String KEY_ID = "_id";
    private static final String KEY_QUESTION = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPT1= "opta"; //option a
    private static final String KEY_OPT2= "optb"; //option b
    private static final String KEY_OPT3= "optc"; //option c
    private static final String KEY_OPT4= "optd"; //option d

    private SQLiteDatabase myDatabase;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        myDatabase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTION + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESTION
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPT1 +" TEXT, "
                +KEY_OPT2 +" TEXT, "+KEY_OPT3 +" TEXT, "+KEY_OPT4 +" TEXT )";

        db.execSQL(sql);

        addQuestions();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION);

        // Create tables again
        onCreate(db);
    }

    public int rowCount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }

    private void addQuestions() {
        Question q1 = new Question("How many dragons does Daenery’s have", "0", "4", "2","3", "3");
        this.addQuestion(q1);
        Question q2 = new Question("What is the sigil of house Lannister","Rose","Lion","Stag","Mockingbird", "Lion");
        this.addQuestion(q2);
        Question q3 = new Question("Who is the youngest Stark child","Bran","Arya","Rickon","Tommen","Rickon");
        this.addQuestion(q3);
        Question q4 = new Question("Who was the lover of Renly Baratheon","Loras Tyrell","Margaery Tyrell","Brienne of Tarth","Tommen", "Loras Tyrell");
        this.addQuestion(q4);
        Question q5 = new Question("Who is the most trusted advisor of the King","The Master of Coin","The Hand of the King","Chief Advisor","Tommen", "The Hand of the King");
        this.addQuestion(q5);
        Question q6 = new Question("Where is Winterfell","The Crownlands","North of the Wall","The North","The West", "The North");
        this.addQuestion(q6);
        Question q7 = new Question("How many kingdoms are there in Westeros","6","7","8","4", "7");
        this.addQuestion(q7);
        Question q8 = new Question("Who are the Wardens of the West","The Lannisters","The Starks","The Freys", "The Tyrells", "The Lannisters");
        this.addQuestion(q8);
        Question q9 = new Question("Where is Brienne from?","The Reach","Qarth","Storm's End","Tarth","Tarth");
        this.addQuestion(q9);
        Question q10 = new Question("Jamie is Cersei’s...","Husband","Twin Brother","Father","Cousin","Twin Brother");
        this.addQuestion(q10);
        Question q11 = new Question("What does Ramsey Bolton take away from Theon","His manhood","His title","His money","his lunch", "His manhood");
        this.addQuestion(q11);
        Question q12 = new Question("Who sentences Ned Stark to death","Robert Baratheon","Tywin Lannister","John Arryn","Joffrey Baratheon","Joffrey Baratheon");
        this.addQuestion(q12);
        Question q13 = new Question("What is the capital of Westeros","Highgarden","King's Landing","Casterly Rock","Storm's End", "King's Landing");
        this.addQuestion(q13);
        Question q14 = new Question("Who helps Arya and her friends escape from Harrenhal","Jaqen h'ghar","Gendry","Tywin Lannister","Roose Bolton", "Jaqen h'ghar");
        this.addQuestion(q14);
        Question q15 = new Question("What god(s) do the Northerners follow","The Seven","The Drowned God","The Old Gods","The Great Other", "The Old Gods");
        this.addQuestion(q15);
        Question q16 = new Question("What were the last word of the Mad King?","Burn them all","End it quick","Traitor","I will burn you", "Burn them all");
        this.addQuestion(q16);
        Question q17 = new Question("What is Jamie Lannister commonly known as?","The Kinslayer","The Kingslayer","The Half-man","The Hand of the King", "The Kingslayer");
        this.addQuestion(q17);
        Question q18 = new Question("Where is the Iron Throne situated","The Sept of Baelor","Flea Bottom","The Dragon Pit","The Red Keep", "The Red Keep");
        this.addQuestion(q18);
        Question q19 = new Question("What the name of Ned Stark’s wife","Lysa","Cersei","Catelyn","Sansa", "Catelyn");
        this.addQuestion(q19);
        Question q20 = new Question("Who killed Ned Stark’s father?","The Wildlings","The Mad King","Roose Bolton","Jamie Lannister", "The Mad King");
        this.addQuestion(q20);
        Question q21 = new Question("Who pushes Bran from the tower at Winterfell?","Jamie Lannister","Cersei Lannister","Maester Luwin","Sansa Stark", "Jamie Lannister");
        this.addQuestion(q21);
    }

    public void addQuestion(Question quest) {

        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION, quest.getQuestion());
        values.put(KEY_ANSWER, quest.getAnswer());
        values.put(KEY_OPT1, quest.getOption1());
        values.put(KEY_OPT2, quest.getOption2());
        values.put(KEY_OPT3, quest.getOption3());
        values.put(KEY_OPT4, quest.getOption4());

        // Inserting Row
        myDatabase.insert(TABLE_QUESTION, null, values);
    }


    public List<Question> getAllQuestions() {

        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION;
        myDatabase=this.getReadableDatabase();

        Cursor cursor = myDatabase.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQuestion(cursor.getString(1));
                quest.setAnswer(cursor.getString(2));
                quest.setOption1(cursor.getString(3));
                quest.setOption2(cursor.getString(4));
                quest.setOption3(cursor.getString(5));
                quest.setOption4(cursor.getString(6));

                quesList.add(quest);

            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

}
