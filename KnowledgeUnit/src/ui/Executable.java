
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:
//El proyecto no esta terminado todavia D:


package ui;


import java.util.Scanner;
//Yo sé que esto es ilegal, despues lo iba a corregir
import model.Controller;
import model.ProjectController;


public class Executable {

	private Scanner reader;
	private Controller controller;
    private ProjectController projectController;

	public Executable() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {

		Executable exe = new Executable();
		exe.menu();

	}



    public void menu() {
        System.out.println("Welcome to GreenSQA Knowledge Center");
        
                boolean cond = false;
        
                while(!cond){
        
                    System.out.println("1. Register Project");
                    System.out.println("2. End project phase");
                    System.out.println("3. Register KnowledgeUnit");
                    System.out.println("4. Approve KnowledgeUnit");
                    System.out.println("5. Publish Knowledge Unit");
                    System.out.println("6. Show Knowledge Unit Quantity by Type");
                    System.out.println("7. Get all lessons learned from a specific phase from a project");
                    System.out.println("8. Leading Project in KnowledgeUnit Quantity");
                    System.out.println("9. Search for Colaborator Knowledge Units");
                    System.out.println("10. Leading Project in KnowledgeUnit Quantity");
                    System.out.println("11. Exit");
                    int opcion = reader.nextInt();
        
                    switch(opcion){
        
                        case 1:
                        registerProject();
                        break;
        
                        case 2:
                        
                        break;
        
                        case 3:
                        
                        break;
                        case 4:
                        
                        break;
                        case 5:
                        
                        break;



                        case 6:
                        cond = true;
                        break;
                        
                        
        
                    }
        
        
                }
            }


            public void registerProject() {
                
                if(projectController.checkSpaceExistance()){
                System.out.println("\n\nWrite the information of your new Knowledge Unit");
                    int pointy=projectController.getAvailableProjectSpace();
            
                
        //Limpieza de buffer
        reader.nextLine();
        System.out.println("\nPlease enter the name of the Project");
        String name=reader.nextLine();
        
        System.out.println("\nPlease enter the client that requested this project");
        String client= reader.nextLine();

            System.out.println("\nPlease enter the budget of the Project");
            String budget=reader.nextLine();

        

        if(projectController.registerProject(pointy,name,client,budget,makePhaseDates(pointy))){

            System.out.println("Knowledge Unit registered succesfuly!\n");
            addManagers(pointy);

        }else{

            System.out.println("Something went wrong :( ");
        }
    }else{
        System.out.println("Memory full, no more project spaces!");
    }
            }

            
            
            
            
// UNFINISHED
// UNFINISHED
// UNFINISHED
// UNFINISHED
// UNFINISHED
// UNFINISHED
            public void endProjectPhase(){
                reader.nextLine();
                System.out.println("Please select the project for which you wish to end it's phase");
            }
// UNFINISHED
// UNFINISHED
// UNFINISHED
// UNFINISHED
// UNFINISHED
// UNFINISHED


            public int[] makePhaseDates(int projectPointer){
                int[] months=new int[6];
                reader.nextLine();
                for(int i=0;months.length<6;i++){
                System.out.println("\nPlease enter the number of months that Phase "+i+":"+projectController.getControllerPhaseName(projectPointer, i)+"will last");
                months[i]=reader.nextInt();
                }
                return months;
                }


                public void addManagers(int projectPointer){
                    int managerAmount=0;
                    String name="";
                    String cell="";

                    reader.nextLine();
                System.out.println("\nPlease enter the number of managers you will add to your project");
                managerAmount=reader.nextInt();
                for(int i=0;i<managerAmount;i++){
                System.out.println("\nEnter the name of manager "+i);
                name=reader.nextLine();
                System.out.println("\nEnter the cellphone number of manager "+i);
                cell=reader.nextLine();
                projectController.addControllerManager(projectPointer, name, cell);
                }
                }
                
                public void defineKUType(){
                    int opt=0;
                reader.nextLine();
                System.out.println("Please select what type of KnowledgeUnit you want");
                System.out.println("[1] Tecnical");
                System.out.println("[2] Management");
                System.out.println("[3] Domain");
                System.out.println("[4] Experiences");
                opt=reader.nextInt();
                
                }



                //Todavía me falta adaptar esta version de registrar capsula. Esta version la usé para la tarea del viernes
                //que era para hacer este trabajo pero incompleto.
                public void registerKnowledgeUnit() {
                    System.out.println("\nWrite the information of your new Knowledge Unit");
                    String id="Impossible";
                        //Limpieza de buffer
                        reader.nextLine();
                        System.out.println("\nPlease enter the id of the Knowledge Unit. Ex: A001");
                        id=reader.nextLine();
                        while(controller.checkIdExistance(id)){
                        System.out.println("\nThe id you entered already exists! Try a new one!");
                        id=reader.nextLine();
                        }
                        System.out.println("\nPlease enter the description for your Knowledge Unit. Ex.:Gestion de repositorios ");
                        String description= reader.nextLine();
                
                        System.out.println("\nPlease enter the type of Knowledge Unit. Ex.: Tecnico");
                        String type = reader.nextLine();
                
                        System.out.println("\nPlease enter the lesson you learned. Ex.: GitHub es una herramienta util");
                        String learnedLessons = reader.nextLine();
                
                        System.out.println(id);
                        if(controller.registerKnowledgeUnit(id,description,type,learnedLessons)){
                
                            System.out.println("Knowledge Unit registered succesfuly!");
                
                        }else{
                
                            System.out.println("Memory full, there is no storage left for more Units!");
                        }
                    }

                    public String showProjects(){
                        String projects=projectController.getSummaryProjects();
                        return projects;
                    }
                    public int chooseProject(){
                        System.out.println(showProjects());

                    }
                
            }

