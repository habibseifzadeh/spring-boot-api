package hello;

import org.springframework.data.repository.*;

public interface UserRepository extends CrudRepository<User, Integer> {

}