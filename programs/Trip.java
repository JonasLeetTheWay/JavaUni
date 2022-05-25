import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.*;
public class Trip {
    // Creating calendar objects
    static  Calendar calndr1 = (Calendar)Calendar.getInstance();
            Calendar calndr2 = (Calendar)Calendar.getInstance();

    int trip_begin_year;
    int trip_begin_month;
    int trip_begin_date;

    int year;
    int month;
    int date;
    int weekday;
    DayOfWeek weekday_ENUM;

  public static void main(String[] args) throws ParseException {

//      Trip fromGermanytoZadar = new Trip();
//      fromGermanytoZadar.TRIP_START();
//      Transport flight_going = new Transport("flight going");
//      flight_going.DEPART_ARRIVAL_PRICE(fromGermanytoZadar.trip_begin_year);
//      Transport flight_return = new Transport("flight going");
//      flight_return.DEPART_ARRIVAL_PRICE(fromGermanytoZadar.trip_begin_year);
      Trip firstday = new Trip();
      DayOfWeek ans = firstday.getWeekday_ENUM("2022-8-10");
      System.out.println(ans);
  }
  public int[] getCurrentTime(){
      LocalDate currentdate = LocalDate.now();
      int current_year = currentdate.getYear();
      int current_month = currentdate.getMonth().getValue();
      int current_date = currentdate.getDayOfMonth();
      int current_weekday = currentdate.getDayOfWeek().getValue();
      return new int[] {current_year,current_month,current_date,current_weekday};
  }
  public void TRIP_START () {
      String trip_begin_cal_temp = Query.queryString("Enter trip start date in such format, YYYY-MM-DD");
      String[] trip_begin_cal_data = trip_begin_cal_temp.split("-");
      trip_begin_year = Integer.parseInt(trip_begin_cal_data[0]);
      trip_begin_month = Integer.parseInt(trip_begin_cal_data[1]);
      trip_begin_date = Integer.parseInt(trip_begin_cal_data[2]);
      calndr2.set(trip_begin_year,trip_begin_month-1,trip_begin_date);
  }
  public int getWeekday_INT (String YYYY_MM_DD) {
      Pattern p = Pattern.compile(".s");//. represents single character.
      Matcher m = p.matcher("as");
      boolean b = m.matches();
      year =    Integer.parseInt(   YYYY_MM_DD.split("-")[0]    );
      month =   Integer.parseInt(   YYYY_MM_DD.split("-")[1]    );
      date =    Integer.parseInt(   YYYY_MM_DD.split("-")[2]    );
      calndr2.set(year,month-1,date);
      Date date = calndr2.getTime();
      LocalDate localdate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      weekday = localdate.getDayOfWeek().getValue();
      return weekday;
  }
    public DayOfWeek getWeekday_ENUM (String YYYY_MM_DD) {
        year =    Integer.parseInt(   YYYY_MM_DD.split("-")[0]    );
        month =   Integer.parseInt(   YYYY_MM_DD.split("-")[1]    );
        date =    Integer.parseInt(   YYYY_MM_DD.split("-")[2]    );
        calndr2.set(year,month-1,date);
        Date date = calndr2.getTime();
        LocalDate localdate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        weekday_ENUM = localdate.getDayOfWeek();
        return weekday_ENUM;
    }
    public String getGeneralTime (int arrivalHour) {
        if (arrivalHour < 12){
            return "morning";
        } else if (arrivalHour > 12 && arrivalHour < 18){
            return "noon";
        } else if (arrivalHour > 18){
            return "night";
        }
        return "noon";
    }


}