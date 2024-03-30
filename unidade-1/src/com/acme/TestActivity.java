package com.acme;

public class TestActivity {

    public static void main(String[] args) {

        
        Activity x = new Activity();
        x.setName("replic");
        
        
        Activity act = new Activity("register");
        System.out.println( "id -> "+act.getId() );
        act.setPriority(Activity.Priority.HIGHEST);
               
        Activity[] activities = generateActivities("register","invoice","print","exclude");
        
        activities[3].setPriority(Activity.Priority.NORMAL);
        
        System.out.println("Mean 1 -> "+ computeMean("NUM", activities[0], 10,30,40,67,89) );
        //System.out.println("Mean 2 -> "+ computeMean(20, 70) );
    }
    
    public static float computeMean(String s, Activity a, int... numbers) {
        float res = 0;
        for(int v : numbers) {
            res = res + v;
        }
        return res / numbers.length;
    }
    
    private static Activity[] generateActivities(String... nameList) {
        Activity[] act = new Activity[nameList.length];
        int i = 0;
        for(String n: nameList) {
            Activity a = new Activity(n);
            act[i] = a;
            i++;
        }
        return act;
    }
    
}
