package com.backendMarch.librarymanagementsytem.Repository;

import com.backendMarch.librarymanagementsytem.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
