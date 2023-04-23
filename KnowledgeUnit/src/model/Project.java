package model;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
public class Project {
    private String name;
    private String client;
    private String budget;
    private Phases phase;
    private List<Manager> manager;
    private sDate_fDate dates;
    public Project(String name, String client, String budget,int[] months){
        this.name = name;
        this.client=client;
        this.budget=budget;
        dates.setStartDate(Calendar.getInstance());
        manager=new ArrayList<Manager>();
        phase=new Phases(months);
        Collections.copy(this.manager, manager);
        dates.setFinishDate(phase.getPhaseFinishDate(5));
    }
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getBudget() {
		return budget;
	}

	public void setCellphone(String budget) {
		this.budget = budget;
	}




    //Dates
    public void setPlannedDate(int pointy){
        
    }
    
    
    //Manager get and set
    public String getManagers() {
        String msg="";
        int c=0;
        for(Manager sup:manager){
            c++;
            msg+="\n\n["+c+"] Name: "+sup.getName()+"\n"+sup.getCellphone();
        }
        return msg;
	}

    //pointy=(pointer)----- pointy-1 because User will chose from a list starting from 1. ArrayList pointers start at 0. 
	public void modifyManagerName(int pointy,String changer) {
        Manager sup=new Manager(changer,manager.get(pointy-1).getCellphone());
        manager.set(pointy-1,sup);
        
	}
    public void modifyManagerCellphone(int pointy,String changer) {
        Manager sup=new Manager(manager.get(pointy-1).getName(),changer);
        manager.set(pointy-1,sup);
	}
    public void addProjectManager(String name, String Cellphone){
        Manager sup=new Manager(name,Cellphone);
        manager.add(sup);
    }
    public String getProjectPhaseName(int pointer){
        return phase.getPhaseName(pointer);
    }
    public void endNextProjectPhase(){
         phase.endNextPhase();
    }

	
}
