public class City {
    public final int MINUTE = 60;
    public final int HOUR = 3600;
    public final int DAY = 86400;

    public String name;

    public int going_day;
    public int going_hour;
    public int going_minute;

    public int leaving_day;
    public int leaving_hour;
    public int leaving_minute;

    public String[] sites;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int get_going_day() {
        return going_day;
    }
    public int get_going_hour() {
        return going_hour;
    }
    public int get_going_minute() {
        return going_minute;
    }

    public void setGoing(int going_day, int going_hour, int going_minute) {
        this.going_day = going_day;
        this.going_hour = going_hour;
        this.going_minute = going_minute;
    }
    public void setGoingDay(int going_day){
        this.going_day = going_day;
    }

    public int get_leaving_day() {
        return leaving_day;
    }
    public int getLeaving_hour() {
        return leaving_hour;
    }
    public int getLeaving_minute() {
        return leaving_minute;
    }

    public void setLeaving(int leaving_day, int leaving_hour, int leaving_minute) {
        this.leaving_day = leaving_day;
        this.leaving_hour = leaving_hour;
        this.leaving_minute = leaving_minute;
    }
    public void setLeavingDay(int leaving_day){
        this.leaving_day = leaving_day;
    }

    public String[] getSites() {
        return sites;
    }

    public void setSites(String[] sites) {
        this.sites = sites;
    }
}
