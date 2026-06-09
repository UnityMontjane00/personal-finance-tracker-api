package com.unity.financetracker.service;

import com.unity.financetracker.Transaction;
import com.unity.financetracker.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction saveTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }
    public Double getTotalIncome() {

        return repository.findAll()
                .stream()
                .filter(t -> t.getType().equalsIgnoreCase("INCOME"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
    public Double getTotalExpenses() {

        return repository.findAll()
                .stream()
                .filter(t -> t.getType().equalsIgnoreCase("EXPENSE"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
    public Double getBalance() {

        return getTotalIncome() - getTotalExpenses();
    }
    public Transaction getTransactionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }
    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {

        Transaction existingTransaction = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        existingTransaction.setDescription(updatedTransaction.getDescription());
        existingTransaction.setAmount(updatedTransaction.getAmount());
        existingTransaction.setCategory(updatedTransaction.getCategory());
        existingTransaction.setType(updatedTransaction.getType());
        existingTransaction.setTransactionDate(updatedTransaction.getTransactionDate());

        return repository.save(existingTransaction);
    }
    public void deleteTransaction(Long id) {

        Transaction transaction = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        repository.delete(transaction);
    }public List<Transaction> getTransactionsByCategory(String category) {

        return repository.findByCategory(category);
    }
    public List<Transaction> getTransactionsByMonth(int month) {

        return repository.findAll()
                .stream()
                .filter(t -> t.getTransactionDate()
                        .getMonthValue() == month)
                .toList();
    }

}