package com.example.procesador.controller;
import com.example.procesador.service.ProcesadorExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

@RestController
public class DataController {
    @Autowired
    private ProcesadorExcelService procesadorExcelService;

    @PostMapping("/procesar-excel")
    public ResponseEntity<String> procesarArchivoExcel(@RequestBody String direccion) {
        try {
            // Procesa el archivo Excel utilizando el service correspondiente
            procesadorExcelService.procesarArchivoExcel(direccion);
            return new ResponseEntity<>("Archivo Excel procesado correctamente", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error al procesar el archivo Excel", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
