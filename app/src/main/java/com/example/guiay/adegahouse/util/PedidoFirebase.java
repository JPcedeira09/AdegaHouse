package com.example.guiay.adegahouse.util;

import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.model.Pedido;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PedidoFirebase {

    private static List<Pedido> pedidos = new ArrayList<Pedido>();
    private static Pedido pedido;


    public static void updateStatus(Pedido pedido, Boolean statuBool, String statusSting){

        pedido.getValoresPedido().setStatusPedido(statusSting);
        pedido.getValoresPedido().setPedidoAceite(statuBool);

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map =
                mapper.convertValue(pedido, new TypeReference<Map<String, Object>>() {});

        ConfiguracaoFirebase.getFirebase()
                .child("Pedidos")
                .updateChildren(map);

    }


}
