package com.solucaocriativa.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solucaocriativa.dao.PermissaoTelaDepartamentoDao;
import com.solucaocriativa.entidade.Departamento;
import com.solucaocriativa.entidade.PermissaoTelaDepartamento;
import com.solucaocriativa.service.ServicoPermissaoTelaDepartamento;
import com.solucaocriativa.service.generico.impl.ServicoGenericoImpl;

@Service
public class ServicoPermissaoTelaDepartamentoImpl extends
	ServicoGenericoImpl<PermissaoTelaDepartamento, Long> implements
	ServicoPermissaoTelaDepartamento {

    private static final long serialVersionUID = 1L;
    private static Log log = LogFactory
	    .getLog(ServicoPermissaoTelaDepartamentoImpl.class);
    private PermissaoTelaDepartamentoDao permissaoTelaDepartamentoDao;

    public ServicoPermissaoTelaDepartamentoImpl() {
    }

    @Inject
    public ServicoPermissaoTelaDepartamentoImpl(
	    PermissaoTelaDepartamentoDao permissaoTelaDepartamentoDao) {
	this.permissaoTelaDepartamentoDao = permissaoTelaDepartamentoDao;
	super.setGenericDAO(permissaoTelaDepartamentoDao);
    }
    
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<PermissaoTelaDepartamento> buscaPermissoes(Departamento departamento) {
	List<PermissaoTelaDepartamento> permissoes = permissaoTelaDepartamentoDao.buscaPermissoes(departamento);
	return permissoes;
    }
}
