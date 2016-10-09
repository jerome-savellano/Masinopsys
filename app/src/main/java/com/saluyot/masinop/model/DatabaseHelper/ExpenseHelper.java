package com.saluyot.masinop.model.DatabaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.saluyot.masinop.Util.Toaster;
import com.saluyot.masinop.model.Expense;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerome on 10/7/2016.
 */
public class ExpenseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String EXPENSE_TABLE_NAME = "expense";

    private static final String KEY_ID = "id";
    private static final String KEY_DATE = "date";
    private static final String KEY_AMOUNT = "amount";
    private static final String KEY_DESCRIPTION = "description";
    private static final String EXPENSE_TABLE_CREATE = "CREATE TABLE " + EXPENSE_TABLE_NAME
            + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_DATE + " TEXT, " + KEY_AMOUNT + " TEXT, "
            + KEY_DESCRIPTION + " TEXT)";


    public ExpenseHelper(Context context) {
        super(context, EXPENSE_TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EXPENSE_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EXPENSE_TABLE_NAME);
        onCreate(db);
    }

    public void addExpense(Expense expense){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DATE, expense.getDate());
        values.put(KEY_AMOUNT, String.valueOf(expense.getAmount()));
        values.put(KEY_DESCRIPTION, expense.getDescription());

        db.insert(EXPENSE_TABLE_NAME, null, values);
        db.close();

        Log.d("WOWOWEEWOWOWEEWOWOWEE", "SUCESSFULLY INSERTED");
    }

    public List<Expense> getAllExpenses(){
        List<Expense> expenses = new ArrayList<>();

        String getExpenses = "SELECT * FROM " + EXPENSE_TABLE_NAME + " ORDER BY datetime("+KEY_DATE+") DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(getExpenses, null);

        if(cursor.moveToFirst()){
            do{
                Expense expense = new Expense();
                expense.setDate(cursor.getString(1));
                expense.setAmount(new BigDecimal(cursor.getString(2)));
                expense.setDescription(cursor.getString(3));

                expenses.add(expense);
            }while(cursor.moveToNext());
        }

        return expenses;
    }
}
