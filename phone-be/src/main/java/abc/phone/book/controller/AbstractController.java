package abc.phone.book.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractController {

	protected final ObjectMapper mapper;

	public AbstractController() {
		mapper = new ObjectMapper();
	}

}
