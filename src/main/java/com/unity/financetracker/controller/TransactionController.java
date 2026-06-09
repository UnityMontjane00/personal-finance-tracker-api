package com.unity.financetracker.controller;

import com.unity.financetracker.entity.Transaction;
import com.unity.financetracker.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public Transaction createTransaction(
            @RequestBody Transaction transaction) {

        return service.saveTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return service.getAllTransactions();
    }
    @GetMapping("/income")
    public Double getTotalIncome() {
        return service.getTotalIncome();
    }
    @GetMapping("/expenses")
    public Double getTotalExpenses() {
        return service.getTotalExpenses();
    }
    @GetMapping("/balance")
    public Double getBalance() {
        return service.getBalance();
    }
    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return service.getTransactionById(id);
    }
    @PutMapping("/{id}")
    public Transaction updateTransaction(
            @PathVariable Long id,
            @RequestBody Transaction transaction) {

        return service.updateTransaction(id, transaction);
    }
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {

        service.deleteTransaction(id);
    }
    @GetMapping("/category/{category}")
    public List<Transaction> getTransactionsByCategory(
            @PathVariable String category) {

        return service.getTransactionsByCategory(category);
    }
    @GetMapping("/month/{month}")
    public List<Transaction> getTransactionsByMonth(
            @PathVariable int month) {

        return service.getTransactionsByMonth(month);
    }
}
