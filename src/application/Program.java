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
			System.out.println("==[06] --------------------List by Employee------===");
			System.out.println("==[0] ----------------------------Exit-----------===");
			System.out.print("== Ente an option: ");
			int caso = sc.nextInt();
			switch (caso) {
				
				case 1:
					 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
					
					System.out.println("==Inform Employee Data==");
					System.out.print("Name:");
					String name = sc.next();;
					System.out.print("Email: ");
					String email = sc.next();
					System.out.print("Birthday (dd/MM/yyy): ");
					Date data = sdf.parse(sc.next());
					System.out.print("Base Salary: ");
					Double baseSalary = sc.nextDouble();
					System.out.print("Department ID: ");
					int idDepartment = sc.nextInt();		
					Seller newSeller = new Seller(null,name,email,data,baseSalary,new Department(idDepartment,null));
					sellerDao.insert(newSeller);
					System.out.println("Inserted!! New id: " + newSeller.getId());
					
				break;
				
				case 2:
					
				break;
					
				case 3:
					
				break;
				
				case 4:
					
					System.out.print("=Informe o id do Funcionário: ");
					int id = sc.nextInt();
					Seller seller = sellerDao.findById(id);
					System.out.println("");
					System.out.println(seller);
					
					
				break;
				
				case 5:
					
					System.out.print("Informe o ID do Departamento: ");
					idDepartment = sc.nextInt();
					Department department = new Department(idDepartment, null);
					List<Seller> list = sellerDao.findByDepartment(department);				
					System.out.println("=Lista de Funcionários por Departamento= ");
					for(Seller obj : list) {
						System.out.println("\n" + obj);
					}
					
					
				break;
			
				case 6:
					
					System.out.println();
					List<Seller> listFindAll = sellerDao.findAll();
					System.out.println("====Lista de todos os funcionários====");
					for (Seller obj : listFindAll) {
						System.out.println("\n" + obj);
					}
					
				break;
				
				case 0:
						System.out.println("Obrigado!");
				break;
			
				default:
					System.out.println("Opção inválida, digite novamente!");
				}
				System.out.println("Deja realizar mais alguma operação? [n] - Não / [s] - Sim");
				 decisao = sc.next().charAt(0);
		}while( decisao == 's');
		System.out.println("Programa Finalizado!.");
	sc.close();
	}
}