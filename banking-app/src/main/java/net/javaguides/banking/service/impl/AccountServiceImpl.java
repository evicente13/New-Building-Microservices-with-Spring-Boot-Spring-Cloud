package net.javaguides.banking.service.impl;

import net.javaguides.banking.dto.AccountDTO;
import net.javaguides.banking.entity.Account;
import net.javaguides.banking.mapper.AccountMapper;
import net.javaguides.banking.repository.AccountRepository;
import net.javaguides.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = AccountMapper.MAPPER.mapAccountDTOToAccount(accountDTO);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.MAPPER.mapAccountToAccountDTO(savedAccount);
    }

    @Override
    public AccountDTO getAccountById(Long id) {

        Account account = accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Account does not exists")
        );
        return AccountMapper.MAPPER.mapAccountToAccountDTO(account);
    }

    @Override
    public AccountDTO deposit(Long id, double amount) {

        Account account = accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Account does not exists")
        );

        account.setBalance(account.getBalance() + amount);
        Account savedAccount =  accountRepository.save(account);
        return AccountMapper.MAPPER.mapAccountToAccountDTO(savedAccount);
    }

    @Override
    public AccountDTO withdraw(Long id, double amount) {

        Account account = accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Account does not exists")
        );

        if(account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }else{
            account.setBalance(account.getBalance()- amount);
        }

        Account savedAccount =  accountRepository.save(account);
        return AccountMapper.MAPPER.mapAccountToAccountDTO(savedAccount);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account -> AccountMapper.MAPPER.mapAccountToAccountDTO(account)))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccountById(Long id) {

        Account account = accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Account does not exists")
        );

        accountRepository.deleteById(id);
    }
}
