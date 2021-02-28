package junia.lab04.core.service;

import junia.lab04.core.dao.CompanyDAO;
import junia.lab04.core.entity.Company;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyService {

    private CompanyDAO companyDAO;


    public CompanyService(final CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }


    public void deleteAll() {
        companyDAO.deleteAll();
    }


    public void save(final Company company) {
        companyDAO.save(company);
    }


    public long countAll() {
        return companyDAO.count();
    }


    public List<Company> findAllWithProjects(){
        return companyDAO.findAllWithProjects();
    }


    public void deleteById(final long id) {
        companyDAO.deleteById(id);
    }
}
