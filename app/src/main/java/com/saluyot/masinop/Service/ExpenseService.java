package com.saluyot.masinop.Service;

import com.saluyot.masinop.model.Expense;

import java.util.List;

/**
 * Created by jerome on 9/21/2016.
 */
public interface ExpenseService {

    List<Expense> getByDate(String date);

}
