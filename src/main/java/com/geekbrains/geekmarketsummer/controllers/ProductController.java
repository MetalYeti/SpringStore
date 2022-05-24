package com.geekbrains.geekmarketsummer.controllers;

import com.geekbrains.geekmarketsummer.entites.Product;
import com.geekbrains.geekmarketsummer.entites.ProductImage;
import com.geekbrains.geekmarketsummer.services.CategoryService;
import com.geekbrains.geekmarketsummer.services.ProductService;
import com.geekbrains.geekmarketsummer.services.ImageSaverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private CategoryService categoryService;
    private ImageSaverService imageSaverService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setImageSaverService(ImageSaverService imageSaverService) {
        this.imageSaverService = imageSaverService;
    }

    @GetMapping("/showProductForm")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product-form";
    }

    @PostMapping("/processProductForm")
    public String processProductForm(@Valid @ModelAttribute("product") Product product, Model model, BindingResult bindingResult, @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "product-form";
        }

        if (!file.isEmpty()){
            String filename = imageSaverService.saveFile(file);
            ProductImage image = new ProductImage();
            image.setPath(filename);
            image.setProduct(product);
            product.addImage(image);
        }

        productService.saveProduct(product);
        return "redirect:/shop";
    }
}
