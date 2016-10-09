package com.saluyot.masinop.Service;

import com.saluyot.masinop.model.Expense;
import com.saluyot.masinop.model.dao.ExpenseDao;

import java.util.List;

/**
 * Created by jerome on 9/21/2016.
 */
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseServiceImpl(){

    }

    public static ExpenseService expenseService(){
        return new ExpenseServiceImpl();
    }

    @Override
    public List<Expense> getByDate(String date) {
        return null;
    }
}
