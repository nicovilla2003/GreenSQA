package model;

public class Controller {

	private KnowledgeUnit[] units;

	public Controller() {

		units = new KnowledgeUnit[50];
		testCases();

	}
	
	public void testCases() {
		
		units[0] = new KnowledgeUnit("A001", "Gestion de repositorios", Type.TECNICAL, "GitHub es una herramienta util");
		units[1] = new KnowledgeUnit("A002", "Gestion de equipos",Type.EXPERIENCES, "Es importante definir responsabilidades claras");
		
	}
	public boolean registerKnowledgeUnit(String id, String description, int chosenType, String Hashtags,String learnedLessons) {

		Type type=defineControllerKUType(chosenType);
		KnowledgeUnit newKnowledgeUnit = new KnowledgeUnit(id, description, type, learnedLessons);
       
        for(int i =0; i<units.length;i++){
            
            if(units[i]==null){
                units[i] = newKnowledgeUnit;
                return true;
            }
           

        }
        
        return false;


		
	}

	//Get ONLY all id and description... Summary="Resumen"
	public String getSummaryKnowledgeUnits(){
		String msg="";
		for(int i=0;i<units.length;i++){
			if(units[i]!=null){
			msg+="\n"+units[i].getId()+". "+units[i].getDescription();
		}
	}
		return msg;
	}


	public Type defineControllerKUType(int i){
		Type chosenType=Type.DOMAIN;
		switch(i){
			case 1:
			chosenType=Type.TECNICAL;
			break;
			case 2:
			chosenType=Type.MANAGEMENT;
			break;
			case 3:
			chosenType=Type.DOMAIN;
			break;
			case 4:
			chosenType=Type.EXPERIENCES;
			break;
		}
		return chosenType;
	}





	//Approve or Disapprove Knowledge Unit
	public void approveKnowledgeUnit(int pointy) {
				units[pointy].setStatus(Status.APPROVED);
	}
	public void disApproveKnowledgeUnit(int pointy) {
		units[pointy].setStatus(Status.NOT_APPROVED);
	}

	public boolean checkExistanceOfAnythingAtAll(){
		String msg = "";

            for(int i=0; i<units.length; i++){

                if(units[i]!=null){
                    msg += "\n"+units[i].toString();
                }
               

            }
			if (msg.equals("")){
				return true;
			}
		return false;
	}


	//Check for ID existance, and get its pointer at Object Array
	public boolean checkIdExistance(String id){
		for(int i=0;i<units.length;i++){
			if(units[i]!=null){
			if(id.equals(units[i].getId())){
				return true;
			}
		}
	}
		return false;
	}

	public int findIdPointer(String id){
		for(int i=0;i<units.length;i++){
			if(units[i]!=null){
			if(id.equals(units[i].getId())){
				return i;
			}
		}
		}
		//This "return 1;" will never be returned, because the checkIdExistance method will always check if the id exists first. 
		//Therefore if it doesnt exist, it won't even run this method.
		return 1;
	}






	//Setters for specific Knowledge unit
	public boolean modifyKnowledgeUnitId(int pointer, String id2) {
		if(!checkIdExistance(id2)){
				units[pointer].setId(id2);
				return true;
			}
		return false;
	}

	public void modifyKnowledgeUnitDescription(int pointer,String changer) {
		units[pointer].setDescription(changer);
	}
	public void modifyKnowledgeUnitType(int pointer,int changer) {
		Type typer=defineControllerKUType(changer);
		units[pointer].setType(typer);
	}
	public void modifyKnowledgeUnitLearnedLesson(int pointer,String changer) {
		units[pointer].setLearnedLessons(changer);
	}
	
	
	
	
	//getters for specific knowledge units
	public String getSpecificKnowledgeUnitId(int pointer) {
		return units[pointer].getId();
	}
	public String getSpecificKnowledgeUnitDescription(int pointer) {
		return units[pointer].getDescription();
	}
	public Type getSpecificKnowledgeUnitType(int pointer) {
		return units[pointer].getType();
	}
	public String getSpecificKnowledgeUnitLearnedLesson(int pointer) {
		return units[pointer].getLearnedLessons();
	}
	







	//Get all
	public String getAllKnowledgeUnits() {

		String msg = "";

            for(int i=0; i<units.length; i++){

                if(units[i]!=null){
                    msg += "\n"+units[i].toString();
                }
               

            }

        return msg;

	}

}
