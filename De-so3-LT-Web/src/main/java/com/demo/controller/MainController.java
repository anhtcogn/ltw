package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entitys.Book;
import com.demo.repository.BookRepository;

@Controller
@RequestMapping("")
public class MainController {

	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("")
	public String home (Model model, HttpSession session) {
		
		Book book0 = new Book("book0", "Lap trinh Web", "Nguyen Huy Hoang", "IT", 0);
		Book book1 = new Book("book1", "Lap trinh C++", "Nguyen Manh Hung", "IT", 0);
		Book book2 = new Book("book2", "Lap trinh Java", "Nguyen Manh Son", "IT", 1);
		Book book3 = new Book("book3", "Em va Trinh", "Trinh Cong Son", "Music", 0);
		Book book4 = new Book("book4", "Papparika", "Kenshi Yonezu", "Music", 1);
		Book book5 = new Book("book5", "Garden of Flower", "Yurima", "Music", 0);
		Book book6 = new Book("book6", "My Girl", "Wiz Khalif", "Loved", 0);
		
		bookRepository.save(book0);
		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);
		bookRepository.save(book4);
		bookRepository.save(book5);
		bookRepository.save(book6);
		
		Book book = new Book();
		
		if (session.getAttribute("bookSearch") != null)
			book = (Book) session.getAttribute("bookSearch");
			
		model.addAttribute("book", book);
		return "home.html";
	}
	
	@PostMapping("")
	public String homePost (Model model, 
			@ModelAttribute("book") Book book, HttpSession session) {
		
		session.setAttribute("bookSearch", book);
		
		List<Book> listBooks = bookRepository.findAll();
		List<Book> resultSearch = new ArrayList<Book>();
		
		for (Book i : listBooks) {
			if (i.getBookCode().contains(book.getBookCode())
					&& i.getAuthor().contains(book.getAuthor())
					&& i.getCategory().contains(book.getCategory())
							&& i.getTitle().contains(book.getTitle())){
						resultSearch.add(i);
					}
		}
		
		model.addAttribute("listSearch", resultSearch);
		
		return "search-list.html";
	}
	
	@GetMapping("/booked/{id}")
	public String booked (Model model, 
			@PathVariable("id") Long id) {
		
		Book book = bookRepository.findById(id).get();
		
		book.setBooked(1);
		bookRepository.save(book);
		
		return "redirect:/";
	}
	
}
