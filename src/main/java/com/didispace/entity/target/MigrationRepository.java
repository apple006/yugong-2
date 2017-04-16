package com.didispace.entity.target;

import com.didispace.entity.target.Migration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MigrationRepository extends JpaRepository<Migration, Long> {

//    Migration findByTableName(String name);

}
