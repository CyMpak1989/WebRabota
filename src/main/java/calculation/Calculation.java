package calculation;

import java.util.Date;

/**
 * Created by CyMpak on 24.11.2016.
 */
public class Calculation {
    int startHours = 0;
    int startMinutes = 0;
    int endHours = 0;
    int endMinutes = 0;
    public String getRealTime(){
        Date a = new Date();
        int hours = a.getHours();
        int mins = a.getMinutes();
        if (mins < 10)
        {
            return "Судя по твоему компьютеру сейчас: " + hours + ":0" + mins;
        }
        else
        {
            return "Судя по твоему компьютеру сейчас: " + hours + ":" + mins;
        }
    }
    public void setStartTime(int startHours, int startMinutes){
        this.startHours = startHours;
        this.startMinutes = startMinutes;
    }
    public String getStartTime(){
        if (this.startMinutes < 10){
            return "Вы приходите на работу в: " + this.startHours + ":0" + this.startMinutes;
        }
        else
        {
            return "Вы приходите на работу в: " + this.startHours + ":" + this.startMinutes;
        }
    }
    public void setEndTime(int endHours, int endMinutes){
        this.endHours = endHours;
        this.endMinutes = endMinutes;
    }
    public String getEndTime(){
        if (this.endMinutes < 10){
            return "Вы уходите с работы в: " + this.endHours + ":0" + this.endMinutes;
        }
        else {
            return "Вы уходите с работы в: " + this.endHours + ":" + this.endMinutes;
        }
    }
    public String getFinalTime(){
        Date a = new Date();
        int realTime = (a.getHours()*60*60*1000) + (a.getMinutes()*60*1000);
        int endTime = (this.endHours*60*60*1000) + (this.endMinutes*60*1000);
        int resault = endTime - realTime;
        int finalHoursTime = resault/1000/60/60;
        int finalMinutesTime = (resault/1000/60) - (finalHoursTime)*60;
        if (finalMinutesTime <= 0){
            return "Беги домой смертный!!! Тебе не оплатят переработку.";
        }
        else
        {
            if (finalMinutesTime == 1 || finalMinutesTime == 2 ||finalMinutesTime == 3 ||finalMinutesTime == 4 ||
                    finalMinutesTime == 5 ||finalMinutesTime == 6 ||finalMinutesTime == 7 ||finalMinutesTime == 8 ||finalMinutesTime == 9){
                return "Вам осталось работать: " + finalHoursTime + ":0" + finalMinutesTime;
            }
            else {
                return "Вам осталось работать: " + finalHoursTime + ":" + finalMinutesTime;
            }
        }
    }
}
