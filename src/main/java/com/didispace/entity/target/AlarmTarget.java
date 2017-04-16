package com.didispace.entity.target;

import com.didispace.entity.target.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmTarget extends JpaRepository<Alarm, Long> {


}
