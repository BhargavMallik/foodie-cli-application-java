import com.bhargav.foodiecliapp.repository.CustomerRepository;
import com.bhargav.foodiecliapp.util.CsvReader;

import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {

        /*CsvReader csvReader = new CsvReader();
        System.out.println(csvReader.readCustomersFromCsv());
         */

        CustomerRepository customerRepository = new CustomerRepository();
        System.out.println(customerRepository.getAllCustomers());
    }
}
