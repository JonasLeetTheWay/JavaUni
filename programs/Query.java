import java.util.Scanner;

public class Query {

    static Scanner input = new Scanner(System.in);

    public final int MINUTE = 60;
    public final int HOUR = 3600;
    public final int DAY = 86400;

    public int length_of_travel_sub;
    public String location_sub;
    public double daily_spend;

    public static String name;
    public static String country;
    public static int length_of_travel_total;
    public static String[] citiesToVisit;
    public static int citiesToVisitNum;

    public static Double money_taking = 10.0; // BUG
    public static String currencyName;
    public static double conversion_ratio;
    public static double conversion = conversion_ratio * money_taking;
    ;
    public static double daily_spend_general = money_taking / length_of_travel_total;

    public static void continuePreviousQuery() {

    }

    public static void acccomodation() {

    }

    public static void currency() {
        currencyName = queryString("What is the three letter currency symbol for your travel destination? ");
        conversion_ratio = queryDouble("How many are there in 1 EUR? ");
    }

    public static void travel_plans() {
        // loop the following SOP
        citiesToVisitNum = queryInt("How many cities would you like to visit?");
        citiesToVisit = new String[citiesToVisitNum];
        for (int i=1; i< citiesToVisitNum+1; i++){
            citiesToVisit[i-1] = queryString("What is the name of city "+ i +"?");
        }
        City[] cities = new City[citiesToVisitNum];

        for (int i = 0; i < cities.length; i++) {
            City city_tmp = new City(citiesToVisit[i]);
            cities[i] = city_tmp;
            System.out.println("For "+ citiesToVisit[i] +", when do you plan to reach there?");
            System.out.println();
            int going_day = queryInt("day?");
            int going_hour = queryInt("hour?");
            int going_minute = queryInt("minute?");

            cities[i].setGoing(going_day, going_hour, going_minute);

            cities[i].setLeavingDay( going_day + queryInt("How many days you plan to stay there") );

            int touristic_sites_count = queryInt("How many touristic sights would you love to visit?");
            String[] sites = new String[touristic_sites_count];
            for (int j=0; j<touristic_sites_count; j++){
                sites[j] = queryString("What touristic sights would you love to visit?");
            }
            cities[i].setSites(sites); // scrape kayak, tripadvisor
        }

        if (citiesToVisit.length > 1) {
            Transport[] transports = new Transport[citiesToVisit.length];
            for (int i = 0; i < citiesToVisit.length; i++) {
                System.out.printf("Since you're inter-city traveller, by what means of transport, would you get from %s to %s?", citiesToVisit[i], citiesToVisit[++i]);
                System.out.println("Input them in such order:");
                System.out.println("means of transport, departing station, arrival station, date, price");
                transports[i] = new Transport( queryString("name of transport means?") );
//                transports[i].set_Depart_Station( queryString("departing station?") );
//                int depart_day = queryInt("day?");
//                int depart_hour = queryInt("hour?");
//                int depart_minute = queryInt("minute?");
//                transports[i].setDepart(depart_day, depart_hour, depart_minute);
//                transports[i].set_Depart_Station( queryString("arrival station?") );
//                int arrival_day = queryInt("day?");
//                int arrival_hour = queryInt("hour?");
//                int arrival_minute = queryInt("minute?");
//                transports[i].setArrival(arrival_day, arrival_hour, arrival_minute);
//                transports[i].setPrice(queryDouble("price?"));
            }
        }
    }
//    public static void queryTravelPlans_DETAILED() {
//        You have plans for this city;
//        How would your first day looks like ?; //2nd, 3rd
//    }


    public static String queryString(String args) {
        System.out.println(args);
        return input.nextLine();
    }

    public static int queryInt(String args) {
        System.out.println(args);
        return input.nextInt();
    }

    public static double queryDouble(String args) {
        System.out.println(args);
        return input.nextDouble();
    }

    public static boolean queryBoolean(String args) {
        System.out.println(args);
        return input.nextBoolean();
    }

    public static void greeting() {
        // Creates greeting message
        System.out.println("Welcome to Vacation Planner!");
        name = queryString("What is your name?");
        System.out.print("Nice to meet you " + name + ", ");
        country = queryString("Where are you travelling to?");
        System.out.println("Great! " + country + " sounds like a great trip");
    }

    public static void cost_time() {
        // Works out how much money per day can be spent depending on time and budget
        Scanner input = new Scanner(System.in);
        System.out.print("How many days are you going to spend travelling? ");
        length_of_travel_total = input.nextInt();

        System.out.print("How much money, in EUR, are you planning to spend on your trip? ");
        money_taking = input.nextDouble();

    }

    public static void summarize(){
        System.out.println("If you are going to spend $" + money_taking + " USD that means per day you can spend up to $" + daily_spend_general + " EUR");
        System.out.println("Your total budget in " + currencyName + " is " + conversion + " " + currencyName + ", which per day is " + daily_spend_general + " " + currencyName);
    }

    public static void time_diff() {
        // works out time at noon / midnight between home and location
        Scanner input = new Scanner(System.in);
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        int time_diff_hrs = input.nextInt();
        int midnight = (24 + time_diff_hrs) % 24;
        int noon = (12 + time_diff_hrs) % 24;
        System.out.print("That means that when it is midnight at hone it will be " + midnight + ":00 in your travel destination and when it is noon at home it will be " + noon + ":00");
    }
}
