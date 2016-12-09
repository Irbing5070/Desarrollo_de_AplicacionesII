package mx.utng.practice.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import mx.utng.practice.model.Dealer;
import mx.utng.practice.repository.DealerRepository;

@Named
@ViewScoped
public class DealerController {
	
	@Autowired
	private DealerRepository dealerRepository;
	
	private Dealer dealer = new Dealer();
	private List<Dealer> dealers;
	private boolean editMode = false;
	
	@PostConstruct
	public void init(){
		setDealers(dealerRepository.findAll());
	}
	
	public void save(){
		dealerRepository.save(dealer);
		if(!editMode){
			getDealers().add(dealer);
		}
		dealer = new Dealer();
		setEditMode(false);
	}
	
	public void delete(Dealer dealer){
		dealerRepository.delete(dealer);
		dealers.remove(dealer);
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
	
	public void update(Dealer dealer){
		setDealer(dealer);
		setEditMode(true);
	}
	
	public void cancel(){
		dealer = new Dealer();
		setEditMode(false);
	}
	
	public List<Dealer> getDealers(){
		return dealers;
	}
	
	public void setDealers(List<Dealer> dealers) {
		this.dealers = dealers;
	}
	
	public boolean isEditMode() {
		return editMode;
	}
	
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

}
