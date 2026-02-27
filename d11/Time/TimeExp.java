package d11.Time;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.time.zone.ZoneRules;
import java.util.Date;

public class TimeExp {

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);

        Time time = new Time(date.getTime());
        System.out.println(time);

        // we can format most of it also
        //mm-dd-yyyy
        LocalDate date1 = new Date().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        System.out.println(date1);

        LocalDate nowT = LocalDate.now();
        System.out.println(nowT);

        LocalDateTime dateTimeX = LocalDateTime.now();
        System.out.println(dateTimeX);

        TemporalUnit temporalUnit = ChronoUnit.DAYS;
        // dateTimeX.adjustInto(temporalUnit);

        // LocalDateTime dateTime = LocalDateTime.of(2022, 1, 1, 12, 0, 0);
        // TemporalAdjuster adjuster = TemporalAdjusters.truncateTo(ChronoUnit.DAYS);
        // LocalDateTime adjustedDateTime = dateTime.with(adjuster);
        // System.out.println(adjustedDateTime);
        LocalDateTime dateTime = LocalDateTime.now();
        TemporalAdjuster adjuster = t -> ((LocalDateTime) t).with(TemporalAdjusters.firstDayOfNextMonth());

        LocalDateTime adjustedDateTime = dateTime.with(adjuster);
        System.out.println("with adjust " + adjustedDateTime);

        // date based timeline -- period of timeline etc... elapsed
        // System.out.println(ZoneId.systemDefault().getAvailableZoneIds());
        System.out.println("Number of TZ: " + ZoneId.getAvailableZoneIds().size());
        ZoneId.getAvailableZoneIds().stream().filter(s -> s.startsWith("America/H")).sorted().map(ZoneId::of).forEach(z -> System.out.println(z.getId() + ": " + z.getRules()));;

        ZonedDateTime hawaiianTime = ZonedDateTime.now(ZoneId.of("Pacific/Honolulu"));
        System.out.println(hawaiianTime);
        System.out.println("Offset: " + hawaiianTime.getOffset() + " Rules: " + hawaiianTime.getZone().getRules());
        System.out.println("Current Time At: " + hawaiianTime.toOffsetDateTime());

        ZoneRules zoneRules = hawaiianTime.getZone().getRules();
        boolean isDaylightSavings = zoneRules.isDaylightSavings(hawaiianTime.toInstant());

        System.out.println("Daylight savings: " + isDaylightSavings);

        //meeting time schedule one in Japan and one in USA New York let say it 10am in usa
        Date date2 = new Date();
        ZonedDateTime newYorkTime = ZonedDateTime.ofInstant(date2.toInstant(), ZoneId.of("America/New_York"));
        ZonedDateTime japanTime = ZonedDateTime.ofInstant(date2.toInstant(), ZoneId.of("Asia/Tokyo"));
        System.out.println("New York Time: " + newYorkTime);
        System.out.println("Japan Time: " + japanTime);

        //meeting time in Japan
        ZonedDateTime meetingTime = ZonedDateTime.ofInstant(date2.toInstant(), ZoneId.of("Asia/Tokyo"));
        System.out.println("JapanMeeting Time: " + meetingTime.getHour() + " " + meetingTime.getMinute() + " " + meetingTime.getSecond() + " " + meetingTime.getOffset() + " " + meetingTime.getZone().getRules());

        Date date3 = new Date();

        ZonedDateTime nyMeeting = ZonedDateTime.now(ZoneId.of("America/New_York"))
                .withHour(10) // Set to 10 AM
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
        ZonedDateTime japanMeeting = nyMeeting.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("New York Time: " + nyMeeting); // Fixed from newYorkTime
        System.out.println("Japan Time: " + japanMeeting);      // Fixed from meetingTime
        System.out.println("Japan Meeting Time: " + japanMeeting.getHour() + ":"
                + japanMeeting.getMinute() + ":" + japanMeeting.getSecond());
        System.out.println("Japan Meeting Time Offset: " + japanMeeting.getOffset());
        System.out.println("Japan Meeting Time Zone Rules: " + japanMeeting.getZone().getRules());

    }
}
