package com.yedam.app.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.book.mapper.BookMapper;
import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;

@Service 
public class BookServiceImpl implements BookService{
	@Autowired
	BookMapper bookMapper;
	
	@Override
	public List<BookVO> bookList(){
		return bookMapper.seleteBookAll();
	}

	@Override
	public int insertBook(BookVO bookVO) {
		int result = bookMapper.insertBookInfo(bookVO);
		
		if(result == 1) {
			return bookVO.getBookNo();
		}else {
			return -1;
		}
	}
}
