package com.didispace;

import com.didispace.entity.source.Alarm;
import com.didispace.entity.source.AlarmRepository;
import com.didispace.entity.target.AlarmTarget;
import com.didispace.entity.target.Migration;
import com.didispace.entity.target.MigrationRepository;
import com.didispace.entity.target.TargetUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTests {

	@Autowired
	private AlarmRepository alarmRepository;
	@Autowired
	private AlarmTarget alarmTarget;
	@Autowired
	private MigrationRepository migrationRepository;
	@Autowired
	private TargetUser targetUser;
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	@Before
	public void setUp() {
	}

	@Test
	public void test()
	{
//		Iterable<User> itSource= userRepository.findAll();
//		Long id = 11l;
//		//从源数据库中查询出数据并存到目标数据中
//		for (User userSource2 : itSource) {
//			System.out.println("user "+userSource2.getName());
//			com.didispace.entity.target.User userTarget=new com.didispace.entity.target.User();
//			userTarget.setId(id);
//			id+=1;
//			userTarget.setName(userSource2.getName());
//			userTarget.setAge(userSource2.getAge());
//			targetUser.save(userTarget);
//		}
	}

	@Test
	public void reportCurrentTime() {
		System.out.println("The time is now " + dateFormat.format(new Date()));
		Migration migration = migrationRepository.findOne(1l);
		Iterable<Alarm> itSource;
		if (migration == null){
			PageRequest pageRequest = new PageRequest(1, 1000, Sort.Direction.ASC, "ID");
			itSource= alarmRepository.findAll(pageRequest);
			Migration migration1 = new Migration();
			migration1.setId(1l);
			migration1.setPageNum(1);
			migration1.setPageSize(1000);
			migration1.setTableName("alarm");
			migrationRepository.save(migration1);
		}else {

			PageRequest pageRequest = new PageRequest(migration.getPageNum()+1, migration.getPageSize(), Sort.Direction.ASC, "ID");
			migration.setPageNum(migration.getPageNum()+1);
			migrationRepository.save(migration);
			itSource= alarmRepository.findAll(pageRequest);
		}
		//从源数据库中查询出数据并存到目标数据中
		Long num = 1l;
		for (Alarm alarm2 : itSource) {
			System.out.println("id "+alarm2.getDEVICE_ID());
			com.didispace.entity.target.Alarm alarm=new com.didispace.entity.target.Alarm();
			alarm.setDEVICE_ID(alarm2.getDEVICE_ID());
			alarm.setFIRST_OCCURENCE(alarm2.getFIRST_OCCURENCE());
			num+=1;
			alarm.setId(num);
			alarmTarget.save(alarm);
		}
	}
}
