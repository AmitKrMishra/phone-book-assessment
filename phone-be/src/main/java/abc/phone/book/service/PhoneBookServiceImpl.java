package abc.phone.book.service;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abc.phone.book.dao.PhoneBookRepository;
import abc.phone.book.transport.PhoneBook;
import abc.phone.book.transport.PhoneBookInfo;
import abc.phone.book.transport.PhoneBookRequest;
import abc.phone.book.utils.PhoneBookConstants;

/**
 * Implementation of operation related to phone book.
 *
 */
@Service
public class PhoneBookServiceImpl extends AbstractPhoneDBClientConnection implements IPhoneBookService {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
//	private Predicate<ELkRepositoryMetaData> chkRepositoryName = obj -> (obj.getName() != null
//			&& obj.getName().startsWith(PhoneBookConstants.ARCHIVE_ES_DATA, 0));

	@Autowired
	private PhoneBookRepository phoneBookRepository;

	@Override
	public PhoneBookInfo getPhoneBookInfo(PhoneBookRequest phoneBookRequest) {
		logger.debug("Inside getPhoneBookInfo");
		Iterable<PhoneBook> phoneRepoObj= phoneBookRepository.findAll();
		PhoneBookInfo pbInfo= new PhoneBookInfo();
		List<PhoneBook> phone = new ArrayList<>();
		for (PhoneBook phoneBook : phoneRepoObj) {
			PhoneBook pb = new PhoneBook();
			pb.setName(phoneBook.getName());
			pb.setPhoneNumber(phoneBook.getPhoneNumber());
			phone.add(pb);
		}
		pbInfo.setPhone(phone);
		return pbInfo;
	}

	@Override
	public String addPhoneBookInfo(PhoneBookRequest phoneBookRequest) {
		logger.debug("Inside addPhoneBookInfo");
		phoneBookRepository.save(phoneBookRequest.getPhoneInfo());
		return PhoneBookConstants.SUCCESS;
	}


}
