package br.com.rest.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.rest.controllers.CategoryController;
import br.com.rest.dtos.CategoryDTO;
import br.com.rest.facades.CategoryFacade;

@RunWith(SpringRunner.class)
@WebMvcTest(value= CategoryController.class, secure = false)
public class CategoryControllerTest {
	
	@MockBean
	private CategoryFacade categoryFacade;
	
	@Autowired
	private MockMvc mockMvc;
	
	CategoryDTO mockedCategoryDto = new CategoryDTO("code1", "tittle1", null);
	
	@Test
	public void testCreateCategoryWithWoutPassingParams() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/categories").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
	}
	
	@Test
	public void testCreateCategory() throws Exception {
		Mockito.when(categoryFacade.createCategory(Mockito.anyString(), Mockito.anyString(), Mockito.anyObject()))
		.thenReturn(mockedCategoryDto);
		
		String exampleCategoryJson = "{\"code\": \"science\",\"tittle\": \"science\",\"superCategoryCode\": null}";
		String expected = "{\"code\": \"code1\",\"tittle\": \"tittle1\"}";

		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/categories").accept(MediaType.APPLICATION_JSON)
				.content(exampleCategoryJson).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
}
