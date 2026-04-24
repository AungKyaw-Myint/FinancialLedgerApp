package com.pluralsight.util;

import java.io.File;

public class FileReaderCsv {

    public void fileReading(File file){
        /*
        try {
            File file = new File("/C:/pluralsight/Puralsight-Modules/week3/bedtime-stories/src/main/resources/payroll.csv");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                Employee employee= new Employee();

                String[] parts = line.split("\\|");

                employee.setEmployeeId(Integer.parseInt(parts[0]));
                employee.setName(parts[1]);
                employee.setHoursWorked(Double.parseDouble(parts[2]));
                employee.setPayRate(Double.parseDouble(parts[3]));

                employees.add(employee);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;

         */
    }
}
