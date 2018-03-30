package com.dean.java8.demo.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Created by chenhu on 2018/3/29.
 */
public class HorsesCompartor {
    private static HorsesCompartor ourInstance = new HorsesCompartor();

    private static final Logger log = LoggerFactory.getLogger(HorsesCompartor.class);
    public static HorsesCompartor getInstance() {
        return ourInstance;
    }


    private HorsesCompartor() {
    }

    public List<BabyBear> lookupNBears(double num) {

        List<BabyBear> babyBears = new ArrayList<BabyBear>();
        for(int i=0; i< num; i++) {
            int age = new Random().nextInt() % 100;
            BabyBear bear = new BabyBear("red", age, 30f, "chenhu");
            babyBears.add(bear);
        }

        return babyBears;
    }

    public static void doByStream(List<BabyBear> list) {
        LocalDateTime ldtBeginTime = LocalDateTime.now();
        final long count1 = list.stream().filter(babyBear -> babyBear.getAge() < 20).count();
        log.debug("count:{}", count1);
        LocalDateTime ldtEndTime = LocalDateTime.now();
        final Duration duration = Duration.between( ldtBeginTime, ldtEndTime );
        log.debug("duration : {}", duration.toMillis());
    }

    public static void doByForeach(List<BabyBear> list) {
        List<BabyBear> babyBears2 = new ArrayList<>();
        LocalDateTime ldtBeginTime = LocalDateTime.now();
        for(BabyBear b: list) {
            if(b.getAge() < 20) {
                babyBears2.add(b);
            }
        }
        log.debug("count:{}", babyBears2.size());
        LocalDateTime ldtEndTime = LocalDateTime.now();
        final Duration duration = Duration.between( ldtBeginTime, ldtEndTime );
        log.debug("duration : {}", duration.toMillis());
    }

    public static void main(String... args) {
        List<BabyBear> babyBears1 = HorsesCompartor.getInstance().lookupNBears(2000000);

        // do by stream
        HorsesCompartor.doByStream(babyBears1);

        // do by foreach
        HorsesCompartor.doByForeach(babyBears1);

    }
}
