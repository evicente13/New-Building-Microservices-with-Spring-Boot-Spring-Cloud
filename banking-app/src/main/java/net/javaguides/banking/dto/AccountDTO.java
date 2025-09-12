package net.javaguides.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
@Data
@AllArgsConstructor
public class AccountDTO {
    private Long id;
    private String accountHolderName;
    private double balance;
}
*/

public record AccountDTO(Long id, String accountHolderName, double balance) {

}
