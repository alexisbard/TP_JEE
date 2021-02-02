package junia.lab04.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import junia.lab04.core.service.CompanyService;
import junia.lab04.core.entity.Company;

import javax.inject.Inject;
import java.util.List;

@Controller
public class CompanyController {
    @Inject
    CompanyService companyService ;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getListOfCompanies(ModelMap modelMap){
        List<Company> companies = companyService.findAllWithProjects();
        modelMap.addAttribute("companies",companies);
        return "companiesList";
    }
}
