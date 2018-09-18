/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.dao;

import com.rafaelvalentim.agro.connection.ConnectionFactory;
import com.rafaelvalentim.agro.model.CustoSafraSintetico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rafael
 */
public class RelatorioDAO {
    
    public CustoSafraSintetico getCustoSafraSintetico(Long codigoSafra) throws SQLException {
        String sql = 
        "select s.descricao AS safra, "	    
       + "IFNULL(sum(a.horas_equipamentos * cep.custo_real),0) AS custo_real_eq_principal, "
       + "IFNULL(sum(a.horas_equipamentos * cep.custo_dollar),0) AS custo_dollar_eq_principal, "
       + "IFNULL(sum(a.horas_equipamentos * cea.custo_real),0) AS custo_real_eq_apoio, "
       + "IFNULL(sum(a.horas_equipamentos * cea.custo_dollar),0) AS custo_dollar_eq_apoio, "
       + "IFNULL(sum(a.horas_operadores * cop.custo_real),0) AS custo_real_op_principal, "
       + "IFNULL(sum(a.horas_operadores * cop.custo_dollar),0) AS custo_dollar_op_principal, "       
       + "IFNULL(sum(a.horas_operadores * coa.custo_real),0) AS custo_real_op_ajudante, "
       + "IFNULL(sum(a.horas_operadores * coa.custo_dollar),0) AS custo_dollar_op_ajudante, "
       + "IFNULL(sum(a.quantidade_produto * cp.custo_real),0) AS custo_real_produto, "
       + "IFNULL(sum(a.quantidade_produto * cp.custo_dollar),0) AS custo_dollar_produto "
       
       + "from apontamento a "
       + "inner join boletim b "
       + "on (a.boletim_id = b.id) "
       + "inner join safra s "
       + "on (b.safra_id = s.id) "
       + "left join custo_equipamento cep "
       + "on (a.equipamento_principal_id = cep.equipamento_id and b.safra_id = cep.safra_id) "
       + "left join custo_equipamento cea "
       + "on (a.equipamento_apoio_id = cea.equipamento_id and b.safra_id = cea.safra_id) "
       + "left join custo_operador cop "
       + "on (a.operador_principal_id = cop.operador_id and b.safra_id = cop.safra_id) "
       + "left join custo_operador coa "
       + "on (a.operador_ajudante_id = coa.operador_id and b.safra_id = coa.safra_id) "
       + "left join custo_produto cp "
       + "on (a.produto_id = cp.produto_id and b.safra_id = cp.safra_id) "
       + "where b.safra_id = ? "
       + "group by b.safra_id ";
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setLong(1, codigoSafra);
        
        ResultSet rs = stmt.executeQuery();
        
        CustoSafraSintetico c = new CustoSafraSintetico();
        
        while(rs.next()) {
  
        c.setSafra(rs.getString("safra"));
        c.setCustoEquipamentoPrincipalReal(rs.getDouble("custo_real_eq_principal"));
        c.setCustoEquipamentoPrincipalDollar(rs.getDouble("custo_dollar_eq_principal"));
        c.setCustoEquipamentoApoioReal(rs.getDouble("custo_real_eq_apoio"));
        c.setCustoEquipamentoApoioDollar(rs.getDouble("custo_dollar_eq_apoio"));
        c.setCustoOperadorPrincipalReal(rs.getDouble("custo_real_op_principal"));
        c.setCustoOperadorPrincipalDollar(rs.getDouble("custo_dollar_op_principal"));
        c.setCustoOperadorAjudanteReal(rs.getDouble("custo_real_op_ajudante"));
        c.setCustoOperadorAjudanteDollar(rs.getDouble("custo_dollar_op_ajudante"));
        c.setCustoProdutoReal(rs.getDouble("custo_real_produto"));
        c.setCustoProdutoDollar(rs.getDouble("custo_dollar_produto"));
        
        
        }
        
        return c;
    }
    
}
