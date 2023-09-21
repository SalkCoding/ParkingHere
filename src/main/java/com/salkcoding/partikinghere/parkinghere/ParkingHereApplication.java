package com.salkcoding.partikinghere.parkinghere;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
@Slf4j
public class ParkingHereApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingHereApplication.class, args);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                log.info("Update database page");
                /*
                TODO last update
                1000개씩 총 175 페이지 업데이트
                Threadpool로 업데이트 요망
                새벽시간대에는 1시간 마다 업데이트
                주간 시간에는 대략 5~10분 마다 업데이트 하기
                http://data.seoul.go.kr/dataList/dataView.do?onepagerow=1000&srvType=S&infId=OA-21709&serviceKind=1&pageNo=1&gridTotalCnt=17496&ssUserId=SAMPLE_VIEW&strWhere=&strOrderby=&filterCol=&txtFilter=
                */
            }
        };
        timer.schedule(task, 1000, 1000);
    }

}
