package Entites;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Entites.Enum.WorkerLevel;

public class Worker {

	private String name;

	private WorkerLevel level;

	private Double baseSalary;

	private Department department;

	private List<HourContract> contracts = new ArrayList<>();
	// quando tiver uma composição "tem muitos" obs isso esta no uml class diagram não
	// incluir o arrayList no construtor
	//por não puder torcar a lista não termos o set do atributo
	
	public Worker() {

	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}


	public void addContract(HourContract contract) {
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}

	public Double income(int year, int month) {
		//o slario base, mas o valor que ele recebeu dos contratos do mes 
		//se fosse todos os contratos seria sum+= c.totalValue
		//mas são os contratos do mes e ano 
		double sum = baseSalary;
		
		Calendar cal = Calendar.getInstance();
		//instaciando o calendar 
				
		//instanciou um obj calendar setando o contrato com getDate da classe HourContract
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int cYear = cal.get(Calendar.YEAR);
			int cMonth = 1+ cal.get(Calendar.MONTH);
			//add mais um pois o mes do calendear começa com zero 

			if (year == cYear && month == cMonth) {
				sum += c.totalValue();
			}
		}
		return sum;
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", level=" + level + ", baseSalary=" + baseSalary + "]";
	}

}
