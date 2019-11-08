package be.multimedi.weblessons.products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionScope
@RequestMapping("/products")
public class ProductController {
    private final static String VIEW = "products";
    private List<String> products = new ArrayList<>();

    @ModelAttribute("products")
    public List<String> getProducts() {
        return products;
    }

    @ModelAttribute("title")
    public String getTitle() {
        return "Producten";
    }

    @GetMapping
    public String handlePlainGet() {
        return VIEW;
    }

    @PostMapping(params = {"add"})
    public String handleAddProduct(@RequestParam("add_product") String product) {
        products.add(product);
        return VIEW;
    }

    @PostMapping(params = {"delete"})
    public String handleDeleteProduct(@RequestParam("product") String product) {
        products.remove(product);
        return VIEW;
    }

    @PostMapping(params = {"change"})
    public String handleChangeProduct(@RequestParam("id") Integer id, @RequestParam("product") String product) {
        if (id < products.size()) {
            products.set(id, product);
        } else {
            products.add(product);
        }
        return VIEW;
    }
}
