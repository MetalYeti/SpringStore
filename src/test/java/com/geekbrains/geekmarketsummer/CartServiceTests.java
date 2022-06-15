package com.geekbrains.geekmarketsummer;

import com.geekbrains.geekmarketsummer.entites.Product;
import com.geekbrains.geekmarketsummer.services.ProductService;
import com.geekbrains.geekmarketsummer.services.ShoppingCartService;
import com.geekbrains.geekmarketsummer.utils.ShoppingCart;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTests {

    @Mock
    MockHttpSession mockHttpSession;

    @Mock
    HttpSession httpSession;

    @Mock
    ProductService productService;

    ShoppingCartService shoppingCartService;
    Product product;
    ShoppingCart currentCart;

    @Before
    public void init() {
        product = new Product();

        product.setId(1L);
        product.setPrice(BigDecimal.valueOf(100));
        product.setTitle("Dummy");


        shoppingCartService = new ShoppingCartService();
        shoppingCartService.setProductService(productService);
        when(productService.getProductById(product.getId())).thenReturn(product);

        currentCart = new ShoppingCart();
        when(httpSession.getAttribute("cart")).thenReturn(currentCart);
    }

    @Test
    public void getCurrentCartEmptyTest() {
        ShoppingCart currentCart = shoppingCartService.getCurrentCart(mockHttpSession);
        assertEquals(currentCart.getTotalCost(), BigDecimal.ZERO);
    }

    @Test
    public void addToCartTest() {
        shoppingCartService.addToCart(httpSession, product.getId());
        assertEquals(product.getPrice(), currentCart.getTotalCost());
    }

    @Test
    public void removeFromCartTest() {
        currentCart.add(product);
        shoppingCartService.removeFromCart(httpSession, product.getId());
        assertEquals(BigDecimal.ZERO, currentCart.getTotalCost());
    }

    @Test
    public void setQuantityTest(){
        currentCart.add(product);
        shoppingCartService.setProductCount(httpSession, product.getId(), 10L);
        assertEquals((Long)10L, currentCart.getItems().get(0).getQuantity());
    }
}
