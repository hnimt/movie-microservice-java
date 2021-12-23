package fpt.training.excelservice.service.impl;

import fpt.training.excelservice.entity.Invoice;
import fpt.training.excelservice.repository.InvoiceRepository;
import fpt.training.excelservice.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Override
    @Scheduled(initialDelay = 10, fixedDelay = 10800)
    public void dbToExcel() {

        List<Invoice> invoiceList = invoiceRepository.findAll();

        String[] headers = { "Id", "AccountId", "Movie Name", "Add Score",
                "Use Score", "Total Money", "Schedule Show", "Schedule Show Time"
        };

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Invoice data");

        // Date style
        CreationHelper creationHelper = workbook.getCreationHelper();
        CellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat(
                creationHelper.createDataFormat().getFormat("d/m/yy"));

        // Headers
        Row headerRow = sheet.createRow(0);
        for (int col = 0; col < headers.length; col++) {
            Cell cell = headerRow.createCell(col);
            cell.setCellValue(headers[col]);
        }

        // Create row and set data
        int rownum = 1;
        for (Invoice invoice : invoiceList) {
            Row row = sheet.createRow(rownum++);

            row.createCell(0).setCellValue(invoice.getInvoiceId());
            row.createCell(1).setCellValue(invoice.getAccountId());
            row.createCell(2).setCellValue(invoice.getMovieName());
            row.createCell(3).setCellValue(invoice.getAddScore());
            row.createCell(4).setCellValue(invoice.getUseScore());
            row.createCell(5).setCellValue(invoice.getTotalMoney());

            Cell scheduleShowCell = row.createCell(6);
            scheduleShowCell.setCellValue(invoice.getScheduleShow());
            scheduleShowCell.setCellStyle(dateStyle);

            row.createCell(7).setCellValue(invoice.getScheduleShowTime());
        }

        // Write file
        try {
            FileOutputStream out = new FileOutputStream(new File("invoice_data.xlsx"));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
