package abc.phone.book.controller;

import java.lang.invoke.MethodHandles;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import abc.phone.book.service.IPhoneBookService;
import abc.phone.book.transport.ErrorDetails;
import abc.phone.book.transport.ErrorTransport;
import abc.phone.book.transport.PhoneBookInfo;
import abc.phone.book.transport.PhoneBookRequest;
import abc.phone.book.utils.PhoneBookConstants;
import io.swagger.annotations.ApiOperation;

/**
 * Operation related to Phone Book. Like Add, get list information.
 */
@RestController
public class PhoneBookServiceController extends AbstractController {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	IPhoneBookService phoneBookService;

	@CrossOrigin
	@ApiOperation(value = "Get all the list of phone book information.")
	@RequestMapping(value = PhoneBookConstants.GET_ALL_PHONE_INFO, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PhoneBookInfo> getPhoneBookInfo(PhoneBookRequest phoneBookRequest) throws Exception {
		logger.debug("Inside getPhoneBookInfo Service");
		PhoneBookInfo phoneBookInfoResponse = phoneBookService.getPhoneBookInfo(phoneBookRequest);
		logger.debug("method call ended.");
		return new ResponseEntity<PhoneBookInfo>(phoneBookInfoResponse, null, HttpStatus.OK);
	}

	@CrossOrigin
	@ApiOperation(value = "Add to phone book.")
	@RequestMapping(value = PhoneBookConstants.ADD_PHONE_INFO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addPhoneBookInfo(@RequestBody PhoneBookRequest phoneBookRequest) throws Exception {
		logger.debug("Inside addPhoneBookInfo");
		String repositoryStatus = phoneBookService.addPhoneBookInfo(phoneBookRequest);
		logger.debug("method call ended.");
		return new ResponseEntity<String>(repositoryStatus, null, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ErrorTransport.class)
	public ResponseEntity<ErrorDetails> handleTransportError(ErrorTransport ex, WebRequest request) {
		logger.error("IOException handler executed");
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleException(Exception ex, WebRequest request) {
		logger.error("IOException handler executed");
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.SERVICE_UNAVAILABLE);
	}

}
