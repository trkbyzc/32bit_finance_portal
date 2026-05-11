package com.otuzikibit.finance_portal.unitofwork;

import com.otuzikibit.finance_portal.repository.AccountRepository;
import com.otuzikibit.finance_portal.repository.TransactionRepository;
import com.otuzikibit.finance_portal.repository.UserRepository;
import com.otuzikibit.finance_portal.repository.PortfolioItemRepository;

public interface IUnitOfWork {
    AccountRepository getAccounts();
    TransactionRepository getTransactions();
    UserRepository getUsers();
    PortfolioItemRepository getPortfolioItems(); // YENİ EKLENEN

    void commit();
}