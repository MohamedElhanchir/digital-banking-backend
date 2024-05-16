package ma.enset.ebankingbackend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.ebankingbackend.dtos.CustomerDTO;
import ma.enset.ebankingbackend.exceptions.CustomerNotFoundException;
import ma.enset.ebankingbackend.services.BankAccountServiceDTO;
import ma.enset.ebankingbackend.services.BankAccountServiceImpl;
import ma.enset.ebankingbackend.services.BankAccountServiceImplDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Slf4j
public class CustomerRestControllerDTO {
    private final BankAccountServiceImplDTO bankAccountServiceImplDTO;
    private final BankAccountServiceImpl bankAccountServiceImpl;
    private BankAccountServiceDTO bankAccountServiceDTO;

    @GetMapping("/customers")
    public List<CustomerDTO> customers(){
        return bankAccountServiceDTO.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable(name = "id") Long customerId) throws CustomerNotFoundException {
        return bankAccountServiceDTO.getCustomer(customerId);
    }

    @PostMapping("/customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return bankAccountServiceDTO.saveCustomer(customerDTO);
    }

    @PutMapping("/customers/{customerId}")
    public CustomerDTO updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO){
        customerDTO.setId(customerId);
        return bankAccountServiceImplDTO.updateCustomer(customerDTO);
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id){
        bankAccountServiceImplDTO.deleteCustomer(id);
    }
    /*
    @GetMapping("/customers/search")
    public List<Customer> searchCustomers(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return bankAccountService.searchCustomers("%"+keyword+"%");
    }




     */

}
