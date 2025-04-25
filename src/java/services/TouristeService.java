/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.TouristeDao;
import dao.UserDao;
import entities.Touriste;
import java.util.List;

/**
 *
 * @author FATI
 */
public class TouristeService implements IService<Touriste> {
    
    private final TouristeDao td;
    
    public TouristeService(){
        this.td = new TouristeDao();
    }

    @Override
    public List<Touriste> findAll() {
        return td.findAll();
    }

    @Override
    public Touriste findById(int id) {
        return td.findById(id);
    }

   @Override
    public boolean create(Touriste o) {
        return td.create(o);
    }

    @Override
    public boolean delete(Touriste o) {
        return td.delete(o);
    }

    @Override
    public boolean update(Touriste o) {
        return td.update(o);
    }
    
}