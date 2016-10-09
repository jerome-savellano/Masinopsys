package com.saluyot.masinop;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.gc.materialdesign.views.ButtonFloat;
import com.saluyot.masinop.Util.DateUtil;
import com.saluyot.masinop.Util.Toaster;
import com.saluyot.masinop.model.DatabaseHelper.ExpenseHelper;
import com.saluyot.masinop.model.Expense;

import java.math.BigDecimal;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    ButtonFloat btnAdd;
    EditText passwordInput;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final ExpenseHelper expenseHelper = new ExpenseHelper(getActivity());

        btnAdd = (ButtonFloat) rootView.findViewById(R.id.buttonFloat);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MaterialDialog dialog = new MaterialDialog.Builder(getActivity())
                        .title("Hello")
                        .customView(R.layout.dialog_add_expense, true)
                        .positiveText("Add expense")
                        .negativeText(android.R.string.cancel)
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                Expense expense = new Expense();

                                expense.setDate(DateUtil.currentDateTime());
                                expense.setAmount(new BigDecimal(passwordInput.getText().toString()));
                                expense.setDescription("wowowee");

                                expenseHelper.addExpense(expense);
                            }
                        }).onNegative(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
                                List<Expense> expenses = expenseHelper.getAllExpenses();

                                for(Expense expense : expenses){
                                    Log.d("EXPENSES", String.valueOf(expense.getAmount()));
                                }
                            }
                        }).build();

                passwordInput = (EditText) dialog.getCustomView().findViewById(R.id.password);

                dialog.show();
            }
        });

        return rootView;
    }
}
