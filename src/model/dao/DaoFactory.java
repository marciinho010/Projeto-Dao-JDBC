package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
		
		//classe vai expor um metodo que retorna o tipo da interface mas internamente vai instanciar uma implementa��o
		//macete para n�o precisar expor a implementa��o, deixar somente a interface.
	}
}
