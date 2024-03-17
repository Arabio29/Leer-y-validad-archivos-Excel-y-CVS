package com.example.procesador.service;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import com.example.procesador.model.ContenidoExcel;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class ProcesadorExcelService {
    public ContenidoExcel procesarArchivoExcel(String direccion) throws IOException {
        try (Workbook workbook = WorkbookFactory.create(new FileInputStream(new File(direccion)))) {
            // Procesa el archivo Excel aquí y devuelve el contenido
            ContenidoExcel contenido = new ContenidoExcel();
            // Lógica para leer y procesar el archivo Excel
            return contenido;
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            throw new IOException("Error al procesar el archivo Excel", e);
        }
    }
}
