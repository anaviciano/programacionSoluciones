package tema4;

public class ClockMain {
    public static void main(String[] args) {
        Clock clock = new Clock(23, 59, 59, true);
        clock.show();
        System.out.println(clock);
        clock.setHour(12);
        clock.setMinute(0);
        clock.setSecond(0);
        clock.show();
        System.out.println(clock);
        clock.setIs24Hour(false);
        clock.show();
        System.out.println(clock);
        Clock clock2 = new Clock(1, 0, 0, false);
        clock2.show();
        System.out.println(clock2);
    }
}
