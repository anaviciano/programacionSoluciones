package tema4;

public class Clock {
    private int hour;
    private int minute;
    private int second;
    private boolean is24Hour;

    public Clock() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
        this.is24Hour = true;
    }

    public Clock(int hour, int minute, int second, boolean is24Hour) {
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59) {
            //throw new IllegalArgumentException("Invalid time");
            System.out.println("Invalid time");
        } else {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
            this.is24Hour = is24Hour;
        }
    }

    public void show() {
        System.out.println(this);
    }

    public String toString() {
        if (is24Hour) {
            return String.format("%02d:%02d:%02d", hour, minute, second);
        } else {
            int adjustedHour = hour % 12 == 0 ? 12 : hour % 12;
            String ampm = hour < 12 ? "AM" : "PM";
            return String.format("%02d:%02d:%02d %s", adjustedHour, minute, second, ampm);
        }
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public boolean getIs24Hour() {
        return is24Hour;
    }

    public void setIs24Hour(boolean is24Hour) {
        this.is24Hour = is24Hour;
    }

}
