package com.betoola.homework.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ExchangeControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void convert1000GBPtoEUR() throws Exception {
        String result = mockMvc
                .perform(post("/rest/exchange")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("currencyForSale", "GBP")
                        .param("amountForSale", "1000")
                        .param("targetCurrency", "EUR"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        Assertions.assertEquals("1205.40", result);
    }

    @Test
    public void convert1000EURtoGBP() throws Exception {
        String result = mockMvc
                .perform(post("/rest/exchange")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("currencyForSale", "EUR")
                        .param("amountForSale", "1000")
                        .param("targetCurrency", "GBP"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        Assertions.assertEquals("796.74", result);
    }

    @Test
    public void convertNegativeValue() throws Exception {
        mockMvc
                .perform(post("/rest/exchange")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("currencyForSale", "EUR")
                        .param("amountForSale", "-1000")
                        .param("targetCurrency", "GBP"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void sameCurrencyTest() throws Exception {
        mockMvc
                .perform(post("/rest/exchange")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("currencyForSale", "EUR")
                        .param("amountForSale", "1000")
                        .param("targetCurrency", "EUR"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void unknownCurrencyTest() throws Exception {
        mockMvc
                .perform(post("/rest/exchange")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("currencyForSale", "RUR")
                        .param("amountForSale", "1000")
                        .param("targetCurrency", "EUR"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void missedMandatoryAmountParameterTest() throws Exception {
        mockMvc
                .perform(post("/rest/exchange")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("currencyForSale", "GBP")
                        .param("targetCurrency", "EUR"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void wrongEndpointTest() throws Exception {
        mockMvc
                .perform(post("/rest/exchange1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("currencyForSale", "GBP")
                        .param("targetCurrency", "EUR"))
                .andExpect(status().isNotFound());
    }

}