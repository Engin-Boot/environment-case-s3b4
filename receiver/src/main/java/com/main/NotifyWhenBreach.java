package com.main;

public abstract class NotifyWhenBreach {

        static String AlertMsg = "";
        abstract void sendAlert(String msg);
    }

class NotifyWhenBreachBySMS extends NotifyWhenBreach
{
    void sendAlert(String AlertMsg) {
        System.out.println("Notifying by SMS: " + AlertMsg + "\n");
    }

}

class NotifyWhenBreachByEmail extends NotifyWhenBreach
{
    void sendAlert(String AlertMsg) {
        System.out.println("Notifying by Email: " + AlertMsg + "\n");
    }

}