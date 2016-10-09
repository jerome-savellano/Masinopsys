package com.saluyot.masinop.model.dao;

import com.saluyot.masinop.model.Expense;

import java.util.Date;
import java.util.List;

/**
 * Created by jerome on 9/21/2016.
 */
public interface ExpenseDao {

    List<Expense> getByDate(Date date);
    Expense getExpense();

    void insertExpense();
    void updateExpense();
    void deleteExpense();
}
