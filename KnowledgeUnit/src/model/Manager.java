package model;

public class Manager {
    private String name;
    private String cellphone;
    
    public Manager(String name, String cellphone) {

		this.name = name;
		this.cellphone = cellphone;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

}
