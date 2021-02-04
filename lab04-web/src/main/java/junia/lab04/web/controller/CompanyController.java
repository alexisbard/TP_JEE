package junia.lab04.web.controller;

import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import junia.lab04.core.service.CompanyService;
import junia.lab04.core.entity.Company;

import javax.inject.Inject;
import java.util.List;

@Controller
public class CompanyController {
    @Inject
    CompanyService companyService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getListOfCompanies(ModelMap modelMap) {
        List<Company> companies = companyService.findAllWithProjects();
        modelMap.addAttribute("companies", companies);
        return "companiesList";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String getForm(ModelMap modelMap) {
        Company company = new Company();
        modelMap.put("company", company);
        return "companyForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("company") Company company) {
        companyService.save(company);
        return "redirect:list";
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
    public String deleteCompany(@PathVariable("id") long id) {
        companyService.deleteById(id);
        return "redirect:/list";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadForm() {
        return "redirect:form";
    }
}