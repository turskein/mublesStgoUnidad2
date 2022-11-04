package tingeso.uploadtimestamps.repositories;

import tingeso.uploadtimestamps.entities.TimestampEntity;
import lombok.Generated;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Generated
public interface TimestampRepository extends CrudRepository<TimestampEntity, Long>{
    @Query(
            value = "SELECT * FROM timestamp WHERE id_staff = ?1 AND date =?2 ORDER BY time ASC",
            nativeQuery = true
    )
    List<TimestampEntity> findByIdStaffAndDate(Long idStaff, Date date);
}
