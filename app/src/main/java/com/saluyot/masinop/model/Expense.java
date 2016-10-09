package com.saluyot.masinop.model;

        import java.math.BigDecimal;
        import java.util.Date;

/**
 * Created by jerome on 9/21/2016.
 */
public class Expense {

    private String date;
    private BigDecimal amount;
    private String description;

    public Expense(){

    }

    public Expense(String date, BigDecimal amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
