package net.javaguides.banking.mapper;

import net.javaguides.banking.dto.AccountDTO;
import net.javaguides.banking.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper MAPPER = Mappers.getMapper(AccountMapper.class);

    AccountDTO mapAccountToAccountDTO(Account account);

    Account mapAccountDTOToAccount(AccountDTO accountDTO);

}
