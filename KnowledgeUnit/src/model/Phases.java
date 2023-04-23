package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Phases{
    //planned dates(the planned dates from the beggining)
    private sDate_fDate[] pDates;
    //real dates(the actual dates things happen)
    private sDate_fDate[] rDates;
    private boolean[] initialized;
    private String[] phase;
    private Controller[] controllerUnits;

    public Phases(int[] months){
        this.pDates = new sDate_fDate[6];
        this.rDates = new sDate_fDate[6];
        controllerUnits=new Controller[6];
        this.pDates[0].setStartDate(Calendar.getInstance());
        this.rDates[0].setStartDate(Calendar.getInstance());
        this.phase=new String[]{"Inicio","Análisis","Diseño","Ejecución","Cierre y Seguimiento","Control del Proyecto"};
        this.initialized=new boolean[]{true,false,false,false,false,false};
        setAddMonths(months);
    }


    public void setInitialized(int pointy){
        initialized[pointy]=true;
    }
    public void setPlannedDate(int pointy, sDate_fDate dates){
        this.pDates[pointy]=dates;
    }
    public String getPhaseName(int pointy){
        return phase[pointy];
    }
    public Calendar getPhaseStartDate(int pointy){
        return pDates[pointy].getStartCalendarDate();
    }
    public Calendar getPhaseFinishDate(int pointy){
        return pDates[pointy].getFinsihCalendarDate();
    }
    public void setAddMonths(int[] months){
        Calendar expendable;
        for(int i=0; i<pDates.length;i++){
            expendable=pDates[i].getStartCalendarDate();
        expendable.add(Calendar.MONTH,months[i]);
            pDates[i].setFinishDate(expendable);
            if(i!=5){
            pDates[i+1].setStartDate(expendable);
            }
        }
    }
    public void endNextPhase(){
        for(int i=0;i<6;i++){
        if(initialized[i]==true){
            initialized[i]=false;
            rDates[i].setFinishDate(Calendar.getInstance());
            if(i!=5){
            initialized[i+1]=true;
            rDates[i+1].setStartDate(Calendar.getInstance());
            }

        }
        }
    }
}
