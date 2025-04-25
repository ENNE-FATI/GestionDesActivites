/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.GuideDao;
import dao.UserDao;
import entities.Guide;
import java.util.List;

/**
 *
 * @author FATI
 */
public class GuideService implements IService<Guide> {
    
    private final GuideDao gd;
    
    public GuideService(){
        this.gd = new GuideDao();
    }

    
    @Override
    public List<Guide> findAll() {
        return gd.findAll();
    }

    @Override
    public Guide findById(int id) {
        return gd.findById(id);
    }

    @Override
    public boolean create(Guide o) {
        return gd.create(o);
    }

    @Override
    public boolean delete(Guide o) {
        return gd.delete(o);
    }

    @Override
    public boolean update(Guide o) {
        return gd.update(o);
    }

   
    
}