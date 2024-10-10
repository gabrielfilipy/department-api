package com.br.api.v1.listener;

import com.br.api.v1.model.CidadeModel;
import com.br.api.v1.model.EstadoModel;
import com.br.api.v1.model.OrgaoModel;
import com.br.api.v1.model.input.EnderecoModelInput;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrgaoListener {
    @RabbitListener(queues = "government-department")
    public void onOrgaoCreated01(OrgaoModel orgaoModel) {
        System.out.println("Orgão recebido: " + orgaoModel.getOrgaoId());
        System.out.println("Nome: " + orgaoModel.getNome());
        System.out.println("Ativo: " + orgaoModel.isActive());
        System.out.println("CEP: " + orgaoModel.getEndereco().getCep());
        System.out.println("Cidade ID: " + orgaoModel.getEndereco().getCidade().getId());
        System.out.println("Estado ID: " + orgaoModel.getEndereco().getCidade().getEstado().getId());
    }
}
