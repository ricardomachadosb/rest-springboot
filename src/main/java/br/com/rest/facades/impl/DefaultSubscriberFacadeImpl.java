package br.com.rest.facades.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rest.converters.CategoryConverter;
import br.com.rest.converters.SubscriberConverter;
import br.com.rest.dtos.NewsLetterDTO;
import br.com.rest.dtos.NewsLetterNotificationDTO;
import br.com.rest.dtos.SubscriberDTO;
import br.com.rest.facades.SubscriberFacade;
import br.com.rest.models.BookModel;
import br.com.rest.models.CategoryModel;
import br.com.rest.models.SubscriberModel;
import br.com.rest.services.BookService;
import br.com.rest.services.SubscriberService;

@Component
public class DefaultSubscriberFacadeImpl implements SubscriberFacade{
	
	@Autowired
	private SubscriberConverter subscriberConverter;
	
	@Autowired
	private SubscriberService subscriberService;
	
	@Autowired
	private BookService bookService;
	
	@Override
	public SubscriberDTO createSubscriber(String email, Set<String> categoriesCodes) {
		SubscriberModel subscriberModel = subscriberService.createSubscriber(email, categoriesCodes);
		SubscriberDTO subscriberDto = subscriberConverter.convert(subscriberModel);
		return subscriberDto;
	}

	@Override
	public List<NewsLetterDTO> getNewsLetterForAllSubscribers() {
		List<NewsLetterDTO> newsLetters = new ArrayList<NewsLetterDTO>();
		List<SubscriberModel> allSubscribers = subscriberService.getAllSubscribers();
		List<BookModel> allBooks = bookService.getAllBooks();

		
		for(SubscriberModel sbsm: allSubscribers){
			NewsLetterDTO newsLetter = buildNewsLetterForSubscriber(allBooks, sbsm);
			newsLetters.add(newsLetter);
		}
		
		return newsLetters;
	}

	/**
	 * @param allBooks
	 * @param sbsm
	 * @return
	 */
	private NewsLetterDTO buildNewsLetterForSubscriber(List<BookModel> allBooks, SubscriberModel sbsm) {
		NewsLetterDTO newsLetter = new NewsLetterDTO(sbsm.getEmail());
		
		List<NewsLetterNotificationDTO> newsLetterNotifications = buildBooksNewsLetterNotificationsByCategory(allBooks, sbsm.getCategories());
		
		newsLetter.setRecipient(sbsm.getEmail());
		newsLetter.setNotifications(newsLetterNotifications);
		return newsLetter;
	}

	/**
	 * @param books
	 * @param newsLetterNotifications
	 * @param sbsCategory
	 */
	private List<NewsLetterNotificationDTO> buildBooksNewsLetterNotificationsByCategory(List<BookModel> books, List<CategoryModel> categories) {
		List<NewsLetterNotificationDTO> newsLetterNotifications = new ArrayList<NewsLetterNotificationDTO>();
		for(CategoryModel category: categories){
			for(BookModel bookModel: books){
				
				List<List<String>> categoriesPaths = buildCategoriesPaths(category, bookModel);
				
				if(!categoriesPaths.isEmpty()){
					NewsLetterNotificationDTO newsLetterNot = new NewsLetterNotificationDTO(bookModel.getTittle(), categoriesPaths);
					newsLetterNotifications.add(newsLetterNot);
				}
			}
		}
		return newsLetterNotifications;
	}

	/**
	 * @param subscriberCategory
	 * @param bookModel
	 * @return
	 */
	private List<List<String>> buildCategoriesPaths(CategoryModel subscriberCategory, BookModel bookModel) {
		List<List<String>> categoriesPaths = new ArrayList<List<String>>();
		
		for(CategoryModel bookCategory: bookModel.getCategories()){
			List<String> categoryPath = buildCategoryPath(bookCategory, subscriberCategory);
			
			if(!categoryPath.isEmpty()){
				categoriesPaths.add(categoryPath);
			}
		}
		
		return categoriesPaths;
	}

	private List<String> buildCategoryPath(CategoryModel bookCategory, CategoryModel subscriberCategory){
		List<String> categoryPath = new ArrayList<String>();
		boolean isUserSubscribedForCategory = false;
		
		CategoryModel currentCategory = bookCategory;
		while(currentCategory != null){
			String currentCategoryCode = currentCategory.getCode();
			categoryPath.add(0, currentCategoryCode);
			if(currentCategoryCode.equals(subscriberCategory.getCode())){
				isUserSubscribedForCategory = true;
				break;
			}
			currentCategory = currentCategory.getSuperCategory();
		}
		
		if(isUserSubscribedForCategory){
			return categoryPath;
		}
		return new ArrayList<String>();
	}

}
