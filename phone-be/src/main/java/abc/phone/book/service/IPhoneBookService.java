package abc.phone.book.service;

import abc.phone.book.transport.PhoneBookInfo;
import abc.phone.book.transport.PhoneBookRequest;

/** This interface defines method for phone book operation. 
 * @author AMIT
 */
public interface IPhoneBookService {

	
	/**This method will return all the phone information.
	 * @param phoneBookRequest
	 * @return PhoneBookInfo
	 */
	public PhoneBookInfo getPhoneBookInfo(PhoneBookRequest phoneBookRequest);
	
	/** This method add phone information.
	 * @return string status
	 */
	public String addPhoneBookInfo(PhoneBookRequest phoneBookRequest);

}
