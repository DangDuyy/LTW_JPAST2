package services.impl;

import dao.ICategoryDAO;
import dao.impl.CategoryDAO;
import entity.Category;
import services.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    ICategoryDAO cateDao = new CategoryDAO();
    @Override
    public int count() {
        return cateDao.count();
    }

    @Override
    public List<Category> findAll(int page, int pagesize) {
        return cateDao.findAll(page, pagesize);
    }
    @Override
    public List<Category> findByCategoryname(String catname) {
        return cateDao.findByCategoryname(catname);
    }

    @Override
    public List<Category> findAll() {
        return cateDao.findAll();
    }



    @Override
    public Category findById(int cateid) {
        return cateDao.findById(cateid);
    }



    @Override
    public void delete(int cateid) throws Exception {
        cateDao.delete(cateid);
    }



    @Override
    public void update(Category category) {
        cateDao.update(category);
    }
    @Override
    public void insert(Category category) {
        cateDao.insert(category);
    }

}
