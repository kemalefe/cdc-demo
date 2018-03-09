package demo;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cdc.demo.Book;
import com.cdc.demo.BookController;
import com.cdc.demo.BookRepository;
import com.cdc.demo.DemoApplication;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public abstract class BaseTestClass {

	@Autowired
	BookController bookRestController;

	@MockBean
	BookRepository bookRepository;

	@Before
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(bookRestController);
		
		Mockito.when(bookRepository.findOne(1L)).thenReturn(new Book(1L,"Nutuk", "Gazi M.Kemal Atatürk", 20.00d));
		
		Mockito.when(bookRepository.save(ArgumentMatchers.any())).thenReturn(new Book(2L, "Fi","Azra Kohen", 18.00d));
		
		Mockito.when(bookRepository.update(ArgumentMatchers.eq(3L), ArgumentMatchers.any())).thenReturn(new Book(3L, "1984","George Orwell", 40.00d));
	}

}