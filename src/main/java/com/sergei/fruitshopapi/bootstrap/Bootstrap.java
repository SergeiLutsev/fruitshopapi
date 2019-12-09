package com.sergei.fruitshopapi.bootstrap;

import com.sergei.fruitshopapi.domain.Category;
import com.sergei.fruitshopapi.domain.Customer;
import com.sergei.fruitshopapi.domain.Vendor;
import com.sergei.fruitshopapi.repositories.CategoryRepository;
import com.sergei.fruitshopapi.repositories.CustomerRepository;
import com.sergei.fruitshopapi.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createCategory();
        createCustomer();
        createVendors();
    }

    private void createVendors() {
          createNewVendor("Western Tasty Fruits Ltd.");
          createNewVendor("Exotic Fruits Company");
          createNewVendor("Home Fruits");
          createNewVendor("Fun Fresh Fruits Ltd.");
          createNewVendor("Nuts for Nuts Company");
        System.out.println("Vendors loaded....: "+vendorRepository.count());
    }
    private void createNewVendor(String name){
        Vendor vendor=new Vendor();
        vendor.setName(name);
        vendorRepository.save(vendor);
    }

    private void createCustomer() {
       saveCustomer("Michael","test");
       saveCustomer("David","Winter");
       saveCustomer("Anne","Hine");
       saveCustomer("Alice","Eastman");
       saveCustomer("Freddie","Mercury");
       saveCustomer("Freddie","Mercury");
       saveCustomer("Fred","Keyers");
       saveCustomer("Freddie","Mercury");
       saveCustomer("Freddie","Mercury");
       saveCustomer("Joe","Buck");
        System.out.println("CUstomer data loaded: "+customerRepository.count());
    }

    private void saveCustomer(String fName, String sName) {
        Customer cust1=new Customer();
        cust1.setFirstName(fName);
        cust1.setSecondName(sName);
        customerRepository.save(cust1);
    }

    private void createCategory() {
        Category fruits=new Category();
        fruits.setName("Fruits");

        Category dried=new Category();
        dried.setName("Dried");

        Category fresh=new Category();
        fresh.setName("Fresh");

        Category exotic=new Category();
        exotic.setName("Exotic");

        Category nuts=new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Data loaded category count: "+categoryRepository.count());
    }
}
