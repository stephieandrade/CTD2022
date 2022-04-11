package com.dh.studentservice.shared;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public abstract class GenericRestController<T, V extends Serializable> {

    private final GenericServiceAPI<T, V> serviceAPI;

    protected GenericRestController(GenericServiceAPI<T, V> serviceAPI) {
        this.serviceAPI = serviceAPI;
    }

    // Validador de campos
    public ResponseEntity<Object> validar(BindingResult result) {
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> errores.put(err.getField(),
                " El campo " + err.getField() + " " + err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errores);
    }

    @GetMapping("/all")
    public List<T> getAll() {
        return serviceAPI.getAll();
    }

    @GetMapping("/{v}")
    public ResponseEntity<Object> find(@PathVariable V v) {
        var entity = serviceAPI.get(v);
        if (entity == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(entity);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@Valid @RequestBody T entity, BindingResult result) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(serviceAPI.save(entity));
    }

    @GetMapping("/delete/{v}")
    public ResponseEntity<Object> delete(@PathVariable V v) {
        var entity = serviceAPI.get(v);
        if (entity != null) {
            serviceAPI.delete(v);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
}
