package com.example.demo.controller;

import com.example.demo.entity.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")  // ← agrega esta línea
public class ClienteController {

    @Autowired
    private ClienteService service;

    // LISTAR
    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Integer id) {
        return service.buscarPorId(id).orElse(null);
    }

    // REGISTRAR
    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        cliente.setCodiClie(null); // 🔥 CLAVE
        return service.guardar(cliente);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Integer id, @RequestBody Cliente cliente) {
        return service.actualizar(id, cliente);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }


}