package ma.enset.ebankingbackend.repositories;



import ma.enset.ebankingbackend.entities.AccountOperation;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
  List<AccountOperation> findByBankAccountId(String accountId);
 // Page<AccountOperation> findByBankAccountIdOrderByOperationDateDesc(String accountId, Pageable pageable);
}
