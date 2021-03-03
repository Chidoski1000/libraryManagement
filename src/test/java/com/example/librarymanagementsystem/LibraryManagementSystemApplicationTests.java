package com.example.librarymanagementsystem;

import com.example.librarymanagementsystem.models.Patron;
import com.example.librarymanagementsystem.repositories.PatronRepository;
import com.example.librarymanagementsystem.services.PatronService;
import com.example.librarymanagementsystem.services.serviceImpl.PatronServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class LibraryManagementSystemApplicationTests {

//    @Test
//    void contextLoads() {
//    }

    @Mock
    private PatronRepository patronRepository;

    @InjectMocks
    private PatronServiceImpl patronService;

    @Test
    public void addPatron(){
        Patron patron = new Patron();
        patron.setNameOfPatron("Hello");
        patron.setEmail("fghjkdf");
        patron.setPassword("dfgfds");
//        given(patronRepository.save(patron)).willReturn(patron);
        given(patronRepository.save(ArgumentMatchers.any(Patron.class))).willReturn(patron);
        Patron added = patronService.addPatron(patron);
        assertEquals(added.getNameOfPatron(), patron.getNameOfPatron());
        verify(patronRepository).save(patron);
    }

    @Test
    public void listEmployeeList(){
        List<Patron> patronList = new ArrayList<>();
        Patron patron = new Patron();
        patron.setNameOfPatron("Hello");
        patron.setEmail("fghjkdf");
        patron.setPassword("dfgfds");
        Patron patron1 = new Patron();
        patron1.setNameOfPatron("HelloWorld");
        patron1.setEmail("test");
        patron1.setPassword("driven");
        patronList.add(patron);
        patronList.add(patron1);
        given(patronRepository.save(ArgumentMatchers.any(Patron.class))).willReturn(patron);
        Patron pat = patronService.addPatron(patron);
        Patron pat1 = patronService.addPatron(patron);
        given(patronRepository.findAll()).willReturn(patronList);
//        List<Patron> listPatron = patronService.;
//        assertEquals(listPatron.size(), patronList.size());
        verify(patronRepository).findAll();
    }

}
