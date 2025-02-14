package com.mehru.roomlibraryexa;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoExpense {

    @Query ("SELECT * FROM  expenses")
    List<Expense> getExpense();

    @Insert

    void addTransaction (Expense expense);

    @Update
    void updateTransaction (Expense expens );

    @Delete
    void deleteTransaction (Expense expens);
}
