public class Transport extends Trip{

    private final int MINUTE = 60;
    private final int HOUR = 3600;
    private final int DAY = 86400;

    private String name_transport;

    private String depart_station;
    private int depart_month;
    private int depart_day;
    private int depart_hour;
    private int depart_minute;

    private String arrival_station;
    private int arrival_month;
    private int arrival_day;
    private int arrival_hour;
    private int arrival_minute;
    private double price;

    public Transport(String name_transport) {
        this.name_transport = name_transport;
    }

    public void DEPART_ARRIVAL_PRICE(int trip_year) {

        boolean flag = true;
        String[] transport_depart_arrival_station_temp = Query.queryString("Enter transport depart & arrival station in such format: depart_station, arrival station").replaceAll("\\s", "").split(",");
        depart_station = transport_depart_arrival_station_temp[0];
        arrival_station = transport_depart_arrival_station_temp[1];
        String transport_depart_arrival_price_temp = Query.queryString("Enter transport depart & arrival time & price in such format: MM-DD, HOUR:MIN - HOUR:MIN, EUR").replaceAll("\\s", "");
        String[] transport_depart_arrival_price_data = transport_depart_arrival_price_temp.split(",");
        String[] transport_depart_arrival_date_data = transport_depart_arrival_price_data[0].split("-");
        depart_month = Integer.parseInt(transport_depart_arrival_date_data[0]);
        depart_day = Integer.parseInt(transport_depart_arrival_date_data[1]);

        if (flag) {
            flag = Query.queryBoolean("The transport depart and arrive on the same day? - true/false");
            arrival_month = depart_month;
            arrival_day = depart_day;
        } else {
            String arrival_month_day_temp = Query.queryString("Enter transport arrival day in such format, MM-DD");
            arrival_month = Integer.parseInt(arrival_month_day_temp.split("-")[0]);
            arrival_day = Integer.parseInt(arrival_month_day_temp.split("-")[1]);
        }

        String[] transport_depart_arrival_data = transport_depart_arrival_price_data[1].split("-");
        String[] transport_depart_hr_min = transport_depart_arrival_data[0].split(":");
        String[] transport_arrival_hr_min = transport_depart_arrival_data[1].split(":");

        depart_hour = Integer.parseInt(transport_depart_hr_min[0]);
        depart_minute = Integer.parseInt(transport_depart_hr_min[1]);
        arrival_hour = Integer.parseInt(transport_arrival_hr_min[0]);
        arrival_minute = Integer.parseInt(transport_arrival_hr_min[1]);
        price = Double.parseDouble(transport_depart_arrival_price_data[2]);
        int depart_month_temp = depart_month;
        int depart_day_temp = depart_day;

        String s1 = String.format("weekday \t date     \t ↗        \t ↘        \t landed at    \t price \n");
        String s2 = String.format("%s      \t %d-%d    \t %d:%d    \t %d:%d    %s              \t %.2f",getWeekday_ENUM(trip_year + "-" + depart_month_temp + "-" + depart_day_temp),
                depart_month, depart_day, depart_hour, depart_minute,
                arrival_month, arrival_day, arrival_hour, arrival_minute,
                getGeneralTime(arrival_hour), price);
        System.out.println(s1);
        System.out.println(s2);

//        System.out.printf(
//                "\t \t \t %s - %s to %s\n" +
//                        "weekday \t date     \t ↗        \t ↘        \t landed at    \t price \n" +
//                        "%s      \t %d-%d    \t %d:%d    \t %d:%d    %s              \t %.2f",
//                name_transport, depart_station, arrival_station,
//                getWeekday_ENUM(trip_year + "-" + depart_month_temp + "-" + depart_day_temp),
//                depart_month, depart_day, depart_hour, depart_minute,
//                arrival_month, arrival_day, arrival_hour, arrival_minute,
//                getGeneralTime(arrival_hour), price
//        );
    }

    public String getName() {
        return name_transport;
    }

    public String get_Depart_Station() {
        return depart_station;
    }

    public int get_Depart_Day() {
        return depart_day;
    }

    public int get_Depart_Hour() {
        return depart_hour;
    }

    public int get_Depart_Minute() {
        return depart_minute;
    }

    public String get_Arrival_Station() {
        return arrival_station;
    }

    public int get_Arrival_Day() {
        return arrival_day;
    }

    public int get_Arrival_Hour() {
        return arrival_hour;
    }

    public int get_Arrival_Minute() {
        return arrival_minute;
    }

    public double get_Journey_Time() {
        return (arrival_day - depart_day) * DAY +
                (arrival_hour - depart_hour) * HOUR +
                (arrival_minute - depart_minute) * MINUTE;
    }

    public double getPrice() {
        return price;
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    public int[] getDepartTime() {
        return new int[]{get_Depart_Day(), get_Depart_Hour(), get_Depart_Minute()};
    }

    public int[] getArrivalTime() {
        return new int[]{get_Arrival_Day(), get_Arrival_Hour(), get_Arrival_Minute()};
    }

    @Override
    public String toString() {
        return "Transport{" +
                "MINUTE=" + MINUTE +
                ", HOUR=" + HOUR +
                ", DAY=" + DAY +
                ", name_transport='" + name_transport + '\'' +
                ", depart_station='" + depart_station + '\'' +
                ", depart_month=" + depart_month +
                ", depart_day=" + depart_day +
                ", depart_hour=" + depart_hour +
                ", depart_minute=" + depart_minute +
                ", arrival_station='" + arrival_station + '\'' +
                ", arrival_month=" + arrival_month +
                ", arrival_day=" + arrival_day +
                ", arrival_hour=" + arrival_hour +
                ", arrival_minute=" + arrival_minute +
                ", price=" + price +
                '}';
    }
}
