package fpt.training.excelservice.controller;

import fpt.training.excelservice.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class ExcelController {

    private final InvoiceService invoiceService;

    @GetMapping("/invoices")
    public ResponseEntity getInvoicesExcel() {
        invoiceService.dbToExcel();
        return ResponseEntity.status(HttpStatus.OK).body("Successfully!");
    }
}
