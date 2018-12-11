package cn.itcast.yyy.service.impl;

import cn.itcast.yyy.dao.ProductDao;
import cn.itcast.yyy.domain.Product;
import cn.itcast.yyy.service.ProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return productDao.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    @Override
    public Product findById(String id) {
        return productDao.findById(id);

    }

    @Override
    public void delById(String[] ids) {
        for (String id : ids) {
            productDao.delByProId(id);
            productDao.delById(id);
        }
    }

    @Override
    public List<Product> findByName(String cityName) {
        return productDao.findByName(cityName);
    }



    @Override
    public void openSta(String[] ids) {
        for (String id : ids) {
            productDao.openSta(id);
        }
    }

    @Override
    public void closeSta(String[] ids) {
        for (String id : ids) {
            productDao.closeSta(id);
        }
    }


}
