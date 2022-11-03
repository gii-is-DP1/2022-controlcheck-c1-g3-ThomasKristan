package org.springframework.samples.petclinic.recoveryroom;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer> {
    @Query("SELECT rr FROM RecoveryRoom rr")
    List<RecoveryRoom> findAll();
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);

    @Query("SELECT rrt FROM RecoveryRoomType rrt WHERE rrt.name = ?1")
    RecoveryRoomType findRecoveryRoomTypeByName(String name);

    @Query("SELECT rrt FROM RecoveryRoomType rrt")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    //RecoveryRoomType getRecoveryRoomType(String name);
}

