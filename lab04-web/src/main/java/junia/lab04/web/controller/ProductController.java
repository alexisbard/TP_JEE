package junia.lab04.web.controller;

import junia.lab04.core.entity.Product;
import junia.lab04.core.entity.User;
import junia.lab04.core.service.ProductService;
import junia.lab04.core.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Inject
    ProductService productService;
    @Inject
    UserService userService;

    User currentUser;
    Product currentProduct;

    //Default page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadForm() {
        return "redirect:userlist";
    }





    // product pages
    @RequestMapping(value = "/productform", method = RequestMethod.GET)
    public String getProductForm(ModelMap modelMap) {
        Product product = new Product();
        modelMap.put("product", product);
        return "productForm";
    }

    @RequestMapping(value = "/productform", method = RequestMethod.POST)
    public String submitProductForm(@ModelAttribute("product") Product product) {
        product.setOwnerID(currentUser.getId());
        productService.save(product);
        return "redirect:userprofile";
    }

    @RequestMapping(value = "{id}/deleteproduct", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") long id) {
        productService.deleteById(id);
        return "redirect:/userprofile";
    }

    @RequestMapping(value = "{id}/seeproduct", method = RequestMethod.GET)
    public String seeProduct(@PathVariable("id") long id) {
        List<Product> products = productService.findAllProducts();
        for (Product product : products){
            if (id == product.getId()){
                currentProduct = product;
                return "redirect:/productprofile";
            }
        }
        return "redirect:/userprofile";
    }

    @RequestMapping(value = "/productprofile", method = RequestMethod.GET)
    public String loadProductProfile(ModelMap modelMap) {
        modelMap.addAttribute("currentProduct", currentProduct);
        return "productProfile";
    }





    //user pages
    @RequestMapping(value = "/userform", method = RequestMethod.GET)
    public String loadUserForm(ModelMap modelMap) {
        User user = new User();
        modelMap.put("user", user);
        return "userForm";
    }

    @RequestMapping(value = "/userform", method = RequestMethod.POST)
    public String submitUserForm(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:userlist";
    }

    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public String loadUserList(ModelMap modelMap) {
        List<User> users = userService.findAllUsers();
        modelMap.addAttribute("users", users);
        return "userList";
    }

    @RequestMapping(value = "{id}/seeuser", method = RequestMethod.GET)
    public String seeUser(@PathVariable("id") long id) {
        List<User> users = userService.findAllUsers();
        for (User user : users){
            if (id == user.getId()){
                currentUser = user;
                return "redirect:/userprofile";
            }
        }
        return "redirect:/userlist";
    }

    @RequestMapping(value = "/userprofile", method = RequestMethod.GET)
    public String loadUserProfile(ModelMap modelMap) {
        List<Product> products = productService.findAllProducts();
        List<Product> currentUserProducts = new ArrayList<>();
        for (Product product : products){
            if (product.getOwnerID() == currentUser.getId()){
                currentUserProducts.add(product);
            }
        }
        modelMap.addAttribute("currentUserProducts", currentUserProducts);
        modelMap.addAttribute("currentUser", currentUser);
        return "userprofile";
    }

    @RequestMapping(value = "{id}/deleteuser", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/userlist";
    }
}