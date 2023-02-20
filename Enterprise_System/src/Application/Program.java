package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entites.Department;
import Entites.HourContract;
import Entites.Worker;
import Entites.Enum.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter department's name: ");
		String departmentName = input.nextLine();

		System.out.println("Enter worker data: ");

		System.out.println("Name: ");
		String workerName = input.nextLine();

		System.out.println("Level: ");
		String workerLevel = input.nextLine();

		System.out.println("Base salary:");
		double baseSalary = input.nextDouble();

		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Department(departmentName));

		System.out.println("How many contracts to this worker ?");
		int contractNumber = input.nextInt();

		for (int i = 0; i < contractNumber; i++) {
			System.out.println("Enter contract #" + (1 + i));

			System.out.println("Date (DD/MM/YYYY)");
			Date contractDate = sdf.parse(input.next());
			// throws ParseException

			System.out.println("Value per hour: ");
			double valuePerHour = input.nextDouble();

			System.out.println("Duration: (hours): ");
			int durationHours = input.nextInt();

			HourContract contract = new HourContract(contractDate, valuePerHour, durationHours);
			// por ser um arrayList é necessário add
			worker.addContract(contract);

		}

		System.out.println();

		System.out.print("Enter the month and year to calculate income (MM/YYYY): ");
		String monthAndYear = input.next();

		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: "+worker.getDepartment().getName());

		System.out.println("Income for "+ monthAndYear +": " +String.format("%.2f", worker.income(year, month)));
		
		input.close();
	}

}
