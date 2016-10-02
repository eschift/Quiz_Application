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

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Quiz";

    // Table name
    private static final String TABLE_QUESTION = "question";

    // Table Columns names
    private static final String KEY_ID = "id";
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
                +KEY_OPT2 +" TEXT, "+KEY_OPT3 +" TEXT, "+KEY_OPT4+" TEXT)";

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
        Question q1 = new Question("How many dragons does Daenery’s have", "3", "0", "4", "2", "3");
        this.addQuestion(q1);
        Question q2 = new Question("What is the sigil of house Lannister","Lion","Rose","Stag","Mockingbird", "Lion");
        this.addQuestion(q2);
        Question q3 = new Question("Who is the youngest Stark child","Rickon","Bran","Arya","Tommen", "Rickon");
        this.addQuestion(q3);
        Question q4 = new Question("Who was the lover of Renly Baratheon","Loras Tyrell","Margaery Tyrell","Brienne of Tarth","Tommen", "Loras Tyrell");
        this.addQuestion(q4);
        Question q5 = new Question("Who is the most trusted advisor of the king","The Hand of the King","The Master of Coin","Chief Advisor","Tommen", "The Hand of the King");
        this.addQuestion(q5);
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
