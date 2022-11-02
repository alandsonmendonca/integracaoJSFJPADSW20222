package bean;

import static util.MessageUtil.infoMessage;
import static util.MessageUtil.errorMessage;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.PresidenteDao;
import entidade.Presidente;

@ManagedBean
public class PresidenteBean {
	private Presidente presidente = new Presidente();
	private List<Presidente> lista;
	
	public String salvar() {
		try {
			PresidenteDao.salvar(presidente);
			infoMessage("Sucesso", "Presidente salvo com sucesso.");
			presidente = new Presidente();
		} catch (Exception e) {
			errorMessage("Erro", "Contate o adminstrador do sistema.");
		}
		return null;
	}
	
	public String votar() {
		presidente.setQtdVotos(presidente.getQtdVotos()+ 1);
		PresidenteDao.atualizar(presidente);
		infoMessage("Pilhilhilhi", "Voto computado com sucesso.");
		lista = PresidenteDao.listar();
		return null;
	}
	
	public String deletar() {
		PresidenteDao.deletar(presidente);
		infoMessage("Sucesso", "Presidente removido com sucesso.");
		lista = PresidenteDao.listar();
		return null;
	}
	
	
	public Presidente getPresidente() {
		return presidente;
	}
	public void setPresidente(Presidente presidente) {
		this.presidente = presidente;
	}
	public List<Presidente> getLista() {
		if (lista == null) {
			lista = PresidenteDao.listar();
		}
		return lista;
	}
	public void setLista(List<Presidente> lista) {
		this.lista = lista;
	}
	
}
