package com.example.apiRest.Controllers;

import com.example.apiRest.Models.DestinoInfo;
import com.example.apiRest.Models.DestinoRequest;
import com.example.apiRest.Models.DestinoResponse;
import com.example.apiRest.Models.User;
import com.example.apiRest.Services.DestinoService;
import com.example.apiRest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.apiRest.Repositories.destinoInfoRespository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DestinoController {

    @Autowired
    private final DestinoService destinoService;

    @Autowired
    private  destinoInfoRespository destinoInfoRespository;


    @Autowired
    public DestinoController(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    @PostMapping("/enviarDestino")
    public DestinoResponse enviarDestino(@RequestBody DestinoRequest destinoRequest) {

        return destinoService.enviarDestino(
                destinoRequest.getpDestino(),
                destinoRequest.getpClimatica(),
                destinoRequest.getpActividad(),
                destinoRequest.getpAlojamiento(),
                destinoRequest.getdViaje(),
                destinoRequest.getEdad()
        );
    }



    @PostMapping("/guardarDestino")
    public ResponseEntity<DestinoInfo> create(@RequestBody DestinoInfo destinoInfo) {
        DestinoInfo destinoCreated = new DestinoService(destinoInfoRespository).create(destinoInfo);
        return new ResponseEntity<>(destinoCreated, HttpStatus.OK);
    }

    @GetMapping("/searchName/{nombreDestino}")
    public ResponseEntity<List<DestinoInfo>> searchName(@PathVariable String nombreDestino) {
        List<DestinoInfo> destinosInfor = new DestinoService(destinoInfoRespository).searchName(nombreDestino);
        if (destinosInfor.size() == 0) {
            return new ResponseEntity<>(destinosInfor, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(destinosInfor, HttpStatus.OK);
    }






}
