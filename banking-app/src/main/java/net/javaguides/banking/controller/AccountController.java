package net.javaguides.banking.controller;

import net.javaguides.banking.dto.AccountDTO;
import net.javaguides.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO) {
        AccountDTO accountCreate = accountService.createAccount(accountDTO);
        return new ResponseEntity<>(accountCreate, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> addAccount(@PathVariable Long id) {
        AccountDTO accountCreate = accountService.getAccountById(id);
        return new ResponseEntity<>(accountCreate, HttpStatus.OK);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDTO> deposit(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        AccountDTO accountCreate = accountService.deposit(id, amount);
        return new ResponseEntity<>(accountCreate, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDTO> withdraw(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        AccountDTO accountCreate = accountService.withdraw(id, amount);
        return new ResponseEntity<>(accountCreate, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> addAccount() {
        List<AccountDTO> AccountsDTO = accountService.getAllAccounts();
        return new ResponseEntity<>(AccountsDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccountById(id);
        return new ResponseEntity<>("Account is Delete Successfully!", HttpStatus.OK);
    }

}
