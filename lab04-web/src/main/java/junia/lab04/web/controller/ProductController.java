package junia.lab04.web.controller;

import junia.lab04.core.entity.Product;
import junia.lab04.core.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

@Controller
public class ProductController {
    @Inject
    ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getListOfCompanies(ModelMap modelMap) {
        List<Product> products = productService.findAllProducts();
        modelMap.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String getForm(ModelMap modelMap) {
        Product product = new Product();
        modelMap.put("product", product);
        return "productForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("product") Product product) {
        productService.save(product);
        System.out.println(product.getName());
        System.out.println(product.getType());
        return "redirect:list";
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
    public String deleteCompany(@PathVariable("id") long id) {
        productService.deleteById(id);
        return "redirect:/list";
    }
    @RequestMapping(value = "{id}/see", method = RequestMethod.GET)
    public String seeUser(@PathVariable("id") long id,ModelMap modelMap) {
        long currentUserID = id;
        modelMap.addAttribute("currentUserID", currentUserID);
        return "userProfile";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadForm() {
        return "redirect:userform";
    }

    @RequestMapping(value = "/userform", method = RequestMethod.GET)
    public String loadUserForm() {
        return "userForm";
    }

    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public String loadUserList(ModelMap modelMap) {
        List<Product> products = productService.findAllProducts();
        modelMap.addAttribute("products", products);
        return "userList";
    }
}