package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		Scanner sc = new Scanner(System.in);
		char decisao;
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		do {
			System.out.println("====================================================");
			System.out.println("=====Administrative Analysis of Employee============");
			System.out.println("==================Options===========================");
			System.out.println("==[01] ---------------------------Insert---------===");
			System.out.println("==[02] ---------------------------Update---------===");
			System.out.println("==[03] ---------------------------Delete---------===");
			System.out.println("==[04] ---------------------------Consult--------===");
			System.out.println("==[05] --------------------List by Department----===");
			System.out.println("==[06] --------------------List all Employee-----===");
			System.out.println("==[0] ----------------------------Exit-----------===");
			System.out.print("==Ente an option: ");
			int caso = sc.nextInt();
			switch (caso) {
				
				case 1:
					
					System.out.println("==Inform Employee Data==");
					System.out.print("==Name: ");
					String name = sc.next();
					sc.nextLine();
					System.out.print("==Email: ");
					String email = sc.nextLine();
					System.out.print("==Birthday (dd/MM/yyy): ");
					Date data = sdf.parse(sc.next());
					System.out.print("==Base Salary: ");
					Double baseSalary = sc.nextDouble();
					System.out.print("==Department ID: ");
					int idDepartment = sc.nextInt();		
					Seller newSeller = new Seller(null,name,email,data,baseSalary,new Department(idDepartment,null));
					sellerDao.insert(newSeller);
					System.out.println("==Inserted!! New id: " + newSeller.getId());
					
				break;
				
				case 2:
					System.out.print("==Inform Eployee ID for update: ");
					int idUpdate = sc.nextInt();
					Seller seller = sellerDao.findById(idUpdate);
					System.out.println("==Updating employee " + seller.getName());
					System.out.print("==Name: ");
					name = sc.nextLine();
					seller.setName(name);
					sc.nextLine();
					System.out.print("==Email: ");
					email = sc.nextLine();
					seller.setEmail(email);
					System.out.print("==Birthday (dd/MM/yyy): ");
					data = sdf.parse(sc.next());
					seller.setBirthDate(data);
					System.out.print("==Base Salary: ");
					baseSalary = sc.nextDouble();
					seller.setBaseSalary(baseSalary);
					System.out.print("==Department ID: ");
					idDepartment = sc.nextInt();
					seller.getDepartment().setId(idDepartment);
					sellerDao.update(seller);
					System.out.println("==Update completed!.==");
					
				break;
					
				case 3:
					
					System.out.print("Enter the Employee ID :");
					int id = sc.nextInt();
					sellerDao.deleteById(id);
					System.out.println("Delete completed!");
				break;
				
				case 4:
					
					System.out.print("==Inform the Employee ID: ");
					id = sc.nextInt();
					seller = sellerDao.findById(id);
					System.out.println("");
					System.out.println(seller);
					
					
				break;
				
				case 5:
					
					System.out.print("==Enter the Department ID: ");
					idDepartment = sc.nextInt();
					Department department = new Department(idDepartment, null);
					List<Seller> list = sellerDao.findByDepartment(department);				
					System.out.println("==List of Employees by Department==");
					for(Seller obj : list) {
						System.out.println("\n" + obj);
					}
					
					
				break;
			
				case 6:
					
					System.out.println();
					List<Seller> listFindAll = sellerDao.findAll();
					System.out.println("====List of all employees====");
					for (Seller obj : listFindAll) {
						System.out.println("\n" + obj);
					}
					
				break;
				
				case 0:
						System.out.println("==Thank you!==");
				break;
			
				default:
					System.out.println("==Invalid option, type again!===");
				}
				System.out.print("==Do you want to perform any more operations? [n] - no / [y] - yes: ");
				 decisao = sc.next().charAt(0);
		}while( decisao == 'y');
		System.out.println("==Finished Program!.==");
	sc.close();
	}
}