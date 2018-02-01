package hello;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "addressBooks", path = "addressBooks")
public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
}
