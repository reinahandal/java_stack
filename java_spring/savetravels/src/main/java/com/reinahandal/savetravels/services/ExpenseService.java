package com.reinahandal.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reinahandal.savetravels.models.Expense;
import com.reinahandal.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository=expenseRepository;
	}
	// returns all expenses
	public List<Expense> allExpenses(){
		return expenseRepository.findAll();
	}
	// creates expense
	public Expense createExpense(Expense exp) {
		return expenseRepository.save(exp);
	}
	// retrieves expense
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	// updates expense
	public Expense updateExpense(Expense exp) {
		return expenseRepository.save(exp);
	}
    // deletes expense
    public void deleteExpense(Long id) {
    	expenseRepository.deleteById(id);
    }
}
