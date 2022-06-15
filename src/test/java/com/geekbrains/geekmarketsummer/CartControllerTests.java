package com.geekbrains.geekmarketsummer;

import com.geekbrains.geekmarketsummer.controllers.CartController;
import com.geekbrains.geekmarketsummer.entites.Product;
import com.geekbrains.geekmarketsummer.services.ShoppingCartService;
import com.geekbrains.geekmarketsummer.utils.ShoppingCart;
import org.hamcrest.core.StringContains;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import javax.servlet.http.HttpSession;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTests {
    @Autowired
    private MockMvc mvc;

    @Mock
    private ShoppingCartService shoppingCartService;

    @Mock
    MockHttpSession httpSession;

    @Test
    public void cartPageTest() throws Exception {
        Product product = new Product();
        product.setTitle("Dummy");
        product.setId(1L);
        product.setPrice(BigDecimal.valueOf(1000));



        ShoppingCart cart = new ShoppingCart();
        cart.add(product);

        when(httpSession.getAttribute("cart")).thenReturn(cart);
        mvc.perform(get("/cart").session(httpSession))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(StringContains.containsString("Dummy")));

    }
}
