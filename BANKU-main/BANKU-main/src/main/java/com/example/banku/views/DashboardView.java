package com.example.banku.views;

import com.example.banku.model.Cuenta;
import com.example.banku.service.CuentaService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class DashboardView extends VerticalLayout {

    private final CuentaService cuentaService;


    public DashboardView(CuentaService cuentaService) {
        this.cuentaService = cuentaService;


        H1 titulo = new H1("Panel de Control - BANKU");


        Grid<Cuenta> gridCuentas = new Grid<>(Cuenta.class, false);


        gridCuentas.addColumn(Cuenta::getId).setHeader("ID de Cuenta").setAutoWidth(true);


        gridCuentas.addColumn(Cuenta::getNumeroCuenta).setHeader("Número de Cuenta");
        gridCuentas.addColumn(Cuenta::getSaldo).setHeader("Saldo Disponible");


        gridCuentas.setItems(cuentaService.obtenerTodas());


        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(titulo, gridCuentas);
    }
}