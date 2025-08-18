package com.yashank.order_service.stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class Inventorystubs {
    public static void stubsInventoryCall(String skuCode,Integer quantity)
    {
        stubFor(get(urlPathEqualTo("/api/inventory/check"))
        .withQueryParam("skuCode", equalTo(skuCode))
        .withQueryParam("quantity", equalTo(quantity.toString()))
        .willReturn(aResponse()
        .withStatus(200)
        .withHeader("Content-Type","application/json")
        .withBody("true")));
    }
}
