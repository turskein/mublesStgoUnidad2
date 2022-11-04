package tingeso.uploadtimestamps.repositories;

import tingeso.uploadtimestamps.entities.TimestampEntity;
import lombok.Generated;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Generated
public interface TimestampRepository extends CrudRepository<TimestampEntity, Long>{
}
