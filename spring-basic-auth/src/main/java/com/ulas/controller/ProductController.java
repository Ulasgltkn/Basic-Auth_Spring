package com.ulas.controller;

import com.ulas.entity.Product;
import com.ulas.repository.ProductRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
@RestController
public class ProductController {
private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public String save(@RequestParam String sessionId, @RequestBody Product product, HttpServletRequest request){

        HttpSession session = request.getSession(false);

        if (session != null && sessionId.equals(session.getId())) {
            // Oturum geçerli, ürün kaydetme işlemi yapılabilir
            productRepository.save(product);
            return "Ürün kaydedildi.";
        } else {
            // Oturum geçersiz, hata mesajı döndür
            return "Oturum geçersiz veya süresi dolmuş.";
        }

    }

}
