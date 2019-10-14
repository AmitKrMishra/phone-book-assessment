package abc.phone.book.dao;

import org.springframework.data.repository.CrudRepository;

import abc.phone.book.transport.PhoneBook;

public interface PhoneBookRepository extends CrudRepository<PhoneBook, Integer> {

//	@Query(value = "SELECT s FROM PHONE_BOOK s WHERE s.NAME= :name")
//	PhoneBook findByName(@Param("name") String name);
//	
//	@Query(value = "SELECT s FROM PHONE_BOOK s WHERE s.PHONENUMBER= :phoneNumber")
//	PhoneBook findByNumber(@Param("phoneNumber") String phoneNumber);
}
