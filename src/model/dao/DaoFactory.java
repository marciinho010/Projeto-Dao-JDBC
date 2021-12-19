package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
		
		//classe vai expor um metodo que retorna o tipo da interface mas internamente vai instanciar uma implementa��o
		//macete para n�o precisar expor a implementa��o, deixar somente a interface.
	}
}
