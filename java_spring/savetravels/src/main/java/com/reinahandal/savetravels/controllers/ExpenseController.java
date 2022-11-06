package com.reinahandal.savetravels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reinahandal.savetravels.models.Expense;
import com.reinahandal.savetravels.services.ExpenseService;


@Controller
@RequestMapping("/expenses")
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		model.addAttribute("expenses", expenseService.allExpenses());
		return "index.jsp";
	}
	
	// method that processes the form that creates new expense
	@PostMapping("/new")
	public String newExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("expenses", expenseService.allExpenses());
			return "index.jsp";
		}
		else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
    // renders a page with a form to edit expense
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
        return "edit.jsp";
    }
    
    // renders a page that shows details of a given expense
	@GetMapping("/{id}")
	public String showExpense(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
		return "show.jsp";
	}
	
    // method that updates a given expense
    @PutMapping("/{id}")
    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/expenses";
        }
    }
    
    // method that deletes a given expense
    @DeleteMapping("/{id}")
    public String destroy(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }
	
	
}
