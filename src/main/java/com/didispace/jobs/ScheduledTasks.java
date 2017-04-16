//package com.didispace.jobs;
//
//import com.didispace.entity.target.Migration;
//import com.didispace.entity.source.Alarm;
//import com.didispace.entity.source.AlarmRepository;
//import com.didispace.entity.target.AlarmTarget;
//import com.didispace.entity.target.MigrationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//@Component
//public class ScheduledTasks {
//    @Autowired
//    private AlarmRepository alarmRepository;
//    @Autowired
//    private AlarmTarget alarmTarget;
//    @Autowired
//    private MigrationRepository migrationRepository;
//
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//    @Scheduled(fixedDelay = 60000)//执行完1分钟后
//    public void reportCurrentTime() {
//        System.out.println("The time is now " + dateFormat.format(new Date()));
//        Migration migration = migrationRepository.findByTableName("alarm");
//        Iterable<Alarm> itSource;
//        if (migration == null){
//            PageRequest pageRequest = new PageRequest(1, 1000, Direction.ASC, "id");
//             itSource= alarmRepository.findAll(pageRequest);
//            Migration migration1 = new Migration();
//            migration1.setPageNum(1);
//            migration1.setPageSize(1000);
//            migration1.setTableName("alarm");
//            migrationRepository.save(migration1);
//        }else {
//
//            PageRequest pageRequest = new PageRequest(migration.getPageNum(), migration.getPageSize(), Direction.ASC, "id");
//            itSource= alarmRepository.findAll(pageRequest);
//        }
//        //从源数据库中查询出数据并存到目标数据中
//        for (Alarm alarm2 : itSource) {
//            System.out.println("id "+alarm2.getDEVICE_ID());
//            com.didispace.entity.target.Alarm alarm=new com.didispace.entity.target.Alarm();
//            alarm.setDEVICE_ID(alarm2.getDEVICE_ID());
//            alarm.setFIRST_OCCURENCE(alarm2.getFIRST_OCCURENCE());
//            alarmTarget.save(alarm);
//        }
//    }
//}