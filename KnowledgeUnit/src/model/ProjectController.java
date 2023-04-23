package model;
import java.util.List;
import java.util.Calendar;
public class ProjectController {
    private Project[] project;
    
	
    public ProjectController() {
    project = new Project[10];
    
	}
    public boolean registerProject(int pointy,String name, String client,String budget, int[] months) {

		Project newProject = new Project(name,client,budget,months);
       
            
            if(checkSpaceExistance()){
                project[pointy] = newProject;
                return true;
            }
        
        return false;


		
	}
    
    public boolean checkSpaceExistance(){
       for(int c=0;c<project.length;c++){
            if(project[c]==null){
                return true;
        }
    }
        return false;
    }



    public int getAvailableProjectSpace(){
        for(int c=0;c<project.length;c++){
            if(project[c]==null){
                return c;
        }
    }
    //This "return 1;" will never be returned, 
    //because Executable.java runs the method projectController.checkSpaceExistance().
    //Thus, ensuring there will be a space open in the Project array, and nulifying the chance of this return ever happening.
        return 1;
        
    }



    public String getControllerPhaseName(int pointy,int i){
        return project[pointy].getProjectPhaseName(i);
    }
    
    public void addControllerManager(int pointy,String name,String cellphone){
         project[pointy].addProjectManager(name, cellphone);
        }
    public void endNextControllerPhase(int i){
        project[i].endNextProjectPhase();
    }
    public String getSummaryProjects(){
        String msg="";
		for(int i=0;i<project.length;i++){
			if(project[i]!=null){
			msg+="\n\n["+i+"] Project Name: "+project[i].getName()+". Project Client: "+project[i].getClient();
		}
	}
		return msg;
	}
    public boolean checkProjectExistance(int i){
		
	if(project[i]!=null){
		return true;
	}
		return false;
	}
}
